package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		Result result = new Result();

		request.setCharacterEncoding("UTF-8");
		// 회원정보 세팅
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setMemberPw(request.getParameter("memberPw"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setMemberPhone(request.getParameter("memberPhone"));
		
		/*
		 * if(request.getParameter("memberPostalCode") == null) {
		 * memberDTO.setMemberPostalCode(12345); } else {
		 * memberDTO.setMemberPostalCode(Integer.parseInt(request.getParameter(
		 * "memberPostalCode"))); }
		 */
		if(request.getParameter("memberPostalCode") == null) memberDTO.setMemberPostalCode(0);
		memberDTO.setMemberPostalCode(Integer.parseInt(request.getParameter("memberPostalCode")));
		
		memberDTO.setMemberPoint(0);

		switch (request.getParameter("myTeam")) {
		case "삼성 라이온즈":
			
			memberDTO.setMemberMyTeam(4);
			break;
		case "LG 트윈스":
			memberDTO.setMemberMyTeam(2);
			break;
		case "두산 베어스":
			
			memberDTO.setMemberMyTeam(1);
			break;
		case "NC 다이노스":
			
			memberDTO.setMemberMyTeam(7);
			break;
		case "키움 히어로즈":
			
			memberDTO.setMemberMyTeam(10);
			break;
		case "KT 위즈":
			memberDTO.setMemberMyTeam(6);
			break;
		case "KIA 타이거즈":
			
			memberDTO.setMemberMyTeam(9);
			break;
		case "SSG 랜더스":
			
			memberDTO.setMemberMyTeam(5);
			break;
		case "롯데 자이언츠":
			
			memberDTO.setMemberMyTeam(8);
			break;
		case "한화 이글스":
			
			memberDTO.setMemberMyTeam(3);
			break;
		default:
			memberDTO.setMemberMyTeam(0);
			break;
		}

		memberDTO.setMemberJoinDate(request.getParameter("memberJoinDate"));
		memberDTO.setMemberEmail(request.getParameter("memberEmail"));

		// DAO 호출
		memberDAO.join(memberDTO);

		if(memberDTO.getMemberMyTeam() != 0) {
			
			result.setPath(request.getContextPath() + "/app/register/RegisterResultMyTeamSelected.jsp");
			request.setAttribute("selectTeam", request.getParameter("memberMyTeam"));
		}
		else {
			result.setPath(request.getContextPath() + "/app/register/RegisterResultMyTeamUnselected.jsp");
		}
		
		result.setRedirect(false);

		return result;
	}

}
