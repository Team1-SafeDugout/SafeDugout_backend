package com.bullPenTalk.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.main.dao.MainDAO;

public class MainOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//진입 확인 메시지 
		System.out.println("메인 공지사항 상세 조회 처리 컨트롤러 진입");
		
		//MainDAO, Result 객체 생성
		MainDAO mainDAO = new MainDAO();
		System.out.println("DAO 생성 완료");
		Result result = new Result();
		
		//path, redirect 여부 설정 
		result.setPath("/main.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
