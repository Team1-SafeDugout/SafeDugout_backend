package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Stadium implements CommunityService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어온 action:" + action);
		// 객체 생성
		Result result = new Result();
		PostDetailController stadium = new PostDetailController();
		switch(action) {
		case "stadium" :
			result = stadium.stadiumetailselect(action, request, response);
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
