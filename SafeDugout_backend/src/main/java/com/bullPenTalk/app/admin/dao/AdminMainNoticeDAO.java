package com.bullPenTalk.app.admin.dao;

import java.util.List;

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
	
	// 조회
	
	public List<MainNoticePostDTO> select() {
		return sqlSession.selectList("adminMainNotice.select");
	}
	
	// 삭제
	public void delete(int noticePostNumber) {
		sqlSession.delete("adminMainNotice.delete", noticePostNumber);
	}
	
	// 검색
	public List<MainNoticePostDTO> selectFilter(String postName){
		return sqlSession.selectList("adminMainNotice.selectFilter", postName);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("adminMainNotice.getTotal");
	}
}
