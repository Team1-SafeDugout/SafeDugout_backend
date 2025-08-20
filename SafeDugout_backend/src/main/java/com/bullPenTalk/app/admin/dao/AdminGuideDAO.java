package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminGuideDAO {
	
	public SqlSession sqlSession;

	public AdminGuideDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(GuidePostDTO guidePostDTO) {
		sqlSession.insert("adminGuide.insert", guidePostDTO);
	}
	
	// 수정
	
	public void update(GuidePostDTO guidePostDTO) {
		sqlSession.update("adminGuide.update", guidePostDTO);
	}
	
	// 조회
	
	public List<GuidePostDTO> select() {
		return sqlSession.selectList("adminGuide.select");
	}
	
	// 삭제
	public void delete(int noticePostNumber) {
		sqlSession.delete("adminGuide.delete", noticePostNumber);
	}
	
	// 검색
	public List<GuidePostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminGuide.selectFilter", postName);
	}
}
