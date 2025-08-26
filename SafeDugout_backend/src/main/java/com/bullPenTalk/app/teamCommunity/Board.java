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
		// 객체 생성
		Result result = new Result();
		PostSelectListController postSelectListController = new PostSelectListController();
		WriteController writeController = new WriteController();
		PostDetailController detail = new PostDetailController();
		WriteOkController writeOkController = new WriteOkController();
		DeleteControllerOkController delete = new DeleteControllerOkController();
		UpdateController update = new UpdateController();
		UpdateOkController updateOk = new UpdateOkController();

		switch (action) {
		case "postlist":
			result = postSelectListController.boardList(action, request, response);
			break;
		case "noitce":
			result= postSelectListController.noticeMoreList(action, request, response);
			break;
		case "write":
			result= writeController.writerequest(request, response);
			break;
		case "writeok":
			result = writeOkController.writePost(request, response);
			break;
		case "detail": 
			result = detail.detailselect(action, request, response);
			break;
		case "noticedetail":
			
			break;
		case "delete":
			result = delete.deletePost(request, response);
			break;
		case "update":
			result = update.update(request, response);
			break;
		case "updateok":		
			result = updateOk.updateOk(request, response);
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