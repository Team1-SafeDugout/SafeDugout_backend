package com.bullPenTalk.app.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.FreeCommentDAO;
import com.bullPenTalk.app.admin.dao.TeamCommentDAO;
import com.bullPenTalk.app.dto.CommentDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReplyWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		CommentDTO commentDTO = new CommentDTO();
		FreeCommentDAO freeReplyDAO = new FreeCommentDAO();
		TeamCommentDAO teamReplyDAO = new TeamCommentDAO();
		
		System.out.println("세션에 저장된 멤버" + session.getAttribute("memberNumber"));

		request.setCharacterEncoding("utf-8");

		// json 응답
		Gson gson = new Gson();
//		Map<String, Object> responseMap = new HashMap<>();

		// Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();

		// 필수 파라미터 확인
		if (!jsonObject.has("boardNumber") || !jsonObject.has("memberNumber") || !jsonObject.has("replyContent")) {
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}
		
		String replyCommunity = request.getParameter("replyCommnunity");
		


		// DTO 설정
		commentDTO.setMemberNumber(jsonObject.get("memberNumber").getAsInt());
		commentDTO.setPostNumber(jsonObject.get("boardNumber").getAsInt());
		commentDTO.setCommentContent(jsonObject.get("replyContent").getAsString());
		
		System.out.println("commentDTO 확인 :" + commentDTO);

		// DB 저장
		
		
		switch(replyCommunity) {
		case "free":
			freeReplyDAO.insert(commentDTO);
			System.out.println("댓글 작성완료 :" + commentDTO);
			break;
			
		case "team":
			teamReplyDAO.insert(commentDTO);
			System.out.println("댓글 작성완료 :" + commentDTO);
			break;		
		}

		// JSON 응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));

		return null;
	}

}
