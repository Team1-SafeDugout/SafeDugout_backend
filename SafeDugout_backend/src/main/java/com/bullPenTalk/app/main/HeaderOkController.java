package com.bullPenTalk.app.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.main.dao.MainDAO;

public class HeaderOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MainDAO mainDAO = new MainDAO();
		Result result = new Result();

		//헤더에서 띄울 최신 공지 저장
		String recentTitle = mainDAO.getRecent();
		if(recentTitle == null) {
			recentTitle = " ";
		}
		System.out.println("최신 공지 제목 조회 완료");
		
		// 응답 설정
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		// 응답 작성
		try (PrintWriter out = response.getWriter()) {
			out.print(recentTitle);
			out.flush();
		}

		// Result 객체 반환(JSON 응답 처리 후 페이지 이동 없음)
		result.setPath(null); // 페이지 이동이 없음을 명시
		result.setRedirect(false); // 리다이렉트 설정(false로 유지)
		
		return null;
	}
	
}
