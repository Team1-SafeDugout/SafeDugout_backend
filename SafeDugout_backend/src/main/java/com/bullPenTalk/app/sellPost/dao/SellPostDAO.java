package com.bullPenTalk.app.sellPost.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class SellPostDAO {
	
	public SqlSession sqlSession;
	
	public SellPostDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 모든 판매글 가져오기
	public List<SellPostDTO> selectList(Map<String, Integer> pageMap) {
		System.out.println("모든 게시글 조회하기 - selectAll 메소드 실행 : " + pageMap);
		List<SellPostDTO> list = sqlSession.selectList("select.sellList", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	
}
