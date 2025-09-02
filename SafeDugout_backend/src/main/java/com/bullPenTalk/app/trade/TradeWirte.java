package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class TradeWirte implements TradeService {

	@Override
	public void execute(String action, String category, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Result 객체 생성
		Result result = new Result();
		System.out.println("액션: " + action);
		WriteControllerOk writeOk = new WriteControllerOk();
		WriteController write = new WriteController();

		try {
			switch (action) {
			case "write" :
				System.out.println("write진입 ");				
				result = write.writerequest(request, response);
				break;
			case "writeok":
				System.out.println("writeOk여기 진입");				
				result =  writeOk.writeProduct(request, response);
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
