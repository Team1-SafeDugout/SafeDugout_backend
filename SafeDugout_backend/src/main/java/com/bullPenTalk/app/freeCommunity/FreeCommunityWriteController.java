package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class FreeCommunityWriteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		MemberDAO memberDAO = new MemberDAO();
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		String path = null;
		System.out.println("넘어온 memberId: " + memberNumber);
		if(memberNumber == null) {
			path = "/app/login/login.jsp";
		}else {
			path = "/app/freeCommunity/freeCommunityWriting.jsp";
			request.setAttribute("memberId", memberDAO.getMemberNumber(memberNumber));
		}
		
		result.setPath(path);
		result.setRedirect(false);
		return result;
	}

}
