package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class BuyProduct implements TradeService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어온 액션값: " + action);
		// 객체 생성
		Result result = new Result();
		BuyController buy = new BuyController();
		switch(action) {
		case "buy" :
			result =  buy.buy(request, response); // 결제 페이지 이동
			break;
		case "payment":
			result = buy.payment(request, response); // 결제 진행
			break;		
		case "canceled" :
			result = buy.canceled(request, response); // 구매 취소
			break;
		case "charging" :
			result = buy.charging(request, response); // 충전페이지 이동
			break;
		case "chargingok":
			result = buy.chargingOk(request, response); // 충전 진행
			break;
		default :
			
			break;
		}
		
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}

		}
		
	}
	

}
