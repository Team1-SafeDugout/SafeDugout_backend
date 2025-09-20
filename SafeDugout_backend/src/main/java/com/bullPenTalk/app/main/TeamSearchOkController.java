package com.bullPenTalk.app.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.NoticePostDTO;
import com.bullPenTalk.app.dto.TeamPostDTO;
import com.bullPenTalk.app.main.dao.TeamMainDAO;

public class TeamSearchOkController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 진입 확인 메시지
		System.out.println("팀 커뮤니티 검색 컨트롤러 진입");
		
		// DAO, DTO, Result 객체 선언 
		TeamMainDAO teamMainDAO = new TeamMainDAO();
		TeamPostDTO teamPostDTO = new TeamPostDTO();
		NoticePostDTO noticePostDTO = new NoticePostDTO();
		Result result = new Result();
		
		// 전송받은 검색어와 현재 팀 번호 가져오기 
		String keyword = request.getParameter("keyword");
		int teamNumber = (int)(request.getSession().getAttribute("teamNumber"));
		
		// DAO 실행 시 사용할 Map 객체에 키워드, 팀 번호 저장
		Map<String, Object> postMap = new HashMap<>();
		Map<String, Object> noticeMap = new HashMap<>();
		postMap.put("keyword", keyword);
		postMap.put("teamNumber", teamNumber);
		noticeMap.put("keyword", keyword);
		noticeMap.put("teamNumber", teamNumber);
		
		//게시글 페이징
		// 페이지 번호 가져오기
		String postTemp = request.getParameter("postPage");
		// 페이지 번호 기본값 1로 설정
		int postPage = (postTemp == null) ? 1 : Integer.valueOf(postTemp); 
		// 한 페이지당 게시글 수
		int postRowCount = 10; 
		// 페이지 버튼 수
		int postPageCount = 5; 
		// 페이지 번호 확인
		System.out.println("postPage 값 : " + postPage);
		// 페이징 처리
		// 시작행(1, 11, 21, ..)
		int postStartRow = (postPage - 1) * postRowCount + 1; 
		// 끝 행(10, 20, 30, ..)
		int postEndRow = postStartRow + postRowCount - 1; 
		// Map에 시작 행과 끝 행 저장
		postMap.put("postStartRow", postStartRow);
		postMap.put("postEndRow", postEndRow);
		// Map 정보 확인
		System.out.println("postMap 정보 : " + postMap);
		// 페이징 정보 설정
		// TeamMainMapper.xml의 totalSearchPost를 이용하여 검색 결과 전체 개수 조회
		// 실제 마지막 페이지 번호(postRealEndPage)를 계산함
		int postTotal = teamMainDAO.totalSearchPost(postMap);
		// 실제 마지막 페이지(전체 게시글 기준으로 계산)
		int postRealEndPage = (int) Math.ceil(postTotal / (double) postRowCount); 
		// 현재 페이지 그룹에서의 마지막 페이지
		int postEndPage = (int) (Math.ceil(postPage / (double) postPageCount) * postPageCount);
		// 현재 페이지 그룹에서의 첫 페이지
		int postStartPage = postEndPage - (postPageCount - 1); 
		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		postEndPage = Math.min(postEndPage, postRealEndPage);
		// 이전, 다음 버튼 활성화 여부 확인
		boolean postPrev = postStartPage > 1;
		boolean postNext = postEndPage < postRealEndPage;
		// request에 각 값 저장
		request.setAttribute("postPage", postPage);
		request.setAttribute("postStartPage", postStartPage);
		request.setAttribute("postEndPage", postEndPage);
		request.setAttribute("postPrev", postPrev);
		request.setAttribute("postNext", postNext);
		
		//공지사항 페이징
		// 페이지 번호 가져오기
		String noticeTemp = request.getParameter("noticePage");
		// 페이지 번호 기본값 1로 설정
		int noticePage = (noticeTemp == null) ? 1 : Integer.valueOf(noticeTemp); 
		// 한 페이지당 게시글 수
		int noticeRowCount = 5; 
		// 페이지 버튼 수
		int noticePageCount = 5; 
		// 페이지 번호 확인
		System.out.println("noticePage 값 : " + noticePage);
		// 페이징 처리
		// 시작행(1, 11, 21, ..)
		int noticeStartRow = (noticePage - 1) * noticeRowCount + 1; 
		// 끝 행(10, 20, 30, ..)
		int noticeEndRow = noticeStartRow + noticeRowCount - 1; 
		// Map에 시작 행과 끝 행 저장
		noticeMap.put("noticeStartRow", noticeStartRow);
		noticeMap.put("noticeEndRow", noticeEndRow);
		// Map 정보 확인
		System.out.println("noticeMap 정보 : " + noticeMap);
		// 페이징 정보 설정
		// TeamMainMapper.xml의 totalSearchNotice를 이용하여 검색 결과 전체 개수 조회
		// 실제 마지막 페이지 번호(noticeRealEndPage)를 계산함
		int noticeTotal = teamMainDAO.totalSearchNotice(noticeMap);
		// 실제 마지막 페이지(전체 게시글 기준으로 계산)
		int noticeRealEndPage = (int) Math.ceil(noticeTotal / (double) noticeRowCount); 
		// 현재 페이지 그룹에서의 마지막 페이지
		int noticeEndPage = (int) (Math.ceil(noticePage / (double) noticePageCount) * noticePageCount);
		// 현재 페이지 그룹에서의 첫 페이지
		int noticeStartPage = noticeEndPage - (noticePageCount - 1); 
		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		noticeEndPage = Math.min(noticeEndPage, noticeRealEndPage);
		// 이전, 다음 버튼 활성화 여부 확인
		boolean noticePrev = noticeStartPage > 1;
		boolean noticeNext = noticeEndPage < noticeRealEndPage;
		// request에 각 값 저장
		request.setAttribute("noticePage", noticePage);
		request.setAttribute("noticeStartPage", noticeStartPage);
		request.setAttribute("noticeEndPage", noticeEndPage);
		request.setAttribute("noticePrev", noticePrev);
		request.setAttribute("noticeNext", noticeNext);
		System.out.println("공지사항 페이지 끝 번호 : " + noticeEndPage);
		System.out.println("게시글 페이지 끝 번호 : " + postEndPage);
		
		// 게시글 검색 목록 조회 
		List<TeamPostDTO> postList = teamMainDAO.searchPost(postMap);
		// 공지사항 검색 목록 조회 
		List<NoticePostDTO> noticeList = teamMainDAO.searchNotice(noticeMap);
		
		// request에 검색 목록, keyword 저장 
		request.setAttribute("postList", postList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("keyword", keyword);
		
		// 경로 및 리다이렉트 여부 설정 
		result.setPath("/app/communityHtml/communityTapPage/teamSearch.jsp");
		result.setRedirect(false);
		
		return result;
	}
}
