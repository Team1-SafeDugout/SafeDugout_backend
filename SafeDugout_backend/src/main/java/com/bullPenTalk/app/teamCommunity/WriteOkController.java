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

public class WriteOkController {

    public Result writePost(HttpServletRequest request, HttpServletResponse response) {
        TeamCommunityDAO teamCommunityDAO = new TeamCommunityDAO();
        TeamPostDTO postDTO = new TeamPostDTO();
        Result result = new Result();
        AttachmentDAO attachmentDAO = new AttachmentDAO();

        System.out.println("Write 컨트롤러 진입");

        try {
            // 로그인 한 회원 정보 가져오기
            Integer sessionMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
            if (sessionMemberNumber == null) {
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

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
                System.out.println("업로드 폴더 생성 완료: " + uploadPath);
            }

            // MultipartRequest로 데이터 파싱
            MultipartRequest multipartRequest = new MultipartRequest(
                    request, uploadPath, FILE_SIZE, "utf-8", new DefaultFileRenamePolicy()
            );

            // 필수 파라미터 확인 및 안전하게 int 변환
            String memberNumberStr = multipartRequest.getParameter("memberNumber");
            String teamNumberStr = multipartRequest.getParameter("teamNumber");
            String postTypeStr = multipartRequest.getParameter("postType");

            if (memberNumberStr == null || teamNumberStr == null || postTypeStr == null) {
                System.out.println("오류: memberNumber 또는 teamNumber 또는 postType 전달 안됨");
                return null;
            }

            int memberNumber = sessionMemberNumber;
            int teamNumber = Integer.parseInt(teamNumberStr);
            int postType = Integer.parseInt(postTypeStr);

            // 게시글 DTO 설정
            postDTO.setMemberNumber(memberNumber);
            postDTO.setTeamNumber(teamNumber);
            postDTO.setPostType(postType);
            postDTO.setPostTitle(multipartRequest.getParameter("postTitle"));
            postDTO.setPostContent(multipartRequest.getParameter("postContent"));

            System.out.println("게시글 추가 - PostDTO : " + postDTO);

            // 게시글 추가
            int postNumber = teamCommunityDAO.insertPost(postDTO);
            System.out.println("생성된 게시글 번호 : " + postNumber);

            // 파일 업로드 처리
            Enumeration<String> fileNames = multipartRequest.getFileNames();
            while (fileNames.hasMoreElements()) {
                String name = fileNames.nextElement();
                String fileSystemName = multipartRequest.getFilesystemName(name);
                String fileOriginalName = multipartRequest.getOriginalFileName(name);

                if (fileSystemName == null) continue; // 업로드 안된 필드 무시

                AttachmentDTO attachmentDTO = new AttachmentDTO();
                attachmentDTO.setAttachmentPath(subPath + fileSystemName);
                attachmentDTO.setAttachmentName(fileOriginalName);
                attachmentDTO.setAttachmentTypeId(1); // 이미지
                attachmentDTO.setPostNumber(postNumber); // 게시글 번호 연결
                attachmentDAO.insertPostAttachment(attachmentDTO);

                int attachmentNumber = attachmentDTO.getAttachmentNumber();
                System.out.println("생성된 첨부파일 번호 : " + attachmentNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        result.setPath("/community/TeamCommunityFrontController.tc?category=board&action=postList");
        result.setRedirect(false);
        System.out.println("리턴진입");
        return result;
    }
}
