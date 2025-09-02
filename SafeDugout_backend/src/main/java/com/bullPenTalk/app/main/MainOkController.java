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

		// 경기 일정 목록 조회
		List<MainDTO> schedule = mainDAO.selectSchedule();

		// 일정표와 순위표에서 반복문과 switch문을 통해 팀명이 한글로 출력되도록 변환 
		for(MainDTO scheduleRow : schedule) {
			switch (scheduleRow.getHomeTeamName()) {
			case "doosan":
				scheduleRow.setHomeTeamName("두산");
				break;
			case "lg":
				scheduleRow.setHomeTeamName("LG");
				break;
			case "hanwha":
				scheduleRow.setHomeTeamName("한화");
				break;
			case "samsung":
				scheduleRow.setHomeTeamName("삼성");
				break;
			case "ssg":
				scheduleRow.setHomeTeamName("SSG");
				break;
			case "kt":
				scheduleRow.setHomeTeamName("KT");
				break;
			case "nc":
				scheduleRow.setHomeTeamName("NC");
				break;
			case "lotte":
				scheduleRow.setHomeTeamName("롯데");
				break;
			case "kia":
				scheduleRow.setHomeTeamName("KIA");
				break;
			case "kiwoom":
				scheduleRow.setHomeTeamName("키움");
				break;
			}
			switch (scheduleRow.getAwayTeamName()) {
			case "doosan":
				scheduleRow.setAwayTeamName("두산");
				break;
			case "lg":
				scheduleRow.setAwayTeamName("LG");
				break;
			case "hanwha":
				scheduleRow.setAwayTeamName("한화");
				break;
			case "samsung":
				scheduleRow.setAwayTeamName("삼성");
				break;
			case "ssg":
				scheduleRow.setAwayTeamName("SSG");
				break;
			case "kt":
				scheduleRow.setAwayTeamName("KT");
				break;
			case "nc":
				scheduleRow.setAwayTeamName("NC");
				break;
			case "lotte":
				scheduleRow.setAwayTeamName("롯데");
				break;
			case "kia":
				scheduleRow.setAwayTeamName("KIA");
				break;
			case "kiwoom":
				scheduleRow.setAwayTeamName("키움");
				break;
			}
		}
		for(MainDTO rankRow : rankList) {
			switch (rankRow.getTeamName()) {
			case "doosan":
				rankRow.setTeamName("두산");
				break;
			case "lg":
				rankRow.setTeamName("LG");
				break;
			case "hanwha":
				rankRow.setTeamName("한화");
				break;
			case "samsung":
				rankRow.setTeamName("삼성");
				break;
			case "ssg":
				rankRow.setTeamName("SSG");
				break;
			case "kt":
				rankRow.setTeamName("KT");
				break;
			case "nc":
				rankRow.setTeamName("NC");
				break;
			case "lotte":
				rankRow.setTeamName("롯데");
				break;
			case "kia":
				rankRow.setTeamName("KIA");
				break;
			case "kiwoom":
				rankRow.setTeamName("키움");
				break;
			}
		}
		
		//일정표 목록과 순위표 목록 대입 
		request.setAttribute("rankList", rankList);
		request.setAttribute("schedule", schedule);
		System.out.println("경기 일정 목록 대입");
		System.out.println(schedule);
		
		// 판매글 목록 조회
		List<MainDTO> sellList = mainDAO.selectSellList();
		System.out.println("상품 목록" + sellList);
		request.setAttribute("sellList", sellList);

		// 입문자 가이드 목록 조회
		
		// path 값, redirect 여부 설정
		result.setPath("/main.jsp");
		result.setRedirect(false);

		return result;
	}

}
