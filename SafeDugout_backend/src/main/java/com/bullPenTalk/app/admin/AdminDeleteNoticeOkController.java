package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminGuideDAO;
import com.bullPenTalk.app.admin.dao.AdminMainNoticeDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamNoticeDAO;
import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.app.dto.TeamNoticeDetailDTO;

public class AdminDeleteNoticeOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		// 메인공지 DAO 가져오기
		int postNumber =  Integer.parseInt(request.getParameter("noticePostNumber"));
		int postType = Integer.parseInt(request.getParameter("noticeTypeId"));
		
		switch(postType) {
		case 1:
			result.setPath("/admin/adminMainNoticeListOk.ad");
			AdminMainNoticeDAO adminMainNoticeDAO = new AdminMainNoticeDAO();
			MainNoticePostDTO mainNoticeDTO = adminMainNoticeDAO.selectDetail(postNumber);
			if(mainNoticeDTO != null) adminMainNoticeDAO.delete(postNumber);
			break;
		case 2:
			result.setPath("/admin/adminMainNoticeListOk.ad");
			AdminTeamNoticeDAO adminTeamNoticeDAO = new AdminTeamNoticeDAO();
			TeamNoticeDetailDTO teamNoticeDTO = adminTeamNoticeDAO.selectDetail(postNumber);
			if(teamNoticeDTO != null) adminTeamNoticeDAO.delete(postNumber);
			break;
		case 3:
			System.out.println("가이드 삭제 진입");
			result.setPath("/admin/adminManageFreeCommunityListOk.ad");
			AdminGuideDAO adminGuideDAO = new AdminGuideDAO();
			GuidePostDTO guideDTO = adminGuideDAO.selectDetail(postNumber);
			System.out.println(postNumber);
			System.out.println(guideDTO);
			if(guideDTO != null) {				
				System.out.println("가이드 삭제 완료");
				adminGuideDAO.delete(postNumber);
			}
			break;
		}
		
		result.setRedirect(true);		
		
		return result;
	}
	
}
