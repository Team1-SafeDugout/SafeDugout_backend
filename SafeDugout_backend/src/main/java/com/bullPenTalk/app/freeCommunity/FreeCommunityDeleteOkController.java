package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;

public class FreeCommunityDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    Result result = new Result();

	    int postNumber = Integer.parseInt(request.getParameter("postNumber"));
	    System.out.println("게시글 삭제 요청 - postNumber : " + postNumber);

	    FreePostDAO dao = new FreePostDAO();

	    // 1. 현재 로그인 사용자 번호 가져오기
	    Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
	    if (loginMemberNumber == null) {
	        // 로그인 안 된 경우 로그인 페이지로 리다이렉트
	        result.setPath("/member/login.me");
	        result.setRedirect(true);
	        return result;
	    }

	    // 2. 게시글 작성자 번호 확인
	    int writerNumber = dao.getWriterNumber(postNumber); // DAO에 작성자 번호 조회 쿼리 추가 필요
	    if (writerNumber != loginMemberNumber) {
	        System.out.println("삭제 권한 없음! 로그인 사용자: " + loginMemberNumber + ", 작성자: " + writerNumber);
	        result.setPath("/error/unauthorized.jsp"); // 권한 없음 페이지
	        result.setRedirect(false);
	        return result;
	    }

	    // 3. 작성자가 맞으면 삭제 실행
	    dao.delete(postNumber);
	    System.out.println("게시글 삭제 완료!");

	    // 삭제 후 목록 페이지로 이동
	    result.setPath("/freeCommunity/freeCommunityList.fc");  
	    result.setRedirect(true);
	    return result;
	}


}
