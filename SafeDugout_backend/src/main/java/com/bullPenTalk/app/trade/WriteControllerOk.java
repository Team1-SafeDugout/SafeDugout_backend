package com.bullPenTalk.app.trade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
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
			
			// 업로드 폴더가 존재하지 않으면 생성
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
			    uploadDir.mkdirs(); // 상위 폴더까지 모두 생성
			    System.out.println("업로드 폴더 생성 완료: " + uploadPath);
			}

			// MultipartRequest를 이용한 데이터 파싱
			MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath  , FILE_SIZE, "utf-8",
					new DefaultFileRenamePolicy());
			// request : HTTP 요청객체
			// UPLOAD_PATH : 파일을 저장할 경로
			// FILE_SIZE : 파일의 최대 크기
			// "utf-8" : 파일명 인코딩 방식
			// new DefaultFileRenamePolicy() : 파일명이 중복될 경우 자동으로 이름 변경해주는 정책
			String title = multipartRequest.getParameter("sellPostTitle");
			String content = multipartRequest.getParameter("sellPostContent");
			String priceStr = multipartRequest.getParameter("pricePoint");
			String dealTypeStr = multipartRequest.getParameter("dealTypeId");
			String categoryStr = multipartRequest.getParameter("categoryId");
			String teamIdStr = multipartRequest.getParameter("teamId");
			String tradingArea = multipartRequest.getParameter("tradingArea");
			
			System.out.println(title);
			System.out.println(content);
			System.out.println(priceStr);
			System.out.println(dealTypeStr);
			System.out.println(categoryStr);
			System.out.println(teamIdStr);
			System.out.println(tradingArea);
			// 게시글 정보 설정
			sellPostDTO.setSellPostTitle(title);
			sellPostDTO.setSellPostContent(content);
			sellPostDTO.setMemberNumber(memberNumber);
			sellPostDTO.setPricePoint(Integer.parseInt(priceStr));
			sellPostDTO.setDealtypeId(Integer.parseInt(dealTypeStr));
			sellPostDTO.setCategoryId(Integer.parseInt(categoryStr));
			sellPostDTO.setTeamId(Integer.parseInt(teamIdStr));
			sellPostDTO.setTradingArea(tradingArea);
			sellPostDTO.setStatusId(1);
			
			System.out.println("게시글 추가 - SellPostDetailDTO : " + sellPostDTO);

			// 게시글 추가
			int sellPostNumber = sellPostDAO.insertSellPost(sellPostDTO);
			System.out.println("생성된 게시글 번호 : " + sellPostDTO);

			// 파일 업로드 처리
			// Enumeration : java.util 패키지에 포함된 인터페이스, Iterator와 비슷한 역할함
			Enumeration<String> fileNames = multipartRequest.getFileNames();

			while (fileNames.hasMoreElements()) {
			    String name = fileNames.nextElement();
			    String fileSystemName = multipartRequest.getFilesystemName(name);
			    String fileOriginalName = multipartRequest.getOriginalFileName(name);

			    if (fileSystemName == null) continue;

			    AttachmentDTO attachmentDTO = new AttachmentDTO();
			    attachmentDTO.setAttachmentPath(subPath + fileSystemName);
			    attachmentDTO.setAttachmentName(fileOriginalName);
			    attachmentDTO.setAttachmentTypeId(1);
			    attachmentDTO.setSellPostNumber(sellPostNumber); // 반드시 insert 전에 세팅

			    // DB에 insert
			    attachmentDAO.insert(attachmentDTO);
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.setPath("/trade/SellPostFrontController2.tr?category=allproduct&action=list");
		result.setRedirect(false);
		System.out.println("리턴징입");
		return result;

	}
	
	
}
