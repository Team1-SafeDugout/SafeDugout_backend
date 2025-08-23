package com.bullPenTalk.app.trade;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.Attachment.dao.SellPostAttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.SellPostAttachmentDTO;
import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteControllerOk {

	public Result writeProduct(HttpServletRequest request, HttpServletResponse response) {
		SellPostDAO sellPostDAO = new SellPostDAO();
		SellPostDTO sellPostDTO = new SellPostDTO();
		Result result = new Result();
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		SellPostAttachmentDAO sellPostAttachmentDAO = new SellPostAttachmentDAO();

		System.out.println("Write 컨트롤러 진입");
		// 로그인 한 회원 정보 가져오기
		try {
			Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
			if (memberNumber == null) {
				System.out.println("오류 : 로그인된 사용자가 없습니다");
				response.sendRedirect("login.jsp");
				return null;
			}

			// 파일 업로드 환경 설정
			LocalDate today = LocalDate.now();
			final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
			String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
			String uploadPath = UPLOAD_PATH + subPath;
			final int FILE_SIZE = 1024 * 1024 * 5; // 5MB
			System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);

			// MultipartRequest를 이용한 데이터 파싱
			MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
					new DefaultFileRenamePolicy());
			// request : HTTP 요청객체
			// UPLOAD_PATH : 파일을 저장할 경로
			// FILE_SIZE : 파일의 최대 크기
			// "utf-8" : 파일명 인코딩 방식
			// new DefaultFileRenamePolicy() : 파일명이 중복될 경우 자동으로 이름 변경해주는 정책

			// 게시글 정보 설정
			sellPostDTO.setSellPostTitle(multipartRequest.getParameter("productTitle"));
			sellPostDTO.setSellPostContent(multipartRequest.getParameter("productContent"));
			sellPostDTO.setMemberNumber(memberNumber);
			String priceStr = multipartRequest.getParameter("pricePoint");
			sellPostDTO.setPricePoint(Integer.parseInt(priceStr));


			// 거래 방식
			String dealTypeIdStr = multipartRequest.getParameter("dealTypeId");
			sellPostDTO.setDealtypeId(Integer.parseInt(dealTypeIdStr));


			// 카테고리
			String categoryIdStr = multipartRequest.getParameter("categoryId");
			sellPostDTO.setCategoryId(Integer.parseInt(categoryIdStr));

			// 거래 지역
			sellPostDTO.setTradingArea(multipartRequest.getParameter("tradingArea"));

			// 팀 번호
			String teamIdStr = multipartRequest.getParameter("teamId");
			sellPostDTO.setTeamId(Integer.parseInt(teamIdStr));
			
			System.out.println("게시글 추가 - SellPostDetailDTO : " + sellPostDTO);

			// 게시글 추가
			int sellPostNumber = sellPostDAO.insertSellPost(sellPostDTO);
			System.out.println("생성된 게시글 번호 : " + sellPostDTO);

			// 파일 업로드 처리
			// Enumeration : java.util 패키지에 포함된 인터페이스, Iterator와 비슷한 역할함
			Enumeration<String> fileNames = multipartRequest.getFileNames();

			while (fileNames.hasMoreElements()) {
				
				String name = fileNames.nextElement();

				// 서버에 저장된 파일명
				String fileSystemName = multipartRequest.getFilesystemName(name);
				// 업로드한 원본 파일명
				String fileOriginalName = multipartRequest.getOriginalFileName(name);

				if (fileSystemName == null) {
					continue; // 업로드 안된 필드는 무시
				}

				// 파일 정보 DB 저장 후 시퀀스로 생성된 attachmentNumber 받기
				AttachmentDTO attachmentDTO = new AttachmentDTO();
				attachmentDTO.setAttachmentPath(uploadPath); 
				attachmentDTO.setAttachmentName(name);
				attachmentDTO.setAttachmentTypeId(1); // 1 = IMAGE
				attachmentDAO.insert(attachmentDTO);
				int attachmentNumber = attachmentDTO.getAttachmentNumber(); // 생성된 번호 가져오기

				// 매핑 DTO 생성
				SellPostAttachmentDTO sellPostAttachmentDTO = new SellPostAttachmentDTO();
				sellPostAttachmentDTO.setSellPostNumber(sellPostNumber); // 방금 생성된 판매글 번호
				sellPostAttachmentDTO.setAttachmentNumber(attachmentNumber); // DB에서 생성된 첨부파일 번호

				// 매핑 테이블에 INSERT
				sellPostAttachmentDTO.setSellPostNumber(sellPostNumber);
				sellPostAttachmentDTO.setAttachmentNumber(attachmentNumber);
				sellPostAttachmentDAO.insert(sellPostAttachmentDTO);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.setPath("/trade/productRegisterResult.tr");
		result.setRedirect(false);
		System.out.println("리턴징입");
		return result;

	}
}
