package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

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
		sqlSession.insert("adminSong.teamInsert", songPostDTO);
	}
	
	public void insertPlayer(SongPostDTO songPostDTO) {
		sqlSession.insert("adminSong.playerInsert", songPostDTO);
	}
	
	// 수정
	
	public void update(SongPostDTO songPostDTO) {
		sqlSession.update("adminSong.update", songPostDTO);
	}
	
	// 조회(전부)
	
	public List<SongPostDTO> select(Map<String, Integer> map) {
		return sqlSession.selectList("adminSong.listSelectAll", map);
	}
	
	// 삭제
	public void delete(int songPostNumber) {
		sqlSession.delete("adminSong.delete", songPostNumber);
	}
	
	// 검색
	public List<SongPostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminSong.selectFilter", postName);
	}
	
	// 조회(하나만)
	public SongPostDTO selectDetail(int songPostNumber) {
		return sqlSession.selectOne("adminSong.selectDetail",songPostNumber);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminSong.total");
	}
}
