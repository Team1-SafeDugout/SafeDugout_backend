package com.bullPenTalk.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;

	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}

	// 로그인 메소드
	public int login(MemberDTO memberDTO) {
		Integer memberNumber = sqlSession.selectOne("member.login", memberDTO);
		return memberNumber == null ? -1 : memberNumber;
	}
	
	public boolean checkId(String memberId) {
		return (Integer) sqlSession.selectOne("member.checkId", memberId) < 1;
	}
	
	public String findId(MemberDTO memberDTO) {
		return sqlSession.selectOne("member.findId", memberDTO);
	}
	
	public void setPw(String memberId, String memberPw) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPw(memberPw);
		sqlSession.update("member.changePw", memberDTO);
	}
	
	public String getMemberNumber(int memberNumber) {
		MemberDTO memberDTO = sqlSession.selectOne("member.select");
		return memberDTO.getMemberId();
	}
	
	public String getMemberIdByNumber(int memberNumber) {
	    MemberDTO memberDTO = sqlSession.selectOne("member.selectByNumber", memberNumber);
	    return memberDTO != null ? memberDTO.getMemberId() : null;
	}
	
	// 포인트 조회
    public int getMemberPoint(int memberNumber) {
        Integer point = sqlSession.selectOne("member.getMemberPoint", memberNumber);
        return (point != null) ? point : 0;
    }
}
