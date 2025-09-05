package com.bullPenTalk.app.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;

	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public String getMyTeam(int memberNumber) {
		return sqlSession.selectOne("member.selectMyTeam", memberNumber);
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
	    MemberDTO memberDTO = sqlSession.selectOne("member.selectByNumber", memberNumber);
	    return memberDTO != null ? memberDTO.getMemberId() : null;
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
    
    public MemberDTO getMember(int memberNumber) {
    	return sqlSession.selectOne("member.select", memberNumber);
    }
    
    // 유저가 쓴 글 목록 조회
    public List<PostDTO> getPosts(int memberNumber) {
    	return sqlSession.selectList("member.selectPosts", memberNumber);
    }
    
    public List<PostDTO> getPostsPage(Map<String, Integer> map){
    	return sqlSession.selectList("member.selectPostPage", map);
    }
    
}
