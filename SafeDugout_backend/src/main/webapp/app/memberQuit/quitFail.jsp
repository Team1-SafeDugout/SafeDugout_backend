<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 탈퇴 불가능</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/memberQuit/quitFail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <div class="main-full">

      <section class="main-content">
        <h3>&nbsp</h3>
        <div class="content-box">
          <h3>&nbsp</h3>
          <h3>
            현재 거래중이므로 탈퇴가 불가능합니다. <br>
            거래 취소 후 탈퇴가 가능합니다.
          </h3>
          <div class="button-container">
            <!-- 확인 버튼 -->
            <a>
              <div class="button-confirm">확인
              </div>
            </a>
          </div>
        </div>
      </section>

    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>