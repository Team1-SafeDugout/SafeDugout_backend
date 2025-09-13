package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageDeleteSellOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		int postNumber = Integer.parseInt(request.getParameter("sellPostNumber"));
		MyPageDAO myPageDao = new MyPageDAO();
		System.out.println("삭제 대상 번호 : "+ postNumber);
		myPageDao.deleteSell(postNumber);
		
		result.setPath("/myPage/sellList.mp");
		result.setRedirect(false);
		
		return result;
	}

}
