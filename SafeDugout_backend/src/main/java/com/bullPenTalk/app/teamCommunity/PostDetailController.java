package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.NewsDetailDTO;
import com.bullPenTalk.app.dto.PostDetailDTO;
import com.bullPenTalk.app.dto.StadiumDTO;
import com.bullPenTalk.app.dto.StadiumFoodDTO;
import com.bullPenTalk.app.dto.StadiumTicketDTO;
import com.bullPenTalk.app.dto.TeamNoticeDetailDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class PostDetailController {

	// 게시판
	public Result detailselect(String action, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		HttpSession session = request.getSession();

		String postNumberStr = request.getParameter("postNumber");
		if (postNumberStr == null || postNumberStr.trim().isEmpty()) {
			System.out.println("postNumber 값이 없습니다");
			result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp");
			result.setRedirect(true);
			return result;
		}

		int postNumber = Integer.parseInt(postNumberStr);
		Integer teamNumber;
		// 파라미터 값에 팀넘버가 있는지 확인
		String teamNumberParam = request.getParameter("teamNumber");
		
		// 있을 경우 세션에 해당 팀 넘버 값 대입
		if (teamNumberParam != null) {
			int paramTeamNumber = Integer.parseInt(teamNumberParam);
			session.setAttribute("teamNumber", paramTeamNumber);
		}
		
		teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
		
		if (teamNumber == null) {
			System.out.println("teamNumber 세션이 없습니다.");
			result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp");
			result.setRedirect(true);
			return result;
		}

		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();

		// DTO에 postNumber와 teamNumber 세팅
		PostDetailDTO postDTO = new PostDetailDTO();
		postDTO.setPostNumber(postNumber);
		postDTO.setTeamNumber(teamNumber);

		// DB에서 게시글 가져오기
		PostDetailDTO postDetailDTO = teamCommunityDAO.postDetail(postDTO);
		System.out.println(postDTO);
		if (postDetailDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + postNumber);
			result.setPath("/app/communityHtml/communityTapPage/teamBoard.jsp");
			result.setRedirect(true);
			return result;
		}

		// 첨부파일 가져오기
		List<AttachmentDTO> files = attachmentDAO.selectByPost(postNumber);
		postDetailDTO.setAttachment(files);

		// 현재 게시글의 작성자 번호 가져오기
		int boardWriterNumber = postDTO.getMemberNumber();
		System.out.println("현재 게시글 작성자 번호 : " + boardWriterNumber);

		request.setAttribute("community", postDetailDTO);
		result.setPath("/app/communityHtml/communityTapPage/teamPostDetail.jsp");
		result.setRedirect(false);
		return result;
	}

	// 뉴스 디테일 조회
	public Result newsdetailselect(String action, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		System.out.println("메소드 실행");
		// boardNumber가 빈 문자열이거나 null인경우
		String newspostNumberStr = request.getParameter("postNumber");
		if (newspostNumberStr == null || newspostNumberStr.trim().isEmpty()) {
			System.out.println("PostNumber 값이 없습니다");
			result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp"); // 커뮤니티 메인 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		int postNumber = Integer.parseInt(newspostNumberStr);

		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();

		// DB에서 게시글 가져오기
		NewsDetailDTO newsPostDetailDTO = teamCommunityDAO.teamNewsDetail(postNumber);

//		 게시글이 존재하지 않을 경우 처리
		if (newsPostDetailDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + postNumber);
			result.setPath("/app/communityHtml/communityTapPage/teamNews.jsp");
			result.setRedirect(true);
			return result;
		}

		// 첨부파일 가져오기
		List<AttachmentDTO> files = attachmentDAO.selectByPost(postNumber);
		System.out.println("======파일 확인======");
		System.out.println(files);
		System.out.println("===================");

		// 첨부파일 붙이기
		newsPostDetailDTO.setAttachment(files);
//		
		// 로그인한 사용자 번호 가져오기
		Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
		System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
//			

		request.setAttribute("community", newsPostDetailDTO);
		result.setPath("/app/communityHtml/communityTapPage/teamNewsDetail.jsp");
		result.setRedirect(false);

		return result;
	}

	// 공지사항 상세조회
	public Result teamNoticeDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		// postNumber가 빈 문자열이거나 null인경우
		String noticepostNumberStr = request.getParameter("postNumber");

		System.out.println("공지사항 번호" + noticepostNumberStr);
		if (noticepostNumberStr == null || noticepostNumberStr.trim().isEmpty()) {
			System.out.println("noticePostNumber 값이 없습니다");
			result.setPath("/freeCommunity/freeCommunityNoticeList.fc"); // 전체커뮤니티 입문 가이드 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		int noticePostNumber = Integer.parseInt(noticepostNumberStr);

		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();

		// DB에서 게시글 가져오기
		TeamNoticeDetailDTO teamNoticeDetailDTO = teamCommunityDAO.teamNoticeDetail(noticePostNumber);

//				 게시글이 존재하지 않을 경우 처리
		if (teamNoticeDetailDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + noticePostNumber);
			result.setPath("/app/communityHtml/communityTapPage/teamNoticeBoard.jsp"); // 공지사항 목록으로
			result.setRedirect(true);
			return result;
		}

		// 첨부파일 가져오기
		List<AttachmentDTO> files = attachmentDAO.selectBySellPost(noticePostNumber);
		System.out.println("======파일 확인======");
		System.out.println(files);
		System.out.println("===================");

		// 첨부파일 붙이기
		teamNoticeDetailDTO.setAttachment(files);
