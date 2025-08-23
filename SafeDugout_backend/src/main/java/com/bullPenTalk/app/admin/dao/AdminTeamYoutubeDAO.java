package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTeamYoutubeDAO {
	public SqlSession sqlSession;

	public AdminTeamYoutubeDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(YoutubePostDTO youtubePostDTO) {
		sqlSession.insert("adminNews.insert", youtubePostDTO);
	}
	
	// 수정
	
	public void update(YoutubePostDTO youtubePostDTO) {
		sqlSession.update("adminNews.update", youtubePostDTO);
	}
	
	// 조회(전부)
	
	public List<YoutubePostDTO> select() {
		return sqlSession.selectList("adminNews.selectAll");
	}
	
	// 삭제
	public void delete(int youtubePostNumber) {
		sqlSession.delete("adminNews.delete", youtubePostNumber);
	}
	
	// 검색
	public List<YoutubePostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminNews.selectFilter", postName);
	}
	
	// 조회(하나만)
	public SongPostDTO selectDetail(int youtubePostNumber) {
		return sqlSession.selectOne("adminNews.selectDetail",youtubePostNumber);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminNews.total");
	}
}
