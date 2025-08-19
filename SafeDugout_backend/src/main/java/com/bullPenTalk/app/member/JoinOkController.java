package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class JoinOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = null;
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		memberDTO = memberDAO.login(memberId, memberPw);
		
		//로그인 성공시와 실패시 조건
		if(memberDTO != null) {
			System.out.println("로그인 성공");
			//로그인 성공시 세션에 사용자 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("memberDTO", memberDTO);
			
			//쿠키에 사용자 id 저장
			Cookie cookie = new Cookie("memberId", memberId);
			
			//유효기간 1일
			cookie.setMaxAge(60 * 60 * 24);
			
			System.out.println("로그인가능");
			result = new Result();
			
			result.setPath(request.getContextPath() + "/mainLogin.html");
			System.out.println(result.getPath());
			result.setRedirect(true);		
		}else {
			//로그인 실패 시 로그인 페이지로 이동
			result.setPath(request.getContextPath() + "/member/login.jsp");
			result.setRedirect(true);
		}
		
		return result;
	}
	
}
