<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/login/adminlogin.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminlogin/adminLogin.js"></script>
</head>
<body>
  <!-- 헤더 -->
  <main>
    <div class="main-container">
      <div class="main-title">
        관리자 로그인
      </div>
      <form action="${pageContext.request.contextPath}/admin/adminLoginOk.ad" method="post">
        <div class="main-form-box">
          <div class="main-input-message">
            아이디
          </div>
          <div class="main-input-blank">
            <input type="text" name="adminId" placeholder="아이디" id = "id" required>
          </div>
          <div class="main-input-message">
            비밀번호
          </div>
          <div class="main-input-blank">
            <input type="password" name="adminPw" placeholder="비밀번호" id = "pw" required>
          </div>
          <div class="main-input-fail-message">
            아이디 또는 비밀번호가 잘못되었습니다.
          </div>
          <div class="main-login-button">
            <button type="submit" id = "login-button"> 로그인 </button>
          </div>
        </div>
      </form>
    </div>
  </main>
  <div id="footer"></div>
  <script src="${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script>
</body>

</html>