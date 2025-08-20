package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.TeamAdminPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTeamNoticeDAO {
	public SqlSession sqlSession;

	public AdminTeamNoticeDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(TeamAdminPostDTO teamPostDTO) {
		sqlSession.insert("adminTeamNotice.insert", teamPostDTO);
	}
	
	// 수정
	
	public void update(TeamAdminPostDTO teamPostDTO) {
		sqlSession.update("adminTeamNotice.update", teamPostDTO);
	}
	
	// 조회
	
	public List<TeamAdminPostDTO> select() {
		return sqlSession.selectList("adminTeamNotice.select");
	}
	
	// 삭제
	public void delete(int noticePostNumber) {
		sqlSession.delete("adminTeamNotice.delete", noticePostNumber);
	}	
	
	// 검색
	public List<TeamAdminPostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminTeamNotice.selectFilter", postName);
	}
}
