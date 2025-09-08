package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTeamNewsDAO {
	public SqlSession sqlSession;

	public AdminTeamNewsDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(NewsPostDTO newsPostDTO) {
		sqlSession.insert("adminNews.insert", newsPostDTO);
	}
	
	// 조회(전부)
	
	public List<NewsPostDTO> select(Map<String, Integer> pageMap) {
		return sqlSession.selectList("adminNews.listSelect", pageMap);
	}
	
	// 삭제
	public void delete(int newsPostNumber) {
		sqlSession.delete("adminNews.delete", newsPostNumber);
	}
	
	// 조회(하나만)
	public NewsPostDTO selectDetail(int newsPostNumber) {
		return sqlSession.selectOne("adminNews.detailSelect", newsPostNumber);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminNews.total");
	}
}
