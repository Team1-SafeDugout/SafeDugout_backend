<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="em">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>검색 기록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamSearch.css">
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
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main>
  	<!-- 공지 컨테이너 -->
	<div class="team-notice-container">
		<h2>검색목록</h2>
		<div class="team-notice-board">
		<h4 class="team-search-title">공지사항</h4>
			<!-- 공지 목록 -->
			<ul id="team-notice-list">
				<!-- 공지 리스트 헤더 -->
				<li class="team-notice-header">
					<div class="center-text">공지 목록</div>
				</li>
				<!-- 공지 목록 추가 -->
				<c:choose>
					<c:when test="${not empty noticeList}">
						<c:forEach var="notice" items="${noticeList}">
							<li class="team-notice-list-item">
								<div class="notice-title">
									<a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=noticedetail&postNumber=${notice.noticePostNumber}">
										<c:out value="${notice.noticePostTitle}" />
									</a>
								</div>
								<div class="notice-date">
									<fmt:formatDate value="${notice.noticePostDate}"
										pattern="yyyy-MM-dd" />
								</div>
							</li>
						</c:forEach>
					</c:when>
				</c:choose>
			</ul>
		</div>
		<!-- 페이지네이션 -->
		<div class="pagination">
			<ul>
				<c:if test="${noticePrev}">
					<li><a
						href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice&page=${noticeStartPage - 1}">&lt;</a></li>
					</c:if>
				<c:set var="noticeRealStartPage" value="${noticeStartPage < 0 ? 0 : noticeStartPage}" />
				<c:forEach var="i" begin="${noticeRealStartPage}" end="${noticeEndPage}">
					<c:choose>
						<c:when test="${i != noticePage}">
							<li><a
								href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice&page=${i}">
									<c:out value="${i}" />
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#" class="active"><c:out value="${i}" /></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${noticeNext}">
					<li><a
						href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice&page=${noticeEndPage + 1}">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
		
    <!-- 검색 기록 컨테이너 -->
    <div class="team-post-container">
    <h4 class="team-search-title">게시글</h4>
    <div class="team-search-list-container">
      <!-- 검색 리스트 헤더 -->
      <div class="team-search-list-header">      	
        <span class="team-col-type">글 종류</span>
        <span class="team-col-num">글 번호</span>
        <span class="team-col-title">제목</span>
        <span class="team-col-writer">작성자ID</span>
        <span class="team-col-date">작성 일자</span>
      </div>
      <ul class="team-search-list">
        <!-- 검색 리스트 아이템 -->
        <c:choose>
        <c:when test="${not empty postList}">
        <c:forEach var="post" items="${postList}">
        <li class="team-search-list-item">
          <span class="team-search-type"><c:out value="${post.postType}" /></span>
          <span class="team-search-num"><c:out value="${post.postNumber}" /></span>
          <span class="team-search-title"><c:out value="${post.postTitle}" /></span>
          <span class="team-search-writer"><c:out value="${post.memberId}" /></span>
          <span class="team-search-date"><c:out value="${post.postDate}" /></span>
        </li>
        </c:forEach>
        </c:when>
        </c:choose>
      </ul>
    </div>
      <!-- 페이지네이션 -->
		<div class="pagination">
			<ul>
				<c:if test="${postPrev}">
					<li><a
						href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice&page=${postStartPage - 1}">&lt;</a></li>
				</c:if>

				<c:set var="postRealStartPage" value="${postStartPage < 0 ? 0 : postStartPage}" />
				<c:forEach var="i" begin="${postRealStartPage}" end="${postEndPage}">
					<c:choose>
						<c:when test="${i != postPage}">
							<li><a
								href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice&page=${i}">
									<c:out value="${i}" />
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#" class="active"><c:out value="${i}" /></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${postNext}">
					<li><a
						href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice&page=${postEndPage + 1}">&gt;</a></li>
				</c:if>
			</ul>
		</div>
    </div>
</main>
<jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>
