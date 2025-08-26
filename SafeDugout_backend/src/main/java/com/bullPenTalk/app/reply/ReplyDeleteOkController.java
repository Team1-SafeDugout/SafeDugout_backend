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

public class ReplyDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FreeCommentDAO freeDao = new FreeCommentDAO();
		TeamCommentDAO teamDao = new TeamCommentDAO();
        Gson gson = new Gson();
        
        String replyCommunity = request.getParameter("replyCommnunity");

        try {
            int replyNumber = Integer.parseInt(request.getParameter("replyNumber"));
            switch(replyCommunity) {
            case "free":
            	freeDao.delete(replyNumber);
            	break;
            	
            case "team":
            	teamDao.delete(replyNumber);
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

        return null; // JSP 이동 없음
	}

}
