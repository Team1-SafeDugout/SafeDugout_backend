package com.bullPenTalk.app.trade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.PointPaymentDTO;
import com.bullPenTalk.app.dto.SellPostDetailDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;
import com.bullPenTalk.app.payment.dao.PaymentDAO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class BuyController {

    // 구매 페이지 이동
    public Result buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();

        String sellPostNumberStr = request.getParameter("sellPostNumber");
        if (sellPostNumberStr == null || sellPostNumberStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2?category=allproduct&action=list");
            return null;
        }

        int sellPostNumber = Integer.parseInt(sellPostNumberStr);
        System.out.println("buy 진입");

        // DAO를 통해 상품 정보 조회
        SellPostDAO sellPostDAO = new SellPostDAO();
        SellPostDetailDTO sellPostDetail = sellPostDAO.selectDetail(sellPostNumber);

        if (sellPostDetail == null) {
            response.sendRedirect(request.getContextPath() + "/trade/productList.jsp");
            return null;
        }

        // ✅ 회원 포인트 조회 후 세션에 세팅
        Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
        if (memberNumber != null) {
            MemberDAO memberDAO = new MemberDAO();
            int memberPoint = memberDAO.getMemberPoint(memberNumber);
            request.getSession().setAttribute("memberPoint", memberPoint);
        }

        // JSP에 상품 정보 전달
        request.setAttribute("sellPostDetail", sellPostDetail);
        result.setPath("/app/trade/productBuy.jsp");
        result.setRedirect(false);
        System.out.println("result:" + result);
        return result;
    }

    // 결제
    public Result payment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();

        int sellPostNumber = Integer.parseInt(request.getParameter("sellPostNumber"));
        int buyerNumber = Integer.parseInt(request.getParameter("buyerNumber"));
        int sellerNumber = Integer.parseInt(request.getParameter("sellerNumber"));
        int pricePoint = Integer.parseInt(request.getParameter("pricePoint"));

        System.out.println("payment 메소드 진입");

        // 멤버 포인트 조회
        MemberDAO memberDAO = new MemberDAO();
        int buyerPoint = memberDAO.getMemberPoint(buyerNumber);

        // 포인트 부족시 충전페이지 이동
        if (buyerPoint < pricePoint) {
            System.out.println("충전페이지 이동");
            result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=buy&action=charging");
            result.setRedirect(false);
            return result;
        }

        
        
        // 결제 정보 매핑
        Map<String, Object> param = new HashMap<>();
        param.put("buyerNumber", buyerNumber);
        param.put("sellerNumber", sellerNumber);
        param.put("pricePoint", pricePoint);
        param.put("sellPostNumber", sellPostNumber);

        // 결제 메소드 실행
        PaymentDAO paymentDAO = new PaymentDAO();
        int buyer = paymentDAO.decreaseBuyerPoint(param);
        int seller = paymentDAO.increaseSellerPoint(param);
        int trade = paymentDAO.insertTradePost(param);
        int updateStatus = paymentDAO.updateSellPostStatus(sellPostNumber);

        if (buyer > 0 && seller > 0 && trade > 0 && updateStatus > 0) {
            // 결제 완료 후 세션 포인트 갱신
            int updatedBuyerPoint = memberDAO.getMemberPoint(buyerNumber);
            request.getSession().setAttribute("memberPoint", updatedBuyerPoint);

            result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=allproduct&action=list");
            result.setRedirect(true);
        } else {
            response.getWriter().println("결제 실패");
            return null;
        }

        return result;
    }

    // 구매 취소
    public Result canceled(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();
        String tradeNumberStr = request.getParameter("tradeNumber");

        if (tradeNumberStr == null || tradeNumberStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=allproduct&action=list");
            return null;
        }

        int tradeNumber = Integer.parseInt(tradeNumberStr);
        PaymentDAO paymentDAO = new PaymentDAO();
        Map<String, Object> param = new HashMap<>();
        param.put("tradeNumber", tradeNumber);

        int updateBuyerPoint = paymentDAO.refundBuyerPoint(param);
        int updateSellStatus = paymentDAO.updateSellPostStatusAfterCancel(param);

        if (updateBuyerPoint > 0 && updateSellStatus > 0) {
            paymentDAO.sqlSession.commit();
            result.setPath("/trade/sellPostFrontController2.tr?category=allproduct&action=list");
            result.setRedirect(true);
        } else {
            paymentDAO.sqlSession.rollback();
            response.getWriter().write("결제 취소 실패");
            return null;
        }
        return result;
    }

    // 포인트 충전 페이지 이동
    public Result charging(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();
        Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");

        if (memberNumber == null) {
            result.setPath(request.getContextPath() + "/main.jsp");
            result.setRedirect(true);
            return result;
        }

        request.setAttribute("memberNumber", memberNumber);
        result.setPath("/app/trade/pointBuy.jsp");
        result.setRedirect(false);
        return result;
    }

    // 포인트 충전 처리
    public Result chargingOk(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();

        String memberNumberStr = request.getParameter("memberNumber");
        String chargePointStr = request.getParameter("amount");
        String paymentId = request.getParameter("paymentId");
        String merchantUid = request.getParameter("merchantUid");
        String payMethod = request.getParameter("payMethod");
        String paidAt = request.getParameter("paidAt");

        if (memberNumberStr == null || chargePointStr == null || memberNumberStr.trim().isEmpty() || chargePointStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/app/trade/pointBuy.jsp");
            return null;
        }

        int memberNumber = Integer.parseInt(memberNumberStr);
        int chargePoint = Integer.parseInt(chargePointStr);

        PaymentDAO paymentDAO = new PaymentDAO();

        try {
            // 아임포트 토큰 요청 및 결제 검증 (생략)

            Map<String, Object> param = new HashMap<>();
            param.put("memberNumber", memberNumber);
            param.put("chargePoint", chargePoint);

            int update = paymentDAO.chargeMemberPoint(param);

            if (update > 0) {
                PointPaymentDTO payment = new PointPaymentDTO();
                payment.setPaymentId(paymentId);
                payment.setMerchantUid(merchantUid);
                payment.setMemberNumber(memberNumber);
                payment.setAmount(chargePoint);
                payment.setStatus("paid");
                payment.setPayMethod(payMethod);
                payment.setPaidAt(paidAt);

                paymentDAO.insertPointPayment(payment);
                paymentDAO.sqlSession.commit();

                // ✅ 충전 후 세션 포인트 갱신
                MemberDAO memberDAO = new MemberDAO();
                int updatedMemberPoint = memberDAO.getMemberPoint(memberNumber);
                request.getSession().setAttribute("memberPoint", updatedMemberPoint);

                result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=allproduct&action=list");
                result.setRedirect(true);
            } else {
                paymentDAO.sqlSession.rollback();
                result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=buy&action=charging");
                result.setRedirect(true);
            }

        } catch (Exception e) {
            paymentDAO.sqlSession.rollback();
            e.printStackTrace();
            result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=buy&action=charging");
            result.setRedirect(true);
        } finally {
            paymentDAO.sqlSession.close();
        }

        return result;
    }
}
