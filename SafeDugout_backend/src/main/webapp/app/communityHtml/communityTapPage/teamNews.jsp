<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamNews.css">
  <c:choose>
  	<c:when test="${sessionScope.teamNumber == 1}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/doosanHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/doosanFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 3}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/hanwhaHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/hanwhaFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 9}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiaHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiaFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 10}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiwoomHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiwoomFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 6}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ktHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ktFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 2}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lgHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lgFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 8}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lotteHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lotteFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 7}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ncHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ncFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 4}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/samsungHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/samsungFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 5}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ssgHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ssgFooter.css">
  	</c:when>
  </c:choose>
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script> --%>
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamNews.js"></script> --%>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main>
    <div class="team-news-container">
      <h2>팀뉴스</h2>
      <!-- 뉴스 박스 -->
      <ul id="team-news-box">
        <li class="team-news-list">
          <a href="./teamNewsDetail.html">
            <span><img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt=""></span>
            <span></span>
          </a>
        </li>
        <!-- 뉴스 추가 공간 -->
      </ul>
      <!-- 페이지 네이션 -->
      <div class = "list-pagenumber">
        <div id ="left-button"> ◁ </div>
        <ul id = "numberlist-ul">
          <li><a>1</a></li>
          <li><a>2</a></li>
          <li><a>3</a></li>
          <li><a>4</a></li>
          <li><a>5</a></li>
        </ul>
        <div id ="right-button"> ▷ </div>
      </div>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>