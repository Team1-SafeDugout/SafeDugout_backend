package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;

public class MyPagePoinChargeListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		
		
		result.setPath("/app/pointCharge/pointChargeList.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
