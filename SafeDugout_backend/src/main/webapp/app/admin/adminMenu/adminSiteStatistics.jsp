<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>사이트 통계</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMenu/adminSiteStatistics.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- 차트 그리기위한 라이브러리 js 에서 써야 하므로 js보다 위에 배치-->
  <script src = "${pageContext.request.contextPath}/assets/js/admin/adminMenu/adminSiteStatistics.js"></script>  
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="body-sidebar">
      <div class="sidebar-div-name">
        관리자 메뉴
      </div>

      <div class="sidebar-div-info">
        <div>
          <div> 관리자 : ${sessionScope.adminInfo.adminId} </div>
          <div> 관리자 이메일 : ${sessionScope.adminInfo.adminEmail}</div>
        </div>
      </div>

      <div class="sidebar-div-container">
        <div>
          <ul>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminSiteStatisticsOk.ad"> 사이트 통계</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad?currentTab=all"> 공지사항</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageFreeCommunityListOk.ad"> 전체 커뮤니티 </a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageUserPostListOk.ad?currentTab=all"> 게시글 </a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad"> 팀 뉴스</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTeamYoutubeListOk.ad"> 팀 유튜브</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTeamSongListOk.ad"> 팀 응원가</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageSellListOk.ad"> 판매글</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTradingListOk.ad"> 거래중인 글</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageMemberListOk.ad"> 회원관리</a> </li>
          </ul>
        </div>
      </div>
    </section>
    <section class="body-container">
      <div class="body-container-name">
        사이트 통계
      </div>

      <div class="statistics-container">
        <section class="guests-statistics">
          <div class="statistics-name">
            방문자수
          </div>
          <div class = "statistics-chart">
          	<canvas id="visitorChart"></canvas>
          </div>
        </section>

        <section class="trading-statistics">
          <div class="trading-count">
            <div class="statistics-name">
              거래중인 글 수
            </div>
            <div>
              ${tradePostNum}
            </div>
          </div>

          <div class="selling-count">
            <div class="statistics-name">
              판매중인 글 수
            </div>
            <div>
              ${sellPostNum}
            </div>
          </div>
        </section>
      </div>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>