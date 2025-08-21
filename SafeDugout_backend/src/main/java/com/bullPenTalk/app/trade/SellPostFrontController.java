package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

/**
 * Servlet implementation class SellPostForntContorller
 */
public class SellPostFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellPostFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("SellPostFrontController 현재 경로 : " + target);
		Result result = new Result();

		switch (target) {
		case "/trade/tradeMainOk.tr":
			System.out.println("중고거래 메인페이지 요청");
			result = new TradeMainOkController().execute(request, response);
			break;
		case "/trade/tradeSerachResult.tr":
			System.out.println("중고거래 검색 요청");
//			result = new BoardListOkController().execute(request, response);
			break;
		case "/trade/tradeSearchResultOk.tr":
			System.out.println("중고거래 검색 페이지 처리 요청");
			break;
		case "/trade/tradeSearchResultNoResultOk.":
			System.out.println("중고거래 검색 없음 페이지 처리 요청");
			break;
		case "/trade/productDetailOk.tr":
			System.out.println("중고거래 상세페이지 처리 요청");
			break;
		case "/trade/productRegister.tr":
			System.out.println("중고거래 상품등록 페이지 요청");
			break;
		case "/trade/productRegisterResultOk.tr":
			System.out.println("중고거래 상품등록 완료 요청");
			break;
		case "/trade/productBuy.tr":
			System.out.println("상품 구매 요청");
			break;
		case "/trade/productBuyResultOk.tr":
			System.out.println("상품 구매 완료 요청");
			break;
		case "/trade/pointBuy.tr":
			System.out.println("포인트 결제 요청");
			break;
		case "/trade/pointResultOK.tr":
			System.out.println("포인트 결제 완료 요청");
			break;
		}

		if (result != null) {
			System.out.println("Forward path = " + result.getPath());
			System.out.println("Real path = " + request.getServletContext().getRealPath(result.getPath()));

			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}
