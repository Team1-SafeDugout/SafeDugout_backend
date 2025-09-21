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
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;

public class FreeCommunityDetailOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Result result = new Result();
			
		// postNumber가 빈 문자열이거나 null인경우
				String postNumberStr = request.getParameter("postNumber");
				if (postNumberStr == null || postNumberStr.trim().isEmpty()) {
					System.out.println("postNumber 값이 없습니다");
					result.setPath("/app/freeCommunity/freeCommunityList.fc"); // 전체커뮤니티 목록 페이지로 리다이렉트
					result.setRedirect(true);
					return result;
				}

				
				int postNumber = Integer.parseInt(postNumberStr);


				
				FreePostDAO freePostDAO = new FreePostDAO();
				AttachmentDAO attachmentDAO = new AttachmentDAO();

				// DB에서 게시글 가져오기
				FreePostDTO freepostDTO = freePostDAO.selectDetail(postNumber);

//				 게시글이 존재하지 않을 경우 처리
				if(freepostDTO == null) {
					System.out.println("존재하지 않는 게시글입니다. " + postNumber);
					result.setPath("/app/freeCommunity/freeCommunityMain.jsp");
					result.setRedirect(true);
					return result;
				}

				 //첨부파일 가져오기
				List<AttachmentDTO> files = attachmentDAO.selectByPost(postNumber);
				System.out.println("======파일 확인======");
				System.out.println(files);
				System.out.println("===================");
				
				//첨부파일 붙이기
				freepostDTO.setAttachment(files);
//				
				//로그인한 사용자 번호 가져오기
				Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
				System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
//				
				//현재 게시글의 작성자 번호 가져오기
				int boardWriterNumber = freepostDTO.getMemberNumber();	
				System.out.println("현재 게시글 작성자 번호 : " + boardWriterNumber);		

				request.setAttribute("freePostDetail", freepostDTO);
				result.setPath("/app/freeCommunity/freeCommunityDetail.jsp");
				result.setRedirect(false);

				return result;

	}

}
