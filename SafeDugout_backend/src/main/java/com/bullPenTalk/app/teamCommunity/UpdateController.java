package com.bullPenTalk.app.teamCommunity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class UpdateController {

	public Result update(HttpServletRequest request, HttpServletResponse response) {
		
		int postNumber = Integer.valueOf(request.getParameter("postNumber"));
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		
		request.setAttribute("sellPost", teamCommunityDAO.postDetail(postNumber));
		
		result.setPath("/app/communityHtml/communityTapPage/Update.jsp");
		result.setRedirect(false);
			
		return result;
	}
}
