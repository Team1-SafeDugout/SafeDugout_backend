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
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.app.main.dao.MainDAO;

public class SelectMainListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("매인 공지사항 목록 조회 처리 컨트롤러 진입");
		MainDAO mainDAO = new MainDAO();
		Result result = new Result();
		
		String temp = request.getParameter("page");
		// 페이지 번호 기본값 1로 설정
		int page = (temp == null) ? 1 : Integer.valueOf(temp); 
		// 한 페이지당 게시글 수
		int rowCount = 10; 
		// 페이지 버튼 수
		int pageCount = 5; 

		System.out.println("page 값 : " + page);
		
		// 페이징 처리
		// 시작행(1, 11, 21, ..)
		int startRow = (page - 1) * rowCount + 1; 
		// 끝 행(10, 20, 30, ..)
		int endRow = startRow + rowCount - 1; 
		
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		System.out.println("pageMap 정보 : " + pageMap);
		
		// 공지사항 목록 조회
		List<MainNoticePostDTO> mainNoticeList = mainDAO.selectMainList(pageMap);
		System.out.println("selectMainList 메소드 호출 완료");
		request.setAttribute("mainNoticeList", mainNoticeList);
		// 페이징 정보 설정
		// MainMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회
		// 실제 마지막 페이지 번호(realEndPage)를 계산함
		int total = mainDAO.getTotal();
		// 실제 마지막 페이지(전체 게시글 기준으로 계산)
		int realEndPage = (int) Math.ceil(total / (double) rowCount); 
		// 현재 페이지 그룹에서의 마지막 페이지
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		// 현재 페이지 그룹에서의 첫 페이지
		int startPage = endPage - (pageCount - 1); 
		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		endPage = Math.min(endPage, realEndPage);
		// 이전, 다음 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("mainNoticeList : " + mainNoticeList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		result.setPath("/app/mainNotice/mainNoticeList.jsp");
		result.setRedirect(false);

		return result;
	}
	
	
	
}
