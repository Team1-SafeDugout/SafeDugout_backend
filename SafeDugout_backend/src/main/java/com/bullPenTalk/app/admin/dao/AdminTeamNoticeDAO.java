package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.TeamNoticePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminTeamNoticeDAO {
	public SqlSession sqlSession;

	public AdminTeamNoticeDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(TeamNoticePostDTO teamPostDTO) {
		sqlSession.insert("adminTeamNotice.insert", teamPostDTO);
	}
	
	// 수정
	
	public void update(TeamNoticePostDTO teamPostDTO) {
		sqlSession.update("adminTeamNotice.update", teamPostDTO);
	}
	
	// 조회
	
	public List<TeamNoticePostDTO> select() {
		return sqlSession.selectList("adminTeamNotice.select");
	}
	
	// 삭제
	public void delete(int noticePostNumber) {
		sqlSession.delete("adminTeamNotice.delete", noticePostNumber);
	}	
	
	// 검색
	public List<TeamNoticePostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminTeamNotice.selectFilter", postName);
	}
	
	public TeamNoticePostDTO selectDetail(int noticePostNumber) {
		return sqlSession.selectOne("adminTeamNotice.selectFilter", noticePostNumber);
	}
}
