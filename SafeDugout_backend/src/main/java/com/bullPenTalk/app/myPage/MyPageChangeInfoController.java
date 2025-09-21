package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageChangeInfoController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		int memberNumber = Integer.parseInt(request.getSession().getAttribute("memberNumber").toString());
		MyPageDAO myPageDAO = new MyPageDAO();
		int memberPoint = myPageDAO.getMemberPoint(memberNumber);
		request.setAttribute("myPoint", memberPoint);
		result.setPath("/app/memberUpdate/updateInputPassword.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
