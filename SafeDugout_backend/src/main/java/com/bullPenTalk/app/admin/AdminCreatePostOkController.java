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
import com.bullPenTalk.app.admin.dao.AdminDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamNewsDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamSongDAO;
import com.bullPenTalk.app.admin.dao.AdminTeamYoutubeDAO;
import com.bullPenTalk.app.dto.AdminDTO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.NewsPostDTO;
import com.bullPenTalk.app.dto.SongPostDTO;
import com.bullPenTalk.app.dto.YoutubePostDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminCreatePostOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		result.setPath("/admin/adminCreateMainNoticeOk.ad");
		result.setRedirect(true);
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		HttpSession session = request.getSession();
		AdminDTO adminInfo = (AdminDTO) session.getAttribute("adminInfo");
		AdminDAO adminDAO = new AdminDAO();
        
		// 파일 업로드 환경 설정
		LocalDate today = LocalDate.now();
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
		String uploadPath = UPLOAD_PATH + subPath;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB
		System.out.println("파일 업로드 경로 : " + uploadPath);
		
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // 상위 폴더까지 모두 생성
            System.out.println("업로드 폴더 생성 완료: " + uploadPath);
        }
        
        System.out.println(UPLOAD_PATH);
		
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());
		
		// 파일 업로드 처리
		// Enumeration : java.util 패키지에 포함된 인터페이스, Iterator와 비슷한 역할함
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		
		String boardCategory =  request.getParameter("boardCategory"); // 리퀘스트로 넘어온 
		int boardNum = 0; // 카테고리 테이블에서의 boardNUM
		
		String title = multipartRequest.getParameter("title-text");
		String date = today.getYear() + "-" + today.getMonth() + "-" + today.getDayOfMonth();
		String upDate = date;
		String content  = multipartRequest.getParameter("content");
		int adminNumber = adminInfo != null ? adminInfo.getAdminNumber() : adminDAO.getFirstAdmin();
		int teamNum = getTeamNumber(multipartRequest.getParameter("team-categories"));
		
		switch(boardCategory) {
		case "teamnews":
			System.out.println("뉴스생성");
			boardNum = 3;
			NewsPostDTO newsPost = new NewsPostDTO();
			AdminTeamNewsDAO newsDAO = new AdminTeamNewsDAO();
			String journalist = multipartRequest.getParameter("journal-text");
			String newsUrl = multipartRequest.getParameter("url-text");
//			VALUES(#{postNumber}, #{teamNumber}, #{adminNumber}, #{boardId}, #{postTilte}, #{postDate}, 
//			#{postLink} , #{journalist})
			newsPost.setPostTitle(title);
			newsPost.setPostContent(content);
			newsPost.setTeamNumber(teamNum);
			newsPost.setJournalist(journalist);
			newsPost.setAdminNumber(adminNumber);
			newsPost.setPostLink(newsUrl);
			newsPost.setPostType(boardNum);
			
			newsDAO.insert(newsPost);
			result.setPath("/admin/adminManageTeamNewsListOk.ad");
			break;
			
		case "teamyoutube":
			boardNum = 4;
			System.out.println(teamNum);
			YoutubePostDTO youtubePostDTO = new YoutubePostDTO();
			AdminTeamYoutubeDAO youtubeDAO = new AdminTeamYoutubeDAO();
			String youtubeUrl = multipartRequest.getParameter("youtubeUrl");
			title = multipartRequest.getParameter("youtubeTitle");
			teamNum = getTeamNumber(multipartRequest.getParameter("team-categories"));
			youtubePostDTO.setPostType(boardNum);
			youtubePostDTO.setPostContent("youtubeID");
			youtubePostDTO.setPostTitle(title);
			youtubePostDTO.setTeamNumber(teamNum);
			youtubePostDTO.setAdminNumber(adminNumber);
			youtubePostDTO.setPostDate(date);
			youtubePostDTO.setPostLink(youtubeUrl);
			
			youtubeDAO.insert(youtubePostDTO);
			result.setPath("/admin/adminManageTeamYoutubeListOk.ad");
			
			break;
			
		case "teamCheeringsong":
			boardNum = 5;
			
			SongPostDTO songPostDTO = new SongPostDTO();
			AdminTeamSongDAO songPostDAO = new AdminTeamSongDAO();
			String songUrl = multipartRequest.getParameter("songUrl");
			title = multipartRequest.getParameter("songTitle");
			teamNum = getTeamNumber(multipartRequest.getParameter("team-categories"));
			songPostDTO.setPostTitle(title);
			songPostDTO.setPostDate(date);
			songPostDTO.setTeamNumber(teamNum);
			songPostDTO.setPostType(boardNum);
			songPostDTO.setAdminId(adminNumber);
			songPostDTO.setPostLink(songUrl);
			songPostDTO.setPostContent("song");
			
			songPostDAO.insert(songPostDTO);
			result.setPath("/admin/adminManageTeamSongListOk.ad");
			break;
			
		case "playercheeringsong":
			boardNum = 6;
			
			SongPostDTO songPlayerPostDTO = new SongPostDTO();
			AdminTeamSongDAO songPlayerPostDAO = new AdminTeamSongDAO();
			String songPlayerUrl = multipartRequest.getParameter("songUrl");
			title = multipartRequest.getParameter("songTitle");
			teamNum = getTeamNumber(multipartRequest.getParameter("team-categories"));
			songPlayerPostDTO.setPostTitle(title);
			songPlayerPostDTO.setPostDate(date);
			songPlayerPostDTO.setTeamNumber(teamNum);
			songPlayerPostDTO.setPostType(boardNum);
			songPlayerPostDTO.setAdminId(adminNumber);
			songPlayerPostDTO.setPostLink(songPlayerUrl);
			songPlayerPostDTO.setPostContent("song");
			
			songPlayerPostDAO.insert(songPlayerPostDTO);
			result.setPath("/admin/adminManageTeamSongListOk.ad");
			
			break;
		}
		
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
			attachmentDTO.setAttachmentPath("/upload/" + subPath);
			attachmentDTO.setAttachmentName(fileOriginalName);
			attachmentDTO.setAttachmentTypeId(1); // 1 = IMAGE
			attachmentDTO.setPostNumber(attachmentDAO.getPostNumber());
			attachmentDAO.insertPostAttachment(attachmentDTO);
			System.out.println("파일 추가 완료");
		}
		
		result.setRedirect(true);
		
		return result;
	}
	
	
	int getTeamNumber(String teamName) {
		
		int teamNumber = 0;
		switch(teamName) {
		
		case "doosan":
			teamNumber = 1;
			break;
			
		case "lg":
			teamNumber = 2;
			break;
			
		case "hh":
			teamNumber = 3;
			break;
			
		case "samsung":
			teamNumber = 4;
			break;
			
		case "ssg":
			teamNumber = 5;
			break;
			
		case "kt":
			teamNumber = 6;
			break;
			
		case "nc":
			teamNumber = 7;
			break;
			
		case "lotte":
			teamNumber = 8;
			break;

		case "kia":
			teamNumber = 9;
			break;

		case "kiwoom":
			teamNumber = 10;
			break;
		}
		System.out.println("-----팀정보------");
		System.out.println("팀이름" + teamName);
		System.out.println("팀 번호" + teamNumber);
		System.out.println("---------------");
		
		return teamNumber;
	}
}
