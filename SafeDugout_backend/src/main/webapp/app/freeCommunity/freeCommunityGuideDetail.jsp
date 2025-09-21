<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>불펜토크</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/freeCommunityGuideDetail.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <!-- 팀 공지 디테일 컨테이너 -->
    <div class="free-guide-board-detail">
      <h2>공지사항</h2>
      <!-- 팀 공지 디테일 내용 헤더 -->
      <div class="free-guide-board-header">
        <span>제목: </span>
        <p><c:out value="${noticePostDetail.noticePostTitle}" /></p>
      </div>
      <!-- 팀 공지 본문 -->
      <div class="free-guide-board-content">
      	<c:if test="${not empty noticePostDetail.attachment}">
      	<c:forEach var="img" items="${noticePostDetail.attachment}">
      		<div class="notice-board-content-img">
      		<img src="${pageContext.request.contextPath}${img.getAttachmentPath()}${img.getAttachmentName()}" alt="">
      		</div>
      	</c:forEach>
      	</c:if>
        <p><c:out value="${noticePostDetail.noticePostContent}" /></p>
      </div>
      <!-- 작성일자 -->
      <div class="free-guide-date">
      	<fmt:formatDate value="${noticePostDetail.noticePostDate}" pattern="yyyy-MM-dd" />
      </div>

      <!-- 목록버튼 -->
      <div class="free-guide-board-btn">
        <a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityNoticeList.fc">목록</a>
      </div>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
  <script>
	let memberNumber = "${sessionScope.memberNumber}";
  </script>
</body>
</html>
