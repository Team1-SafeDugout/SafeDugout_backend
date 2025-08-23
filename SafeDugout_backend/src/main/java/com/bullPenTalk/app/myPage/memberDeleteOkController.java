@WebServlet("/memberDelete")
public class MemberDeleteOkController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        String memberId = request.getParameter("memberId");

        MemberDAO dao = new MemberDAO();
        boolean success = dao.delete(memberId);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }
}
