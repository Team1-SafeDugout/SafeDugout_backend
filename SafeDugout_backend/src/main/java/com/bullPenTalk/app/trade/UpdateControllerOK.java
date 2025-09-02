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

public class UpdateControllerOK {

    public Result updateOk(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SellPostDAO sellPostDAO = new SellPostDAO();
        AttachmentDAO attachmentDAO = new AttachmentDAO();
        Result result = new Result();
        SellPostDTO sellPostDTO = new SellPostDTO();

        // 1. 로그인 회원번호 확인
        Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
        if (memberNumber == null) {
            response.sendRedirect("login.jsp");
            return null;
        }

        // 2. 파일 업로드 경로 설정
        LocalDate today = LocalDate.now();
        final String UPLOAD_BASE_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
        String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
        String uploadPath = UPLOAD_BASE_PATH + subPath;
        final int FILE_SIZE = 1024 * 1024 * 5; // 5MB

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        // 3. MultipartRequest 객체 생성
        MultipartRequest multipartRequest = new MultipartRequest(
                request,
                uploadPath,
                FILE_SIZE,
                "UTF-8",
                new DefaultFileRenamePolicy()
        );

        // 4. 폼 데이터 가져오기
        int sellPostNumber = Integer.parseInt(multipartRequest.getParameter("sellPostNumber"));
        sellPostDTO.setSellPostNumber(sellPostNumber);
        sellPostDTO.setSellPostTitle(multipartRequest.getParameter("boardTitle"));
        sellPostDTO.setSellPostContent(multipartRequest.getParameter("boardContent"));
        sellPostDTO.setMemberNumber(memberNumber);

        // 5. 기존 첨부파일 삭제 (물리 + DB)
        for (AttachmentDTO file : attachmentDAO.selectBySellPost(sellPostNumber)) {
            File oldFile = new File(request.getSession().getServletContext().getRealPath("/") + file.getAttachmentPath());
            if (oldFile.exists()) oldFile.delete();
        }
        attachmentDAO.deleteBySellPost(sellPostNumber);

        // 6. 새 첨부파일 처리 (멀티 파일 지원)
        Enumeration<String> files = multipartRequest.getFileNames();
        while (files.hasMoreElements()) {
            String fieldName = files.nextElement();
            String originalFileName = multipartRequest.getOriginalFileName(fieldName);
            String savedFileName = multipartRequest.getFilesystemName(fieldName);

            if (originalFileName != null && savedFileName != null) {
                AttachmentDTO attachmentDTO = new AttachmentDTO();
                attachmentDTO.setAttachmentName(originalFileName);
                attachmentDTO.setAttachmentPath(subPath + savedFileName);
                attachmentDTO.setAttachmentTypeId(1); // 이미지 고정
                attachmentDTO.setSellPostNumber(sellPostNumber);

                attachmentDAO.insert(attachmentDTO);
            }
        }

        // 7. 게시글 업데이트
        sellPostDAO.update(sellPostDTO);

        // 8. 결과 페이지 설정
        result.setPath("/trade/SellPostFrontController2.tr?category=allproduct&action=list");
        result.setRedirect(true);
        return result;
    }
}
