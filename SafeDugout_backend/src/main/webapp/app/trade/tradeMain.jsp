<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>중고거래 메인페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/trade/tradeMain.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerLogin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerNoLogin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/trade/tradeMain.js"></script>
</head>

<body>
	<!-- 헤더 -->
	<jsp:include page="/headerLogin.jsp" />

	<!-- 검색 폼 -->
	<form action="tradeMainOkController.do" method="get">
		<div class="search-container">
			<input type="text" name="searchWord" placeholder="검색어를 입력해주세요" value="${sellPost.Search}">
			<button type="submit" id="searchBtn">검색</button>
		</div>
	</form>

	<!-- 메인 -->
	<main>
		<div class="main-container">
			<!-- 좌측 카테고리 -->
			<aside>
				<div class="aside-container">
					<div class="aside-text">상품 카테고리</div>
					<ul>
						<li><div class="category"><a href="tradeMainOkController.do">모든 상품 유형</a></div></li>
						<li><div class="category"><a href="tradeMainOkController.do?category=유니폼">유니폼</a></div></li>
						<li><div class="category"><a href="tradeMainOkController.do?category=모자">모자</a></div></li>
						<li><div class="category"><a href="tradeMainOkController.do?category=의류">의류</a></div></li>
						<li><div class="category"><a href="tradeMainOkController.do?category=잡화">잡화</a></div></li>
						<li><div class="category"><a href="tradeMainOkController.do?category=응원용품">응원용품</a></div></li>
						<li><div class="category"><a href="tradeMainOkController.do?category=야구용품">야구용품</a></div></li>
					</ul>
				</div>
			</aside>

			<!-- 우측 메인 영역 -->
			<section class="section-container">
				<!-- 팀 로고 바 -->
				<div class="team-bar">
					<div class="team-bar-text">팀 선택</div>
					<div class="team-bar-logo-container">
						<c:forEach var="team" items="${teamList}">
							<div class="team-bar-logo">
								<a href="tradeMainOkController.do?teamNumber=${team.teamNumber}">
									<img src="${team.logoPath}" alt="${team.teamName}" title="${team.teamName}">
								</a>
							</div>
						</c:forEach>
					</div>
				</div>

				<!-- 검색 결과 & 페이지네이션 -->
				<div class="page-bar">
					<div class="page-bar-text">
						<span class="big-text">[“<c:out value="${sellPost.Search}" default="전체"/>”] 검색 결과</span>
						<span class="small-text"><span id="productCount">${total}</span>개 모든 팀 > 모든 상품 유형</span>
					</div>

					<div class="page-container">
						<c:if test="${prev}">
							<div class="arrow-button"><a href="tradeMainOkController.do?page=${startPage-1}">◀</a></div>
						</c:if>

						<c:forEach var="p" begin="${startPage}" end="${endPage}">
							<div class="page-num">
								<a href="tradeMainOkController.do?page=${p}" class="${p==page ? 'active' : ''}">${p}</a>
							</div>
						</c:forEach>

						<c:if test="${next}">
							<div class="arrow-button"><a href="tradeMainOkController.do?page=${endPage+1}">▶</a></div>
						</c:if>
					</div>
				</div>

				<!-- 상품 리스트 -->
				<div class="product-container">
					<c:if test="${empty sellPostList}">
						<div class="no-result-text">결과 없음</div>
					</c:if>

					<c:forEach var="sellPost" items="${sellPostList}">
						<div class="product-list">
							<div class="product-img">
								<a href="tradeDetailOkController.do?sellPostNumber=${sellPost.sellPostNumber}">
									<img src="${sellPost.imagePath}" alt="상품이미지">
								</a>
							</div>
							<div class="product-name">
								<a href="tradeDetailOkController.do?sellPostNumber=${sellPost.sellPostNumber}">
									${sellPost.sellPostTitle}
								</a>
							</div>
							<div class="product-price">
								<fmt:formatNumber value="${sellPost.pricePoint}" pattern="#,###"/> 포인트
							</div>
							<div class="product-time">${sellPost.postDate}</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</div>
	</main>

	<!-- 푸터 -->
	<jsp:include page="/footer.jsp" />
	<script src="${pageContext.request.contextPath}/assets/js/include.js"></script>
	<script>
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>
</html>
