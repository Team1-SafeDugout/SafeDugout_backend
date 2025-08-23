package com.bullPenTalk.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.main.dao.MainDAO;

public class SelectMainDetailOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("메인 공지사항 상세 조회 처리 컨트롤러 진입");
		MainDAO mainDAO = new MainDAO();
		Result result = new Result();
		
		
		
		
		return result;
	}
	
	
}
