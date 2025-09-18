package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;

public class LogoutOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		//로그아웃 버튼 누른 페이지 저장 
		String curPage = request.getParameter("curPage");
		System.out.println(curPage);
		if(curPage.equals("main")) {
			result.setPath("/main.ma");
		}
		if(curPage.equals("mainTeam")) {
			result.setPath("/main/mainTeam.ma?teamNumber=" + request.getSession().getAttribute("teamNumber"));
		}
		result.setRedirect(true);
		request.getSession().invalidate(); // 세션 무효화
		return result;
	}

}
