package com.bullPenTalk.app.admin.dao;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.AdminDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class AdminDAO {
	public SqlSession sqlSession;

	public AdminDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	

	// 로그인 메소드
	public int login(AdminDTO adminDTO) {
		Integer adminNumber = sqlSession.selectOne("admin.login", adminDTO);
		return adminNumber == null ? -1 : adminNumber;
	}
	
	public void logOut() {
		
	}

}
