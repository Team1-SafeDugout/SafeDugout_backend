<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜 토크 - 팀 유튜브</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamYoutubeList.css">

  <!-- 팀별 헤더/푸터 CSS -->
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
</head>
<body>
  <!-- 헤더 -->
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />

  <main>
    <div class="team-youtube-container">
      <h2>팀 유튜브</h2>
      <!-- 팀 공식 유튜브 링크 -->
      <a href="${youtube.link}" class="official-link" target="_blank">팀 공식 Youtube 바로가기</a>

      <!-- 유튜브 리스트 -->
      <ul class="team-youtube-list">
        <!-- 리스트 헤더 -->
        <li class="team-youtube-list-header">
          <span class="team-youtube-num">번호</span>
          <span class="team-youtube-title">제목</span>
        </li>

        <!-- 유튜브 게시글 반복 -->
        <c:choose>
          <c:when test="${not empty postList}">
            <c:forEach var="youtube" items="${postList}">
              <li class="team-youtube-list-row">
                <span class="col-num"><c:out value="${youtube.postNumber}" /></span>
                <a href="${youtube.postLink}" class="col-title">
                  <span><c:out value="${youtube.postTitle}" /></span>
                </a>
              </li>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <li class="team-youtube-list-row">
              <span class="col-num">-</span>
              <span class="col-title">등록된 유튜브가 없습니다.</span>
            </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </main>

  <!-- 푸터 -->
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>
