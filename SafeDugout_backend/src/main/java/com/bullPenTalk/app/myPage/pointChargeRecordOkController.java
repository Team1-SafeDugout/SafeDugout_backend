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
import com.bullPenTalk.app.dto.PointChargeRecordDTO;
import com.bullPenTalk.app.myPage.dao.myPageDAO;

public class PointChargeRecordOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("==== PointChargeRecordOkController 실행 ====");

        myPageDAO mypageDAO = new myPageDAO();
        Result result = new Result();

        // 현재 페이지
        String temp = request.getParameter("page");
        int page = (temp == null) ? 1 : Integer.parseInt(temp);

        // 페이징 기본 설정
        int rowCount = 10;
        int pageCount = 5;

        int startRow = (page - 1) * rowCount + 1;
        int endRow = startRow + rowCount - 1;

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);

        // 포인트 충전 내역 가져오기
        List<PointChargeRecordDTO> payList = mypageDAO.selectAll(pageMap);
        request.setAttribute("payList", payList);

        // 전체 데이터 수와 페이징 계산
        int total = mypageDAO.getTotal();
        int realEndPage = (int) Math.ceil(total / (double) rowCount);
        int endPage = (int) Math.ceil(page / (double) pageCount) * pageCount;
        int startPage = endPage - (pageCount - 1);
        endPage = Math.min(endPage, realEndPage);

        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        // JSP에 넘길 값들 설정
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);

        System.out.println("==== 페이징정보 확인 ====");
        System.out.println("pageMap : " + pageMap);
        System.out.println("payList : " + payList);
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
        System.out.println("========================");

        result.setPath("/app/pointCharge/pointCharge.jsp");
        result.setRedirect(false);

        return result;
    }
}
