package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.TeamNoticePostDTO;

public class AdminCreateNoticePostController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	private TeamNoticePostDTO addTeamNotice(HttpServletRequest request) {
		TeamNoticePostDTO teamNoticeDTO = new TeamNoticePostDTO();
		String postTitle = request.getParameter("");
		String postContent = request.getParameter("");
		String targetTeam = request.getParameter("");
		return teamNoticeDTO;
	}
	
}
