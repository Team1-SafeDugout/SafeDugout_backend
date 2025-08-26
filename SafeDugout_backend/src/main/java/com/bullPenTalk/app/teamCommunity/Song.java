package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Song implements CommunityService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어온 액션: "  + action);	
		
		// 객체생성
		Result result = new Result();
		PostSelectListController list = new PostSelectListController();
		
		switch(action) {
		case "teamsong" :
			result = list.teamSongList(action, request, response);
			break;
		case "playersong":
			result = list.playerSongList(action, request, response);
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
