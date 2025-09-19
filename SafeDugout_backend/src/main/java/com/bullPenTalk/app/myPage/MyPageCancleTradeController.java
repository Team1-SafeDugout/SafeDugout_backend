package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageCancleTradeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		int postNumber= Integer.parseInt(request.getParameter("postNumber"));
		System.out.println(postNumber);
		MyPageDAO myPageDAO = new MyPageDAO();
		boolean complete = myPageDAO.cancleTrade(postNumber);
		
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
        
		result.setPath("/myPage/tradeList.mp");
		result.setRedirect(false);
		
		return result;
	}

}
