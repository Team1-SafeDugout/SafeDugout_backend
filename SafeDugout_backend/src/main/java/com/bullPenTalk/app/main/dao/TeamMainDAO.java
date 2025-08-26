package com.bullPenTalk.app.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MainDTO;
import com.bullPenTalk.app.dto.TeamMainDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class TeamMainDAO {
	public SqlSession sqlSession;

	public TeamMainDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	//팀 뉴스 목록 조회
	public List<TeamMainDTO> selectNewsList(Map<String, Integer> map) {
		return sqlSession.selectList("main.selectNewsList", map);
	}
	
	//팀 게시글 목록 조회
	public List<TeamMainDTO> selectPostList(Map<String, Integer> map) {
		return sqlSession.selectList("main.selectPostList", map);
	}
	
	//팀 유튜브 썸네일 목록 조회
	public List<TeamMainDTO> selectYouTubeList(Map<String, Integer> map) {
		return sqlSession.selectList("main.selectYouTubeList", map);
	}
	
	//경기 일정 목록 조회
	public List<TeamMainDTO> selectTeamSchedule(int teamNumber) {
		return sqlSession.selectList("main.selectTeamSchedule", teamNumber);
	}
	
	//팀별 순위 목록 조회
	public List<TeamMainDTO> selectTeamRank() {
		return sqlSession.selectList("main.selectTeamRank");
	}
}
