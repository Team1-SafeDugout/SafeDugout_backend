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
        System.out.println(sellPostNumberStr);
        String sellPostStr = request.getParameter("sellPostNumber");
        if(sellPostStr == null || sellPostStr.trim().isEmpty()){
            throw new IllegalArgumentException("sellPostNumber가 비어있습니다.");
        }
        int sellPostNumber = Integer.parseInt(sellPostStr);
        System.out.println("buy 진입");
        // 판매정보 가져오기
        if(sellPostNumberStr == null || sellPostNumberStr.trim().isEmpty()) {
           response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2?category=allproduct&action=list");
           return null;
        }
		
         sellPostNumber = Integer.parseInt(sellPostNumberStr);
		
        // DAO를 통해 상품 정보 조회
        SellPostDAO sellPostDAO = new SellPostDAO();
        SellPostDetailDTO sellPostDetail = sellPostDAO.selectDetail(sellPostNumber);

        if(sellPostDetail == null) {
           response.sendRedirect(request.getContextPath() + "/trade/productList.jsp");
           return null;
        }
        
        
        // JSP에 상품 정보 전달
        request.setAttribute("sellPostDetail", sellPostDetail);
        result.setPath("/app/trade/productBuy.jsp");
        result.setRedirect(false); 
        System.out.println("result:" + result);
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
		System.out.println("payment 메소드 진입");
		// 멤버 포인트 조회
	    MemberDAO memberDAO = new MemberDAO();
	    int buyerPoint = memberDAO.getMemberPoint(buyerNumber);
	    
	    // 포인트 부족시 충전페이지 이동
	    if(buyerPoint < pricePoint) {
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
		
	    if(buyer > 0 && seller > 0 && trade > 0 && updateStatus > 0) {
	        result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=allproduct&action=list");
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
            response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=allproduct&action=list");
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
            result.setPath("/trade/sellPostFrontController2.tr?category=allproduct&action=list");
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
        Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
        
        
        // 회원번호 없으면 메인페이지로 이동
        if(memberNumber == null ) {
            result.setPath(request.getContextPath() + "/main.jsp");
            result.setRedirect(true); // 리다이렉트
            return result;
        }

        // 충전 페이지 이동
        request.setAttribute("memberNumber", memberNumber);
        result.setPath("/app/trade/pointBuy.jsp");
        result.setRedirect(false); 

        return result;
		
	}
	
	
	// 포인트 충전
	 public Result chargingOk(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        Result result = new Result();

	        // 파라미터 가져오기
	        String memberNumberStr = request.getParameter("memberNumber"); // 회원번호
	        String chargePointStr = request.getParameter("chargePoint"); // 충전 포인트
	        String paymentId = request.getParameter("paymentId");      // IMP 결제번호
	        String merchantUid = request.getParameter("merchantUid");  // 가맹점 주문번호
	        String payMethod = request.getParameter("payMethod");      // 결제수단
	        String paidAt = request.getParameter("paidAt");            // 결제 완료 시각

	        
	        System.out.println(memberNumberStr);
	        System.out.println(chargePointStr);
	        System.out.println(paymentId);
	        System.out.println(merchantUid);
	        System.out.println(payMethod);
	        System.out.println(paidAt);
	        
	        // 회원번호, 충전 금액이 null 이면 충전페이지로 강제 리다이랙트
	        if(memberNumberStr == null || chargePointStr == null ||
	           memberNumberStr.trim().isEmpty() || chargePointStr.trim().isEmpty()) {
	            response.sendRedirect(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=buy&action=charging");
	            return null;
	        }
	        
	         // 문자열로 받은 회원번호, 충전금액 형변환
	        int memberNumber = Integer.parseInt(memberNumberStr);
	        int chargePoint = Integer.parseInt(chargePointStr);

	        PaymentDAO paymentDAO = new PaymentDAO();

	        try {
	        	
	        	// 결제 api key로 서버검증
	            String impKey = "7128467038170850";
	            String impSecret = "xuhDtfZuwNLH0rqd2SRfauYejfRiZfPvyjUarvK5JTnJVwBXqfCuGzgx2G0mJtaF0Ul5aQfRBaRvyI1j";
	            // 아임포트 토큰 요청 Json으로 토큰 획득
	            org.jsoup.Connection.Response jsoupResponse = org.jsoup.Jsoup.connect("https://api.iamport.kr/users/getToken")
	                    .ignoreContentType(true)
	                    .method(org.jsoup.Connection.Method.POST)
	                    .data("imp_key", impKey)
	                    .data("imp_secret", impSecret)
	                    .execute();


	            // JSON 문자열 파싱
	            JSONParser parser = new JSONParser();
	            JSONObject tokenObj = (JSONObject) parser.parse(jsoupResponse.body());

	            // "response" 객체 가져오기
	            JSONObject responseObj = (JSONObject) tokenObj.get("response");

	            // access_token 추출
	            String accessToken = (String) responseObj.get("access_token");

	            System.out.println("Access Token: " + accessToken);

	            
	         // imp_uid로 결제 정보 조회
	            String impUid = request.getParameter("paymentId");

	            org.jsoup.Connection.Response paymentResponse = org.jsoup.Jsoup
	                    .connect("https://api.iamport.kr/payments/" + impUid)
	                    .ignoreContentType(true)
	                    .header("Authorization", "Bearer " + accessToken)
	                    .method(org.jsoup.Connection.Method.GET)
	                    .execute();

	            // 응답 JSON 문자열
	            String paymentJson = paymentResponse.body();

	            // JSON 파싱 예시 (org.json.simple 기준)
	            org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
	            org.json.simple.JSONObject paymentObj = (org.json.simple.JSONObject) parser.parse(paymentJson);

	            // 실제 결제 정보 접근
	            org.json.simple.JSONObject respObj = (org.json.simple.JSONObject) paymentObj.get("response");

	            // 예: 결제 금액
	            Long amount = (Long) responseObj.get("amount");
	            System.out.println("결제 금액: " + amount);
	        	
	            // 1. 회원 포인트 충전
	            Map<String, Object> param = new HashMap<>();
	            param.put("memberNumber", memberNumber);
	            param.put("chargePoint", chargePoint);

	            int update = paymentDAO.chargeMemberPoint(param);

	            if(update > 0) {
	                // 2. 결제 기록 저장
	                PointPaymentDTO payment = new PointPaymentDTO();
	                payment.setPaymentId(paymentId);
	                payment.setMerchantUid(merchantUid);
	                payment.setMemberNumber(memberNumber);
	                payment.setAmount(chargePoint);
	                payment.setStatus("paid"); // 결제 완료
	                payment.setPayMethod(payMethod);
	                payment.setPaidAt(paidAt); // "YYYY-MM-DD HH:mm:ss" 형태
	                // createdAt는 매퍼에서 SYSDATE로 처리

	                paymentDAO.insertPointPayment(payment);

	                // 3. 커밋
	                paymentDAO.sqlSession.commit();

	                // 4. 성공 페이지 이동
	                result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=allproduct&action=list");
	                result.setRedirect(true);

	            } else {
	                paymentDAO.sqlSession.rollback();
	                result.setPath(request.getContextPath() + "/trade/sellPostFrontController2.tr?category=buy&action=charging");
	                result.setRedirect(true);
	            }

	        } catch(Exception e) {
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
