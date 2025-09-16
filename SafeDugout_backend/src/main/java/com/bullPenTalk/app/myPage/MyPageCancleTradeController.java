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
		
		MyPageDAO myPageDAO = new MyPageDAO();
		myPageDAO.cancelTradeUpdate(postNumber);
		myPageDAO.cancelTradeDelete(postNumber);
		
		result.setPath("/myPage/tradeList.mp");
		result.setRedirect(false);
		
		return result;
	}

}
