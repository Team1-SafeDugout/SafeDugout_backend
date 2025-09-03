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

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            int sellPostNumber = Integer.parseInt(request.getParameter("sellPostNumber"));

            // 권한 체크
            int sessionMember = (Integer) request.getSession().getAttribute("memberNumber");
            int postWriter = sellPostDAO.getWriter(sellPostNumber); // DAO에서 작성자 조회
            if (sessionMember != postWriter) {
                out.println("<script>alert('권한이 없습니다.'); location.href='" 
                            + request.getContextPath() + "/trade/tradeMain.tr';</script>");
                return;
            }

            // 첨부파일 삭제
            List<AttachmentDTO> attachments = attachmentDAO.selectBySellPost(sellPostNumber);
            for (AttachmentDTO attachment : attachments) {
                File file = new File(request.getSession().getServletContext().getRealPath("/") + attachment.getAttachmentPath());
                if (file.exists() && !file.delete()) {
                    System.out.println("파일 삭제 실패: " + file.getAbsolutePath());
                }
            }

            // DB에서 판매글 삭제
            sellPostDAO.delete(sellPostNumber);
            System.out.println("판매글 삭제 완료: " + sellPostNumber);

            // alert 후 리다이렉트
            out.println("<script>alert('판매글이 삭제되었습니다.'); location.href='" 
                        + request.getContextPath() + "/trade/tradeMain.tr';</script>");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("<script>alert('잘못된 요청입니다.'); location.href='" 
                        + request.getContextPath() + "/trade/tradeMain.tr';</script>");
        } finally {
            out.flush();
            out.close();
        }
    }
}
