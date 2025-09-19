package com.bullPenTalk.app.member;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class LoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		int memberNumber = 0;
		Result result = new Result();
		String path = null;
		
		String memberId = request.getParameter("memberId"); //아이디 저장 처리할 때 재사용
		String memberPw = request.getParameter("memberPw");
		HttpSession session = request.getSession(); //++++++세션저장
		
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPw(memberPw);
		
		//쿼리문 실행 메소드 호출
		memberNumber = memberDAO.login(memberDTO);
		
		if(memberNumber != -1) {
			path = "/main.ma";
			// 비밀번호찾기, 아이디찾기, 회원가입 관련 페이지에서는 이전 경로저장하지 않도록 
			// 이전 페이지가 있다면 URI 저장
			String originPage = request.getParameter("originPage");
			if(!originPage.contains("/member/") && !originPage.contains("/findPw") && !originPage.contains("/findId")) {
				System.out.println(originPage);
				if(!originPage.equals("")) {
					try {
						// URI와 쿼리스트링 조합으로 변환
						URI originPageURI = new URI(originPage);
						String query = originPageURI.getQuery();
						originPage = originPageURI.getPath() + (query != null ? "?" + query : "");
						path = originPage;
						System.out.println(path);
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			session.setAttribute("memberNumber", memberNumber);
			session.setAttribute("memberId", memberId);
			System.out.println("세션값 : " + memberNumber);
			
//			if(remember != null) {
//				Cookie cookie = new Cookie("memberId", memberId);
//				cookie.setMaxAge(60 * 60 * 24); // 1일
//				response.addCookie(cookie);
//			}else {
//				//체크 해제시 쿠키 삭제
//				Cookie cookie = new Cookie("memberId", "");
//				cookie.setMaxAge(0);
//				cookie.setPath(cookiePath);
//				response.addCookie(cookie);
//			}
			
			
		}else {
			path = "/member/login.me?login=fail";
		}
		
		result.setRedirect(false); //세션에 저장된 값은 유지
		result.setPath(path);
		return result;
	}
	
}
