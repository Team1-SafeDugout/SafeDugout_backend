package com.bullPenTalk.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.main.dao.MainDAO;

public class MainTeamOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 진입 확인 메시지
		System.out.println("팀 커뮤니티 메인 페이지 처리 컨트롤러 진입");

		// MainDAO, Result 객체 생성
		MainDAO mainDAO = new MainDAO();
		System.out.println("DAO 생성 완료");
		Result result = new Result();

		// path 값, redirect 여부 설정
		result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp");
		result.setRedirect(true);
		
		// session 저장 
		HttpSession session = request.getSession();
		
		// session에 팀별 값(팀 번호) 저장
		session.setAttribute("teamNumber", request.getParameter("teamNumber"));
		
		return result;
	}

}
