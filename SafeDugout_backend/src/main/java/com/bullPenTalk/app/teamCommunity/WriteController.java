package com.bullPenTalk.app.teamCommunity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class WriteController {
	
	public Result writerequest(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		String path = null;
		
		if(memberNumber == null) {
			path = "/app/login/login.jsp";
		}else {
			path = "/app/communityHtml/communityTapPage/teamPostWriting.jsp";
			request.setAttribute("memberId", memberDAO.getMemberIdByNumber(memberNumber));
		}
		
		result.setPath(path);
		result.setRedirect(false);
		
		
		return result;
	}
}

