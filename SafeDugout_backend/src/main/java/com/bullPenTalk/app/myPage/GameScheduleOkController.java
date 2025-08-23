package com.bullPenTalk.app.myPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.dto.MainDTO;
import com.bullPenTalk.app.main.dao.MainDAO;

@WebServlet("/gameSchedule")
public class GameScheduleOkController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // MainDAO에서 경기 일정 목록 조회
        List<MainDTO> gameScheduleList = MainDAO.selectList(pageMap);

        request.setAttribute("gameScheduleList", gameScheduleList);

        System.out.println("경기 일정 진입");

        request.getRequestDispatcher("/./../GameSchedule.jsp").forward(request, response);
    }
}
