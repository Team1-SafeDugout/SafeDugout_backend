package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageGetCurrentPoint implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session  = request.getSession();
		int memberNumber = Integer.parseInt(session.getAttribute("memberNumber").toString());
		System.out.println(memberNumber);
		MyPageDAO myPageDao = new MyPageDAO();
		
		int memberPoint = myPageDao.getMemberPoint(memberNumber);
		System.out.println(memberPoint);
		
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.setContentType("text/plain"); // json방식 전달
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(memberPoint + "");
            return null; // AJAX 응답은 직접 처리하므로 Result 반환 필요 없음
        }
		return null;
	}
}
