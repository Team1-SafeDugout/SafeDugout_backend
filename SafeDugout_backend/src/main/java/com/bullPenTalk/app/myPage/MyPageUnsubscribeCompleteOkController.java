package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageUnsubscribeCompleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		result.setPath("/app/memberQuit/quitComplete.jsp");
		result.setRedirect(false);
		
		MyPageDAO dao = new MyPageDAO();
		int memberNumber = Integer.parseInt(request.getSession().getAttribute("memberNumber").toString());
		int memberPoint = dao.getMemberPoint(memberNumber);
		request.setAttribute("myPoint", memberPoint);
		
		return result;
	}
	
}
