package com.bullPenTalk.app.teamCommunity.dao;

	
import java.util.List;

import com.bullPenTalk.config.MyBatisConfig;

	public class TeamNoticePostDTO {
		 public SqlSession sqlSession;

		    public TeamNoticePostDTO () {
		    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		    }

	    // 공지 목록 조회 
		public List<TeamNoticePostDTO> select() {
			return sqlSession.selectList("TeamCommunityNoticeMapper.select");
			}

	    
	    // 공지 상세 조회
		public TeamNoticePostDTO detailSelect() { 
			return sqlSession.selectOne("TeamCommunityNoticeMapper.detailselect"); 
			}

}
