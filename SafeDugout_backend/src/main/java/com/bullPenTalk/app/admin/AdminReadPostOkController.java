package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamYoutubeDAO;
import com.bullPenTalk.app.dto.NewsDetailDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;

public class AdminReadPostOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
			
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		switch(boardId) {
		case 1:
//			전체 커뮤니티
			break;
			
		case 2:
//			팀 커뮤니티 
			break;
			
		case 3:
//			팀뉴스
			System.out.println("뉴스여는중");
			AdminTeamNewsDAO adminNewsDAO = new AdminTeamNewsDAO();
			NewsDetailDTO newsDTO = adminNewsDAO.selectDetail(postNumber);
			result.setPath("/app/admin/adminDetailMenu/adminTeamNewesDetail.jsp");
			request.setAttribute("newsDTO", newsDTO);
			result.setRedirect(false);
			break;
		}
		
		
		return result;
	}
	
}
