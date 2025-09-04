package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AdminUserPostDTO;
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.dto.TeamPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminUserPostDAO {
	public SqlSession sqlSession;

	public AdminUserPostDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	팀 게시판 조회	
	public List<AdminUserPostDTO> selectAllTeam(Map<String, Integer> pageMap) {
		return sqlSession.selectList("adminTeamPost.listSelect", pageMap);
	}
	
	public int totalTeam() {
		return sqlSession.selectOne("adminTeamPost.total");
	}
	
//	전체 게시판 조회	
	public List<AdminUserPostDTO> selectAllFree(Map<String, Integer> pageMap) {
		return sqlSession.selectList("adminFreePost.listSelect", pageMap);
	}
	
	public int totalFree() {
		return sqlSession.selectOne("adminFreePost.total");
	}
	
//	모든 게시판 조회
	public List<AdminUserPostDTO> selectAll(Map<String, Integer> pageMap) {
		return sqlSession.selectList("adminFreePost.listSelectAll", pageMap);
	}
	
	public int total() {
		return sqlSession.selectOne("adminFreePost.totalAll");
	}
	
//	공통 작업	
	public AdminUserPostDTO selectDetail(int postNumber) {
		return sqlSession.selectOne("adminFreePost.selectDetail", postNumber);
	}
	
	public void delete(int postNumber) {
		sqlSession.delete("adminFreePost.delete", postNumber);
	}
	
}
