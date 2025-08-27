package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class AdminReadMemberOk implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		if(request.getParameter("memberNumber") == null)
			return null;
		int memberNumber = Integer.parseInt(request.getParameter("memberNumber"));
		MemberDTO memberDTO = memberDAO.getMember(memberNumber);
		
		Result result = new Result();
		
		
		request.setAttribute("myTeam", memberDAO.getMyTeam(memberNumber));
		request.setAttribute("memberDetail", memberDTO);
		result.setPath("/app/admin/adminDetailMenu/adminUserDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