//				
		// 로그인한 사용자 번호 가져오기
		Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
		System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
//				
		// 현재 게시글의 작성자 번호 가져오기
		int boardWriterNumber = teamNoticeDetailDTO.getAdminNumber();
		System.out.println("현재 게시글 작성자 번호 : " + boardWriterNumber);

		request.setAttribute("noticePostDetail", teamNoticeDetailDTO);
		result.setPath("/app/communityHtml/communityTapPage/teamNoticeBoardDetail.jsp");
		result.setRedirect(false);

		return result;

	}

	// 경기장 정보 조회
	public Result stadiumetailselect(String action, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		// teamNumber 체크
		String teamNumberStr = request.getParameter("teamNumber");
		if (teamNumberStr == null || teamNumberStr.trim().isEmpty()) {
			System.out.println("teamNumber 값이 없습니다");
			result.setPath("/app/communityHtml/communityTapPage/teamMain.jsp");
			result.setRedirect(true);
			return result;
		}

		int teamNumber = Integer.parseInt(teamNumberStr);

		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();

		// 팀 번호로 경기장 조회
		StadiumDTO stadium = teamCommunityDAO.selectStadium(teamNumber);
		if (stadium == null) {
			System.out.println("해당 팀의 경기장이 없습니다");
			result.setPath("/app/communityHtml/communityTapPage/teamMain.jsp");
			result.setRedirect(true);
			return result;
		}

		int stadiumNumber = stadium.getStadiumNumber();

		// 경기장 티켓 및 먹거리 조회
		List<StadiumTicketDTO> tickets = teamCommunityDAO.selectTicket(stadiumNumber);
		List<StadiumFoodDTO> foods = teamCommunityDAO.selectFood(stadiumNumber);

		// 티켓 예매처 정보를 추출하여 따로 JSP로 전달
		String ticketReservationSite = "";
		if (!tickets.isEmpty()) {
			// 리스트의 첫 번째 항목에서 예매 사이트 정보를 가져옴
			ticketReservationSite = tickets.get(0).getReservationSite();
		}

		request.setAttribute("ticketReservationSite", ticketReservationSite);

		request.setAttribute("stadium", stadium);
		request.setAttribute("tickets", tickets);
		request.setAttribute("foods", foods);
		result.setPath("/app/communityHtml/communityTapPage/teamStadium.jsp");
		result.setRedirect(false);

		return result;
	}

}
