<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>비밀번호 재설정 완료</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/findPw/findPwChangeResult.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/findPw/findPwChangeResult.js"></script>
</head>

<!-- 바디 -->

<body>
  <!-- 헤더 -->
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <!-- 메인 -->
  <main>
    <!-- 메인 컨테이너 -->
    <div class="main-container">
      <!-- 페이지 큰 제목 -->
      <div class="main-title">
        비밀번호 재설정
      </div>
      <div class="main-small-title">

      </div>
        <!-- 메시지 박스 -->
        <div class="main-message-container">
          <!-- 결과 메시지 -->
          <div class="main-result-message">
            비밀번호 변경이 완료되었습니다. <br><br>
            다시 로그인 해주세요.
          </div>
        </div>
        <!-- 버튼 컨테이너 -->
         <div class="main-button-container">
           <!-- 버튼 컨테이너 a 태그 -->
           <a href="${pageContext.request.contextPath}/member/login.me">
             <!-- 로그인 버튼 -->
             <div class="main-button-next">로그인
             </div>
           </a>
         </div>
    </div>
  </main>
  <!-- 푸터 -->
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
  <!-- 스크립트 -->
  <script src="./../../assets/js/include.js"></script>
</body>

</html>