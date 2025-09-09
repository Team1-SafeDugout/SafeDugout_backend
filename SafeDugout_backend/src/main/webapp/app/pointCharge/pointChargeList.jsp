<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>포인트 충전 내역</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pointCharge/pointChargeList.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
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
        <h3>포인트 충전 내역</h3>
        <div class="content-box">
          <div class="post-list">
            <li class="post-list-top">
              <div class="post-list-number">충전 금액</div>
              <div class="post-list-title">충전 후 포인트</div>
              <div class="post-list-date">충전 날짜</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.06</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.05</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.04</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.03</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.02</div>
            </li>
          </div>
          <div class="pagination">
            <a href="">◁</a>
            <ul id="numberlist-ul">
              <li><a href="">1</a></li>
              <li><a href="">2</a></li>
              <li><a href="">3</a></li>
              <li><a href="">4</a></li>
              <li><a href="">5</a></li>
            </ul>
            <a href="">▷</a>
          </div>
        </div>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value">
          <span>20000</span><span>P</span>
        </div>
        <a href="./../pointRecharge/pointList.html" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="./../trade/pointBuy.html" class="charge-btn">충전</a>
      </section>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>