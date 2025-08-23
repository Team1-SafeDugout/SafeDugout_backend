package com.bullPenTalk.app.admin;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.admin.dao.AdminGuideDAO;
import com.bullPenTalk.app.admin.dao.AdminMainNoticeDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamNoticeDAO;
import com.bullPenTalk.app.dto.AdminDTO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.app.dto.TeamAdminPostDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class AdminCreateMainNoticeOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		result.setPath("/admin/adminCreateMainNoticeOk.ad");
		result.setRedirect(true);
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		HttpSession session = request.getSession();
		AdminDTO adminInfo = (AdminDTO) session.getAttribute("adminInfo");
        
		// 파일 업로드 환경 설정
		LocalDate today = LocalDate.now();
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
		String uploadPath = UPLOAD_PATH + subPath;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB
		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);
		
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // 상위 폴더까지 모두 생성
            System.out.println("업로드 폴더 생성 완료: " + uploadPath);
        }
		
		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());
		
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
		}
		
		String boardCategory = multipartRequest.getParameter("post-categories"); // 리퀘스트로 넘어온 
		int boardNum = 0; // 카테고리 테이블에서의 boardNUM
		
		String title = multipartRequest.getParameter("title-text");
		String date = today.getYear() + "-" + today.getMonth() + "-" + today.getDayOfMonth();
		String upDate = date;
		String content  = multipartRequest.getParameter("content");
		int adminNumber = adminInfo.getAdminNumber();
		
		switch(boardCategory) {
		case "main":
			boardNum = 1;
			MainNoticePostDTO mainPost = new MainNoticePostDTO();
			AdminMainNoticeDAO mainDAO = new AdminMainNoticeDAO();
			
			mainPost.setNoticePostTitle(title);
			mainPost.setNoticePostContent(content);
			mainPost.setNoticePostDate(date);
			mainPost.setNoticePostUpdate(upDate);
			mainPost.setAdminNumber(adminNumber);
			
			mainDAO.insert(mainPost);
			result.setPath("");
			break;
			
		case "guide":
			boardNum = 2;
			GuidePostDTO guidePost = new GuidePostDTO();
			AdminGuideDAO guideDAO = new AdminGuideDAO();
			
			guidePost.setNoticePostTitle(title);
			guidePost.setNoticePostContent(content);
			guidePost.setNoticePostDate(date);
			guidePost.setNoticePostUpdate(upDate);
			guidePost.setAdminNumber(adminNumber);
			
			guideDAO.insert(guidePost);
			result.setPath("");
			break;
			
		case "team":
			boardNum = 3;
			TeamAdminPostDTO teamPost = new TeamAdminPostDTO();
			AdminTeamNoticeDAO teamDAO = new AdminTeamNoticeDAO();
			
			int teamNum = getTeamNumber(multipartRequest.getParameter("team-categories"));
			
			teamPost.setPostTitle(title);
			teamPost.setPostContent(content);
			teamPost.setPostDate(date);
			teamPost.setPostUpdate(upDate);
			teamPost.setTeamNumber(teamNum);
			
			teamDAO.insert(teamPost);
			result.setPath("");
			break;
			
		default:
			result = null;
			break;
		}
		result.setPath("/admin/adminMainNoticeListOk.ad");
		result.setRedirect(true);
		
		return result;
	}
	
	
	
	int getTeamNumber(String teamName) {
		int teamNumber = 0;
		switch(teamName) {
		case "lg":
			teamNumber = 1;
			break;
		case "hh":
			teamNumber = 2;
			break;
		case "lotte":
			teamNumber = 3;
			break;
		case "ssg":
			teamNumber = 4;
			break;
		case "kia":
			teamNumber = 5;
			break;
		case "kt":
			teamNumber = 6;
			break;
		case "nc":
			teamNumber = 7;
			break;
		case "samsung":
			teamNumber = 8;
			break;
		case "doosan":
			teamNumber = 9;
			break;
		case "kiwoom":
			teamNumber = 10;
			break;
		}
		return teamNumber;
	}

}
