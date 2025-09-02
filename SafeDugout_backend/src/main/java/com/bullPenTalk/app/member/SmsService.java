package com.bullPenTalk.app.member;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


public class SmsService {
	// CoolSMS API 인증 키
   private static final String API_KEY = System.getenv("MESSAGE_API_KEY");
   private static final String API_SECRET = System.getenv("MESSAGE_SECRET_KEY");
   
   // SMS 발신자 번호
   private static final String FROM_NUMBER = System.getenv("FROM_NUMBER");

   /*
    * 인증번호를 SMS로 발송하는 메서드
    * @param to : 수신자 핸드폰 번호
    * @return 발송된 6자리 인증번호
    * @throws CoolsmsException : SMS 발송 실패 시 예외 발생
    */ 
   public String sendVerificationSms(String to) throws CoolsmsException {
	   
	   // CoolSMS Message 객체 생성 (API_KEY, API_SECRET 사용)
      Message coolsms = new Message(API_KEY, API_SECRET);
      
      // 랜덤 인증번호 생성
      String verificationCode = generateVerificationCode();

      // SMS 발송에 필요한 파라미터 세팅
      HashMap<String, String> params = new HashMap<String, String>();
      params.put("to", to);
      params.put("from", FROM_NUMBER);
      params.put("type", "SMS");
      params.put("text", "인증번호는 [" + verificationCode + "] 입니다.");

      System.out.println("인증코드까지는 만들어짐");
      // SMS 발송
      JSONObject obj = (JSONObject) coolsms.send(params);
      
      System.out.println("전송시도까지함");
      
      // 발송 결과 콘솔에 출력 (디버깅용)
      System.out.println(obj.toString());

      // 생성한 인증번호 반환 (서버 세션 등에서 인증 검증용)
      return verificationCode;
   }

   private String generateVerificationCode() {
      Random random = new Random();  // 난수 생성기
      StringBuilder code = new StringBuilder();  // 인증번호 문자열을 담을 객체
      
   // 6자리 숫자 생성
      for (int i = 0; i < 6; i++) {
         code.append(random.nextInt(10));
      }
      return code.toString();
   }
}