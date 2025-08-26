package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;
import java.net.MulticastSocket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Board implements CommunityService {

	@Override
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("전달된 액션값: " + action);
		Result result = new Result();
		PostSelectListController postSelectListController = new PostSelectListController();

		switch (action) {
		case "postlist":
			result = postSelectListController.boardList(action, request, response);
			break;
		case "noitce":
			result= postSelectListController.noticeMoreList(action, request, response);
			break;
		case "write":
			WriteController writeController = new WriteController();
			result= writeController.writerequest(request, response);
			break;
		case "writeOk":
			WriteOkController writeOkController = new WriteOkController();
			result = writeOkController.writePost(request, response);
			break;
		case "detail": 
			PostDetailController detail = new PostDetailController();
			result = detail.detailselect(action, request, response);
			break;
		case "delete":
			DeleteControllerOkController delete = new DeleteControllerOkController();
			result = delete.deletePost(request, response);
			break;
		case "update":
			UpdateController update = new UpdateController();
			result = update.update(request, response);
			break;
		case "updateOk":
			UpdateOkController updateOk = new UpdateOkController();
			result = updateOk.updateOk(request, response);
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