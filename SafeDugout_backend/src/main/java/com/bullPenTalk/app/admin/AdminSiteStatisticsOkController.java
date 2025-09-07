package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminSellDAO;
import com.bullPenTalk.app.admin.dao.AdminTradeDAO;

public class AdminSiteStatisticsOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		
		result.setPath("/app/admin/adminMenu/adminSiteStatistics.jsp");
		
		AdminTradeDAO tradeList = new AdminTradeDAO();
		AdminSellDAO sellList = new AdminSellDAO();
		
		request.setAttribute("sellPostNum", tradeList.getTotal());
		request.setAttribute("tradePostNum", sellList.getTotal());
		
		result.setRedirect(false);

		return result;
	}
	
}
