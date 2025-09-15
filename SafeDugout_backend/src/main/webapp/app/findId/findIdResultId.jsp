<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>찾은 아이디 페이지</title>
  <link rel="stylesheet" href="./../../assets/css/findId/findIdResultId.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/findId/findIdResultId.js"></script>
</head>

<body>
  <!-- 헤더 -->
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <!-- 메인 -->
  <main>
    <!-- 메인 컨테이너 -->
    <div class="main-container">
      <!-- 페이지 큰 제목 -->
      <div class="main-title">
        아이디 찾기
      </div>
      <!-- 소제목 -->
      <div class="main-message-title">
        <span>●</span>&nbsp;아이디 찾기 결과
      </div>
      <!-- 폼 태그 -->
      <form action="" method="post">
        <!-- 메시지 박스 -->
        <div class="main-message-container">
          <!-- 결과 메시지 -->
          <div class="main-result-message">
            • 가입하신 아이디는 <span><c:out value="${afterMemberId}" /><!-- thd**** --></span> 입니다. <br><br>
            • 가입 일자 : <c:out value="${registerDate}" /><!-- 2025 - 08 - 03 -->
          </div>
        </div>
      </form>
      <!-- 버튼 컨테이너 -->
      <div class="main-button-container">
        <!-- 메인페이지 버튼 a 태그 -->
        <a href="${pageContext.request.contextPath}/main.ma">
          <!-- 메인페이지 텍스트 -->
          <div class="main-button-next">메인페이지
          </div>
        </a>
        <!-- 로그인 버튼 a 태그 -->
        <a href="${pageContext.request.contextPath}/member/login.me">
          <!-- 로그인 텍스트 -->
          <div class="main-button-cancel">로그인
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