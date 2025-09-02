package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Result;

public class Update implements TradeService{

	@Override
	public void execute(String action, String category, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		UpdateController update = new UpdateController();
		UpdateControllerOK updateOk = new UpdateControllerOK();
		switch(action) {
		case "update" :
			result = update.update(request, response);
		case "updateOk" :
			result = updateOk.updateOk(request, response);
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
