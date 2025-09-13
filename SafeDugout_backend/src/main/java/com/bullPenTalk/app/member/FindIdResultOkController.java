package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class FindIdResultOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result(); 
		MemberDAO memberDAO = new MemberDAO(); 
		
		System.out.println("아이디 찾기 결과 페이지 처리 컨트롤러 진입");

		// 전송받은 회원번호 저장
		int memberNumber = Integer.valueOf(request.getParameter("memberNumber"));
		
		// ID에 별표 처리 
		// 조회한 ID 문자열에 저장 
		String beforeMemberId = memberDAO.getMemberIdByNumber(memberNumber);
		// 앞 3글자 저장 
		String afterMemberId = beforeMemberId.substring(0, 3);
		// 4번째부터 마지막 순번까지 * 추가  
		for(int i = 1; i <= beforeMemberId.length() - 3; i++) {
			afterMemberId += "*";
		}
		
		// request에 변환된 ID 저장 
		request.setAttribute("afterMemberId", afterMemberId);
		
		// ID로 가입 날짜 조회 
		String registerDate = memberDAO.getRegisterDate(beforeMemberId);
		
		// request에 가입 날짜 저장 
		request.setAttribute("registerDate", registerDate);
		
		// 경로, redirect 여부 설정 
		result.setPath("/app/findId/findIdResultId.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
	
}
