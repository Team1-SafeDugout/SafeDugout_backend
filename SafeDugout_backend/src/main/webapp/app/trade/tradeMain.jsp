<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>중고거래 메인페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/trade/tradeMain.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/trade/tradeMain.js"></script>
</head>

<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />

	<!-- 검색 폼 -->
	<div class="search-container">
	    <form action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr" method="get">
	        <input type="hidden" name="category" value="search">
	        <input type="hidden" name="action" value="search">
	        <input type="text" name="searchWord" placeholder="검색어를 입력해주세요" value="${searchWord != null ? searchWord : ''}">
	        <button type="submit">검색</button>
	    </form>
	</div>

	<!-- 메인 -->
	<main>
		<div class="main-container">
			<!-- 좌측 카테고리 -->
			<aside>
				<div class="aside-container">
					<div class="aside-text">상품 카테고리</div>
					<form
						action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr"
						method="get">
						<input type="hidden" name="category"
							value="${param.category != null ? param.category : 'allproduct'}">

						<c:set var="categories"
							value="list,uniformList,capList,apparelList,accessoriesList,cheeringitemList,baseballgearList" />
						<c:forEach var="cat" items="${fn:split(categories, ',')}">
							<button type="submit" name="action" value="${cat}"
								class="category-btn ${param.category == cat ? 'active' : ''}">
								<c:choose>
									<c:when test="${cat == 'list'}">모든 상품 유형</c:when>
									<c:when test="${cat == 'uniformList'}">유니폼</c:when>
									<c:when test="${cat == 'capList'}">모자</c:when>
									<c:when test="${cat == 'apparelList'}">의류</c:when>
									<c:when test="${cat == 'accessoriesList'}">잡화</c:when>
									<c:when test="${cat == 'cheeringitemList'}">응원용품</c:when>
									<c:when test="${cat == 'baseballgearList'}">야구용품</c:when>
								</c:choose>
							</button>
						</c:forEach>
					</form>
				</div>
			</aside>

			<!-- 우측 메인 영역 -->
			<section class="section-container">
				<!-- 팀 로고 바 -->
				<form
					action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr"
					method="get">
					<input type="hidden" name="action" value="list">

					<div class="team-bar">
						<div class="team-bar-text">팀 선택</div>
						<div class="team-bar-logo-container">
							<c:set var="teamList"
								value="doosan,lg,hanwha,samsung,ssg,kt,nc,lotte,kia,kiwoom" />
							<c:forEach var="teamName" items="${fn:split(teamList, ',')}">
								<button type="submit" name="category" value="${teamName}"
									class="team-bar-logo-btn">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/${teamName}.png"
										alt="${teamName}" title="${teamName}">
								</button>
							</c:forEach>
						</div>
					</div>
				</form>


				<!-- 검색 결과 & 페이지네이션 -->
				<div class="page-bar">
					<div class="page-container">
						<c:if test="${prev}">
							<a
								href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?page=${startPage-1}${not empty searchWord ? '&searchWord=' + searchWord : ''}">◀</a>
						</c:if>

						<c:forEach var="p" begin="${startPage}" end="${endPage}">
							<a
								href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?page=${p}${not empty searchWord ? '&searchWord=' + searchWord : ''}"
								class="${p==page ? 'active' : ''}">${p}</a>
						</c:forEach>

						<c:if test="${next}">
							<a
								href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?page=${endPage+1}${not empty searchWord ? '&searchWord=' + searchWord : ''}">▶</a>
						</c:if>
					</div>
				</div>

				<!-- 상품 리스트 -->
				<div class="product-container">
					<c:if test="${empty sellPostList}">
						<div class="no-result-text">등록된 상품이 없습니다.</div>
					</c:if>

					<c:forEach var="sellPost" items="${sellPostList}">
						<div class="product-list">

							<!-- 상품 이미지 -->
							<div class="product-img">
								<a
									href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=allproduct&action=detail&sellPostNumber=${sellPost.sellPostNumber}">
									<c:choose>
										<c:when test="${not empty sellPost.imagePath}">
											<img
												src="/upload/product/${file.attachmentPath}"
												alt="${sellPost.sellPostTitle}"
												onerror="this.src='${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png'">
										</c:when>
										<c:otherwise>
											<img
												src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png"
												alt="기본이미지">
										</c:otherwise>
									</c:choose>
								</a>
							</div>

							<!-- 상품 제목 -->
							<div class="product-name">
								<a
									href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=allproduct&action=detail&sellPostNumber=${sellPost.sellPostNumber}">
									<c:out value="${sellPost.sellPostTitle}" />
								</a>
							</div>

							<!-- 상품 가격 -->
							<div class="product-price">
								<fmt:formatNumber value="${sellPost.pricePoint}" pattern="#,###" />
								P
							</div>

							<!-- 등록 날짜 -->
							<div class="product-time">
								<c:choose>
									<c:when test="${not empty sellPost.sellPostCreationDate}">
										<fmt:formatDate value="${sellPost.sellPostCreationDate}"
											pattern="yyyy-MM-dd HH:mm" />
									</c:when>
									<c:otherwise>날짜 없음</c:otherwise>
								</c:choose>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</div>
	</main>

	<!-- 푸터 -->
	<jsp:include page="/footer.jsp" />
	<script>
		let memberNumber = "${sessionScope.memberNumber}";
	</script>
</body>
</html>
