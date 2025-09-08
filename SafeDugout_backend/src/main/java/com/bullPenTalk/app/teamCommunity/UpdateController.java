package com.bullPenTalk.app.teamCommunity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class UpdateController {

	public Result update(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("업데이트 요청");
		int boardNumber = Integer.valueOf(request.getParameter("postNumber"));
		FreePostDAO boardDAO = new FreePostDAO();
		Result result = new Result();
		
		System.out.println(boardNumber);
		
		request.setAttribute("postDetail", boardDAO.selectDetail(boardNumber));
		
		result.setPath("/app/communityHtml/communityTapPage/teamPostUpdate.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
