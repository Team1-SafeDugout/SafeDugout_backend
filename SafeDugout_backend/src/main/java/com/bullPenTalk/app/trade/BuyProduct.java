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
		Result result = new Result();
		
		switch(action) {
		case "buy" :
			
			break;
		case "payment":
			
			break;
			
		case "canceled" :
			
			break;
		case "charging" :
			
			break;
		}
		
	}
	

}
