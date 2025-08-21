package com.bullPenTalk.app.freeCommunity.dao;

	import java.sql.*;
	import java.util.*;

	public class FreeCommunityPostDAO {
	    private final Connection connection;

	    public FreeCommunityPostDAO(Connection connection) {
	        this.connection = connection;
	    }

	    // 목록 조회
	    public List<FreePostDTO> selectList(int startRow, int endRow) throws SQLException {
	        String sql = """
	            SELECT * FROM (
	                SELECT ROWNUM AS rnum, subquery.*
	                FROM (
	                    SELECT P.POST_NUMBER,
	                           P.POST_TITLE,
	                           P.POST_CONTENT,
	                           P.POST_DATE,
	                           M.MEMBER_ID AS POST_WRITER
	                    FROM TBL_POST P
	                    JOIN TBL_MEMBER M ON P.MEMBER_NUMBER = M.MEMBER_NUMBER
	                    WHERE P.BOARD_ID = 1
	                    ORDER BY P.POST_DATE DESC
	                ) subquery
	            )
	            WHERE rnum BETWEEN ? AND ?
	        """;

	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, startRow);
	            stmt.setInt(2, endRow);

	            ResultSet rs = stmt.executeQuery();
	            List<FreePostDTO> list = new ArrayList<>();

	            while (rs.next()) {
	                FreePostDTO post = new FreePostDTO();
	                post.setPostNumber(rs.getInt("POST_NUMBER"));
	                post.setPostTitle(rs.getString("POST_TITLE"));
	                post.setPostContent(rs.getString("POST_CONTENT"));
	                post.setPostDate(rs.getTimestamp("POST_DATE"));
	                post.setPostWriter(rs.getString("POST_WRITER"));
	                list.add(post);
	            }
	            return list;
	        }
	    }

	    // 상세 조회 (댓글 + 첨부 포함)
	    public FreePostDTO selectDetail(int postNumber) throws SQLException {
	        String sql = """
	            SELECT P.POST_NUMBER,
	                   P.POST_TITLE,
	                   P.POST_CONTENT,
	                   P.POST_DATE,
	                   M.MEMBER_NAME AS POST_WRITER,
	                   C.COMMENT_NUMBER,
	                   C.COMMENT_CONTENT,
	                   NVL(C.COMMENT_UPDATE, C.COMMENT_DATE) AS COMMENT_LAST_UPDATE,
	                   CM.MEMBER_NAME AS COMMENT_WRITER,
	                   A.ATTACHMENT_NUMBER,
	                   A.ATTACHMENT_NAME,
	                   A.ATTACHMENT_PATH
	            FROM TBL_POST P
	            JOIN TBL_MEMBER M ON P.MEMBER_NUMBER = M.MEMBER_NUMBER
	            LEFT JOIN TBL_COMMENT C ON P.POST_NUMBER = C.POST_NUMBER
	            LEFT JOIN TBL_MEMBER CM ON C.MEMBER_NUMBER = CM.MEMBER_NUMBER
	            LEFT JOIN TBL_POST_ATTACHMENT PA ON P.POST_NUMBER = PA.POST_NUMBER
	            LEFT JOIN TBL_ATTACHMENT A ON PA.ATTACHMENT_NUMBER = A.ATTACHMENT_NUMBER
	            WHERE P.POST_NUMBER = ?
	            ORDER BY C.COMMENT_DATE ASC, A.ATTACHMENT_NUMBER ASC
	        """;

	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, postNumber);
	            ResultSet rs = stmt.executeQuery();

	            FreePostDTO post = null;
	            Map<Integer, CommentDTO> commentMap = new LinkedHashMap<>();
	            Map<Integer, AttachmentDTO> attachmentMap = new LinkedHashMap<>();

	            while (rs.next()) {
	                if (post == null) {
	                    post = new FreePostDTO();
	                    post.setPostNumber(rs.getInt("POST_NUMBER"));
	                    post.setPostTitle(rs.getString("POST_TITLE"));
	                    post.setPostContent(rs.getString("POST_CONTENT"));
	                    post.setPostDate(rs.getTimestamp("POST_DATE"));
	                    post.setPostWriter(rs.getString("POST_WRITER"));
	                }

	                int commentNum = rs.getInt("COMMENT_NUMBER");
	                if (commentNum != 0 && !commentMap.containsKey(commentNum)) {
	                    CommentDTO comment = new CommentDTO();
	                    comment.setCommentNumber(commentNum);
	                    comment.setCommentContent(rs.getString("COMMENT_CONTENT"));
	                    comment.setCommentLastUpdate(rs.getTimestamp("COMMENT_LAST_UPDATE"));
	                    comment.setCommentWriter(rs.getString("COMMENT_WRITER"));
	                    commentMap.put(commentNum, comment);
	                }

	                int attachmentNum = rs.getInt("ATTACHMENT_NUMBER");
	                if (attachmentNum != 0 && !attachmentMap.containsKey(attachmentNum)) {
	                    AttachmentDTO attachment = new AttachmentDTO();
	                    attachment.setAttachmentNumber(attachmentNum);
	                    attachment.setAttachmentName(rs.getString("ATTACHMENT_NAME"));
	                    attachment.setAttachmentPath(rs.getString("ATTACHMENT_PATH"));
	                    attachmentMap.put(attachmentNum, attachment);
	                }
	            }

	            if (post != null) {
	                post.setComments(new ArrayList<>(commentMap.values()));
	                post.setAttachments(new ArrayList<>(attachmentMap.values()));
	            }
	            return post;
	        }
	    }

	    // 게시글 작성
	    public int insertPost(FreePostDTO post) throws SQLException {
	        String sql = """
	            INSERT INTO tbl_board(board_number, board_title, board_content, member_number)
	            VALUES(seq_board.nextval, ?, ?, ?)
	        """;

	        try (PreparedStatement stmt = connection.prepareStatement(sql, new String[]{"board_number"})) {
	            stmt.setString(1, post.getPostTitle());
	            stmt.setString(2, post.getPostContent());
	            // Assuming post.getPostWriter() is memberNumber, 필요시 변환 필요
	            stmt.setInt(3, Integer.parseInt(post.getPostWriter()));

	            int affectedRows = stmt.executeUpdate();

	            if (affectedRows == 0) {
	                throw new SQLException("Creating post failed, no rows affected.");
	            }

	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    post.setPostNumber(generatedKeys.getInt(1));
	                }
	            }
	            return affectedRows;
	        }
	    }

	    // 게시글 삭제
	    public int deletePost(int boardNumber) throws SQLException {
	        String sql = "DELETE FROM tbl_board WHERE board_number = ?";

	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, boardNumber);
	            return stmt.executeUpdate();
	        }
	    }
	}

}
