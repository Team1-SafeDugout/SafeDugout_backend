package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;
import com.bullPenTalk.app.admin.dao.AdminUserPostDAO;
import com.bullPenTalk.app.dto.AdminUserPostDTO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.dto.NewsDetailDTO;
import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;



public class AdminReadPostOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
			
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		AdminUserPostDAO userPostDAO = new AdminUserPostDAO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		
		switch(boardId) {
		case 1:
//			전체 커뮤니티
			System.out.println("전체게시판 여는중");
			AdminUserPostDTO freeUserPostDTO = userPostDAO.selectDetail(postNumber);
			freeUserPostDTO.setAttachment(attachmentDAO.selectByPost(postNumber));
			result.setPath("/app/admin/adminDetailMenu/adminUserPostDetail.jsp");
			request.setAttribute("postDTO", freeUserPostDTO);
			// 댓글 추가 필요
			result.setRedirect(false);
			break;
			
		case 2:
//			팀 커뮤니티 
			System.out.println("팀 게시판 여는중");
			AdminUserPostDTO teamPostDTO = userPostDAO.selectDetail(postNumber);
			teamPostDTO.setAttachment(attachmentDAO.selectByPost(postNumber));
			result.setPath("/app/admin/adminDetailMenu/adminUserPostDetail.jsp");
			request.setAttribute("postDTO", teamPostDTO);
			// 댓글 추가 필요
			result.setRedirect(false);
			break;
			
		case 3:
//			팀뉴스
			System.out.println("뉴스여는중");
			AdminTeamNewsDAO adminNewsDAO = new AdminTeamNewsDAO();
			NewsPostDTO newsDTO = adminNewsDAO.selectDetail(postNumber);
			newsDTO.setAttachment(attachmentDAO.selectByPost(postNumber));
			System.out.println(newsDTO);
			result.setPath("/app/admin/adminDetailMenu/adminTeamNewesDetail.jsp");
			request.setAttribute("newsDTO", newsDTO);
			result.setRedirect(false);
			break;
		}
		
		
		return result;
	}
	
}
