package com.bullPenTalk.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

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
		
		switch (target) {
		case "/main.ma":
			System.out.println("메인 페이지 처리 요청");
			result = new MainOkController().execute(request, response); 
			break;
		case "/main/mainTeam.ma":
			System.out.println("팀 커뮤니티 메인 페이지 처리 요청");
			result = new MainTeamOkController().execute(request, response); 
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
