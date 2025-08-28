package com.bullPenTalk.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.app.dto.MainNoticePostDTO;
import com.bullPenTalk.app.main.dao.MainDAO;

/**
 * Servlet implementation class MainFrontController
 */
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("현재 경로 : " + target);
		Result result = new Result();
		
		//세션 저장 
		HttpSession session = request.getSession();
				
		//MainDAO 객체 생성
		MainDAO mainDAO = new MainDAO();
		
		//헤더에서 띄울 최신 공지 저장
		MainNoticePostDTO recentMainNotice = mainDAO.getRecent();
		if(recentMainNotice != null) {
			request.setAttribute("recentMainTitle", recentMainNotice.getNoticePostTitle());
		}else {
			request.setAttribute("recentMainTitle", "[메인공지]");
		}

		GuidePostDTO recentGuide = mainDAO.getRecentGuide();
		if(recentGuide != null) {
			request.setAttribute("recentGuideTitle", recentGuide.getNoticePostTitle());
		}else {
			request.setAttribute("recentGuideTitle", "[입문가이드]");
		}
		
		//팀 번호가 있을 경우 실행 
		if(request.getParameter("teamNumber") != null) {
			System.out.println("팀 번호 전송됨");
			session.setAttribute("teamNumber", request.getParameter("teamNumber"));
		}else {
			
		}
		
		switch (target) {
		case "/main.ma":
			System.out.println("메인 페이지 처리 요청");
			//로그인한 회원 회원번호 저장 
			int memberNumber = 0;
			if(session.getAttribute("memberNumber") != null) {
				memberNumber = (Integer)session.getAttribute("memberNumber");
				//로그인한 사용자 이름 저장 
				String memberName = mainDAO.selectLoginMember(memberNumber).getMemberName();
				System.out.println(memberName);
				request.getSession().setAttribute("memberName", memberName);
			}
			result = new MainOkController().execute(request, response); 
			System.out.println("메인페이지 처리 완료");
			break;
		case "/main/mainTeam.ma":
			System.out.println("팀 커뮤니티 메인페이지 처리 요청");
			System.out.println(result.getPath());
			System.out.println("팀 번호 : " + session.getAttribute("teamNumber"));
			result = new TeamMainOkController().execute(request, response);
			System.out.println("팀 커뮤니티 메인페이지 처리 완료");
			break;
		case "/main/mainAll.ma":
			System.out.println("전체 커뮤니티 메인 페이지 처리 요청");
			result = new MainAllOkController().execute(request, response); 
			break;
		case "/main/selectMainListOk.ma":
			System.out.println("메인 공지사항 목록 페이지 처리 요청");
			result = new SelectMainListOkController().execute(request, response); 
			break;
		case "/main/selectMainDetailOk.ma":
			System.out.println("메인 공지사항 상세 페이지 처리 요청");
			result = new SelectMainDetailOkController().execute(request, response);
			break;
		}
		
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
		
	}
	
	
}
