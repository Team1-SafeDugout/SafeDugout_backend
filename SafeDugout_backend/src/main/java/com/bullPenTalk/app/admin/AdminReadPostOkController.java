package com.bullPenTalk.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;
import com.bullPenTalk.app.admin.dao.AdminUserPostDAO;
import com.bullPenTalk.app.admin.dao.FreeCommentDAO;
import com.bullPenTalk.app.dto.AdminUserPostDTO;
import com.bullPenTalk.app.dto.CommentDTO;
import com.bullPenTalk.app.dto.NewsPostDTO;



public class AdminReadPostOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
			
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		int boardId = Integer.parseInt(request.getParameter("postTypeId"));
		AdminUserPostDAO userPostDAO = new AdminUserPostDAO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		List<CommentDTO> commentDTO = null;
		
		// 페이지네이션
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수

		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		// 시작과 행과 끝행 맵으로 정리 [(startRow,1), (endRow,2)]... 이런식으로 가게됨
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("postNumber", postNumber);
		int total = 0;
		
		String currentTab = "all";
		if(request.getParameter("currentTab") != null) {
			currentTab = request.getParameter("currentTab");
		}
		
		
		
		switch(boardId) {
		case 1:
//			전체 커뮤니티
			System.out.println("전체게시판 여는중");
			AdminUserPostDTO freeUserPostDTO = userPostDAO.selectDetail(postNumber);
			freeUserPostDTO.setAttachment(attachmentDAO.selectByPost(postNumber));
			result.setPath("/app/admin/adminDetailMenu/adminUserPostDetail.jsp");
			request.setAttribute("postDTO", freeUserPostDTO);
			// 댓글 추가 필요
			
			FreeCommentDAO freeCommentDAO = new FreeCommentDAO();
			commentDTO = freeCommentDAO.selectAll(pageMap);
			
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
			
			FreeCommentDAO teamCommentDAO = new FreeCommentDAO();
			commentDTO = teamCommentDAO.selectAll(pageMap);
			
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
		
		
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회
		// 실제 마지막 페이지 번호(realEndPage)를 계산함
		int realEndPage = (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지(전체 게시글 기준으로 계산)
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현재 페이지 그룹에서의 마지막 페이지
		int startPage = endPage - (pageCount - 1); // 현재 페이지 그룹에서의 첫 페이지
		
		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		endPage = Math.min(endPage, realEndPage);
	
		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
	
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		if(commentDTO != null) {
			System.out.println(commentDTO.size());
			request.setAttribute("comments", commentDTO);
		}
		
		return result;
	}
	
}
