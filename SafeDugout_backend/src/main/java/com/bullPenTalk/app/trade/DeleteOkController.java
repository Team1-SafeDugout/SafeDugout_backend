package com.bullPenTalk.app.trade;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;

public class DeleteOkController {

    public void deleteSellPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SellPostDAO sellPostDAO = new SellPostDAO();
        AttachmentDAO attachmentDAO = new AttachmentDAO();

        try {
            int sellPostNumber = Integer.parseInt(request.getParameter("sellPostNumber"));

            // 권한 체크
            int sessionMember = (Integer) request.getSession().getAttribute("memberNumber");
            int postWriter = sellPostDAO.getWriter(sellPostNumber);

            if (sessionMember != postWriter) {
                response.sendRedirect(request.getContextPath() + "/trade/tradeMain.tr?status=noAuth");
                return;
            }

            // 첨부파일 삭제
            List<AttachmentDTO> attachments = attachmentDAO.selectBySellPost(sellPostNumber);
            for (AttachmentDTO attachment : attachments) {
                File file = new File(
                        request.getSession().getServletContext().getRealPath("/") + attachment.getAttachmentPath());
                if (file.exists() && !file.delete()) {
                    System.out.println("파일 삭제 실패: " + file.getAbsolutePath());
                }
            }

            // DB에서 판매글 삭제
            sellPostDAO.delete(sellPostNumber);
            System.out.println("판매글 삭제 완료: " + sellPostNumber);

            // 삭제 성공 → status 전달
            response.sendRedirect(request.getContextPath() + "/trade/tradeMain.tr?status=deleted");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/trade/tradeMain.tr?status=error");
        }
    }
}

