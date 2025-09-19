package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.DeffenseBaseRecordDTO;
import com.bullPenTalk.app.dto.TeamBatterRecordDTO;
import com.bullPenTalk.app.dto.TeamPitcherRecordDTO;
import com.bullPenTalk.app.dto.TeamRecordDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class RecordSelectController {
		
	private StatsJSONReader statsReader = new StatsJSONReader();
	private static final Logger logger = Logger.getLogger(RecordSelectController.class.getName());
		

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
        result.setPath("/app/communityHtml/communityTapPage/teamPlayerStats.jsp");

        try {
            // URL 파라미터에서 teamNumber를 가져옵니다.
            String teamNumberStr = request.getParameter("teamNumber");

            // teamNumber가 없는 경우, 세션에서 가져옵니다.
            HttpSession session = request.getSession();
            if (teamNumberStr == null || teamNumberStr.isEmpty()) {
                Integer sessionTeamNumber = (Integer) session.getAttribute("teamNumber");
                if (sessionTeamNumber != null) {
                    teamNumberStr = sessionTeamNumber.toString();
                    logger.info("세션에서 teamNumber를 가져옴: " + teamNumberStr);
                }
            } else {
                // 새로운 teamNumber가 있을 경우 세션에 저장합니다.
                Integer newTeamNumber = Integer.parseInt(teamNumberStr);
                session.setAttribute("teamNumber", newTeamNumber);
                logger.info("새로운 teamNumber를 세션에 저장: " + newTeamNumber);
            }

            Integer teamNumber = teamNumberStr != null ? Integer.parseInt(teamNumberStr) : null;
            
            if (teamNumber == null) {
                // teamNumber가 세션에도 없고 URL에도 없는 경우
                logger.warning("teamNumber를 가져올 수 없습니다. 기본값으로 리다이렉트합니다.");
                result.setPath("/index.jsp"); // 또는 적절한 에러 페이지
                result.setRedirect(true);
                return result;
            }
            
            // 투수와 타자 기록을 각각 별도의 리스트로 가져와서 request에 담습니다.
            List<?> pitcherStatsList = StatsJSONReader.readStats(teamNumber, "pitcher");
            List<?> batterStatsList = StatsJSONReader.readStats(teamNumber, "batter");

            // JSP로 전달할 데이터를 request 속성에 담습니다.
            request.setAttribute("pitcherStatsList", pitcherStatsList);
            request.setAttribute("batterStatsList", batterStatsList);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            // 에러 처리: 에러 페이지로 리다이렉트하거나 메시지를 전달합니다.
            result.setPath("/error.jsp");
            result.setRedirect(false);
        }
        return result;
    }
}
