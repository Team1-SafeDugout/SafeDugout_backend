package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageCompleteEditController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session  = request.getSession();
		int memberNumber = Integer.parseInt(session.getAttribute("memberNumber").toString());
		MyPageDAO myPageDAO = new MyPageDAO();
		
		MemberDTO updateMember = new MemberDTO();
		
		updateMember.setMemberNumber(memberNumber);
		updateMember.setMemberEmail(request.getParameter("email"));
		updateMember.setMemberPw(request.getParameter("pw"));
		updateMember.setMemberPhone(request.getParameter("phone"));
		updateMember.setMemberPostalCode(Integer.parseInt(request.getParameter("postal")));
		switch (request.getParameter("myTeam")) {
		case "삼성 라이온즈":
			
			updateMember.setMemberMyTeam(4);
			break;
		case "LG 트윈스":
			updateMember.setMemberMyTeam(2);
			break;
		case "두산 베어스":
			
			updateMember.setMemberMyTeam(1);
			break;
		case "NC 다이노스":
			
			updateMember.setMemberMyTeam(7);
			break;
		case "키움 히어로즈":
			
			updateMember.setMemberMyTeam(10);
			break;
		case "KT 위즈":
			updateMember.setMemberMyTeam(6);
			break;
		case "KIA 타이거즈":
			
			updateMember.setMemberMyTeam(9);
			break;
		case "SSG 랜더스":
			
			updateMember.setMemberMyTeam(5);
			break;
		case "롯데 자이언츠":
			
			updateMember.setMemberMyTeam(8);
			break;
		case "한화 이글스":
			
			updateMember.setMemberMyTeam(3);
			break;
		default:
			updateMember.setMemberMyTeam(0);
			break;
		}
		
		System.out.println(updateMember);
		myPageDAO.updateMember(updateMember);
		int memberPoint = myPageDAO.getMemberPoint(memberNumber);
		request.setAttribute("myPoint", memberPoint);
		result.setPath("/app/memberUpdate/updateComplete.jsp");
		result.setRedirect(false);
		return result;
	}
}
