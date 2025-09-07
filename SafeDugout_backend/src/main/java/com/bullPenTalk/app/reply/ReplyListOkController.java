package com.bullPenTalk.app.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.FreeCommentDAO;
import com.bullPenTalk.app.admin.dao.TeamCommentDAO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ReplyListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int postNumber = Integer.valueOf(request.getParameter("postNumber"));
		FreeCommentDAO freeReplyDAO = new FreeCommentDAO();

		Gson gson = new Gson();
		JsonArray replies = new JsonArray();
		
		// 페이지네이션
		String temp = null;
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
	
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)
	
		// 시작과 행과 끝행 맵으로 정리 [(startRow,1), (endRow,2)]... 이런식으로 가게됨
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("postNumber", postNumber);
		
		freeReplyDAO.selectAll(pageMap).stream().map(gson::toJson).map(JsonParser::parseString).forEach(replies::add);
		
		System.out.println("================댓목록================");
		System.out.println(freeReplyDAO.selectAll(pageMap));
		System.out.println("================================");

		System.out.println(replies.toString());

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(replies.toString());
		out.close();

		return null;
	}

}
