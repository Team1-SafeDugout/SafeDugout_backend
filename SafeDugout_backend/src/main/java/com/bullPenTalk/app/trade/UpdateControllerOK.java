package com.bullPenTalk.app.trade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.Attachment.dao.SellPostAttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.SellPostAttachmentDTO;
import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class UpdateControllerOK {

	public Result updateOk(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SellPostDAO sellPostDAO = new SellPostDAO();
        SellPostDTO sellPostDTO = new SellPostDTO();
        AttachmentDAO attachmentDAO = new AttachmentDAO();
        SellPostAttachmentDAO sellPostAttachment = new SellPostAttachmentDAO();
        Result result = new Result();

        LocalDate today = LocalDate.now();
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
		String uploadPath = UPLOAD_PATH + subPath;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB

        // MultipartParser 실행
        MultipartParser parser = new MultipartParser(request, FILE_SIZE);
        parser.setEncoding("utf-8");
        System.out.println("MultipartParser 초기화 완료");

        int sellPostNumber = 0;
        boolean isFileUpload = false;

        // 파일, 텍스트 데이터 처리
        Part part;
        while ((part = parser.readNextPart()) != null) {
            System.out.println("Part: " + part.getClass().getSimpleName());

            if (part.isParam()) {
                // 텍스트 파라미터 처리
                ParamPart paramPart = (ParamPart) part;
                String paramName = paramPart.getName();
                String paramValue = paramPart.getStringValue();

                System.out.println("파라미터: " + paramName + " = " + paramValue);

                if ("sellPostNumber".equals(paramName)) {
                	sellPostNumber = Integer.parseInt(paramValue);
                    sellPostDTO.setSellPostNumber(sellPostNumber);
                } else if ("boardTitle".equals(paramName)) {
                	sellPostDTO.setSellPostTitle(paramValue);
                } else if ("boardContent".equals(paramName)) {
                	sellPostDTO.setSellPostContent(paramValue);
                }
            } else if (part.isFile() && !isFileUpload) {
                FilePart filePart = (FilePart) part;
                filePart.setRenamePolicy(new DefaultFileRenamePolicy());
                String fileOriginalName = filePart.getFileName();
                
                // 기존 파일 삭제
                if (sellPostNumber != 0) {
                    List<AttachmentDTO> existingFiles = attachmentDAO.select(sellPostNumber);
                    for (AttachmentDTO file : existingFiles) {
                    	File oldFile = new File(request.getSession().getServletContext().getRealPath("/") + file.getAttachmentPath());
                        if (oldFile.exists()) {
                            System.out.println("기존 파일 삭제: " + oldFile.getAbsolutePath());
                            oldFile.delete();
                        }
                    }
                    attachmentDAO.delete(sellPostNumber);
                    System.out.println("기존 파일 DB 삭제 완료");
                }

                if (fileOriginalName != null) {
                    String newFileName = System.currentTimeMillis() + "_" + fileOriginalName;
                    File newFile = new File(uploadPath, newFileName);
                    filePart.writeTo(newFile);

                    if (newFile.exists()) {
                        System.out.println("새로운 파일 저장 완료: " + newFile.getAbsolutePath());
                    } else {
                        System.out.println("새로운 파일 저장 실패: " + newFile.getAbsolutePath());
                    }

                    // DB 저장
                    AttachmentDTO attachmentDTO = new AttachmentDTO();
                    attachmentDTO.setAttachmentPath(subPath + newFileName);
                    attachmentDTO.setAttachmentName(fileOriginalName); // 원본 파일명
                    attachmentDTO.setAttachmentTypeId(1);
                    attachmentDAO.insert(attachmentDTO);
                    int attachmentNumber = attachmentDTO.getAttachmentNumber(); 
                    System.out.println("새로운 파일 DB 저장 완료: " + attachmentDTO);

                    // 매핑 테이블에 insert
                    SellPostAttachmentDTO sellPostAttachmentDTO = new SellPostAttachmentDTO();
                    sellPostAttachmentDTO.setSellPostNumber(sellPostNumber);
                    sellPostAttachmentDTO.setAttachmentNumber(attachmentDTO.getAttachmentNumber());
                    sellPostAttachment.insert(sellPostAttachmentDTO);
    				
                    
                    isFileUpload = true; // 파일이 업로드되었음을 표시
                } else {
                    System.out.println("업로드된 파일이 없습니다 (파일 선택하지 않음)");
                }
            }
        }

        // 게시글 업데이트 실행
        sellPostDTO.setMemberNumber((Integer) request.getSession().getAttribute("memberNumber"));
        sellPostDAO.update(sellPostDTO);
        System.out.println("게시글 수정 완료");

        //수정 완료 후 리스트 페이지로 이동
        result.setPath("/board/boardListOk.bo");
        result.setRedirect(true);
        return result;
		

	}
}
