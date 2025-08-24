package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Board implements CommunityService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostSelectListController postSelectListController = new PostSelectListController();
		
		switch(action) {
		case "postlist" :
			postSelectListController.boardList(action, request, response);
			break;
		case "noitce" :
			postSelectListController.noticeMoreList(action, request, response);
			break;	
		case "write" :
			
			break;
		case "writeOk":
			
			
		case "detail" :
		
			break;
		case "delete" :
		
			break;
		case "update": 	
		}
		
	}
}
