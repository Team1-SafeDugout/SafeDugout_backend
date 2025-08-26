package com.bullPenTalk.app.teamCommunity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.TeamNoticePostDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class PostSelectListController {

	// 게시판 조회 메소드
	public Result boardList(String action, HttpServletRequest request, HttpServletResponse response){
		System.out.println("listTeam 메소드 진입");
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 게시글 목록 조회
		List<PostDTO> PostList = teamCommunityDAO.selectBoard(pageMap);
		request.setAttribute("PostList", PostList);
		System.out.println("게시판 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = teamCommunityDAO.getTotalBoard();
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

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("PostList : " + PostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/communityHtml/communityTapPage/teamBoardjsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
		
	
	// 공지사항 더보기 목록 조회
	public Result noticeMoreList(String action, HttpServletRequest request, HttpServletResponse response){
		System.out.println("listTeam 메소드 진입");
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 공지사항 목록 조회
		List<TeamNoticePostDTO> PostList = teamCommunityDAO.selectNotice(pageMap);
		request.setAttribute("PostList", PostList);
		System.out.println("게시판 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = teamCommunityDAO.getTotalBoard();
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

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("PostList : " + PostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/communityHtml/communityTapPage/teamNoticeBoard.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	// 뉴스 목록 조회
	public Result newsList(String action, HttpServletRequest request, HttpServletResponse response){
		System.out.println("listTeam 메소드 진입");
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 뉴스 목록 조회
		List<NewsPostDTO> PostList = teamCommunityDAO.selectNews(pageMap);
		request.setAttribute("PostList", PostList);
		System.out.println("게시판 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = teamCommunityDAO.getTotalBoard();
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

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("PostList : " + PostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/communityHtml/communityTapPage/teamNoticeBoard.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	
	// 유튜브 목록 조회
	public Result youtubeList(String action, HttpServletRequest request, HttpServletResponse response){
		System.out.println("listTeam 메소드 진입");
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 유튜브 목록 조회
		List<YoutubePostDTO> PostList = teamCommunityDAO.selectYoutube(pageMap);
		request.setAttribute("PostList", PostList);
		System.out.println("게시판 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = teamCommunityDAO.getTotalBoard();
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

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("PostList : " + PostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/communityHtml/communityTapPage/teamNoticeBoard.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	// 선수 응원가 목록 조회
	public Result playerSongList(String action, HttpServletRequest request, HttpServletResponse response){
		System.out.println("playerSongList 메소드 진입");
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 목록 조회
		List<SongPostDTO> PostList = teamCommunityDAO.selectPlayerSong(pageMap);
		request.setAttribute("PostList", PostList);
		System.out.println("게시판 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = teamCommunityDAO.getTotalPlayerSong();
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

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("PostList : " + PostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/communityHtml/communityTapPage/teamSongPlayerList.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	
	// 팀 응원가 목록 조회
	public Result teamSongList(String action, HttpServletRequest request, HttpServletResponse response){
		System.out.println("listTeam 메소드 진입");
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 팀 응원가 목록 조회
		List<SongPostDTO> PostList = teamCommunityDAO.selectTeamSong(pageMap);
		request.setAttribute("PostList", PostList);
		System.out.println("게시판 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = teamCommunityDAO.getTotalTeamSong();
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

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("PostList : " + PostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/communityHtml/communityTapPage/teamSongTeamList.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	// 팀/선수 응원가 목록 조회
		public Result teamAllList(String action, HttpServletRequest request, HttpServletResponse response){
			System.out.println("listTeam 메소드 진입");
			TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
			Result result = new Result();
			String temp = request.getParameter("page");
			int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
			int rowCount = 10; // 한 페이지당 게시글 수
			int pageCount = 5; // 페이지 버튼 수
			// 페이징 처리
			int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
			int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

			Map<String, Integer> pageMap = new HashMap<>();
			pageMap.put("startRow", startRow);
			pageMap.put("endRow", endRow);

			// 응원가 목록 조회
			List<SongPostDTO> PostList = teamCommunityDAO.selectSong(pageMap);
			request.setAttribute("PostList", PostList);
			System.out.println("게시판 진입");
			// 페이징 정보 설정
			// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

			// 실제 마지막 페이지 번호(realEndPage)를 계산함

			int total = teamCommunityDAO.getTotalBoard();
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

			System.out.println("====페이징정보 확인====");
			System.out.println("pageMap : " + pageMap);
			System.out.println("PostList : " + PostList);
			System.out.println(
					"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
			System.out.println("====================");

			System.out.println("끝 진입");
			result.setPath("/app/communityHtml/communityTapPage/teamSongTeamList.jsp");
			result.setRedirect(false);
			System.out.println("리턴 진입");
			return result;
		}
	
}
