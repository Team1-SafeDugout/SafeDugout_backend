package com.bullPenTalk.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;

	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 로그인 메소드
	public int login(MemberDTO memberDTO) {
		Integer memberNumber = sqlSession.selectOne("member.login", memberDTO);
		return memberNumber == null ? -1 : memberNumber;
	}
}
