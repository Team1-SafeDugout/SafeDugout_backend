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
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 요청 파라미터 team 꺼내기
        String team = req.getParameter("team");
        if (team != null) team = team.toLowerCase();
        
        String action = req.getParameter("action");
        if (action != null) action = action.toLowerCase();
        
        // 팀별 서비스 객체 조회, 없으면 defaultService 사용
        TradeService service = registry.getOrDefault(team, defaultService);

        // 서비스 실행
        service.execute(action,req, resp);
    }
}


