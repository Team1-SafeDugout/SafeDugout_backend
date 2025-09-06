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
	href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/freeCommunityGuideList.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/freeCommunityGuideList.js"></script>
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
		<!-- 입문가이드 컨테이너 -->
		<div class="free-guide-list-container">
			<h2>입문가이드</h2>
			<!-- 입문가이드 리스트박스 목록 -->
			<div class="free-guide-list-box">
				<ul id="free-guide-list">
					<li class="free-guide-list-header">
						<div class="free-guide-title">가이드 목록</div>
					</li>
					<c:choose>
						<c:when test="${not empty goidePostList}">
							<c:forEach var="notice" items="${goidePostList}">
								<li class="free-guide-list-item">
									<div class="free-guide-title">
										<a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityNoticeDetail.fc?noticePostNumber=${notice.noticePostNumber}">
											<c:out value="${notice.noticePostTitle}" />
										</a>
									</div>
									<div class="free-guide-date">
										<fmt:formatDate value="${notice.noticePostDate}" pattern="yyyy-MM-dd" />
									</div>
								</li>
							</c:forEach>
						</c:when>
					</c:choose>
				</ul>							
			</div>
			<!-- 페이지 네이션 -->
			<div class="pagination">
				<ul>
					<c:if test="${prev}">
						<li><a
							href="${pageContext.request.contextPath}/freeCommunity/freeCommunityGuideListOk.fc?page=${startPage - 1}"
							class="prev">&lt;</a></li>
					</c:if>
					<c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
					<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
						<c:choose>
							<c:when test="${!(i == page) }">
								<li><a
									href="${pageContext.request.contextPath}/freeCommunity/freeCommunityGuideListOk.fc?page=${i}">
										<c:out value="${i}" />
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#" class="active"> <c:out value="${i}" />
								</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${next}">
						<li><a
							href="${pageContext.request.contextPath}/freeCommunity/freeCommunityGuideListOk.fc?page=${endPage + 1}"
							class="next">&gt;</a>
					</c:if>
				</ul>
			</div>
		</div>
	</main>
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
	<script>
		let memberNumber = "${sessionScope.memberNumber}";
	</script>
</body>
</html>