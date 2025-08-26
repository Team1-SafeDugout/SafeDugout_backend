package com.bullPenTalk.app.trade;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class SelectController {

	// 특정 팀 조회
	public Result listTeam(String action, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("listTeam 메소드 진입");
		SellPostDAO sellPostDAO = new SellPostDAO();
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

		// 판매글 목록 조회
		List<SellPostDTO> sellPostList = sellPostDAO.selectListTeam(pageMap);
		request.setAttribute("sellPostList", sellPostList);
		System.out.println("판매글 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = sellPostDAO.getTotal();
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
		System.out.println("sellPostList : " + sellPostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/trade/tradeMain.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}

	// 특정 팀 카테고리 조회
	public Result listTeamItemCategory(String action, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("listTeamItemCategory 메소드진입");
		SellPostDAO sellPostDAO = new SellPostDAO();
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

		// 판매글 목록 조회
		List<SellPostDTO> sellPostList = sellPostDAO.selectListTeam(pageMap);
		request.setAttribute("sellPostList", sellPostList);
		System.out.println("판매글 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = sellPostDAO.getTotal();
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
		System.out.println("sellPostList : " + sellPostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/trade/tradeMain.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	// 메인페이지 조회
	public Result selectAll(String action, HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("selectAll메소드 진입");
		SellPostDAO sellPostDAO = new SellPostDAO();
		Result result = new Result();
		System.out.println("페이징 진입");
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 8; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		System.out.println("페이징 진입");
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 판매글 목록 조회
		List<SellPostDTO> sellPostList = sellPostDAO.selectList(pageMap);
		request.setAttribute("sellPostList", sellPostList);
		System.out.println("판매글 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회
		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = sellPostDAO.getTotal();
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
		System.out.println("sellPostList : " + sellPostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/trade/tradeMain.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	// 특정 카테고리 조회
	public Result listCategory(String action, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("listTeamItemCategory 메소드진입");
		SellPostDAO sellPostDAO = new SellPostDAO();
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 8; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		// 판매글 목록 조회
		List<SellPostDTO> sellPostList = sellPostDAO.selectListCategory(pageMap);
		request.setAttribute("sellPostList", sellPostList);
		System.out.println("판매글 진입");
		// 페이징 정보 설정
		// BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회

		// 실제 마지막 페이지 번호(realEndPage)를 계산함

		int total = sellPostDAO.getTotal();
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
		System.out.println("sellPostList : " + sellPostList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		System.out.println("끝 진입");
		result.setPath("/app/trade/tradeMain.jsp");
		result.setRedirect(false);
		System.out.println("리턴 진입");
		return result;
	}
	
	
	// 검색결과
	public Result search(String action, HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("search 메소드 진입");
	    SellPostDAO sellPostDAO = new SellPostDAO();
	    Result result = new Result();

	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp); 
	    int rowCount = 8; 
	    int pageCount = 5; 

	    int startRow = (page - 1) * rowCount + 1; 
	    int endRow = startRow + rowCount - 1; 

	    String searchWord = request.getParameter("searchWord");
	    if(searchWord == null) {
	        searchWord = "";
	    }

	    Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("searchWord", searchWord);

	    List<SellPostDTO> tradePostList = sellPostDAO.searchList(pageMap);
	    request.setAttribute("tradePostList", tradePostList);
	    request.setAttribute("searchWord", searchWord);

	    int total = sellPostDAO.getTotalSearch(searchWord);
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
	    request.setAttribute("total", total);

	    result.setPath("/app/trade/tradeSearchResult.jsp");
	    result.setRedirect(false);
	    return result;
	}


}
