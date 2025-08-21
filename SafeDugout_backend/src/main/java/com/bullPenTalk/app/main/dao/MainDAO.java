package com.bullPenTalk.app.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MainDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

//메인페이지 DAO
public class MainDAO {
	public SqlSession sqlSession;
	
	public MainDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	public void selectMainList(MemberDTO memberDTO) {
//		sqlSession.insert("member.join", memberDTO);
//	}
	
	//메인 공지사항 목록 조회
	public List<MainNoticePostDTO> selectMainList(Map<String, Integer> map) {
		return sqlSession.selectList("main.selectMainlist");
	}
	
	//공지사항 총 개수 가져오기
	public int getTotal() {
		System.out.println("getTotal 메소드 실행");
		return sqlSession.selectOne("main.getTotal");
	}
	
	//메인 공지사항 상세 조회
	public MainNoticePostDTO selectMainDetail(int noticePostNumber) {
		return sqlSession.selectOne("main.selectMainDetail", noticePostNumber);
	}
	
	//경기 일정 목록 조회
	public List<MainDTO> selectSchedule(int gameId) {
		return sqlSession.selectList("main.selectSchedule", gameId);
	}
	
	//중고거래 목록 조회
	public List<MainDTO> selectSellList() {
		return sqlSession.selectList("main.selectSellList");
	}
	
	//입문자 가이드 목록 조회
	public List<MainDTO> selectGuideList() {
		return sqlSession.selectList("main.selectGuideList");
	}
	
	//팀별 순위 조회
	public List<MainDTO> selectTeamRank() {
		return sqlSession.selectList("main.selectTeamRank");
	}
	
}
