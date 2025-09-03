package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.dto.TeamPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminUserPostDAO {
	public SqlSession sqlSession;

	public AdminUserPostDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	팀 게시판 조회
	public TeamPostDTO selectDetail(int postNumber) {
		return sqlSession.selectOne("",postNumber);
	}
	
	public void delete(int postNumber) {
		sqlSession.delete("", postNumber);
	}
	
	public List<TeamPostDTO> selectAll() {
		return sqlSession.selectList("");
	}
	
	public int total() {
		return selectAll().size();
	}
	
//	전체 게시판 조회
	public FreePostDTO selectDetailFree(int postNumber) {
		return sqlSession.selectOne("",postNumber);
	}
	
	public void deleteFree(int postNumber) {
		sqlSession.delete("", postNumber);
	}
	
	public List<FreePostDTO> selectAllFree() {
		return sqlSession.selectList("");
	}
	
	public int totalFree() {
		return selectAllFree().size();
	}
	
}
