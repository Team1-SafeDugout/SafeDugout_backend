package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;


public class VerifyCodeController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // 클라이언트로부터 받은 인증번호
        String userCode = request.getParameter("verificationCode");
        HttpSession session = request.getSession();
        
        // 세션에 저장된 인증번호
        String sessionCode = (String) session.getAttribute("verificationCode");
        
        System.out.println("유저코드 : " + userCode);
        System.out.println("섹션코드 : " + sessionCode);
        // 인증번호 일치 여부 검사
        if (sessionCode != null && sessionCode.equals(userCode)) {
        	System.out.println("인증성공");
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("인증 성공");
        } else {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("인증 실패");
        }
        
        return null;
    }
}
