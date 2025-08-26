package com.bullPenTalk.app.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MainDTO;
import com.bullPenTalk.app.main.dao.MainDAO;

public class MainOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 진입 확인 메시지
		System.out.println("메인 페이지 처리 컨트롤러 진입");

		// MainDAO, Result 객체 생성
		MainDAO mainDAO = new MainDAO();
		System.out.println("DAO 생성 완료");
		Result result = new Result();

		// 팀 순위 조회
		List<MainDTO> rankList = mainDAO.selectTeamRank();
		request.setAttribute("rankList", rankList);

		// 경기 일정 목록 조회
		List<MainDTO> schedule = mainDAO.selectSchedule();
		request.setAttribute("schedule", schedule);

		// 최신 상품 목록 조회
		List<MainDTO> sellList = mainDAO.selectSellList();
		request.setAttribute("sellList", sellList);

		// 입문자 가이드 목록 조회
		
		// path 값, redirect 여부 설정
		result.setPath("/main.jsp");
		result.setRedirect(false);

		return result;
	}

}
