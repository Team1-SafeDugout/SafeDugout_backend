package com.bullPenTalk.app.teamCommunity.dao;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bullPenTalk.app.dto.TeamNoticePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

	public class TeamCommunityNoticeDAO {
		 public SqlSession sqlSession;

		    public TeamCommunityNoticeDAO () {
		    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		    }

	    // 공지 목록 조회 
	    public List<TeamNoticePostDTO> selectTeamNotices(int teamNumber, int startRow, int endRow) throws SQLException {
	        String sql = """
	            SELECT * FROM (
	                SELECT ROWNUM AS rnum, subquery.*
	                FROM (
	                    SELECT NP.NOTICE_POST_NUMBER,
	                           NT.NOTICE_TYPE,
	                           NP.NOTICE_POST_TITLE,
	                           NP.NOTICE_POST_CONTENT,
	                           NP.NOTICE_POST_DATE,
	                           NVL(NP.NOTICE_POST_UPDATE, NP.NOTICE_POST_DATE) AS LAST_UPDATE,
	                           A.ADMIN_NAME,
	                           T.TEAM_NAME
	                    FROM TBL_NOTICE_POST NP
	                    JOIN TBL_NOTICE_TYPE NT ON NP.NOTICE_TYPE_ID = NT.NOTICE_TYPE_ID
	                    JOIN TBL_ADMIN A ON NP.ADMIN_NUMBER = A.ADMIN_NUMBER
	                    JOIN TBL_TEAM T ON NP.TEAM_NUMBER = T.TEAM_NUMBER
	                    WHERE NT.NOTICE_ID = 2 AND NP.TEAM_NUMBER = ?
	                    ORDER BY NP.NOTICE_POST_DATE DESC
	                ) subquery
	                WHERE ROWNUM <= ?
	            ) WHERE rnum >= ?
	            """;

	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, teamNumber);
	            stmt.setInt(2, endRow);
	            stmt.setInt(3, startRow);

	            ResultSet rs = stmt.executeQuery();
	            List<TeamNoticePostDTO> list = new ArrayList<>();
	            while (rs.next()) {
	                list.add(new TeamNoticePostDTO(
	                    rs.getInt("NOTICE_POST_NUMBER"),
	                    rs.getString("NOTICE_TYPE"),
	                    rs.getString("NOTICE_POST_TITLE"),
	                    rs.getString("NOTICE_POST_CONTENT"),
	                    rs.getTimestamp("NOTICE_POST_DATE"),
	                    rs.getTimestamp("LAST_UPDATE"),
	                    rs.getString("ADMIN_NAME"),
	                    rs.getString("TEAM_NAME")
	                ));
	            }
	            return list;
	        }
	    }

	    // 공지 상세 조회
	    public TeamNoticePostDTO selectTeamNoticeDetail(int noticePostNumber) throws SQLException {
	        String sql = """
	            SELECT NP.NOTICE_POST_NUMBER,
	                   NP.NOTICE_POST_TITLE,
	                   NP.NOTICE_POST_CONTENT,
	                   NP.NOTICE_POST_DATE,
	                   NVL(NP.NOTICE_POST_UPDATE, NP.NOTICE_POST_DATE) AS LAST_UPDATE,
	                   A.ADMIN_NAME,
	                   T.TEAM_NAME,
	                   AT.ATTACHMENT_NUMBER,
	                   AT.ATTACHMENT_NAME,
	                   AT.ATTACHMENT_PATH
	            FROM TBL_NOTICE_POST NP
	            JOIN TBL_NOTICE_TYPE NT ON NP.NOTICE_TYPE_ID = NT.NOTICE_TYPE_ID
	            JOIN TBL_ADMIN A ON NP.ADMIN_NUMBER = A.ADMIN_NUMBER
	            JOIN TBL_TEAM T ON NP.TEAM_NUMBER = T.TEAM_NUMBER
	            LEFT JOIN TBL_NOTICE_ATTACHMENT NA ON NP.NOTICE_POST_NUMBER = NA.NOTICE_POST_NUMBER
	            LEFT JOIN TBL_ATTACHMENT AT ON NA.ATTACHMENT_NUMBER = AT.ATTACHMENT_NUMBER
	            WHERE NP.NOTICE_POST_NUMBER = ? AND NT.NOTICE_ID = 2
	            """;

	        try (PreparedStatement stmt = prepareStatement(sql)) {
	            stmt.setInt(1, noticePostNumber);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new TeamNoticePostDTO(
	                    rs.getInt("NOTICE_POST_NUMBER"),
	                    rs.getString("NOTICE_POST_TITLE"),
	                    rs.getString("NOTICE_POST_CONTENT"),
	                    rs.getTimestamp("NOTICE_POST_DATE"),
	                    rs.getTimestamp("LAST_UPDATE"),
	                    rs.getString("ADMIN_NAME"),
	                    rs.getString("TEAM_NAME"),
	                    rs.getInt("ATTACHMENT_NUMBER"),
	                    rs.getString("ATTACHMENT_NAME"),
	                    rs.getString("ATTACHMENT_PATH")
	                );
	            }
	        }
	        return null;
	    }
	}

}
