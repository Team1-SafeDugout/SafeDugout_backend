package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class AdminReadTradeOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		SellPostDAO sellPostDAO = new SellPostDAO();
		if(request.getParameter("postNumber") == null) {
			System.out.println("눌값임");
			return null;
		}
		
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		
		request.setAttribute("sellPostDetail", sellPostDAO.selectDetail(postNumber));
		
		result.setPath("${pageContext.request.contextPath}/app"
				+ "/admin/adminDetailMenu/adminProductTradingDetail.jsp");
		result.setRedirect(true);
		
		return result;
	}

}
