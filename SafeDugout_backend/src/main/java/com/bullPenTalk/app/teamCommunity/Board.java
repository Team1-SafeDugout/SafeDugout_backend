package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Board implements CommunityService {

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		PostSelectListController postSelectListController = new PostSelectListController();

		switch (action) {
		case "postlist":
			postSelectListController.boardList(action, request, response);
			break;
		case "noitce":
			postSelectListController.noticeMoreList(action, request, response);
			break;
		case "write":
			WriteController writeController = new WriteController();
			writeController.writerequest(request, response);
			break;
		case "writeOk":
			WriteOkController writeOkController = new WriteOkController();
			writeOkController.writePost(request, response);
			break;
		case "detail": 
			PostDetailController detail = new PostDetailController();
			detail.detailselect(action, request, response);
			break;
		case "delete":
			DeleteControllerOkController delete = new DeleteControllerOkController();
			delete.deletePost(request, response);
			break;
		case "update":
		
		case "updateOk":
			
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