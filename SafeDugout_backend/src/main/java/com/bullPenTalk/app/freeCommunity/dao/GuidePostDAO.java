package com.bullPenTalk.app.freeCommunity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.app.teamCommunity.dao.SqlSession;
import com.bullPenTalk.app.teamCommunity.dao.TeamNoticePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class GuidePostDAO {
		public SqlSession sqlSession;
	

	    public GuidePostDAO() {
	    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	    }

	    // 입문 가이드 목록 조회 
		public List<GuidePostDTO> select() {
			return sqlSession.selectList("FreeCommunityGuideMapper.select");
			}

	    
	    // 입문 가이드 상세 조회
		public GuidePostDTO detailSelect() { 
			return sqlSession.selectOne("FreeCommunityGuideMapper.detailselect"); 
			}



}
