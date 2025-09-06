package com.bullPenTalk.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.admin.dao.AdminMainNoticeDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;

public class AdminReadMainNoticeOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		// 메인공지 가져오기
		MainNoticePostDTO mainNoticeDTO = new MainNoticePostDTO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		
		// 메인공지 DAO 가져오기
		AdminMainNoticeDAO adminMainNoticeDAO = new AdminMainNoticeDAO();
		int postNumber =  Integer.parseInt(request.getParameter("noticePostNumber"));
		int postType = Integer.parseInt(request.getParameter("noticeTypeId"));
		
		mainNoticeDTO = adminMainNoticeDAO.selectDetail(postNumber);
		List<AttachmentDTO> attachment = attachmentDAO.selectByNoticePost(postNumber);
		
		for(int i = 0; i < attachment.size(); i++) {
			System.out.println("찾음!!");
			System.out.println(attachment.get(i));
		}

		
		if(mainNoticeDTO == null) {
			System.out.println("검색 실패");
			result.setPath("");
			result.setRedirect(true);
			return result;
		}
		
		mainNoticeDTO.setAttachment(attachment);
		request.setAttribute("mainNotice", mainNoticeDTO);
		System.out.println(mainNoticeDTO);
		
		result.setPath("/app/admin/adminDetailMenu/adminNoticePost.jsp");
		
		result.setRedirect(false);		
		
		return result;
	}

}
