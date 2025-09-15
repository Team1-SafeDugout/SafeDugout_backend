<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>불펜토크 - 선수 응원가</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamSongPlayerList.css">

<!-- 팀별 헤더/푸터 CSS -->
<c:choose>
	<c:when test="${sessionScope.teamNumber == 1}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/doosanHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/doosanFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 3}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/hanwhaHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/hanwhaFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 9}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiaHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiaFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 10}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiwoomHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiwoomFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 6}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ktHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ktFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 2}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lgHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lgFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 8}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lotteHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lotteFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 7}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ncHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ncFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 4}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/samsungHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/samsungFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 5}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ssgHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ssgFooter.css">
	</c:when>
</c:choose>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include
		page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />

	<main>
		<div class="team-song-list-player">
			<h2>선수 응원가</h2>

			<ul id="team-song-list">
				<!-- 리스트 헤더 -->
				<li class="team-song-list-header"><span class="team-song-num">번호</span>
					<span class="team-song-title">제목</span></li>
				<!-- 응원가 게시글 반복 -->
				<c:choose>
					<c:when test="${not empty postList}">
						<c:forEach var="song" items="${postList}">
							<li class="team-song-list-row"><span class="team-song-num"><c:out
										value="${song.postNumber}" /></span> <span class="team-song-title">
									<a href="${song.postLink}" target="_blank"> <c:out
											value="${song.postTitle}" />
								</a>
							</span></li>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<li class="team-song-list-row"><span class="team-song-num">-</span>
							<span class="team-song-title">등록된 응원가가 없습니다.</span></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<!-- 페이지네이션 -->
			<div class="pagination">
				<ul>
					<c:if test="${prev}">
						<li><a
							href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=song&action=playersong&page=${startPage - 1}">&lt;</a></li>
					</c:if>

					<c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
					<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
						<c:choose>
							<c:when test="${i != page}">
								<li><a
									href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=song&action=playersong&page=${i}">
										<c:out value="${i}" />
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#" class="active"><c:out value="${i}" /></a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${next}">
						<li><a
							href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=song&action=playersong&page=${endPage + 1}">&gt;</a></li>
					</c:if>
				</ul>
			</div>
		</div>

	</main>

	<!-- 푸터 -->
	<jsp:include
		page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>
