package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommunityService {
	public void execute(String action, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
