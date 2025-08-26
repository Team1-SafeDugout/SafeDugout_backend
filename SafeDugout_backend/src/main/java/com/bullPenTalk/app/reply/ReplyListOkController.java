package com.bullPenTalk.app.reply;

import java.io.IOException;
import java.io.PrintWriter;

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
		int boardNumber = Integer.valueOf(request.getParameter("boardNumber"));
		FreeCommentDAO freeReplyDAO = new FreeCommentDAO();
		TeamCommentDAO teamReplyDAO = new TeamCommentDAO();
		Gson gson = new Gson();
		JsonArray replies = new JsonArray();
		
		String replyCommunity = request.getParameter("replyCommnunity");
		
		switch(replyCommunity) {
		case "team":
			teamReplyDAO.selectAll(boardNumber).stream().map(gson::toJson).map(JsonParser::parseString).forEach(replies::add);
			break;
			
		case "free":
			freeReplyDAO.selectAll(boardNumber).stream().map(gson::toJson).map(JsonParser::parseString).forEach(replies::add);
			break;
		}	

		System.out.println(replies.toString());

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(replies.toString());
		out.close();

		return null;
	}

}
