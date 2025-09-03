package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminSellDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;

public class AdminDeleteSellPostOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		
		System.out.println("판매글 삭제 중");
		AdminSellDAO adminNewsDAO = new AdminSellDAO();
		adminNewsDAO.delete(postNumber);
		result.setPath("/admin/adminManageSellListOk.ad");
		result.setRedirect(false);
		
		return result;
	}

}
