package com.bullPenTalk.app.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.TeamMainDTO;
import com.bullPenTalk.app.main.dao.TeamMainDAO;

public class TeamMainOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 진입 확인 메시지
		System.out.println("팀 커뮤니티 메인 페이지 처리 컨트롤러 진입");

		// TeamMainDAO, Result 객체 생성
		TeamMainDAO teamMainDAO = new TeamMainDAO();
		System.out.println("DAO 생성 완료");
		Result result = new Result();

		// session 저장
		HttpSession session = request.getSession();

		int teamNumber = 0;

		// 팀별 값(팀 번호) 저장
		if (request.getParameter("teamNumber") != null) {
			teamNumber = Integer.valueOf(request.getParameter("teamNumber"));
		} else {
			teamNumber = 0;
		}

		// session에 팀별 값(팀 번호) 저장
		session.setAttribute("teamNumber", teamNumber);

		// session 만료 시간 조회 
		System.out.println(session.getMaxInactiveInterval());
		
		// 팀 뉴스 목록 조회
		List<TeamMainDTO> newsList = teamMainDAO.selectNewsList(teamNumber);
		System.out.println(newsList);
		request.setAttribute("newsList", newsList);

		// 팀 게시글 목록 조회
		List<TeamMainDTO> postList = teamMainDAO.selectPostList(teamNumber);
		System.out.println(postList);
		request.setAttribute("postList", postList);

		// 팀 유튜브 썸네일 목록 조회
		List<TeamMainDTO> youTubeList = teamMainDAO.selectYouTubeList(teamNumber);
		request.setAttribute("youTubeList", youTubeList);

		// 팀 경기 일정 조회
		List<TeamMainDTO> teamSchedule = teamMainDAO.selectTeamSchedule(teamNumber);

		// 팀 순위 조회
		List<TeamMainDTO> rankList = teamMainDAO.selectTeamRank();

		// 일정표와 순위표에서 반복문과 switch문을 통해 팀명이 한글로 출력되도록 변환
		for (TeamMainDTO scheduleRow : teamSchedule) {
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
		for (TeamMainDTO rankRow : rankList) {
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
		
		//주중 경기 리스트 생성 
		List<TeamMainDTO> teamScheduleWeekdays = new ArrayList();
		
		//주말 경기 리스트 생성 
		List<TeamMainDTO> teamScheduleWeekends = new ArrayList();
		
		//경기 일정 리스트를 주중, 주말로 분배 
		for(TeamMainDTO schedule : teamSchedule) {
			if(schedule.getScheduleDate().indexOf("금") != -1 
					|| schedule.getScheduleDate().indexOf("토") != -1
					|| schedule.getScheduleDate().indexOf("일") != -1) {
				teamScheduleWeekends.add(schedule);
			}else {
				teamScheduleWeekdays.add(schedule);
			}
		}
		
		// 일정표, 순위표 대입
		request.setAttribute("teamScheduleWeekdays", teamScheduleWeekdays);
		request.setAttribute("teamScheduleWeekends", teamScheduleWeekends);
		request.setAttribute("rankList", rankList);

		// path 값, redirect 여부 설정
		result.setPath("/app/communityHtml/communityTapPage/teamMain.jsp");
		result.setRedirect(false);
		System.out.println(result.getPath());

		return result;
	}

}
