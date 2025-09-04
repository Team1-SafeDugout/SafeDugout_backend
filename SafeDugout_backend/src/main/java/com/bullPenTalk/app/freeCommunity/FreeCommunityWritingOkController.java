package com.bullPenTalk.app.freeCommunity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FreeCommunityWritingOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Result result = new Result();
        FreePostDAO freePostDAO = new FreePostDAO();
        AttachmentDAO attachmentDAO = new AttachmentDAO();

        // ------------------------------
        // 1. 로그인 체크
        // ------------------------------
        Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
        if (memberNumber == null) {
            System.out.println("오류 : 로그인된 사용자가 없습니다");
            result.setPath("/member/login.me");  // 로그인 페이지로 이동
            result.setRedirect(true);
            return result;
        }

        // ------------------------------
        // 2. 업로드 경로 설정
        // ------------------------------
        LocalDate today = LocalDate.now();
        String uploadBasePath = request.getSession().getServletContext().getRealPath("/upload/freeCommunity/");
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

        FreePostDTO freePostDTO = new FreePostDTO();
        freePostDTO.setPostTitle(postTitle);
        freePostDTO.setPostContent(postContent);
        freePostDTO.setMemberNumber(memberNumber);
        

        // 게시글 저장
        int postNumber = freePostDAO.insert(freePostDTO);

        // ------------------------------
        // 5. 첨부파일 처리
        // ------------------------------
        Enumeration<String> fileNames = multipartRequest.getFileNames();

        while (fileNames.hasMoreElements()) {
            String name = fileNames.nextElement();
            String fileSystemName = multipartRequest.getFilesystemName(name);
            String fileOriginalName = multipartRequest.getOriginalFileName(name);

            if (fileSystemName == null) continue;

            AttachmentDTO attachmentDTO = new AttachmentDTO();
            String dbPath = subPath + fileSystemName; // DB에 저장할 경로

            attachmentDTO.setAttachmentPath(dbPath);
            attachmentDTO.setAttachmentName(fileOriginalName);
            attachmentDTO.setAttachmentTypeId(2); // 자유게시판 = 2 라고 구분 가능
            attachmentDTO.setPostNumber(postNumber);

            attachmentDAO.insert(attachmentDTO);
        }

        // ------------------------------
        // 6. 완료 후 목록으로 리다이렉트
        // ------------------------------
        result.setPath("/freeCommunity/freeCommunityList.fc");
        result.setRedirect(true);
        return result;
    }
}
