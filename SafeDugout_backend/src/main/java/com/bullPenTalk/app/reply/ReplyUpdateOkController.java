package com.bullPenTalk.app.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.admin.dao.FreeCommentDAO;
import com.bullPenTalk.app.admin.dao.TeamCommentDAO;
import com.bullPenTalk.app.dto.CommentDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReplyUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
        FreeCommentDAO freeDao = new FreeCommentDAO();
        TeamCommentDAO teamDao = new TeamCommentDAO();
        Gson gson = new Gson();
        
        String replyCommunity = request.getParameter("replyCommnunity");

        try {
            BufferedReader reader = request.getReader();
            String body = reader.lines().collect(Collectors.joining());
            JsonObject json = JsonParser.parseString(body).getAsJsonObject();

            int replyNumber = json.get("replyNumber").getAsInt();
            String replyContent = json.get("replyContent").getAsString();

            CommentDTO dto = new CommentDTO();
            dto.setCommentNumber(replyNumber);
            dto.setCommentContent(replyContent);

            switch(replyCommunity) {
            case "team":
            	teamDao.update(dto);
            	break;
            case "free":
            	freeDao.update(dto);
            	break;
            }

            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(java.util.Map.of("status", "success")));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(gson.toJson(java.util.Map.of("status", "fail")));
        }

        return null;
	}

}
