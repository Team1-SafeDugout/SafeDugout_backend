import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bullPenTalk.app.dto.MemberDTO;
import com.bullPenTalk.app.member.dao.MemberDAO;

public class MemberUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        // 폼에서 보낸 값 꺼내기
        String memberId = request.getParameter("memberId");
        String memberPw = request.getParameter("memberPw");
        String memberName = request.getParameter("memberName");
        String memberPhone = request.getParameter("memberPhone");
        int memberPostalCode = Integer.parseInt(request.getParameter("memberPostalCode"));
        String memberEmail = request.getParameter("memberEmail");
        String teamName = request.getParameter("memberMyTeam");

        // 팀 문자열을 숫자로 바꾸기 (간단하게 1~10 사이 숫자만 예시)
        int memberMyTeam = 0;
        if (teamName.equals("LG 트윈스")) memberMyTeam = 2;

        // DTO 만들기
        MemberDTO member = new MemberDTO();
        member.setMemberId(memberId);
        member.setMemberPw(memberPw);
        member.setMemberName(memberName);
        member.setMemberPhone(memberPhone);
        member.setMemberPostalCode(memberPostalCode);
        member.setMemberEmail(memberEmail);
        member.setMemberMyTeam(memberMyTeam);

        // DAO 호출 (수정 성공 여부 리턴)
        MemberDAO dao = new MemberDAO();
        boolean success = dao.update(member);

        // 응답 JSON으로 보내기
        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }
}
