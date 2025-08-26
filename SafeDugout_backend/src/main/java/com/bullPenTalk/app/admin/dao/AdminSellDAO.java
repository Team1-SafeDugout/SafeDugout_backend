package com.bullPenTalk.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AdminSellPostDTO;
import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminSellDAO {
	public SqlSession sqlSession;

	public AdminSellDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 추가

	public void insert(SellPostDTO sellPostDTO) {
		sqlSession.insert("adminSellPost.insert", sellPostDTO);
	}

	// 수정

	public void update(SellPostDTO sellPostDTO) {
		sqlSession.update("adminSellPost.update", sellPostDTO);
	}

	// 조회(전부)

	public List<SellPostDTO> select() {
		return sqlSession.selectList("adminSellPost.selectAll");
	}

	// 삭제
	public void delete(int sellPostNumber) {
		sqlSession.delete("adminSellPost.delete", sellPostNumber);
	}
	
	public List<AdminSellPostDTO> selectList(){
		return sqlSession.selectList("adminSellPost.adminSelectList");
	}
	
	public AdminSellPostDTO selectDetail(int postNumber) {
		return sqlSession.selectOne("adminSellPost.adminSelectDetail", postNumber);
	}


//	// 조회(하나만)
//	public SellPostDTO selectDetail(int sellPostNumber) {
//		return sqlSession.selectOne("adminSellPost.selectDetail", sellPostNumber);
//	}
//
	public int getTotal() {
		return sqlSession.selectOne("adminSellPost.total");
	}
}
