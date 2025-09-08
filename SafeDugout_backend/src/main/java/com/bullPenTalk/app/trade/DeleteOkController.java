package com.bullPenTalk.app.trade;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.sellPost.dao.SellPostDAO;
import com.bullPenTalk.app.teamCommunity.dao.TeamCommunityDAO;

public class DeleteOkController {

	public Result deleteSellPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		SellPostDAO sellPostDAO = new SellPostDAO();
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		Result result = new Result();

		try {
			int postNumber = Integer.parseInt(request.getParameter("sellPostNumber"));

			// 첨부파일 조회 (서버 파일 삭제용)
			List<AttachmentDTO> attachments = attachmentDAO.selectByPost(postNumber);
			for (AttachmentDTO attachment : attachments) {
				File file = new File(
						request.getSession().getServletContext().getRealPath("/") + attachment.getAttachmentPath());
				if (file.exists()) {
					file.delete();
					System.out.println("파일 삭제: " + file.getAbsolutePath());
				}
			}

			// 판매글 삭제 (DB에서 첨부파일, 매핑 자동 삭제)
			sellPostDAO.delete(postNumber);
			System.out.println("판매글 삭제 완료: " + postNumber);

			result.setPath("/trade/SellPostFrontController2.tr?category=allporduct&action=list");
			result.setRedirect(true);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

		return result;
	}

}
