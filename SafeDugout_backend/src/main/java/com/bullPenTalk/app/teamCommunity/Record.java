package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Record implements CommunityService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어온 액션" + action);
		Result result = new Result();
		RecordSelectController select = new RecordSelectController();
		
		switch(action) {
		case "teamrecord" :
			result = select.teamRecordselect(action, request, response);
			break;
			
		case "playerrecord" :
			result = select.playerRecordSelect(action, request, response);
			break;
			
		default :
            System.out.println("알 수 없는 액션입니다: " + action);
            result.setPath("/app/communityHtml/communityTapPage/communityMainPage.jsp");
            result.setRedirect(true);
            break;
		
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
