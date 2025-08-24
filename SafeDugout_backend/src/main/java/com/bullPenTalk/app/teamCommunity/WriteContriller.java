package com.bullPenTalk.app.teamCommunity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class WriteContriller {
	
	public Result writerequest(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		String path = null;
		
		if(memberNumber == null) {
			path = "/app/member/login.jsp";
		}else {
			path = "/app/communityHtml/communityTapPage/PostWriting.jsp";
			request.setAttribute("memberId", memberDAO.getMemberNumber(memberNumber));
		}
		
		result.setPath(path);
		result.setRedirect(false);
		
		
		return result;
	}
}

