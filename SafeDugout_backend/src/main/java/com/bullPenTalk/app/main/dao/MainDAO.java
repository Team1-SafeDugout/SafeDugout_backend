package com.bullPenTalk.app.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MainDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.app.dto.MemberDTO;
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
	
	//로그인한 회원 정보 조회 
	public MemberDTO selectLoginMember(int memberNumber) {
		System.out.println("selectLoginMember 메소드 실행");
		return sqlSession.selectOne("main.selectLoginMember", memberNumber);
	}
	
	//메인 공지사항 목록 조회
	public List<MainNoticePostDTO> selectMainList(Map<String, Integer> map) {
		System.out.println("selectMainList 메소드 실행");
		List<MainNoticePostDTO> list = sqlSession.selectList("main.selectMainList", map);
		System.out.println(list);
		return list;
	}
	
	//메인 공지사항 최신 제목 가져오기
	public MainNoticePostDTO getRecent() {
		System.out.println("getRecent 메소드 실행");
		return sqlSession.selectOne("main.getRecent");
	}
	
	//메인 공지사항 총 개수 가져오기
	public int getTotal() {
		System.out.println("getTotal 메소드 실행");
		return sqlSession.selectOne("main.getTotalMainList");
	}
	
	//현재 메인 공지사항 항목 순서 가져오기
	public int getIndex(int noticePostNumber) {
		System.out.println("getIndex 메소드 실행");
		return sqlSession.selectOne("main.getMainIndex", noticePostNumber);
	}
	
	//메인 공지사항 상세 조회
	public MainNoticePostDTO selectMainDetail(int noticePostNumber) {
		return sqlSession.selectOne("main.selectMainDetail", noticePostNumber);
	}
	
	//메인 공지사항 상세 조회 (이전글) 
	public MainNoticePostDTO selectMainPrev(int noticePostNumber) {
		return sqlSession.selectOne("main.selectMainPrev", noticePostNumber);
	}
	
	//메인 공지사항 상세 조회 (다음글) 
	public MainNoticePostDTO selectMainNext(int noticePostNumber) {
		return sqlSession.selectOne("main.selectMainNext", noticePostNumber);
	}
	
	//경기 일정 목록 조회
	public List<MainDTO> selectSchedule() {
		System.out.println("경기 일정 목록 조회 쿼리 실행");
		return sqlSession.selectList("main.selectSchedule");
	}
	
	//판매글 목록 조회
	public List<MainDTO> selectSellList() {
		return sqlSession.selectList("main.selectSellList");
	}
	
	//팀별 순위 조회
	public List<MainDTO> selectTeamRank() {
		return sqlSession.selectList("main.selectTeamRank");
	}
	
	//입문자 가이드 목록 조회
	public List<MainDTO> selectGuideList() {
		return sqlSession.selectList("main.selectGuideList");
	}
	
}
