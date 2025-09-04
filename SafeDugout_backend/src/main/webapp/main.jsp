<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <title>메인페이지</title>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <nav>
    <div class="team-logo">
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=3">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/hanwha.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=2">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=8">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/lotte.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=5">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=9">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=6">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=7">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=4">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/samsung.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=1">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png" alt="">
      </a>
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=10">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kiwoom.png" alt="">
      </a>
    </div>
  </nav>

  <main>
    <!-- 메인 섹션 -->
    <section class="main-section">
      <!-- 팀순위 섹션 -->
      <section class="rank-section">
        <!-- 팀순위 섹션 제목 -->
        <h2 class="rank-section-title">팀별 순위</h2>
        <!-- 팀 순위 테이블 -->
        <div class="rank-table">
          <!-- 팀순위 테이블 제목 -->
          <div class="rank-table-title">팀 순위 (2025)</div>
          <!-- 팀순위 테이블 컬럼 -->
          <div class="rank-table-column">
            <!-- 팀순위 테이블 컬럼 목록 리스트 -->
            <li class="rank-table-column-li rank-li-rank">순위</li>
            <li class="rank-table-column-li rank-li-team">팀</li>
            <li class="rank-table-column-li rank-li-G">G</li>
            <li class="rank-table-column-li rank-li-win">승</li>
            <li class="rank-table-column-li rank-li-draw">무</li>
            <li class="rank-table-column-li rank-li-loss">패</li>
            <li class="rank-table-column-li rank-li-winRate">승률</li>
            <li class="rank-table-column-li rank-li-winloss">승차</li>
          </div>
          <!-- 팀 순위 1위 ~ 10위 -->
          <div class="rank-table-teamlist">
          <c:forEach var="rankRow" items="${rankList}">
            <!-- 팀순위 팀 데이터 리스트 -->
            <div class="rank-table-teamlist-team">
              <!-- 팀순위 팀 데이터 리스트 목록 -->
              <li class="rank-table-teamlist-team-list rank-li-rank"><c:out value="${rankRow.teamRank}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-team"><c:out value="${rankRow.teamName}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-G"><c:out value="${rankRow.gameCount}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-win"><c:out value="${rankRow.teamWin}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-draw"><c:out value="${rankRow.teamDraw}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-loss"><c:out value="${rankRow.teamLose}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-winRate"><c:out value="${rankRow.teamWinRate}"/></li>
              <li class="rank-table-teamlist-team-list rank-li-winloss"><c:out value="${rankRow.teamGB}"/></li>
            </div>
          </c:forEach>
          </div>
        </div>
        
        <!-- 입문가이드 목록 제목 -->
        <h2 class="rank-section-title">입문가이드</h2>
        <!-- 입문가이드 목록 공간 -->
        <div class="guide-list-container">
          <div class="guide-list-all">
          <c:forEach var="guideRow" items="${guideList}">
            <div class="guide-list-guide">
              <li class="guide-list-guide-li guide-li-number"><a></a><c:out value="${guideRow.noticePostNumber}"/></a></li>
              <li class="guide-list-guide-li guide-li-title"><c:out value="${guideRow.noticePostTitle}"/></li>
              <li class="guide-list-guide-li guide-li-date"><c:out value="${guideRow.noticePostDate}"/></li>
            </div>
          </c:forEach>
          </div>
        </div>
      </section>
      <!-- 경기 일정 & 최신 등록 상품 섹션 -->
      <section class="schedule-product-section">
        <!-- 경기 일정 섹션 -->
        <section class="schedule-section">
          <!-- 경기 일정 섹션 제목 -->
          <h2 class="schedule-title">경기일정</h2>
          <!-- 경기 일정 테이블 -->
          <div class="schedule-table">
            <!-- 경기 일정 테이블 제목 -->
            <div class="schedule-table-title">다음 경기 일정</div>
            <!-- 경기 일정 빠른 5일 -->
            <div class="schedule-table-schedulelist">
              <!-- 경기 일정 데이터 리스트 -->
              <c:forEach var="scheduleRow" items="${schedule}">
              <div class="schedule-table-schedulelist-schedule">
                <!-- 경기 일정 데이터 리스트 목록 -->
                <li class="schedule-table-schedulelist-schedule-list schedule-li-home"><c:out value="${scheduleRow.awayTeamName}"/></li>
                <li class="schedule-table-schedulelist-schedule-list schedule-li-loc">
                  <div class="schedule-li-loc-text">
                    <c:out value="${scheduleRow.stadiumName}"/>
                  </div>
                </li>
                <li class="schedule-table-schedulelist-schedule-list schedule-li-away"><c:out value="${scheduleRow.homeTeamName}"/></li>
                <li class="schedule-table-schedulelist-schedule-list schedule-li-time"><c:out value="${scheduleRow.scheduleDate}"/></li>
                <li class="schedule-table-schedulelist-schedule-list schedule-li-info">
                  <a class="schedule-li-info-link" href="">정보</a>
                </li>
              </div>
              </c:forEach>
            </div>
          </div>
        </section>
        <!-- 최신 등록 상품 섹션 -->
        <section class="product-section">
          <!-- 최신 등록 상품 섹션 제목 -->
          <h2 class="product-title">최신 등록 상품</h2>
          <!-- 중고 거래 창으로 -->
          <div class="product-used">
            <a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr" class="product-used-text">중고거래 창으로</a>
          </div>
          <!-- 중고거래 목록 묶음 -->
          <div class="product-box">
          <c:forEach var="sellPost" items="${sellList}">
            <!-- 중고거래 목록 아이템 -->
            <div class="product-box-item">
              <!-- 중고 거래 이미지 -->
              <div class="product-box-item-imgdiv">
                <img src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png" alt="" class="product-box-item-img">
              </div>
              <!-- 중고 거래 상품명 -->
              <div class="product-box-item-name">
                <!-- [PRO-SPECS] 야구 대표팀 점퍼 --><c:out value="${sellPost.sellPostTitle}"/>
              </div>
              <!-- 중고 거래 상품 판매가 -->
              <div class="product-box-item-price">
                <!-- 판매가 : 249,000원 -->판매가 : <c:out value="${sellPost.pricePoint}"/>
              </div>
              <!-- 중고 거래 상품 등록날짜 -->
              <div class="product-box-item-date">
                <!-- 등록날짜 : 2025.08.05 -->등록날짜 : <c:out value="${sellPost.sellPostCreationDate}"/>
              </div>
            </div>
            </c:forEach>
          </div>
        </section>
      </section>
    </section>
  </main>
    <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
    <script src="${pageContext.request.contextPath}/assets/js/includeMain.js"></script>
</body>
</html>