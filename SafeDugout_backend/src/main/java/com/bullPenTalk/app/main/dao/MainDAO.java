package com.bullPenTalk.app.main.dao;

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
	public MainNoticePostDTO selectMainList() {
		sqlSession.selectList("main.selectMainlist");
	}
	
	//메인 공지사항 상세 조회
	public MainNoticePostDTO selectMainList(int noticePostNumber) {
		sqlSession.selectOne("main.selectMainDetail", noticePostNumber);
	}
	
	//경기 일정 목록 조회
	public MainDTO selectSchedule(int gameId) {
		sqlSession.selectList("main.selectSchedule", gameId);
	}
	
	//중고거래 목록 조회
	
	
	//입문가이드 목록 조회
	
	
	//팀별 순위 조회
	
	
}
