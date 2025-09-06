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
	href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/freeCommuntiyList.css">
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
		<!-- 자유게시판 컨테이너 -->
		<div class="free-board-list-container">
			<div class="free-board-container">
				<h4>자유 게시판</h4>
				<a
					href="${pageContext.request.contextPath}/freeCommunity/freeCommunityWrite.fc">글쓰기</a>
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
										<a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityDetail.fc?postNumber=${freeCommunity.postNumber}"> 
											<c:out value="${freeCommunity.postTitle}" />
										</a>
									</div>
									<div>
										<c:out value="${freeCommunity.memberId}" />
									</div>
									<div>
										<fmt:formatDate value="${freeCommunity.postDate}" pattern="yyyy-MM-dd" />
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
							href="${pageContext.request.contextPath}/freeCommunity/freeCommunityListOk.fc?page=${startPage - 1}"
							class="prev">&lt;</a></li>
					</c:if>
					<c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
					<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
						<c:choose>
							<c:when test="${!(i == page) }">
								<li><a
									href="${pageContext.request.contextPath}/freeCommunity/freeCommunityListOk.fc?page=${i}">
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
							href="${pageContext.request.contextPath}/freeCommunity/freeCommunityListOk.fc?page=${endPage + 1}"
							class="next">&gt;</a>
					</c:if>
				</ul>
			</div>
		</div>
	</main>
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
	<script>
		let memberNumber = "${sessionScope.memberNumber}"
	</script>
</body>
</html>