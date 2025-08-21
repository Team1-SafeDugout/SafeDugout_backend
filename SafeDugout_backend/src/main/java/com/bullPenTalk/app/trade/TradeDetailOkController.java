package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.SellPostDetailDTO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class TradeDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		// 판매글이 null인 경우
		String sellPostNumberStr = request.getParameter("sellPostNumber");
		if (sellPostNumberStr == null || sellPostNumberStr.trim().isEmpty()) {
			System.out.println("sellPostNumber 값이 없습니다");
			result.setPath("/app/trade/tradeMain.jsp"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		int sellPostNumber = Integer.parseInt(sellPostNumberStr);

		SellPostDAO sellPostDAO = new SellPostDAO();
//		AttachmentDAO atachmentDAO = new AttachmentDAO();

		// DB에서 글 가져오기
		SellPostDetailDTO sellPostDetailDTO = sellPostDAO.selectDetail(sellPostNumber);

		// 게시글이 존재하지 않을 경우 처리
		if (sellPostDetailDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + sellPostNumber);
			result.setPath("/app/trade/tradeMain.jsp");
			result.setRedirect(true);
			return result;
		}
		
//	      //첨부파일 가져오기
//	      List<FileDTO> files = fileDAO.select(sellPostNumber);
//	      System.out.println("======파일 확인======");
//	      System.out.println(files);
//	      System.out.println("===================");
//	      
//	      //첨부파일 붙이기
//	      sellPostDetailDTO.setFiles(files);

		// 로그인한 사용자 번호 가져오기
		Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
		System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);

		// 현재 게시글의 작성자 번호 가져오기
		int boardWriterNumber = sellPostDetailDTO.getMemberNumber();
		System.out.println("현재 게시글 작성자 번호 : " + boardWriterNumber);

		request.setAttribute("sellPost", sellPostDetailDTO);
		result.setPath("/app/trade/productDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
