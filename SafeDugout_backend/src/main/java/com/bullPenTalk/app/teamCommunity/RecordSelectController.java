package com.bullPenTalk.app.teamCommunity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.BatterRecordDTO;
import com.bullPenTalk.app.dto.DeffenseBaseRecordDTO;
import com.bullPenTalk.app.dto.PitcherRecordDTO;
import com.bullPenTalk.app.dto.TeamBatterRecordDTO;
import com.bullPenTalk.app.dto.TeamPitcherRecordDTO;
import com.bullPenTalk.app.dto.TeamRecordDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class RecordSelectController {

		// 팀기록 조회
		public Result teamRecordselect(String action, HttpServletRequest request, HttpServletResponse response) {
	        Result result = new Result();

	        // 팀번호 없으면 메인페이지로 이동
	        String teamNumberStr = request.getParameter("teamNumber");
	        if (teamNumberStr == null || teamNumberStr.trim().isEmpty()) {
	            System.out.println("teamNumber 값이 없습니다");
	            result.setPath("/app/communityHtml/communityTapPage/teamMain.jsp");
	            result.setRedirect(true);
	            return result;
	        }

	        int teamNumber = Integer.parseInt(teamNumberStr);

	        TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();

	        // 팀 번호로 기록 조회
	        Map<String, Integer> param = new HashMap<>();
	        param.put("teamNumber", teamNumber);

	        List<TeamRecordDTO> teamRecords = teamCommunityDAO.selectTeamRecord(param);
	        List<TeamPitcherRecordDTO> pitcherRecords = teamCommunityDAO.selectTeamPitcherRecord(param);
	        List<TeamBatterRecordDTO> batterRecords = teamCommunityDAO.selectTeamBatterRecord(param);
	        List<DeffenseBaseRecordDTO> defenseRecords = teamCommunityDAO.selectTeamDeffenseRecord(param);

	        // 조회결과 없으면 메인페이지로 이동
	        if (teamRecords.isEmpty() && pitcherRecords.isEmpty() && batterRecords.isEmpty() && defenseRecords.isEmpty()) {
	            System.out.println("해당 팀의 기록이 없습니다");
	            result.setPath("/app/communityHtml/communityTapPage/teamStats.jsp");
	            result.setRedirect(true);
	            return result;
	        }
	        
	        request.setAttribute("teamRecords", teamRecords);
	        request.setAttribute("pitcherRecords", pitcherRecords);
	        request.setAttribute("batterRecords", batterRecords);
	        request.setAttribute("defenseRecords", defenseRecords);
	        request.setAttribute("teamNumber", teamNumber);
	        
			result.setPath("/app/communityHtml/communityTapPage/teamStats.jsp");
			result.setRedirect(false);

			return result;
		}
	
		// 선수기록 조회
		public Result playerRecordSelect(String action, HttpServletRequest request, HttpServletResponse response) {
		    Result result = new Result();

		    String playerIdStr = request.getParameter("playerId");
		    if (playerIdStr == null || playerIdStr.trim().isEmpty()) {
		        System.out.println("playerId 값이 없습니다");
		        result.setPath("/app/communityHtml/communityTapPage/teamPlayerStats.jsp");
		        result.setRedirect(true);
		        return result;
		    }

		    int playerId = Integer.parseInt(playerIdStr);
		    TeamCommunityDAO dao = new TeamCommunityDAO();

		    Map<String, Integer> param = new HashMap<>();
		    
		    param.put("playerId", playerId);

		    List<BatterRecordDTO> batterRecords = dao.selectPlayerBatter(param);
		    List<PitcherRecordDTO> pitcherRecords = dao.selectPlayerPitcher(param);
		     
		    if (batterRecords.isEmpty() && pitcherRecords.isEmpty()) {
		        System.out.println("해당 선수의 기록이 없습니다");
		        result.setPath("/app/communityHtml/communityTapPage/teamPlayerStats.jsp");
		        result.setRedirect(true);
		        return result;
		    }

		    request.setAttribute("batterRecords", batterRecords);
		    request.setAttribute("pitcherRecords", pitcherRecords);
		    request.setAttribute("playerId", playerId);

		    result.setPath("/app/communityHtml/communityTapPage/playerStats.jsp");
		    result.setRedirect(false);
		    return result;
		}
}
