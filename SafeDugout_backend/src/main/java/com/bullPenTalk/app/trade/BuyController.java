package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.SellPostDetailDTO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class BuyController {
	
	public Result buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sellPostNumberStr = request.getParameter("sellPostNumber");
        Result result = new Result();
        
        // 요청 파라미터에서 sellPostNumber 가져오기
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
	
}
