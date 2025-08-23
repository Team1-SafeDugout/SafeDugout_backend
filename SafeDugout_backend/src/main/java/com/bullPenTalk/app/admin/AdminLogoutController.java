package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;

public class AdminLogoutController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		request.getSession().invalidate(); // 세션 무효화
		result.setPath("/admin/adminLogin.ad");
		result.setRedirect(true);

		return result;
	}
	

}
