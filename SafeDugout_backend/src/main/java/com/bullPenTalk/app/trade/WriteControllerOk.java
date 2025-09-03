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

        try {
            Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
            if (memberNumber == null) {
                System.out.println("오류 : 로그인된 사용자가 없습니다");
                response.sendRedirect("login.jsp");
                return null;
            }

            // ------------------------------
            // 1. 업로드 경로 설정
            // ------------------------------
            LocalDate today = LocalDate.now();
            String uploadBasePath = request.getSession().getServletContext().getRealPath("/upload/product/");
            String subPath = today.getYear() + "/" + String.format("%02d", today.getMonthValue()) + "/";
            String uploadPath = uploadBasePath + subPath;
            System.out.println(uploadPath);
            
            final int FILE_SIZE = 1024 * 1024 * 5; // 5MB
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // ------------------------------
            // 2. MultipartRequest 생성
            // ------------------------------
            MultipartRequest multipartRequest = new MultipartRequest(
                    request,
                    uploadPath,
                    FILE_SIZE,
                    "utf-8",
                    new DefaultFileRenamePolicy()
            );

            // ------------------------------
            // 3. 게시글 정보 세팅
            // ------------------------------
            String title = multipartRequest.getParameter("sellPostTitle");
            String content = multipartRequest.getParameter("sellPostContent");
            String priceStr = multipartRequest.getParameter("pricePoint");
            String dealTypeStr = multipartRequest.getParameter("dealTypeId");
            String categoryStr = multipartRequest.getParameter("categoryId");
            String teamIdStr = multipartRequest.getParameter("teamId");
            String tradingArea = multipartRequest.getParameter("tradingArea");

            sellPostDTO.setSellPostTitle(title);
            sellPostDTO.setSellPostContent(content);
            sellPostDTO.setMemberNumber(memberNumber);
            sellPostDTO.setPricePoint(Integer.parseInt(priceStr));
            sellPostDTO.setDealtypeId(Integer.parseInt(dealTypeStr));
            sellPostDTO.setCategoryId(Integer.parseInt(categoryStr));
            sellPostDTO.setTeamId(Integer.parseInt(teamIdStr));
            sellPostDTO.setTradingArea(tradingArea);
            sellPostDTO.setStatusId(1);

            int sellPostNumber = sellPostDAO.insertSellPost(sellPostDTO);

            // ------------------------------
            // 4. 첨부파일 처리
            // ------------------------------
            Enumeration<String> fileNames = multipartRequest.getFileNames();

            while (fileNames.hasMoreElements()) {
                String name = fileNames.nextElement();
                String fileSystemName = multipartRequest.getFilesystemName(name);
                String fileOriginalName = multipartRequest.getOriginalFileName(name);

                if (fileSystemName == null) continue;

                AttachmentDTO attachmentDTO = new AttachmentDTO();

                // DB에 저장할 경로 (JSP에서 바로 사용 가능)
                String dbPath = subPath + fileSystemName; 
                attachmentDTO.setAttachmentPath(dbPath);
                attachmentDTO.setAttachmentName(fileOriginalName);
                attachmentDTO.setAttachmentTypeId(1);
                attachmentDTO.setSellPostNumber(sellPostNumber);

                attachmentDAO.insertSellPostAttachment(attachmentDTO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        result.setPath("/trade/SellPostFrontController2.tr?category=allproduct&action=list");
        result.setRedirect(false);
        return result;
    }
}
