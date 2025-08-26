package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminTradeDAO;
import com.bullPenTalk.app.dto.AdminTradeListDTO;

public class AdminReadTradeOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		AdminTradeDAO tradeDAO = new AdminTradeDAO();
		if(request.getParameter("postNumber") == null) {
			System.out.println("눌값임");
			return null;
		}
		
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		
		request.setAttribute("tradePostDetail", tradeDAO.selectDetail(postNumber));
		
		result.setPath("/app/admin/adminDetailMenu/adminProductTradingDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
