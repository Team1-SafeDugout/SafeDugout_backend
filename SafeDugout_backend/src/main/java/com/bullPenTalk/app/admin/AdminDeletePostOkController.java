package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamSongDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamYoutubeDAO;
import com.bullPenTalk.app.admin.dao.AdminUserPostDAO;

public class AdminDeletePostOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		// 메인공지 DAO 가져오기
		System.out.println(request.getParameter("postNumber"));
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		int postType = Integer.parseInt(request.getParameter("postTypeId"));

		switch(postType) {
		case 1:
//			전체 커뮤니티			
		case 2:
//			팀 커뮤니티 
			System.out.println("게시글 삭제중");
			AdminUserPostDAO postDAO = new AdminUserPostDAO();
			postDAO.delete(postNumber);
			result.setPath("/admin/adminManageUserPostListOk.ad");
			result.setRedirect(false);
			break;
			
		case 3:
//			팀뉴스
			System.out.println("뉴스삭제중");
			AdminTeamNewsDAO adminNewsDAO = new AdminTeamNewsDAO();
			adminNewsDAO.delete(postNumber);
			result.setPath("/admin/adminManageTeamNewsListOk.ad");
			result.setRedirect(false);
			break;
			
		case 4:
//			팀 유튜브
			System.out.println("유튜브삭제중");
			AdminTeamYoutubeDAO adminYoutubeDAO = new AdminTeamYoutubeDAO();
			adminYoutubeDAO.delete(postNumber);
			result.setPath("/admin/adminManageTeamYoutubeListOk.ad");
			result.setRedirect(false);
			break;
			
		case 5:
//			팀 응원가
			System.out.println("응원가삭제중");
			AdminTeamSongDAO adminSongDAO = new AdminTeamSongDAO();
			adminSongDAO.delete(postNumber);
			result.setPath("/admin/adminManageTeamSongListOk.ad");
			result.setRedirect(false);
			break;
			
		case 6:
//			선수 응원가
			System.out.println("선수응원가삭제중");
			AdminTeamSongDAO adminPlayerSongDAO = new AdminTeamSongDAO();
			adminPlayerSongDAO.delete(postNumber);
			result.setPath("/app/admin/adminDetailMenu/adminManageTeamSong.jsp");
			result.setRedirect(false);
			break;
		}

		return result;
	}

}
