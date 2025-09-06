package com.bullPenTalk.app.freeCommunity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.FreePostDTO;
import com.bullPenTalk.app.dto.GuidePostDTO;
import com.bullPenTalk.app.freeCommunity.dao.FreePostDAO;
import com.bullPenTalk.app.freeCommunity.dao.GuidePostDAO;

public class FreeCommunityMainListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	        System.out.println("메인페이지 컨트롤러 진입");

	        FreePostDAO freePostDAO = new FreePostDAO();
	        GuidePostDAO guidePostDAO = new GuidePostDAO();
	        Result result = new Result();

	        // 최신 자유게시판 글 10개 조회
	        List<FreePostDTO> freePostList = freePostDAO.selectLatestPosts(10);
	        request.setAttribute("freePostList", freePostList);
	        System.out.println("자유게시판 최신 10개: " + freePostList.size());

	        // 최신 입문가이드 글 5개 조회
	        List<GuidePostDTO> guidePostList = guidePostDAO.selectLatestPosts(5);
	        request.setAttribute("goidePostList", guidePostList);
	        System.out.println("입문가이드 최신 5개: " + guidePostList.size());

	        // JSP 경로
	        result.setPath("/app/freeCommunity/freeCommunityMain.jsp"); // 메인페이지 JSP
	        result.setRedirect(false);

	        return result;
	    }
	}

	

