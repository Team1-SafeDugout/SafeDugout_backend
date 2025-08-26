package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class News implements CommunityService{

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostSelectListController postSelectListController = new PostSelectListController();
		
		switch(action) {
		case "news" :
			postSelectListController.newsList(action, request, response);
			break;
		case "newsdetail":
			PostDetailController detail = new PostDetailController();
			detail.newsdetailselect(action, request, response);
		}
		
	}

}
