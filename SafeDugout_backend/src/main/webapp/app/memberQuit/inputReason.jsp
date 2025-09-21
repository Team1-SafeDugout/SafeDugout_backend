<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 탈퇴 사유 입력</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/memberQuit/inputReason.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <script defer src = "${pageContext.request.contextPath}/assets/js/memberWithDrawal/memberReason.js"></script>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <div class="main-full">
      <section class="sidebar">
        <h2>MY페이지</h2>
        <div>
          <ul>
            <li class="sidebar-button post"> <a href="${pageContext.request.contextPath}/myPage/postList.mp"> 내가 쓴 게시글</a> </li>
            <li class="sidebar-button commet"> <a href="${pageContext.request.contextPath}/myPage/commentList.mp"> 내가 쓴 댓글</a> </li>
            <li class="sidebar-button buy"> <a href="${pageContext.request.contextPath}/myPage/tradeList.mp"> 구매 내역</a> </li>
            <li class="sidebar-button sell"> <a href="${pageContext.request.contextPath}/myPage/sellList.mp"> 판매 내역</a> </li>
            <li class="sidebar-button member-update"> <a href="${pageContext.request.contextPath}/myPage/changeInfo.mp"> 회원 정보 수정</a></li>
            <li class="sidebar-button member-quit"> <a href="${pageContext.request.contextPath}/myPage/unSubscribe.mp"> 회원 탈퇴</a></li>
          </ul>
        </div>
      </section>

      <section class="main-content">
        <h3>회원 탈퇴</h3>
        <div class="content-box">
          <div class="box-content">
            <span>탈퇴 사유를 입력해주세요.</span>
            <textarea name="quitReason" id=""></textarea>
          </div>
          <div class="button-container">
            <!-- 확인 버튼 -->
            <a>
              <div class="button-confirm" id = "confirm-button">확인
              </div>
            </a>
          </div>
        </div>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value">
          <span>${myPoint}</span><span>P</span>
        </div>
        <a href="${pageContext.request.contextPath}/myPage/pointCharge.mp" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=buy&action=charging" class="charge-btn">충전</a>
      </section>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>