package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Samsung implements TradeService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("삼성진입");
		// Result 객체 생성
		Result result = new Result();

		// 조회 객체 생성
		SelectController select = new SelectController();

		try {
			switch (action) {
			case "list":
				result = select.listTeam(action, request, response);
				break;
			case "detail":
				DetailControllerOK detailController = new DetailControllerOK();
				result = detailController.detailselect(action, request, response);
				break;

			case "uniformlist":
			case "caplist":
			case "apparellist":
			case "accessorieslist":
			case "cheeringitemlist":
			case "baseballgearlist":
				result = select.listTeamItemCategory(action, request, response);
				break;
			case "deletePostOk":

				break;
			}
		} catch (Exception e) {
			e.printStackTrace(); // 로그 출력
			result.setPath("/app/trade/tradeMain.jsp"); // 예외 발생 시 이동 페이지
			result.setRedirect(false);
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
