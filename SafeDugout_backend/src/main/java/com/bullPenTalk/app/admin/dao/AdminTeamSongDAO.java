package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTeamSongDAO {
	public SqlSession sqlSession;

	public AdminTeamSongDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(SongPostDTO songPostDTO) {
		sqlSession.insert("adminNews.insert", songPostDTO);
	}
	
	// 수정
	
	public void update(SongPostDTO songPostDTO) {
		sqlSession.update("adminNews.update", songPostDTO);
	}
	
	// 조회(전부)
	
	public List<SongPostDTO> select() {
		return sqlSession.selectList("adminNews.selectAll");
	}
	
	// 삭제
	public void delete(int songPostNumber) {
		sqlSession.delete("adminNews.delete", songPostNumber);
	}
	
	// 검색
	public List<SongPostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminNews.selectFilter", postName);
	}
	
	// 조회(하나만)
	public SongPostDTO selectDetail(int songPostNumber) {
		return sqlSession.selectOne("adminNews.selectDetail",songPostNumber);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminNews.total");
	}
}
