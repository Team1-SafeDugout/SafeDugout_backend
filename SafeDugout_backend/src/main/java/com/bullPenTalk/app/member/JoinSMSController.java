package com.bullPenTalk.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;


public class JoinSMSController implements Execute {

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

       String phoneNumber = request.getParameter("memberPhoneNumber");
       SmsService smsService = new SmsService();
       Result result = new Result();

       try {
          System.out.println("===인증코드====");
           // SMS 전송 및 인증 코드 생성
           String verificationCode = smsService.sendVerificationSms(phoneNumber);

           // 세션에 인증 코드 저장
           HttpSession session = request.getSession();
           session.setAttribute("verificationCode", verificationCode);

           // AJAX 요청일 경우, 직접 응답 처리
           if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
               response.setContentType("text/plain"); // json이 아닌 text 방식으로 전달
               response.setCharacterEncoding("UTF-8");
               response.getWriter().write("인증번호가 발송되었습니다.");
               return null; // AJAX 응답은 직접 처리하므로 Result 반환 필요 없음
           }

           // 일반 요청일 경우 페이지 이동
           result.setPath("/app/register/RegisterInput.jsp");
           result.setRedirect(false); // 포워딩 방식 사용
       } catch (Exception e) {
           // 예외 발생 시 에러 메시지 전송
           if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
               response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
               response.getWriter().write("SMS 발송 실패: " + e.getMessage());
               return null;
           }

           // 일반 요청의 경우 에러 페이지로 리다이렉트
           result.setPath("/error.jsp");
           result.setRedirect(true);
       }

       return result;
   }
}
