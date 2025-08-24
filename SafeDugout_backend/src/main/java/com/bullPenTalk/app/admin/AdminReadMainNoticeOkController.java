package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminMainNoticeDAO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;

public class AdminReadMainNoticeOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		// 메인공지 가져오기
		MainNoticePostDTO mainNoticeDTO = new MainNoticePostDTO();
		
		// 메인공지 DAO 가져오기
		AdminMainNoticeDAO adminMainNoticeDAO = new AdminMainNoticeDAO();
		int postNumber =  Integer.parseInt(request.getParameter("noticePostNumber"));
		int postType = Integer.parseInt(request.getParameter("noticeTypeId"));
		
		mainNoticeDTO = adminMainNoticeDAO.selectDetail(postNumber);
		
		System.out.println(mainNoticeDTO);
		
		if(mainNoticeDTO == null) {
			System.out.println("검색 실패");
			result.setPath("");
			result.setRedirect(true);
			return result;
		}
		
		switch(postType) {
		case 1:
			result.setPath("/app/admin/adminDetailMenu/adminNoticePost.jsp");
			break;
		case 2:
			result.setPath("/app/admin/adminDetailMenu/adminNoticePost.jsp");
			break;
		case 3:
			result.setPath("/app/admin/adminDetailMenu/adminAddFreeCommunityGuideDetail.jsp");
			break;
		}
		
		request.setAttribute("mainNotice", mainNoticeDTO);
		
		result.setRedirect(false);		
		
		return result;
	}

}
