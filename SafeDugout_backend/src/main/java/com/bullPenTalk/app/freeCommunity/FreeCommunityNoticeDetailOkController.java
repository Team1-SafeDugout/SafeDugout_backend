package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.Attachment.dao.AttachmentDAO;
import com.bullPenTalk.app.dto.AttachmentDTO;
import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.app.freeCommunity.dao.GuidePostDAO;

public class FreeCommunityNoticeDetailOkController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Result result = new Result();
			
		// postNumber가 빈 문자열이거나 null인경우
				String noticepostNumberStr = request.getParameter("noticePostNumber");
				
				System.out.println("공지사항 번호" + noticepostNumberStr);
				if (noticepostNumberStr == null || noticepostNumberStr.trim().isEmpty()) {
					System.out.println("noticePostNumber 값이 없습니다");
					result.setPath("/freeCommunity/freeCommunityNoticeList.fc"); // 전체커뮤니티 입문 가이드 목록 페이지로 리다이렉트
					result.setRedirect(true);
					return result;
				}

				
				int noticePostNumber = Integer.parseInt(noticepostNumberStr);


				
				GuidePostDAO guidePostDAO = new GuidePostDAO();
				AttachmentDAO attachmentDAO = new AttachmentDAO();

				// DB에서 게시글 가져오기
				GuidePostDTO guidepostDTO = guidePostDAO.selectDetail(noticePostNumber);

//				 게시글이 존재하지 않을 경우 처리
				if(guidepostDTO == null) {
					System.out.println("존재하지 않는 게시글입니다. " + noticePostNumber);
					result.setPath("/app/freeCommunity/freeCommunityMain.jsp");
					result.setRedirect(true);
					return result;
				}

				 //첨부파일 가져오기
				List<AttachmentDTO> files = attachmentDAO.selectBySellPost(noticePostNumber);
				System.out.println("======파일 확인======");
				System.out.println(files);
				System.out.println("===================");
				
				//첨부파일 붙이기
				guidepostDTO.setAttachment(files);
//				
				//로그인한 사용자 번호 가져오기
				Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
				System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
//				
				//현재 게시글의 작성자 번호 가져오기
				int boardWriterNumber = guidepostDTO.getAdminNumber();	
				System.out.println("현재 게시글 작성자 번호 : " + boardWriterNumber);		

				request.setAttribute("noticePostDetail", guidepostDTO);
				result.setPath("/app/freeCommunity/freeCommunityGuideDetail.jsp");
				result.setRedirect(false);

				return result;

	}

}
