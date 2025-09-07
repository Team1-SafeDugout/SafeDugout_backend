package com.bullPenTalk.app.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.FreeCommentDAO;
import com.bullPenTalk.app.dto.CommentDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;
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
		MemberDAO memberDAO = new MemberDAO();
		
		System.out.println("세션에 저장된 멤버" + session.getAttribute("memberNumber"));

		request.setCharacterEncoding("utf-8");

		// json 응답
		Gson gson = new Gson();
//		Map<String, Object> responseMap = new HashMap<>();

		// Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();

		// 필수 파라미터 확인
		if (!jsonObject.has("postNumber") || !jsonObject.has("memberNumber") || !jsonObject.has("commentContent")) {
			System.out.println("필수 요소 없음");
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}

		// DTO 설정
		
		String memberId = memberDAO.getMemberIdByNumber(jsonObject.get("memberNumber").getAsInt());
		commentDTO.setMemberID(memberId);
		System.out.println("commentDTO 확인 :" + commentDTO);
		
		commentDTO.setPostNumber(jsonObject.get("postNumber").getAsInt());
		System.out.println("commentDTO 확인 :" + commentDTO);
		
		commentDTO.setCommentContent(jsonObject.get("commentContent").getAsString());
		System.out.println("commentDTO 확인 :" + commentDTO);
		
		Map<String, String> map = new HashMap<>();
		map.put("memberNumber", jsonObject.get("memberNumber").getAsInt() + "");
		map.put("postNumber", jsonObject.get("postNumber").getAsInt() + "");
		map.put("commentContent", jsonObject.get("commentContent").getAsString());

		// DB 저장
		freeReplyDAO.insert(map);

		// JSON 응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));

		return null;
	}

}
