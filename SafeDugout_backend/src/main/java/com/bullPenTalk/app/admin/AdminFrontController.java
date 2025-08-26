package com.bullPenTalk.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

/**
 * Servlet implementation class AdminFrontController
 */

public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFrontController() {
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
		System.out.println("현재 경로" + target);
		Result result = new Result();
		
		switch(target) {
		case "/admin/adminLogin.ad":
			request.getRequestDispatcher("/app/admin/login/adminLogin.jsp").forward(request, response);
			break;
		case "/admin/adminLoginOk.ad":
			System.out.println("로그인 진입");
			result = new AdminLoginOkController().execute(request, response);
			break;
			
		case "/admin/adminMainNoticeListOk.ad":
			System.out.println("메인공지목록");
			result = new AdminMainNoticeListOkController().execute(request, response);
			break;
			
		case "/admin/adminManageFreeCommunityListOk.ad":
			System.out.println("입문 가이드");
			result = new AdminGuideListOkController().execute(request, response);
			break;
			
		case "/admin/adminSiteStatisticsOk.ad":
			System.out.println("통계");
			result = new AdminSiteStatisticsOkController().execute(request, response);
			break;
			
		case "/admin/adminManageTeamNewsListOk.ad":
			System.out.println("팀 뉴스");
			result = new AdminTeamNewsListOkController().execute(request, response);
			break;
			
		case "/admin/adminManageTeamYoutubeListOk.ad" :
			System.out.println("팀 유튜브");
			result = new AdminTeamYoutubeListOkController().execute(request, response);
			break;
			
		case "/admin/adminManageTeamSongListOk.ad":
			System.out.println("팀 응원가");
			result = new AdminTeamSongListOkController().execute(request, response);
			break;
			
		case "/admin/adminManageSellListOk.ad":
			System.out.println("판매 목록");
			result = new AdminSellPostListOkController().execute(request, response);
			break;
			
		case "/admin/adminManageTradingListOk.ad" :
			System.out.println("거래 목록");
			result = new AdminTradePostListOkController().execute(request, response);
			break;
			
		case "/admin/adminManageMemberListOk.ad" :
			System.out.println("유저 목록");
			result = new MemberListOkController().execute(request, response);
			break;
			
		case "/admin/adminLogout.ad":
			result = new AdminLogoutController().execute(request, response);
			break;
			
		case "/admin/adminReadMainNoticeOk.ad":
			System.out.println("읽는중");
			result = new AdminReadMainNoticeOkController().execute(request, response);
			break;
			
		case "/admin/adminReadPostOk.ad":
			System.out.println("포스트 읽는중");
			result = new AdminReadPostOkController().execute(request, response);
			break;
			
		case "/admin/adminCreateMainNoticeOk.ad":
			System.out.println("글생성");
			result = new AdminCreateMainNoticeOkController().execute(request, response);
			break;
			
		case "/admin/adminCreateNotice.ad":
			result = new AdminCreateNotice().execute(request, response);
			break;
			
		case "/admin/adminDeleteNoticeOk.ad":
			System.out.println("삭제 진입");
			result = new AdminDeleteNoticeOkController().execute(request, response);
			break;
			
		case "/admin/adminCreatePost.ad" :
			System.out.println("생성창");
			result = new AdminCreatePostController().execute(request, response);
			break;
			
		case "/admin/adminCreatePostOk.ad" :
			System.out.println("포스트 생성");
			result = new AdminCreatePostOkController().execute(request, response);
			break;
			
		case "/admin/adminDeletePostOk.ad":
			System.out.println("포스트 제거");
			result = new AdminDeletePostOkController().execute(request, response);
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
