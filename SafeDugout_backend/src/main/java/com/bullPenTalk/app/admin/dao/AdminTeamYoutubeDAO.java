package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTeamYoutubeDAO {
	public SqlSession sqlSession;

	public AdminTeamYoutubeDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(YoutubePostDTO youtubePostDTO) {
		sqlSession.insert("adminYoutube.insert", youtubePostDTO);
	}
	
	// 수정
	
	public void update(YoutubePostDTO youtubePostDTO) {
		sqlSession.update("adminYoutube.update", youtubePostDTO);
	}
	
	// 조회(전부)
	
	public List<YoutubePostDTO> select() {
		return sqlSession.selectList("adminYoutube.selectAll");
	}
	
	
	// 삭제
	public void delete(int youtubePostNumber) {
		sqlSession.delete("adminYoutube.delete", youtubePostNumber);
	}
	
	// 검색
	public List<YoutubePostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminYoutube.selectFilter", postName);
	}
	
	// 조회(하나만)
	public YoutubePostDTO selectDetail(int youtubePostNumber) {
		return sqlSession.selectOne("adminYoutube.selectDetail",youtubePostNumber);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminYoutube.total");
	}
}
