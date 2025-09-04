package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;


public class FreeCommunityFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeCommunityFrontController() {
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
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("현재 경로: " + target);
		Result result = new Result();
		
		switch(target) {
		case "/freeCommunity/freeCommunityList.fc":
			System.out.println("전체 커뮤니티 게시글 목록 요청");
			result = new FreeCommunityListController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityListOk.fc" : 
			System.out.println("전체 커뮤니티 게시글 목록 완료");
			result = new FreeCommunityListOkController().execute(request, response);
			break;	
			
		case "/freeCommunity/freeCommunityDetail.fc" :
			System.out.println("전체 커뮤니티 게시글 상세페이지 요청");
			result = new FreeCommunityDetailController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityDetailOk.fc":
			System.out.println("전체 커뮤니티 게시글 상세페이지 완료");
			result = new FreeCommunityDetailOkController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityUpdate.fc":
			System.out.println("전체 커뮤니티 게시글 업데이트 요청");
			result = new FreeCommunityUpdateController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityUpdateOk.fc":
			System.out.println("전체 커뮤니티 게시글 업테이트 완료");
			result = new FreeCommunityUpdateOkController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityDelete.fc":
			System.out.println("전체 커뮤니티 게시글 삭제 요청");
			result = new FreeCommunityDeleteOkController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityWrite.fc" :
			System.out.println("전체 커뮤니티 게시글 작성 요청");
			result = new FreeCommunityWriteController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityWriteOk.fc":	
			System.out.println("전체 커뮤니티 게시글 작성 완료 요청");
			result = new FreeCommunityWritingOkController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityNoticeList.fc" :
			System.out.println("입문가이드 목록 요청");
			result = new FreeCommunityNoitceListController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityNoticeListOk.fc":
			System.out.println("입문가이드 목록 완료 요청");
			result = new FreeCommunityNoticeListOkController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityNoticeDetail.fc":
			System.out.println("입문가이드 상세페이지 요청");
			result = new FreeCommunityNoticeDetailController().execute(request, response);
			break;
			
		case "/freeCommunity/freeCommunityNoticeDetailOk.fc":
			System.out.println("입문가이드 상세페이지 완료");
			result = new FreeCommunityNoticeDetailOkController().execute(request, response);
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
