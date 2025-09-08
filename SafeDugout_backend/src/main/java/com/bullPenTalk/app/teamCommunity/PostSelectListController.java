package com.bullPenTalk.app.teamCommunity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.TeamNoticePostDTO;
import com.bullPenTalk.app.dto.TeamPostDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class PostSelectListController {

	// 게시판 조회 메소드
	public Result boardList(String action, HttpServletRequest request, HttpServletResponse response) {

	    System.out.println("listTeam 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();

	    // 현재 페이지
	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp);

	    int rowCount = 10; // 한 페이지당 게시글 수
	    int pageCount = 5; // 페이지 버튼 수

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1; // 시작행 (1, 11, 21, ..)
	    int endRow = startRow + rowCount - 1;     // 끝행 (10, 20, 30, ..)

	    // ⭐ 세션에서 팀 번호 꺼내오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if (teamNumber == null) {
	        teamNumber = 0; // 또는 기본값 처리
	    }

	    // Mapper에 넘겨줄 파라미터
	    Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber);

	    // 게시글 목록 조회
	    List<TeamPostDTO> postList = teamCommunityDAO.selectBoard(pageMap);
	    request.setAttribute("postList", postList);

	    // 전체 게시글 개수
	    int total = teamCommunityDAO.getTotalBoard(teamNumber);

	    // 페이징 계산
	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);

	    // endPage 보정
	    endPage = Math.min(endPage, realEndPage);

	    // prev, next 여부
	    boolean prev = startPage > 1;
	    boolean next = endPage < realEndPage;

	    // JSP에 전달
	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);

	    System.out.println("====페이징정보 확인====");
	    System.out.println("pageMap : " + pageMap);
	    System.out.println("postList : " + postList);
	    System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
	    System.out.println("====================");

	    result.setPath("/app/communityHtml/communityTapPage/teamBoard.jsp");
	    result.setRedirect(false);

	    System.out.println("teamNumber = " + teamNumber);
	    System.out.println("리턴 진입");
	    return result;
	}

		
	
	// 공지사항 더보기 목록 조회
	public Result noticeMoreList(String action, HttpServletRequest request, HttpServletResponse response){
	    System.out.println("noticeMoreList 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();

	    // 현재 페이지 번호 가져오기 (기본값 1)
	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.parseInt(temp);

	    int rowCount = 10; // 한 페이지당 게시글 수
	    int pageCount = 5;  // 페이지 버튼 수

	    // 세션에서 팀 번호 가져오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if (teamNumber == null) {
	        teamNumber = 0; // 기본값 처리
	    }

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber);

	    // 공지사항 목록 조회
	    List<TeamNoticePostDTO> PostList = teamCommunityDAO.selectNotice(pageMap);
	    request.setAttribute("noticePostList", PostList);

	    // 전체 게시글 개수 조회
	    int total = teamCommunityDAO.getTotalNotice(teamNumber);

	    // 페이징 계산
	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);

	    if (endPage > realEndPage) {
	        endPage = realEndPage;
	    }

	    boolean prev = startPage > 1;
	    boolean next = endPage < realEndPage;

	    // JSP로 전달
	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);

	    System.out.println("====페이징정보 확인====");
	    System.out.println("pageMap : " + pageMap);
	    System.out.println("PostList : " + PostList);
	    System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
	    System.out.println("====================");

	    result.setPath("/app/communityHtml/communityTapPage/teamNoticeBoard.jsp");
	    result.setRedirect(false);

	    return result;
	}
	
	// 뉴스 목록 조회
	public Result newsList(String action, HttpServletRequest request, HttpServletResponse response){
	    System.out.println("listTeam 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();

	    // 팀 번호 가져오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if(teamNumber == null) teamNumber = 0; // 기본값 처리

	    // 페이지 번호
	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.parseInt(temp);
	    int rowCount = 10; // 한 페이지당 게시글 수
	    int pageCount = 5; // 페이지 버튼 수

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber); // 팀 번호 추가

	    // 뉴스 목록 조회
	    List<NewsPostDTO> PostList = teamCommunityDAO.selectNews(pageMap);
	    request.setAttribute("postList", PostList);
	    System.out.println("게시판 진입");

	    // 게시글 총 개수 조회
	    int total = teamCommunityDAO.getTotalNews(teamNumber);

	    // 페이징 계산
	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);
	    endPage = Math.min(endPage, realEndPage);

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
	    System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
	    System.out.println("====================");

	    result.setPath("/app/communityHtml/communityTapPage/teamNews.jsp");
	    result.setRedirect(false);
	    return result;
	}

	
	
	// 유튜브 목록 조회
	public Result youtubeList(String action, HttpServletRequest request, HttpServletResponse response){
	    System.out.println("listTeam 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();
	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1

	    int rowCount = 10; // 한 페이지당 게시글 수
	    int pageCount = 5; // 페이지 버튼 수

	    // 세션에서 팀 번호 가져오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if (teamNumber == null) teamNumber = 0; // 기본값 처리

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber); // DAO 쿼리에서 사용

	    // 유튜브 목록 조회
	    List<YoutubePostDTO> PostList = teamCommunityDAO.selectYoutube(pageMap);
	    request.setAttribute("postList", PostList);

	    // 전체 게시글 수 가져오기
	    int total = teamCommunityDAO.getTotalYoutube(teamNumber); // teamNumber 전달

	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);

	    endPage = Math.min(endPage, realEndPage);

	    boolean prev = startPage > 1;
	    boolean next = endPage < realEndPage;

	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);

	    result.setPath("/app/communityHtml/communityTapPage/teamYoutubeList.jsp");
	    result.setRedirect(false);
	    return result;
	}

	
	// 선수 응원가 목록 조회
	public Result playerSongList(String action, HttpServletRequest request, HttpServletResponse response){
	    System.out.println("playerSongList 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();

	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp);
	    int rowCount = 10;
	    int pageCount = 5;

	    // 세션에서 팀 번호 가져오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if(teamNumber == null) teamNumber = 0; // 기본값 처리

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber); // DAO 쿼리에서 사용

	    // 선수 응원가 목록 조회
	    List<SongPostDTO> PostList = teamCommunityDAO.selectPlayerSong(pageMap);
	    request.setAttribute("PostList", PostList);

	    // 총 게시글 수 조회
	    int total = teamCommunityDAO.getTotalPlayerSong(teamNumber);

	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);
	    endPage = Math.min(endPage, realEndPage);

	    boolean prev = startPage > 1;
	    boolean next = endPage < realEndPage;

	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);

	    result.setPath("/app/communityHtml/communityTapPage/teamSongPlayerList.jsp");
	    result.setRedirect(false);
	    return result;
	}
	
	
	// 팀 응원가 목록 조회
	public Result teamSongList(String action, HttpServletRequest request, HttpServletResponse response){
	    System.out.println("teamSongList 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();

	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp); 
	    int rowCount = 10; 
	    int pageCount = 5;

	    // 세션에서 팀 번호 가져오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if(teamNumber == null) teamNumber = 0; // 기본값 처리

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber); // DAO 쿼리에서 팀번호 사용

	    // 팀 응원가 목록 조회
	    List<SongPostDTO> PostList = teamCommunityDAO.selectTeamSong(pageMap);
	    request.setAttribute("PostList", PostList);

	    // 총 게시글 수 조회
	    int total = teamCommunityDAO.getTotalTeamSong(teamNumber);

	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);
	    endPage = Math.min(endPage, realEndPage);

	    boolean prev = startPage > 1;
	    boolean next = endPage < realEndPage;

	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);

	    result.setPath("/app/communityHtml/communityTapPage/teamSongTeamList.jsp");
	    result.setRedirect(false);

	    System.out.println("teamNumber: " + teamNumber);
	    System.out.println("리턴 진입");
	    return result;
	}

	
	// 팀/선수 응원가 목록 조회
	public Result teamAllList(String action, HttpServletRequest request, HttpServletResponse response){
	    System.out.println("teamAllList 메소드 진입");
	    TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
	    Result result = new Result();

	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp);
	    int rowCount = 10;
	    int pageCount = 5;

	    // 세션에서 팀 번호 가져오기
	    Integer teamNumber = (Integer) request.getSession().getAttribute("teamNumber");
	    if(teamNumber == null) teamNumber = 0;

	    // 페이징 처리
	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("teamNumber", teamNumber); // DAO 쿼리에서 팀 번호 사용

	    // 응원가 목록 조회
	    List<SongPostDTO> PostList = teamCommunityDAO.selectSong(pageMap);
	    request.setAttribute("PostList", PostList);

	    // 총 게시글 수 조회
	    int total = teamCommunityDAO.getTotalBoard(teamNumber);

	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);
	    endPage = Math.min(endPage, realEndPage);

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
	    System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
	    System.out.println("====================");

	    result.setPath("/app/communityHtml/communityTapPage/teamSongTeamList.jsp");
	    result.setRedirect(false);

	    System.out.println("teamNumber: " + teamNumber);
	    System.out.println("리턴 진입");
	    return result;
	}

	
}
