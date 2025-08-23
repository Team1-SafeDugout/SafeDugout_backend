package com.bullPenTalk.app.myPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.SellPostDTO;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class SellPostOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SellPostOkController 진입");
        MyPageDAO sellPostDAO = new MyPageDAO();
        Result result = new Result();

        String temp = request.getParameter("page");
        int page = (temp == null) ? 1 : Integer.parseInt(temp);
        int rowCount = 10;
        int pageCount = 5;

        int startRow = (page - 1) * rowCount + 1;
        int endRow = startRow + rowCount - 1;

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);

        List<SellPostDTO> sellPostList = sellPostDAO.selectList(pageMap);
        request.setAttribute("sellPostList", sellPostList);

        int total = sellPostDAO.getTotal();
        int realEndPage = (int) Math.ceil(total / (double) rowCount);
        int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
        int startPage = endPage - (pageCount - 1);

        endPage = Math.min(endPage, realEndPage);

        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);

        System.out.println("====페이징정보 확인====");
        System.out.println("pageMap : " + pageMap);
        System.out.println("sellPostList : " + sellPostList);
        System.out.println(
                "startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
        System.out.println("====================");

        result.setPath("/app/sellList/sellList.jsp");
        result.setRedirect(false);

        return result;
    }
}
