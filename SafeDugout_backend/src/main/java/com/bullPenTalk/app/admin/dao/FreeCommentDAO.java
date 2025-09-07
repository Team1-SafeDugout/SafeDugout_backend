package com.bullPenTalk.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.CommentDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class FreeCommentDAO {
	public SqlSession sqlSession;

	public FreeCommentDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(Map<String, String> commentDTO) {
		sqlSession.insert("freeComment.insert", commentDTO);
	}
	
	// 수정
	
	public void update(CommentDTO teamPostDTO) {
		sqlSession.update("freeComment.update", teamPostDTO);
	}
	
	// 조회
	
	public List<CommentDTO> select() {
		return sqlSession.selectList("freeComment.select");
	}
	
	// 삭제
	public void delete(int commentNumber) {
		sqlSession.delete("freeComment.delete", commentNumber);
	}
	
	public CommentDTO selectOne(int commentNumber) {
		return sqlSession.selectOne("freeComment.selectOne");
	}
	
	public List<CommentDTO> selectAll(Map<String, Integer> map){
		return sqlSession.selectList("freeComment.selectAll", map);
	}
}
