package com.bullPenTalk.app.trade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.SellPostDetailDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;
import com.bullPenTalk.app.payment.dao.PaymentDAO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class BuyController {
	 
	
	 // 구매 페이지 이동
	public Result buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Result result = new Result();
        String sellPostNumberStr = request.getParameter("sellPostNumber");
        
        
        // 판매정보 가져오기
        if(sellPostNumberStr == null || sellPostNumberStr.trim().isEmpty()) {
           response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2?category=allproduct&action=list");
           return null;
        }
		
        int sellPostNumber = Integer.parseInt(sellPostNumberStr);
		
        // DAO를 통해 상품 정보 조회
        SellPostDAO sellPostDAO = new SellPostDAO();
        SellPostDetailDTO sellPostDetail = sellPostDAO.selectDetail(sellPostNumber);

        if(sellPostDetail == null) {
           response.sendRedirect(request.getContextPath() + "/trade/productList.jsp");
           return null;
        }
        
        // JSP에 상품 정보 전달
        request.setAttribute("sellPostDetail", sellPostDetail);
        result.setPath("/trade/productBuy.jsp");
        result.setRedirect(false); 
        
		return result;
	}
	
	// 결제 
	public Result payment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Result result = new Result();
		// 결제 정보 가져오기
		int sellPostNumber = Integer.parseInt(request.getParameter("sellPostNumber"));
		int buyerNumber = Integer.parseInt(request.getParameter("buyerNumber"));
		int sellerNumber = Integer.parseInt(request.getParameter("sellerNumber"));
		int pricePoint = Integer.parseInt(request.getParameter("pricePoint"));
		
		// 멤버 포인트 조회
	    MemberDAO memberDAO = new MemberDAO();
	    int buyerPoint = memberDAO.getMemberPoint(buyerNumber);
	    
	    // 포인트 부족시 충전페이지 이동
	    if(buyerPoint < pricePoint) {
	        result.setPath(request.getContextPath() + "/trade/chargePoint.jsp");
	        result.setRedirect(true);
	        return result;
	    }
		
	    // 결제 정보 매핑
		Map<String, Object> param = new HashMap<>();
		param.put("buyerNumber", buyerNumber);
		param.put("sellerNumber", sellerNumber);
		param.put("pricePoint", pricePoint);
		
		// 결제 메소드 실행
		PaymentDAO paymentDAO = new PaymentDAO();
		int buyer = paymentDAO.decreaseBuyerPoint(param);
		int seller = paymentDAO.increaseSellerPoint(param);
	    int trade = paymentDAO.insertTradePost(param);
	    int updateStatus = paymentDAO.updateSellPostStatus(sellPostNumber);
		
	    if(buyer > 0 && seller > 0 && trade > 0 && updateStatus > 0) {
	        result.setPath(request.getContextPath() + "/trade/sellPostFrontController2?category=allproduct&action=list");
	        result.setRedirect(true);
	    } else {
	        response.getWriter().println("결제 실패");
	        
	        return null;
	    }
		
		return result;
	}
	
	// 구매 취소
	public Result canceled(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Result result = new Result();
		// 거래번호 꺼내오기
		String tradeNumberStr = request.getParameter("tradeNumber");
		
		// 거래번호가 없을 때 메인페이지로 리다이렉트
        if(tradeNumberStr == null || tradeNumberStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2?category=allproduct&action=list");
            return null;
        }
		
        int tradeNumber = Integer.parseInt(tradeNumberStr);
        PaymentDAO paymentDAO = new PaymentDAO();
        
        // 거래정보 매핑
        Map<String, Object> param = new HashMap<>();
        param.put("tradeNumber", tradeNumber);
        
        // 결제 취소 시: 구매자에게 환불
        int updateBuyerPoint = paymentDAO.refundBuyerPoint(param);
        
        // 거래 상태 원래대로 변경 (예: 'selling')
        int updateSellStatus = paymentDAO.updateSellPostStatusAfterCancel(param);
        
        
        // 2개 쿼리문 모두 실행 성공시 결제 취소 성공
        if(updateBuyerPoint > 0 && updateSellStatus > 0) {
            paymentDAO.sqlSession.commit();
            result.setPath("/trade/sellPostFrontController2?category=allproduct&action=list");
            result.setRedirect(true);
        } else {
            paymentDAO.sqlSession.rollback();
            response.getWriter().write("결제 취소 실패");
            return null;
        }
		return result;
	}
	
	// 포인트 충전페이지 이동
	public Result charging(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Result result = new Result();
		// 세션에서 회원번호 가져오기
        String memberNumber = (String) request.getSession().getAttribute("memberNumber");
        
        // 회원번호 없으면 메인페이지로 이동
        if(memberNumber == null || memberNumber.trim().isEmpty()) {
            result.setPath(request.getContextPath() + "/main.jsp");
            result.setRedirect(true); // 리다이렉트
            return result;
        }

        // 충전 페이지 이동
        request.setAttribute("memberNumber", memberNumber);
        result.setPath("/trade/pointBuy.jsp");
        result.setRedirect(false); 

        return result;
		
	}
	
	
	// 포인트 충전
	public Result chargingOk(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Result result = new Result();
		// 회원 정보 꺼내오기
        String memberNumberStr = request.getParameter("memberNumber");
        
        //충전 포인트 가격 꺼내오기
        String chargePointStr = request.getParameter("chargePoint");
        
        // 회원정보가 없으면 충전 페이지로 이동
        if(memberNumberStr == null || memberNumberStr.trim().isEmpty() ||
                chargePointStr == null || chargePointStr.trim().isEmpty()) {
                 response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2?category=buy&action=charging");
                 return null;
             }
        
        PaymentDAO paymentDAO = new PaymentDAO();
        
        int memberNumber = Integer.parseInt(memberNumberStr);
        int chargePoint = Integer.parseInt(chargePointStr);
        
        // 충전 처리
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("memberNumber", memberNumber);
            param.put("chargePoint", chargePoint);

            int update = paymentDAO.chargeMemberPoint(param);

            if(update > 0) {
                paymentDAO.sqlSession.commit();
                result.setPath(request.getContextPath() + "/trade/sellPostFrontController2?category=allproduct&action=list");
                result.setRedirect(true);
            } else {
                paymentDAO.sqlSession.rollback();
                result.setPath(request.getContextPath() + "/trade/sellPostFrontController2?category=buy&action=charging");
                result.setRedirect(true);
            }

        } catch(Exception e) {
            paymentDAO.sqlSession.rollback();
            e.printStackTrace();
            result.setPath(request.getContextPath() + "/trade/sellPostFrontController2?category=buy&action=charging");
            result.setRedirect(true);
        }

        return result;
    }

	
}
