package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.CommentDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class TeamCommentDAO {
	public SqlSession sqlSession;

	public TeamCommentDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 추가
	
	public void insert(CommentDTO commentDTO) {
		sqlSession.insert("teamComment.insert", commentDTO);
	}
	
	// 수정
	
	public void update(CommentDTO teamPostDTO) {
		sqlSession.update("teamComment.update", teamPostDTO);
	}
	
	// 조회
	
	public List<CommentDTO> select() {
		return sqlSession.selectList("teamComment.select");
	}
	
	// 삭제
	public void delete(int commentNumber) {
		sqlSession.delete("teamComment.delete", commentNumber);
	}	
}
