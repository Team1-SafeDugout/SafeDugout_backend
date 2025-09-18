package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageUnsubscribeCompleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		MyPageDAO dao = new MyPageDAO();
		int memberNumber = Integer.parseInt(request.getSession().getAttribute("memberNumber").toString());
		
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
        	if(dao.quit(memberNumber)) {
    			request.getSession().invalidate();
    			
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("성공");
    		} else {
    			 response.setContentType("text/plain");
                 response.setCharacterEncoding("UTF-8");
                 response.getWriter().write("거래 중인 글이 있습니다");
    		}
            return null; // AJAX 응답은 직접 처리하므로 Result 반환 필요 없음
        }
		
		if(dao.quit(memberNumber)) {
			request.getSession().invalidate();
			
			result.setPath("/app/memberQuit/quitComplete.jsp");
			result.setRedirect(true);
		} else {
			result.setPath("/app/memberQuit/quitComplete.jsp");
			result.setRedirect(true);
		}
		
		
		return result;
	}

}
