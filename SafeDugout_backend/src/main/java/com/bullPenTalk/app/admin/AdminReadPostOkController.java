package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;
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
		
		switch(boardId) {
		case 1:
//			전체 커뮤니티
			System.out.println("전체게시판 여는중");
			FreePostDAO freePostDAO = new FreePostDAO();
//			FreePostDTO freePostDTO = freePostDAO.detailSelect(postNumber);
			result.setPath("/app/admin/adminDetailMenu/adminFreeComunityUserPost.jsp");
//			request.setAttribute("freePostDTO", freePostDTO);
			result.setRedirect(false);
			break;
			
		case 2:
//			팀 커뮤니티 
			System.out.println("팀 게시판 여는중");
			/* AdminMemberDAO teamPostDAO = new TeamCommunityDAO(); */
			/* PostDetailDTO teamPostDTO = teamPostDAO.postDetail(postNumber); */
			result.setPath("/app/admin/adminDetailMenu/adminFreeComunityUserPost.jsp");
			request.setAttribute("teamPostDTO", 1);
			result.setRedirect(false);
			break;
			
		case 3:
//			팀뉴스
			System.out.println("뉴스여는중");
			AdminTeamNewsDAO adminNewsDAO = new AdminTeamNewsDAO();
			NewsPostDTO newsDTO = adminNewsDAO.selectDetail(postNumber);
			System.out.println(newsDTO);
			result.setPath("/app/admin/adminDetailMenu/adminTeamNewesDetail.jsp");
			request.setAttribute("newsDTO", newsDTO);
			result.setRedirect(false);
			break;
		}
		
		
		return result;
	}
	
}
