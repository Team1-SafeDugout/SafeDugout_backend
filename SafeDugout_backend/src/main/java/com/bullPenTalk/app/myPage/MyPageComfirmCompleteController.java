package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MyPageTradeListDTO;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class MyPageComfirmCompleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sellPostNumber = Integer.parseInt(request.getParameter("sellPostNumber"));
		MyPageDAO dao = new MyPageDAO();
		MyPageTradeListDTO dto = dao.selectDetailTrade(sellPostNumber);
		
		request.setAttribute("sellPost", dto);
		int memberNumber = Integer.parseInt(request.getSession().getAttribute("memberNumber").toString());
		int memberPoint = dao.getMemberPoint(memberNumber);
		request.setAttribute("myPoint", memberPoint);
		
		Result result = new Result();
		result.setPath("/app/buyList/buyListConfirmComplete.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
