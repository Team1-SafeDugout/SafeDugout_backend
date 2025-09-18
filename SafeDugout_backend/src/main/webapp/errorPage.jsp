<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>에러페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/errorPage.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/errorPage.js"></script>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <!-- 메인 섹션 -->
  <section class="main-section">
    <div class="message-container">
      <h1>Page Not Found</h1>
      <p>존재하지 않는 주소를 입력하셨거나,</p>
      <p>요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.</p>
      <p>입력하신 주소를 다시 한번 확인해 주시기 바랍니다.</p>
      <div class="main-link"><a href="${pageContext.request.contextPath}/main.ma">메인페이지로 이동 ⇒</a></div>
    </div>
  </section>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>