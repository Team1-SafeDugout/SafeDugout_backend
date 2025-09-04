package com.bullPenTalk.app.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.TeamMainDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class TeamMainDAO {
	public SqlSession sqlSession;

	public TeamMainDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 팀 뉴스 목록 조회
	public List<TeamMainDTO> selectNewsList(int teamNumber) {
		return sqlSession.selectList("teamMain.selectNewsList", teamNumber);
	}

	// 팀 게시글 목록 조회
	public List<TeamMainDTO> selectPostList(int teamNumber) {
		return sqlSession.selectList("teamMain.selectPostList", teamNumber);
	}

	// 팀 유튜브 썸네일 목록 조회
	public List<TeamMainDTO> selectYouTubeList(int teamNumber) {
		return sqlSession.selectList("teamMain.selectYouTubeList", teamNumber);
	}

	// 팀별 경기 일정 목록 조회
	public List<TeamMainDTO> selectTeamSchedule(int teamNumber) {
		return sqlSession.selectList("teamMain.selectTeamSchedule", teamNumber);
	}

	// 팀 순위 목록 조회
	public List<TeamMainDTO> selectTeamRank() {
		return sqlSession.selectList("teamMain.selectTeamRank");
	}
}
