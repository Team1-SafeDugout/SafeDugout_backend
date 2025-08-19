package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

/**
 * Servlet implementation class MemberFrontController
 */

public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("현재 경로");
		Result result = new Result();
		
		switch(target) {
		case "/member/join.me" :
			request.getRequestDispatcher("/app/register/RegisterInput.jsp").forward(request, response);
			break;
			
		case "/member/joinOk.me" :
			result = new JoinOkController().execute(request, response);
			break;
			
		case "/member/login.me" : 
			request.getRequestDispatcher("/app/login/login.jsp").forward(request, response);
			break;
			
		case "/member/loginOk.me":
			System.out.println("loginOk접속");
			result = new LoginOkController().execute(request, response);
			System.out.println("loginOk접속완");
			break;
			
		case "member/logOut.me":
			break;
			
		case "member/sendSMS.me":
			break;
			
		case "/member/findId.me":
			break;
			
		case "/member/findPw.me":
			break;
			
		case "/member/verifyCode.me":
			break;
			
		case "/member/checkIdOk":
			break;
		}
		
		if (result != null && result.getPath() != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
	
}
