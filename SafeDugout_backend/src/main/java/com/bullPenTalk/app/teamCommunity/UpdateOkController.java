package com.bullPenTalk.app.teamCommunity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.Attachment.dao.PostAttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.PostAttachmentDTO;
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class UpdateOkController {

	public Result updateOk(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
        PostDTO postDTO = new PostDTO();
        AttachmentDAO attachmentDAO = new AttachmentDAO();
        PostAttachmentDAO postAttachmentDAO = new PostAttachmentDAO();
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

        int postNumber = 0;
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
                	postNumber = Integer.parseInt(paramValue);
                	postDTO.setPostNumber(postNumber);
                } else if ("boardTitle".equals(paramName)) {
                	postDTO.setPostTitle(paramValue);
                } else if ("boardContent".equals(paramName)) {
                	postDTO.setPostContent(paramValue);
                }
            } else if (part.isFile() && !isFileUpload) {
                FilePart filePart = (FilePart) part;
                filePart.setRenamePolicy(new DefaultFileRenamePolicy());
                String fileOriginalName = filePart.getFileName();
                
                // 기존 파일 삭제
                if (postNumber != 0) {
                    List<AttachmentDTO> existingFiles = attachmentDAO.select(postNumber);
                    for (AttachmentDTO file : existingFiles) {
                    	File oldFile = new File(request.getSession().getServletContext().getRealPath("/") + file.getAttachmentPath());
                        if (oldFile.exists()) {
                            System.out.println("기존 파일 삭제: " + oldFile.getAbsolutePath());
                            oldFile.delete();
                        }
                    }
                    attachmentDAO.delete(postNumber);
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
                    PostAttachmentDTO postAttachmentDTO = new PostAttachmentDTO();
                    postAttachmentDTO.setPostNumber(postNumber);
                    postAttachmentDTO.setAttachmentNumber(attachmentDTO.getAttachmentNumber());
                    postAttachmentDAO.insert(postAttachmentDTO);
    				
                    
                    isFileUpload = true; // 파일이 업로드되었음을 표시
                } else {
                    System.out.println("업로드된 파일이 없습니다 (파일 선택하지 않음)");
                }
            }
        }

        // 게시글 업데이트 실행
        postDTO.setMemberNumber((Integer) request.getSession().getAttribute("memberNumber"));
        teamCommunityDAO.update(postDTO);
        System.out.println("게시글 수정 완료");

        //수정 완료 후 리스트 페이지로 이동
        result.setPath("/communityHtml/communityTapPage/teamBoard.jsp");
        result.setRedirect(true);
        return result;
		

	}
}
