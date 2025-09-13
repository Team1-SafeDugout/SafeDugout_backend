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
	
	public int findNumber(MemberDTO memberDTO) {
		Integer memberNumber = sqlSession.selectOne("member.findNumber", memberDTO);
		return memberNumber == null ? -1 : memberNumber;
	}
	
	public int findNumberWithId(MemberDTO memberDTO) {
		Integer memberNumber = sqlSession.selectOne("member.findNumberWithId", memberDTO);
		return memberNumber == null ? -1 : memberNumber;
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
    public int getTotal(int memberNumber) {
    	return sqlSession.selectOne("member.getTotalPost", memberNumber);
    }
    
    public List<PostDTO> getPostsPage(Map<String, Integer> map){
    	return sqlSession.selectList("member.selectPostPage", map);
    }
    
    // 유저가 응원중인 팀 반환
    public int getTeamNumber(int memberNumber) {
    	if(sqlSession.selectOne("member.getTeamNumber", memberNumber) != null) {
    		return sqlSession.selectOne("member.getTeamNumber", memberNumber); 
    	}
    	return 0;
    }
    
    // 이름 등록 여부 검사 
    public int checkNameRegistered(String inputName) {
    	return sqlSession.selectOne("member.checkNameRegistered", inputName);
    }
    
    // 아이디 등록 여부 검사 
    public int checkIdRegistered(String inputId) {
    	return sqlSession.selectOne("member.checkIdRegistered", inputId);
    }
    
    // 이메일 등록 여부 검사 
    public int checkEmailRegistered(String inputEmail) {
    	return sqlSession.selectOne("member.checkEmailRegistered", inputEmail);
    }
    
    // 전화번호 등록 여부 검사 
    public int checkPhoneRegistered(String inputPhone) {
    	return sqlSession.selectOne("member.checkPhoneRegistered", inputPhone);
    }
    
    // 아이디로 가입 날짜 조회 
    public String getRegisterDate(String memberId) {
    	return sqlSession.selectOne("member.getRegisterDate", memberId);
    }
    
    // 비밀번호 변경 
    public int updatePw(MemberDTO memberDTO) {
    	return sqlSession.update("member.updatePw", memberDTO);
    }
    
}
