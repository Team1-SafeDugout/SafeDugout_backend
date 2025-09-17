package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.member.dao.MemberDAO;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageInputInfoController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		HttpSession session  = request.getSession();
		int memberNumber = Integer.parseInt(session.getAttribute("memberNumber").toString());
		
		String inputPw = request.getParameter("password");

		MyPageDAO myPageDao = new MyPageDAO();
		
		String memberPw = myPageDao.getMemberPw(memberNumber);
		
		if(memberPw.equals(inputPw)) {
			MemberDAO memberDAO = new MemberDAO();
			request.setAttribute("memberInfo", memberDAO.getMember(memberNumber));
			result.setPath("/app/memberUpdate/inputInformation.jsp");
			result.setRedirect(false);
		}
		else {
			request.setAttribute("isCorrect", "실패");
			result.setPath("/myPage/changeInfo.mp");
			result.setRedirect(false);
		}
		
		return result;
	}
}
