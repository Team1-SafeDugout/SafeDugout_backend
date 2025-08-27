package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.AdminDAO;
import com.bullPenTalk.app.dto.AdminDTO;

public class AdminLoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDTO adminDTO = new AdminDTO();
		AdminDAO adminDAO = new AdminDAO();
		int adminNumber = 0;
		Result result = new Result();
		String path = null;
		String adminId = request.getParameter("adminId"); //아이디 저장 처리할 때 재사용
		String adminPw = request.getParameter("adminPw");
		HttpSession session = request.getSession(); //++++++세션저장
		
		adminDTO.setAdminId(adminId);
		adminDTO.setAdmidPw(adminPw);
		
		//쿼리문 실행 메소드 호출
		adminNumber = adminDAO.login(adminDTO);
		
		if(adminNumber != -1) {
			path = "/admin/adminMainNoticeListOk.ad";
			session.setAttribute("adminNumber", adminNumber);
			session.setAttribute("adminInfo", adminDAO.takeInfo(adminNumber));
			System.out.println("세션값 : " + adminNumber);
			System.out.println("현재 어드민 : " + adminDAO.takeInfo(adminNumber));
			
//			if(remember != null) {
//				Cookie cookie = new Cookie("memberId", memberId);
//				cookie.setMaxAge(60 * 60 * 24); // 1일
//				response.addCookie(cookie);
//			}else {
//				//체크 해제시 쿠키 삭제
//				Cookie cookie = new Cookie("memberId", "");
//				cookie.setMaxAge(0);
////				cookie.setPath(cookiePath);
//				response.addCookie(cookie);
//			}
			
		}else {
			path = "/admin/adminLogin.ad?login=fail";
		}
		
		result.setRedirect(true); //세션에 저장된 값은 유지
		result.setPath(path);
		return result;
	}
	
}
