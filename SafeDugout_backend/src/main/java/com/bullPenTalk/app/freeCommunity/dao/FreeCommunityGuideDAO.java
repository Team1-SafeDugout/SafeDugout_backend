package com.bullPenTalk.app.freeCommunityGuide.dao;

	public class FreeCommunityGuideDAO {

	    private final Connection conn;

	    public FreeCommunityGuideDAO(Connection conn) {
	        this.conn = conn;
	    }

	    // 입문 가이드 목록 조회
	    public List<GuidePostDTO> selectIntroGuides() throws SQLException {
	        String sql = """
	            SELECT NP.NOTICE_POST_NUMBER,
	                   NT.NOTICE_TYPE,
	                   NP.NOTICE_POST_TITLE,
	                   NP.NOTICE_POST_CONTENT,
	                   NP.NOTICE_POST_DATE,
	                   NVL(NP.NOTICE_POST_UPDATE, NP.NOTICE_POST_DATE) AS LAST_UPDATE,
	                   A.ADMIN_NAME
	            FROM TBL_NOTICE_POST NP
	            JOIN TBL_NOTICE_TYPE NT ON NP.NOTICE_TYPE_ID = NT.NOTICE_TYPE_ID
	            JOIN TBL_ADMIN A ON NP.ADMIN_NUMBER = A.ADMIN_NUMBER
	            WHERE NT.NOTICE_TYPE = '입문가이드'
	            ORDER BY NP.NOTICE_POST_DATE DESC""";

	        List<GuidePostDTO> guides = new ArrayList<>();
	        try (PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            
	            while (rs.next()) {
	                GuidePostDTO guide = new GuidePostDTO();
	                guide.setNoticePostNumber(rs.getInt("NOTICE_POST_NUMBER"));
	                guide.setNoticeType(rs.getString("NOTICE_TYPE"));
	                guide.setNoticePostTitle(rs.getString("NOTICE_POST_TITLE"));
	                guide.setNoticePostContent(rs.getString("NOTICE_POST_CONTENT"));
	                guide.setNoticePostDate(rs.getTimestamp("NOTICE_POST_DATE"));
	                guide.setLastUpdate(rs.getTimestamp("LAST_UPDATE"));
	                guide.setAdminName(rs.getString("ADMIN_NAME"));
	                guides.add(guide);
	            }
	        }
	        return guides;
	    }

	    // 입문 가이드 상세 조회
	    public GuidePostDTO selectIntroGuideDetail(int noticePostNumber) throws SQLException {
	        String sql = """
	            SELECT NP.NOTICE_POST_NUMBER,
	                   NP.NOTICE_POST_TITLE,
	                   NP.NOTICE_POST_CONTENT,
	                   NP.NOTICE_POST_DATE,
	                   NVL(NP.NOTICE_POST_UPDATE, NP.NOTICE_POST_DATE) AS LAST_UPDATE,
	                   A.ADMIN_NAME,
	                   AT.ATTACHMENT_NUMBER,
	                   AT.ATTACHMENT_NAME,
	                   AT.ATTACHMENT_PATH
	            FROM TBL_NOTICE_POST NP
	            JOIN TBL_NOTICE_TYPE NT ON NP.NOTICE_TYPE_ID = NT.NOTICE_TYPE_ID
	            JOIN TBL_ADMIN A ON NP.ADMIN_NUMBER = A.ADMIN_NUMBER
	            LEFT JOIN TBL_NOTICE_ATTACHMENT NA ON NP.NOTICE_POST_NUMBER = NA.NOTICE_POST_NUMBER
	            LEFT JOIN TBL_ATTACHMENT AT ON NA.ATTACHMENT_NUMBER = AT.ATTACHMENT_NUMBER
	            WHERE NP.NOTICE_POST_NUMBER = ?
	              AND NT.NOTICE_TYPE = '입문가이드'
	        """;

	        GuidePostDTO guide = null;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, noticePostNumber);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    guide = new GuidePostDTO();
	                    guide.setNoticePostNumber(rs.getInt("NOTICE_POST_NUMBER"));
	                    guide.setNoticePostTitle(rs.getString("NOTICE_POST_TITLE"));
	                    guide.setNoticePostContent(rs.getString("NOTICE_POST_CONTENT"));
	                    guide.setNoticePostDate(rs.getTimestamp("NOTICE_POST_DATE"));
	                    guide.setLastUpdate(rs.getTimestamp("LAST_UPDATE"));
	                    guide.setAdminName(rs.getString("ADMIN_NAME"));

	                }
	            }
	        }
	        return guide;
	    }
	}


}
