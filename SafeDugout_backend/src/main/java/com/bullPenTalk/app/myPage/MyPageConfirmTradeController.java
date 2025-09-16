package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;
import com.google.gson.Gson;

public class MyPageConfirmTradeController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sellPostNumber = Integer.parseInt(request.getParameter("sellPostNumber"));
		
		MyPageDAO dao = new MyPageDAO();
		boolean complete = dao.completeTrade(sellPostNumber);
		
		
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.setContentType("text/plain"); // json방식 전달
            response.setCharacterEncoding("UTF-8");
            if(complete == true) {
            	response.getWriter().write("성공");
            }
            
            else {
            	response.getWriter().write("실패");
            }
            return null; // AJAX 응답은 직접 처리하므로 Result 반환 필요 없음
        }
		return null;
	}

}
