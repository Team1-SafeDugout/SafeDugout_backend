package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminMainNoticeDAO {
	public SqlSession sqlSession;

	public AdminMainNoticeDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(MainNoticePostDTO mainPostDTO) {
		sqlSession.insert("adminMainNotice.insert", mainPostDTO);
	}
	
	// 수정
	
	public void update(MainNoticePostDTO mainPostDTO) {
		sqlSession.update("adminMainNotice.update", mainPostDTO);
	}
	
	// 팀공지 전체공지 모두 조회
	public List<MainNoticePostDTO> selectAll(Map<String, Integer> map) {
		return sqlSession.selectList("adminMainNotice.selectAll", map);
	}
	// 조회(전부)
	
	public List<MainNoticePostDTO> select(Map<String, Integer> map) {
		return sqlSession.selectList("adminMainNotice.select", map);
	}
	
	// 삭제
	public void delete(int noticePostNumber) {
		sqlSession.delete("adminMainNotice.delete", noticePostNumber);
	}
	
	// 검색
	public List<MainNoticePostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminMainNotice.selectFilter", postName);
	}
	
	// 조회(하나만)
	public MainNoticePostDTO selectDetail(int noticePostNumber) {
		return sqlSession.selectOne("adminMainNotice.selectDetail",noticePostNumber);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminMainNotice.total");
	}
	
	public int getTotalAll() {
		return sqlSession.selectOne("adminMainNotice.totalAll");
	}
}
