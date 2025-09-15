package com.bullPenTalk.app.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

/**
 * Servlet implementation class MyPageFrontController
 */
@WebServlet("/MyPageFrontController")
public class MyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageFrontController() {
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
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("현재 경로" + target);
		Result result = new Result();
		
		switch(target) {
		// 리스트 불러오기
		case "/myPage/postList.mp":
			System.out.println("게시글 목록 진입 중");
			result = new MyPagePostListOkController().execute(request, response);
			break;
			
		case "/myPage/deletePost.mp":
			System.out.println("게시글 삭제 중");
			result = new MyPageDeletePostOkController().execute(request, response);
			break;
			
		case "/myPage/commentList.mp":
			System.out.println("댓글 목록 진입 중");
			result = new MyPageCommentListOkController().execute(request, response);
			break;
			
		case "/myPage/deleteComment.mp":
			System.out.println("댓글 삭제 중");
			result = new MyPageDeleteCommentOkController().execute(request, response);
			break;
		
		case "/myPage/tradeList.mp":
			System.out.println("거래 중 목록 진입 중");
			result = new MyPageTradeListOkController().execute(request, response);
			break;
		
		case "/myPage/sellList.mp":
			System.out.println("판매 중 목록 진입 중");
			result = new MyPageSellListOkController().execute(request, response);
			break;
			
		case "/myPage/deleteSell.mp":
			System.out.println("판매 목록 제거 진입 중");
			result = new MyPageDeleteSellOkController().execute(request, response);
			break;
			
		// 메뉴 오픈
		case "/myPage/changeInfo.mp":
			System.out.println("정보 수정 진입 중");
			result = new MyPageChangeInfoController().execute(request, response);
			break;
			
		case "/myPage/unSubscribe.mp":
			System.out.println("회원 탈퇴 진입 중");
			result = new MyPageUnSubcribeController().execute(request, response);
			break;
			
		case "/myPage/pointCharge.mp":
			System.out.println("충전 목록 진입 중");
			result = new MyPagePoinChargeListOkController().execute(request, response);
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
