package com.bullPenTalk.app.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if(request.getParameter("teamNumber") != null) {
			teamNumber = Integer.valueOf(request.getParameter("teamNumber"));
		}else {
			teamNumber = 0;
		}

		// session에 팀별 값(팀 번호) 저장
		session.setAttribute("teamNumber", teamNumber);

		// 팀 뉴스 목록 조회
		List<TeamMainDTO> newsList = teamMainDAO.selectPostList(teamNumber);
		request.setAttribute("newsList", newsList);

		// 팀 게시글 목록 조회
		List<TeamMainDTO> postList = teamMainDAO.selectPostList(teamNumber);
		request.setAttribute("postList", postList);

		// 팀 유튜브 썸네일 목록 조회
		List<TeamMainDTO> youTubeList = teamMainDAO.selectYouTubeList(teamNumber);
		request.setAttribute("youTubeList", youTubeList);

		// 팀 경기 일정 조회
		List<TeamMainDTO> teamSchedule = teamMainDAO.selectTeamSchedule(teamNumber);
		request.setAttribute("teamSchedule", teamSchedule);

		// 팀 순위 조회
		List<TeamMainDTO> rankList = teamMainDAO.selectTeamRank();
		request.setAttribute("rankList", rankList);
		
		// path 값, redirect 여부 설정
		result.setPath("/app/communityHtml/communityTapPage/teamMain.jsp");
		result.setRedirect(false);
		System.out.println(result.getPath());

		return result;
	}

}
