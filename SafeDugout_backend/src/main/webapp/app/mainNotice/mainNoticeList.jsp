<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메인 공지사항 목록 페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mainNotice/mainNoticeList.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerLogin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerNoLogin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<%-- <script defer src="${pageContext.request.contextPath}/assets/js/mainNotice/mainNoticeList.js"></script> --%>
</head>

<!-- 바디 -->

<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />
	<!-- 메인 -->
	<main>
		<!-- 메인 컨테이너 -->
		<div class="main-container">
			<!-- 페이지 큰 제목 -->
			<div class="main-title"></div>
			<!-- 페이지 작은 제목 -->
			<div class="main-small-title">공지 사항</div>
			<!-- 메시지 박스 -->
			<div class="main-message-container">
				<!-- 리스트 컨테이너 -->
				<div class="list-container">
					<!-- 목록 상단 바 -->
					<div class="top-bar">
						<!-- 글 번호 텍스트 -->
						<div class="page-number">글 번호</div>
						<!-- 제목 텍스트 -->
						<div class="post-title">제목</div>
						<!-- 작성 일자 텍스트 -->
						<div class="upload-date">작성 일자</div>
					</div>
					<c:choose>
						<c:when test="${not empty mainNoticeList}">
							<c:forEach var="mainNotice" items="${mainNoticeList}">
								<!-- 공지사항 리스트 -->
								<div class="notice-list">
									<!-- 글 번호 -->
									<div class="page-number">
										<c:out value="${mainNotice.getNoticePostNumber()}" />
									</div>
									<!-- 제목 -->
									<div class="post-title">
										<a href="${pageContext.request.contextPath}/main/selectMainDetailOk.ma?noticePostNumber=${mainNotice.noticePostNumber}"> <c:out
												value="${mainNotice.getNoticePostTitle()}" />
										</a>
									</div>
									<!-- 작성 일자 -->
									<div class="upload-date">
										<c:out value="${mainNotice.getNoticePostDate()}" />
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div style="text-align: center;">등록된 공지사항이 없습니다.</div>
						</c:otherwise>
					</c:choose>
				</div>

				<!-- 페이지네이션 컨테이너 -->
				<div class="page-container">
					<!-- 왼쪽 화살표 버튼 -->
					<div class="arrow-button">
						<c:if test="${prev}">
							<a href="${pageContext.request.contextPath}/main/selectMainListOk.ma?page=${startPage - 1}">
								◀</a>
						</c:if>
					</div>
					<!-- 페이지 버튼 -->
					<c:forEach var="i" begin="${startPage < 0 ? 0 : startPage}"
						end="${endPage}">
						<c:choose>
							<c:when test="${!(i == page)}">
								<div class="page-num">
									<a
										href="${pageContext.request.contextPath}/main/selectMainListOk.ma?page=${i}">
										<c:out value="${i}" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="page-num active">
									<a href="#"> <c:out value="${i}" />
									</a>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- 오른쪽 화표 버튼 -->
					<c:if test="${next}">
						<div class="arrow-button">
							<a
								href="${pageContext.request.contextPath}/main/selectMainListOk.ma?page=${endPage + 1}">
								▶</a>
						</div>
					</c:if>
				</div>
			</div>
	</main>
	<!-- 푸터 -->
	<jsp:include page="/footer.jsp" />
	<!-- 스크립트 -->
	<script src="${pageContext.request.contextPath}/assets/js/include.js"></script>
</body>

</html>