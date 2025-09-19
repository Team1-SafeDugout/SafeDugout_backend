package com.bullPenTalk.app.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.Execute;
import com.bullPenTalk.app.Result;
import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;
import com.google.gson.Gson;

public class FindPwOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 진입 확인 메시지
		System.out.println("비밀번호 찾기 처리 컨트롤러 진입");

		// 요청 JSON 읽기
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String jsonData = sb.toString();

		// JSON 데이터 확인
		System.out.println(jsonData);

		// JSON 파싱 (Gson 사용 예시)
		Gson gson = new Gson();
		Map<String, Object> data = gson.fromJson(jsonData, Map.class);

		// 변수 선언
		String inputName = (String) data.get("name");
		String inputId = (String) data.get("id");
		String inputEmail = (String) data.get("email");
		String inputPhone = (String) data.get("phoneNumber");

		// DAO, DTO 생성 및 회원번호 조회
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberName(inputName);
		memberDTO.setMemberId(inputId);
		memberDTO.setMemberEmail(inputEmail);
		memberDTO.setMemberPhone(inputPhone);
		int memberNumber = memberDAO.findNumberWithId(memberDTO);
		System.out.println(memberNumber);

		// 이름, 아이디, 이메일, 핸드폰 번호 등록 여부 설정
		boolean nameRegistered = memberDAO.checkNameRegistered(inputName) == 0 ? false : true;
		boolean idRegistered = memberDAO.checkIdRegistered(inputId) == 0 ? false : true;
		boolean emailRegistered = memberDAO.checkEmailRegistered(inputEmail) == 0 ? false : true;
		boolean phoneRegistered = memberDAO.checkPhoneRegistered(inputPhone) == 0 ? false : true;

		// 응답 JSON 보내기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("memberNumber", memberNumber);
		responseMap.put("nameRegistered", nameRegistered);
		responseMap.put("idRegistered", idRegistered);
		responseMap.put("emailRegistered", emailRegistered);
		responseMap.put("phoneRegistered", phoneRegistered);
		
		System.out.println("응답 : " + responseMap);

		out.print(gson.toJson(responseMap));
		out.flush();

		return null;
	}

}
