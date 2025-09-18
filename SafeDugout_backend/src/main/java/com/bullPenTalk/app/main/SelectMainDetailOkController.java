package com.bullPenTalk.app.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.app.main.dao.MainDAO;

public class SelectMainDetailOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//진입 확인 메시지 
		System.out.println("메인 공지사항 상세 조회 처리 컨트롤러 진입");
		
		//MainDAO, Result 객체 생성
		MainDAO mainDAO = new MainDAO();
		System.out.println("DAO 생성 완료");
		Result result = new Result();
		
		//공지사항 번호 변수에 저장
		int noticePostNumber = Integer.parseInt(request.getParameter("noticePostNumber"));
		//이전글, 다음글 조회 방식 변수에 저장 
		String prevNext = request.getParameter("prevNext");
		//DTO 객체 선언
		MainNoticePostDTO mainNoticePostDTO; 
		//조회 방식에 맞게 MainDAO의 공지사항 상세 조회 메소드 호출
		if(prevNext != null) {
			if(prevNext.equals("prev")) {
				//이전글 조회
				mainNoticePostDTO = mainDAO.selectMainPrev(noticePostNumber);
			}else {
				//다음글 조회
				mainNoticePostDTO = mainDAO.selectMainNext(noticePostNumber);
			}
		}else {
			mainNoticePostDTO = mainDAO.selectMainDetail(noticePostNumber);
		}
		//조회한 공지사항 DTO의 번호로 첨부파일 조회하기 
		int realNoticeNumber = mainNoticePostDTO.getNoticePostNumber();
		List<AttachmentDTO> attachmentList = mainDAO.selectMainNoticeAttachment(realNoticeNumber);
		//request에 DTO 대입
		request.setAttribute("mainNoticePost", mainNoticePostDTO);
		request.setAttribute("attachmentList", attachmentList);
		System.out.println("첨부파일 목록 : " + attachmentList);
		//전체 글 개수 가져오기
		int total = mainDAO.getTotal();
		//현재 항목 순서 가져오기 
		int index = mainDAO.getIndex(mainNoticePostDTO.getNoticePostNumber());
		//이전글, 다음글 버튼 활성화 여부 
		boolean prevPost = index > 1;
		boolean nextPost = index < total; 
		//이전글, 다음글 버튼 활성화 여부 속성에 저장 
		request.setAttribute("prevPost", prevPost);
		request.setAttribute("nextPost", nextPost);
		//현재 글의 페이지 번호 계산 
		//한 페이지당 글 수 
		int rowCount = 10;
		//페이지 번호 계산
		int page = (int) Math.ceil(index / (double) rowCount);
		//페이지 번호 속성에 저장 
		request.setAttribute("page", page);
		
		System.out.println("=====글 순서, 이전글/다음글 방식, 이전글 활성화 여부, 다은글 활성화 여부, 페이지 번호 출력=====");
		System.out.println(index);
		System.out.println(prevNext);
		System.out.println(prevPost);
		System.out.println(nextPost);
		System.out.println(page);
		System.out.println("=====================");
		
		//path, redirect 여부 설정 
		result.setPath("/app/mainNotice/mainNoticeDetail.jsp");
		result.setRedirect(false);
		
		//공지사항이 존재하지 않을 경우 처리
		if(mainNoticePostDTO == null) {
			System.out.println("");
			result.setPath("/app/board/boardList.jsp");
			result.setRedirect(true);
			return result;
		}
		
		return result;
	}
	
	
}
