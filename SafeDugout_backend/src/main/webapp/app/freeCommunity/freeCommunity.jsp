<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>불펜토크</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/freeCommunity.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/freeCommunity.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/include.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">

</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/header.jsp" />
	<main>
		<div class="free-community-container">
			<!-- 자유게시판 섹션 -->
			<section class="free-communtiy-board">
				<div class="free-board-container">
					<!-- 자유게시판 헤더 -->
					<h4>자유 게시판</h4>
					<div class="free-board-more">
						<a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityList.fc">더보기</a>
					</div>
					<ul id="free-board-content">
						<!-- 자유게시판 리스트 헤더 -->
						<li class="free-board-header">
							<div>글번호</div>
							<div>제목</div>
							<div>작성자</div>
							<div>작성일자</div>
						</li>
						<c:choose>
							<c:when test="${not empty freePostList}">
								<c:forEach var="freeCommunity" items="${freePostList}">
									<li class="free-board-list">
										<div>
											<c:out value="${freeCommunity.postNumber}" />
										</div>
										<div>
											<a> <c:out value="${freeCommunity.postTitle}" />
											</a>
										</div>
										<div>
											<c:out value="${freeCommunity.memberId}" />
										</div>
										<div>
											<c:out value="${freeCommunity.postDate}" />
										</div>
									</li>
								</c:forEach>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</section>
			<!-- 입문 가이드 섹션 -->
			<section class="free-community-guide">
				<div class="free-guide-container">
					<!-- 입문자 가이드 헤더 -->
					<h4>입문자 가이드</h4>
					<div class="free-guide-more">
						<a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityNoticeList.fc">더보기</a>
					</div>
					<ul id="free-guide-content">
						<!-- 입문자 가이드 리스트 헤더 -->
						<li class="free-guide-header">
							<div>글번호</div>
							<div>제목</div>
						</li>
						<!-- 입문자 가이드 추가 공간 -->
						<c:choose>
							<c:when test="${not empty freePostList}">
								<c:forEach var="freeCommunity" items="${noticePostList}">
									<li class="free-guide-list">
										<div>
											<c:out value="${freeCommunity.noticePostNumber}" />
										</div>
										<div>
											<c:out value="${freeCommunity.noticePostTitle}" />
										</div>
									</li>
								</c:forEach>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</section>
		</div>
	</main>
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
	<script>
		let memberNumber = "${sessionScope.memberNumber}"
	</script>
</body>
</html>