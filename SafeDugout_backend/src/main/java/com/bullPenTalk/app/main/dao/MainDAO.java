package com.bullPenTalk.app.main.dao;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class MainDAO {
	public SqlSession sqlSession;
	
	public MainDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void selectMainList(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}
	
	
}
