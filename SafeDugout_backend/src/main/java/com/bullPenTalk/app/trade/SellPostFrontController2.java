package com.bullPenTalk.app.trade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SellPostForntContorller
 */

public class SellPostFrontController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	
	// 요청별 서비스 컨트롤러 등록
	private final Map<String, TradeService> registry = new HashMap<>();
	private final TradeService defaultService = new NotFoundService();
	
	@Override
	public void init() {
		registry.put("doosan", new Doosan());
		registry.put("lg", new Lg());
		registry.put("hanwha", new Hanwha());
		registry.put("samsung", new Samsung());
		registry.put("ssg", new Ssg());
		registry.put("kt", new Kt());
		registry.put("nc", new Nc());
		registry.put("lotte", new Lotte());
		registry.put("kia", new Kia());
		registry.put("kiwoom", new Kiwoom());
		registry.put("allProduct", new AllProduct());
		registry.put("tradeWirte", new TradeWirte());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("현재 경로 진입" );
		req.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		// 요청 파라미터(team, action) 꺼내기
		String category = nvl(req.getParameter("team")).toLowerCase();
		String action = nvl(req.getParameter("action")).toLowerCase();
		// team에 맞는 서비스 찾기 (없으면 defaultService로)
		TradeService svc = registry.getOrDefault(category, defaultService);
		// 찾은 서비스 실행 -> 실제 로직은 서비스 클래스에서 처리
		svc.execute(action, req, resp);
	}

	// null 값 들어오면 ""로 바꿔주기
	private String nvl(String s) {
		return (s == null) ? "" : s;
	}
}
