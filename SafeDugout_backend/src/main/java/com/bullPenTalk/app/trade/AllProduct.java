package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class AllProduct implements TradeService{

	@Override
	public void execute(String action, String category, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AllProcudt 진입");
		System.out.println("action값: " + action);
		System.out.println("category값: " + category);
		
		// Result 객체 생성
		Result result = new Result();

		// 조회 객체 생성
		SelectController select = new SelectController();

		switch (action) {
		case "list":
			result = select.selectAll(action, category, request, response); // 전체 품목 
			break;
		case "detail": // 디테일 페이지
			System.out.println("detail 진입");
			DetailControllerOK detailController = new DetailControllerOK();
			result = detailController.detailselect(action, category, request, response);
			break;

		case "uniformlist":			
		case "caplist":
		case "apparellist":
		case "accessorieslist":
		case "cheeringitemlist":
		case "baseballgearlist":
			result = select.listCategory(action, category, request, response); // 특정 카테고리 
			break;
		case "deletepostok":
			DeleteOkController delete = new DeleteOkController();
			result = delete.deleteSellPost(request, response);
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
