package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;


public class FindPwChangeOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result(); 
		MemberDAO memberDAO = new MemberDAO(); 
		MemberDTO memberDTO = new MemberDTO(); 
		
		// 변수 선언 및 값 저장 
		int memberNumber = Integer.valueOf(request.getParameter("memberNumber"));
		String newPw = request.getParameter("newPw");
		
		// DTO 필드 저장 
		memberDTO.setMemberNumber(memberNumber);
		memberDTO.setMemberPw(newPw);
		
		// 비밀번호 변경 쿼리 실행 
		int updated = memberDAO.updatePw(memberDTO);
		
		// 경로, redirect 여부 설정 
		result.setPath("/app/findPw/findPwChangeResult.jsp");
		result.setRedirect(true);
		
		return result;
	}

}
