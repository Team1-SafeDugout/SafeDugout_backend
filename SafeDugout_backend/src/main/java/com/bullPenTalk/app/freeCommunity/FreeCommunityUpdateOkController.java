package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;

public class FreeCommunityUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    Result result = new Result();
	    request.setCharacterEncoding("UTF-8");

	    int postNumber = Integer.parseInt(request.getParameter("postNumber"));
	    String postTitle = request.getParameter("postTitle");
	    String postContent = request.getParameter("postContent");

	    System.out.println("게시글 수정 요청 - postNumber : " + postNumber);
	    System.out.println("제목 : " + postTitle + ", 내용 : " + postContent);

	    FreePostDAO freePostdao = new FreePostDAO();

	    // 로그인 사용자 번호
	    Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");

	    // 게시글 작성자 번호 확인
	    int writerNumber = freePostdao.getWriterNumber(postNumber);

	    if (loginMemberNumber == null || loginMemberNumber != writerNumber) {
	        // 권한 없음 처리
	        System.out.println("수정 권한 없음 - 로그인한 사용자 : " + loginMemberNumber + ", 작성자 : " + writerNumber);
	        result.setPath("/freeCommunity/freeCommunityList.fc"); 
	        result.setRedirect(true);
	        return result;
	    }

	    // DTO 생성 및 데이터 담기
	    FreePostDTO freePostDTO = new FreePostDTO();
	    freePostDTO.setPostNumber(postNumber);
	    freePostDTO.setPostTitle(postTitle);
	    freePostDTO.setPostContent(postContent);

	    // DAO 호출
	    freePostdao.update(freePostDTO);

	    // 수정 후 상세보기 페이지로 이동
	    result.setPath("/freeCommunity/freeCommunitydetail.fc");
	    result.setRedirect(true);
	    return result;
	}

	

}
