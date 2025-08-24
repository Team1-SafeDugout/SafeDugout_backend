package com.bullPenTalk.app.trade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class UpdateController {

	public Result update(HttpServletRequest request, HttpServletResponse response) {
		
		int bsellPostNumber = Integer.valueOf(request.getParameter("sellPostNumber"));
		SellPostDAO boardDAO = new SellPostDAO();
		Result result = new Result();
		
		request.setAttribute("board", boardDAO.select(boardNumber));
		
		result.setPath("/app/board/boardUpdate.jsp");
		result.setRedirect(false);
			
		return result;
	}
}
