package com.bullPenTalk.app.trade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.SellPostAttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.SellPostDetailDTO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class DetailControllerOK {

	public Result detailselect(String action, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		// boardNumber가 빈 문자열이거나 null인경우
		String sellPostNumberStr = request.getParameter("sellPostNumber");
		if (sellPostNumberStr == null || sellPostNumberStr.trim().isEmpty()) {
			System.out.println("sellPostNumber 값이 없습니다");
			result.setPath("/app/trade/tradeMain.jsp"); // 판매글 메인 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		int sellPostNumber = Integer.parseInt(sellPostNumberStr);

		SellPostDAO sellPostDAO = new SellPostDAO();
		SellPostAttachmentDAO sellPostattachmentDAO = new SellPostAttachmentDAO();

		// DB에서 게시글 가져오기
		SellPostDetailDTO sellPostDetailDTO = sellPostDAO.selectDetail(sellPostNumber);

//		 게시글이 존재하지 않을 경우 처리
		if(sellPostDetailDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + sellPostNumber);
			result.setPath("/app/trade/tradeMain.jsp");
			result.setRedirect(true);
			return result;
		}

		 //첨부파일 가져오기
		List<AttachmentDTO> files = sellPostattachmentDAO.select(sellPostNumber);
		System.out.println("======파일 확인======");
		System.out.println(files);
		System.out.println("===================");
		
		//첨부파일 붙이기
		sellPostDetailDTO.setAttachment(files);
//		
		//로그인한 사용자 번호 가져오기
		Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
		System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
//		
		//현재 게시글의 작성자 번호 가져오기
		int boardWriterNumber = sellPostDetailDTO.getMemberNumber();	
		System.out.println("현재 게시글 작성자 번호 : " + boardWriterNumber);		

		request.setAttribute("board", sellPostDetailDTO);
		result.setPath("/app/trade/productDetail.jsp");
		result.setRedirect(false);

		return result;
	}
}
