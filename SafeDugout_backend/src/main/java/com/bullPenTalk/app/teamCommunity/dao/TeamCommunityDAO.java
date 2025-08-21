package com.bullPenTalk.app.teamCommunity.dao;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bullPenTalk.app.dto.TeamPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

	public class TeamCommunityDAO {
	    public SqlSession sqlSession;

	    public TeamCommunityDAO() {
	    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	    }

	    
	    // 게시글 목록 조회
	    public List<TeamPostDTO> selectTeamPostList(int boardId, int teamNumber, int startRow, int endRow) throws SQLException {
	        String sql = """
	            SELECT * FROM (
	                SELECT ROWNUM AS RNUM, TMP.*
	                FROM (
	                    SELECT P.POST_NUMBER, P.POST_TITLE, P.POST_CONTENT, P.POST_DATE, M.MEMBER_NAME AS POST_WRITER
	                    FROM TBL_POST P
	                    JOIN TBL_MEMBER M ON P.MEMBER_NUMBER = M.MEMBER_NUMBER
	                    WHERE P.BOARD_ID = ? AND P.TEAM_NUMBER = ?
	                    ORDER BY P.POST_DATE DESC
	                ) TMP
	                WHERE ROWNUM <= ?
	            ) WHERE RNUM >= ?
	            """;

	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, boardId);
	            stmt.setInt(2, teamNumber);
	            stmt.setInt(3, endRow);
	            stmt.setInt(4, startRow);
	            ResultSet rs = stmt.executeQuery();
	            List<TeamPostDTO> list = new ArrayList<>();
	            while (rs.next()) {
	                list.add(new TeamPostDTO(
	                    rs.getInt("POST_NUMBER"),
	                    rs.getString("POST_TITLE"),
	                    rs.getString("POST_CONTENT"),
	                    rs.getTimestamp("POST_DATE"),
	                    rs.getString("POST_WRITER")
	                ));
	            }
	            return list;
	        }
	    }

	    // 게시글 작성
	    public void insertTeamPost(TeamPostDTO post) throws SQLException {
	        String sql = """
	            INSERT INTO TBL_POST (POST_TITLE, POST_CONTENT, POST_DATE, MEMBER_NUMBER, BOARD_ID, TEAM_NUMBER)
	            VALUES (?, ?, ?, ?, ?, ?)
	            """;
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, post.getPostTitle());
	            stmt.setString(2, post.getPostContent());
	            stmt.setTimestamp(3, post.getPostDate());
	            stmt.setInt(4, post.getMemberNumber());
	            stmt.setInt(5, post.getBoardId());
	            stmt.setInt(6, post.getTeamNumber());
	            stmt.executeUpdate();
	        }
	    }

	    // 게시글 상세 조회
	    public TeamPostDTO selectTeamPostDetail(int postNumber) throws SQLException {
	        String sql = """
	            SELECT P.POST_NUMBER, P.POST_TITLE, P.POST_CONTENT, P.POST_DATE, M.MEMBER_NAME AS POST_WRITER
	            FROM TBL_POST P
	            JOIN TBL_MEMBER M ON P.MEMBER_NUMBER = M.MEMBER_NUMBER
	            WHERE P.POST_NUMBER = ?
	            """;
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, postNumber);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new TeamPostDTO(
	                    rs.getInt("POST_NUMBER"),
	                    rs.getString("POST_TITLE"),
	                    rs.getString("POST_CONTENT"),
	                    rs.getTimestamp("POST_DATE"),
	                    rs.getString("POST_WRITER")
	                );
	            }
	        }
	        return null;
	    }

	    // 게시글 수정
	    public void updateTeamPost(TeamPostDTO post) throws SQLException {
	        String sql = """
	            UPDATE TBL_POST
	            SET POST_TITLE = ?, POST_CONTENT = ?
	            WHERE POST_NUMBER = ?
	            """;
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, post.getPostTitle());
	            stmt.setString(2, post.getPostContent());
	            stmt.setInt(3, post.getPostNumber());
	            stmt.executeUpdate();
	        }
	    }

	    // 게시글 삭제
	    public void deleteTeamPost(int postNumber) throws SQLException {
	        String sql = "DELETE FROM TBL_POST WHERE POST_NUMBER = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, postNumber);
	            stmt.executeUpdate();
	        }
	    }
	}

	
}
