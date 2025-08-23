package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundService implements TradeService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response) {
		AllProduct allProduct = new AllProduct();
		try {
			allProduct.execute("list", request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
