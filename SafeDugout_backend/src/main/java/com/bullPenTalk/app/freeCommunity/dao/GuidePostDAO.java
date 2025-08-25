package com.bullPenTalk.app.freeCommunity.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.GuidePostDTO;
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
