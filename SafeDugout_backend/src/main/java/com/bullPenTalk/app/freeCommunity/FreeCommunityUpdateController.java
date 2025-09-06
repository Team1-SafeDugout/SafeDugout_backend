package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;

public class FreeCommunityUpdateController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("업데이트 요청");
		int boardNumber = Integer.valueOf(request.getParameter("postNumber"));
		FreePostDAO boardDAO = new FreePostDAO();
		Result result = new Result();
		
		System.out.println(boardNumber);
		
		request.setAttribute("freePostDetail", boardDAO.selectDetail(boardNumber));
		
		result.setPath("/app/freeCommunity/freeCommunityUpdate.jsp");
		result.setRedirect(false);
		return result;
	}

}
