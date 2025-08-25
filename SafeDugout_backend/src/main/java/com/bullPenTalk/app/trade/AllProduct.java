package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class AllProduct implements TradeService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AllProcudt 진입");
		System.out.println("action값: " + action);
		// Result 객체 생성
		Result result = new Result();

		// 조회 객체 생성
		SelectController select = new SelectController();

		switch (action) {
		case "list":
			result = select.selectAll(action, request, response); // 전체 품목 
			break;
		case "detail": // 디테일 페이지
			DetailControllerOK detailController = new DetailControllerOK();
			result = detailController.detailselect(action, request, response);
			break;

		case "uniformList":			
		case "capList":
		case "apparelList":
		case "accessoriesList":
		case "cheeringitemList":
		case "baseballgearList":
			result = select.listCategory(action, request, response); // 특정 카테고리 
			break;
		case "deletepostok":
			DeleteOkController delete = new DeleteOkController();
			delete.deleteSellPost(request, response);
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
