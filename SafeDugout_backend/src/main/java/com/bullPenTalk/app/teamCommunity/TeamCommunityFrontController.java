package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.trade.TradeService;



/**
 * Servlet implementation class TeamCommunityFrontController
 */
@WebServlet("/TeamCommunityFrontController")
public class TeamCommunityFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final Map<String, CommunityService> registry = new HashMap<>();
	private final CommunityService defaultService = new NotFoundCommunityService();
	
	// 서비스 등록
	@Override
	public void init() {
		registry.put("board", new Board());
		registry.put("news", new News());
		registry.put("youtube", new Youtube());
		registry.put("song", new Song());
		registry.put("game", new Game());
		registry.put("stadium", new Stadium());
		
	}

	// 요청 꺼내기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("현재 경로 진입" );
		req.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		// 요청 파라미터(team, action) 꺼내기
		String category = nvl(req.getParameter("category")).toLowerCase();
		String action = nvl(req.getParameter("action")).toLowerCase();
		// team에 맞는 서비스 찾기 (없으면 defaultService로)
		CommunityService svc = registry.getOrDefault(category, defaultService);
		// 찾은 서비스 실행 -> 실제 로직은 서비스 클래스에서 처리
		svc.execute(action, req, resp);
	}

	// null 값 들어오면 ""로 바꿔주기
	private String nvl(String s) {
		return (s == null) ? "" : s;
	}

}
