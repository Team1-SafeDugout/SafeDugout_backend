package com.bullPenTalk.app.teamCommunity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.TeamPostDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateOkController {

	public Result updateOk(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Result result = new Result();
        TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
        AttachmentDAO attachmentDAO = new AttachmentDAO();

        // ------------------------------
        // 1. 로그인 체크
        // ------------------------------
        Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
        if (memberNumber == null) {
            System.out.println("오류 : 로그인된 사용자가 없습니다");
            result.setPath("/member/login.me");
            result.setRedirect(true);
            return result;
        }

        // ------------------------------
        // 2. 업로드 경로 설정
        // ------------------------------
        LocalDate today = LocalDate.now();
        String uploadBasePath = request.getSession().getServletContext().getRealPath("/upload/teamCommunity/");
        String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
        String uploadPath = uploadBasePath + subPath;

        final int FILE_SIZE = 1024 * 1024 * 5; // 5MB
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        // ------------------------------
        // 3. MultipartRequest 생성
        // ------------------------------
        MultipartRequest multipartRequest = new MultipartRequest(
                request,
                uploadPath,
                FILE_SIZE,
                "utf-8",
                new DefaultFileRenamePolicy()
        );

        // ------------------------------
        // 4. 게시글 정보 세팅
        // ------------------------------
        String postTitle = multipartRequest.getParameter("postTitle");
        String postContent = multipartRequest.getParameter("postContent");
        String postNumberStr = multipartRequest.getParameter("postNumber");

        if (postNumberStr == null || postNumberStr.isEmpty()) {
            System.out.println("오류: 게시글 번호가 넘어오지 않았습니다.");
            result.setPath("/community/TeamCommunityFrontController.tc?category=board&action=postList");
            result.setRedirect(true);
            return result;
        }

        int postNumber = Integer.parseInt(postNumberStr);

        // 작성자 확인
        int writerNumber = teamCommunityDAO.getWriterNumber(postNumber);
        if (writerNumber != memberNumber) {
            System.out.println("오류: 수정 권한 없음 - 로그인:" + memberNumber + ", 작성자:" + writerNumber);
            result.setPath("/community/TeamCommunityFrontController.tc?category=board&action=postList");
            result.setRedirect(true);
            return result;
        }

        TeamPostDTO teamPostDTO = new TeamPostDTO();
        teamPostDTO.setPostNumber(postNumber);
        teamPostDTO.setPostTitle(postTitle);
        teamPostDTO.setPostContent(postContent);

        // ------------------------------
        // 5. 게시글 업데이트
        // ------------------------------
        teamCommunityDAO.update(teamPostDTO);

        // ------------------------------
        // 6. 첨부파일 처리
        // ------------------------------
        Enumeration<String> fileNames = multipartRequest.getFileNames();

        while (fileNames.hasMoreElements()) {
            String name = fileNames.nextElement();
            String fileSystemName = multipartRequest.getFilesystemName(name);
            String fileOriginalName = multipartRequest.getOriginalFileName(name);

            if (fileSystemName == null) continue;

            AttachmentDTO attachmentDTO = new AttachmentDTO();
            String dbPath = subPath + fileSystemName;

            attachmentDTO.setAttachmentPath(dbPath);
            attachmentDTO.setAttachmentName(fileOriginalName);
            attachmentDTO.setAttachmentTypeId(2); 
            attachmentDTO.setPostNumber(postNumber);

            attachmentDAO.insert(attachmentDTO);
        }

        // ------------------------------
        // 7. 수정 완료 후 상세보기 페이지 이동
        // ------------------------------
        result.setPath("/community/TeamCommunityFrontController.tc?category=board&action=postList");
        result.setRedirect(true);
        return result;
    }
		

	
}
