package com.bullPenTalk.app.trade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class UpdateController {

	public Result update(HttpServletRequest request, HttpServletResponse response) {
		
		int sellPostNumber = Integer.valueOf(request.getParameter("sellPostNumber"));
		SellPostDAO sellPostDAO = new SellPostDAO();
		Result result = new Result();
		
		request.setAttribute("sellPost", sellPostDAO.selectDetail(sellPostNumber));
		
		result.setPath("/app/trade/Update.jsp");
		result.setRedirect(false);
			
		return result;
	}
}
