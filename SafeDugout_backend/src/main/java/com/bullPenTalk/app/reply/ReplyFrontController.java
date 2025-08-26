package com.bullPenTalk.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.main.MainAllOkController;
import com.bullPenTalk.app.main.MainOkController;
import com.bullPenTalk.app.main.SelectMainDetailOkController;
import com.bullPenTalk.app.main.SelectMainListOkController;
import com.bullPenTalk.app.main.TeamMainOkController;
import com.bullPenTalk.app.main.dao.MainDAO;

/**
 * Servlet implementation class ReplyFrontController
 */

public class ReplyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyFrontController() {
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
		case "/reply/replyWriteOk.re":
			System.out.println("댓글 작성 컨트롤러 진입");
			result = new ReplyWriteOkController().execute(request, response);
			break;

		case "/reply/replyListOk.re":
			System.out.println("댓글 목록 컨트롤러 진입");
			result = new ReplyListOkController().execute(request, response);
			break;
		case "/reply/replyDeleteOk.re":
		    System.out.println("댓글 삭제 컨트롤러 진입");
		    result = new ReplyDeleteOkController().execute(request, response);
		    break;

		case "/reply/replyUpdateOk.re":
		    System.out.println("댓글 수정 컨트롤러 진입");
		    result = new ReplyUpdateOkController().execute(request, response);
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
