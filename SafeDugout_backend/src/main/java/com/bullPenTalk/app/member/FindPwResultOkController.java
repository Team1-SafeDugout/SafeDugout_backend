package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;

public class FindPwResultOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		// 회원번호 변수에 저장 
		int memberNumber = Integer.valueOf(request.getParameter("memberNumber"));
		
		// 회원번호 저장 
		request.setAttribute("memberNumber", memberNumber);
		
		// 경로, redirect 여부 설정
		result.setPath("/app/findPw/findPwChange.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
