package com.bullPenTalk.app.teamCommunity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.StadiumDTO;
import com.bullPenTalk.app.dto.StadiumFoodDTO;
import com.bullPenTalk.app.dto.StadiumTicketDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class RecordSelectController {

	// 팀기록 조회
		public Result teamRecordselect(String action, HttpServletRequest request, HttpServletResponse response) {
	        Result result = new Result();

	        // teamNumber 체크
	        String teamNumberStr = request.getParameter("teamNumber");
	        if (teamNumberStr == null || teamNumberStr.trim().isEmpty()) {
	            System.out.println("teamNumber 값이 없습니다");
	            result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp");
	            result.setRedirect(true);
	            return result;
	        }

	        int teamNumber = Integer.parseInt(teamNumberStr);

	        TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();

	        // 팀 번호로 기록 조회
	        StadiumDTO stadium = teamCommunityDAO.selectTeamRecord(teamNumber);
	        if (stadium == null) {
	            System.out.println("해당 팀의 기록 없습니다");
	            result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp");
	            result.setRedirect(true);
	            return result;
	        }

	        int stadiumNumber = stadium.getStadiumNumber();

	        // 경기장 티켓 및 먹거리 조회
	        List<StadiumTicketDTO> tickets = teamCommunityDAO.selectTicket(stadiumNumber);
	        List<StadiumFoodDTO> foods = teamCommunityDAO.selectFood(stadiumNumber);
				

			request.setAttribute("stadium", stadium);
			request.setAttribute("tickets", tickets);
			request.setAttribute("foods", foods);
			result.setPath("/app/communityHtml/communityTapPage/teamStadium.jsp");
			result.setRedirect(false);

			return result;
		}
	
}
