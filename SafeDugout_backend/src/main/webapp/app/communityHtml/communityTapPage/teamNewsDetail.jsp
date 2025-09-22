<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 - 뉴스 상세</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamNewsDetail.css">

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
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  
  <main>
    <div class="team-news-container">
      <!-- 뉴스 제목 -->
      <h1 class="team-news-title">
        <c:out value="${community.postTitle}" />
      </h1>

      <!-- 기사 원문 링크 -->
      <c:if test="${not empty community.postLink}">
        <a href="${community.postLink}" target="_blank"><button>기사 원문</button></a>
      </c:if>

      <!-- 작성일, 작성자 -->
      <div class="team-news-meta">
        <span class="team-news-date"><c:out value="${community.postDate}" /></span>
        <span class="team-news-reporter"><c:out value="${community.journalist}" /></span>
      </div>

      <!-- 뉴스 이미지 -->
      <div class="team-news-images">
        <c:forEach var="file" items="${community.attachment}">
          <img src="${pageContext.request.contextPath}${file.attachmentPath}${file.attachmentName}" alt="${file.attachmentName}" />
        </c:forEach>
      </div>

      <!-- 뉴스 본문 -->
      <div class="team-news-content">
        <p><c:out value="${community.postContent}" /></p>
      </div>

      <!-- 목록 버튼 -->
      <button type="button" class="list-btn" onclick="history.back();">목록</button>
    </div>
  </main>

  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>
