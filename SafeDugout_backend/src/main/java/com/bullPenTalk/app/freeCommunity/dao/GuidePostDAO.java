package com.bullPenTalk.app.freeCommunity.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class GuidePostDAO {
		public SqlSession sqlSession;
	

	    public GuidePostDAO() {
	    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	    }


	    // 가이드 목록 조회
	    public List<GuidePostDTO> selectList(Map<String, Integer> pageMap) {
	        System.out.println("전체 커뮤니티 게시글 조회하기 - selectList 메소드 실행 : " + pageMap);
	        List<GuidePostDTO> list = sqlSession.selectList("guide.selectList", pageMap);
	        System.out.println("조회결과 : " + list);
	        return list;
	    }

	    // 가이드 총 개수
	    public int getTotal() {
	        System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
	        return sqlSession.selectOne("guide.getTotal");
	    }
	    
	    // 게시글 상세 조회
	    public GuidePostDTO selectDetail(int noitceNostNumber) {
	        System.out.println("게시글 상세 페이지 조회(단건조회): " + noitceNostNumber);
	        return sqlSession.selectOne("guide.selectDetail", noitceNostNumber);
	    }

	    // 메인페이지 조회
	    public List<GuidePostDTO> selectLatestPosts(int count) {
	        return sqlSession.selectList("guide.selectLatestPosts", count);
	    }
}
