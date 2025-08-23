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
import com.bullPenTalk.app.dto.PostDTO;
import com.bullPenTalk.app.myPage.dao.MyPageDAO;

public class PostOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("==== PostOkController 실행 ====");

        MyPageDAO myPageDAO = new MyPageDAO();
        Result result = new Result();

        // 페이지 파라미터 처리
        String temp = request.getParameter("page");
        int page = (temp == null) ? 1 : Integer.valueOf(temp);

        int rowCount = 10;
        int pageCount = 5;

        int startRow = (page - 1) * rowCount + 1;
        int endRow = startRow + rowCount - 1;

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);

        // 게시글 목록 불러오기
        List<PostDTO> postList = myPageDAO.selectAll(pageMap);
        request.setAttribute("postList", postList);

        // 페이징 계산
        int total = myPageDAO.getTotal();
        int realEndPage = (int) Math.ceil(total / (double) rowCount);
        int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
        int startPage = endPage - (pageCount - 1);
        endPage = Math.min(endPage, realEndPage);

        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        // request에 정보 담기
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);

        // 디버깅용 출력
        System.out.println("pageMap : " + pageMap);
        System.out.println("postList : " + postList);
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
        System.out.println("==============================");

        result.setPath("/app/mypostList/myPostList.jsp");
        result.setRedirect(false);

        return result;
    }
}
