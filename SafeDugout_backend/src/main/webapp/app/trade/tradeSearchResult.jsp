<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>중고거래 검색결과 페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/trade/tradeSearchResult.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>
<body>
	<jsp:include page="/header.jsp" />
	<!-- 검색 폼 -->
	<div class="search-container">
		<form
			action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr"
			method="get">
			<input type="hidden" name="category" value="search"> <input
				type="hidden" name="action" value="search"> <input
				type="text" name="searchWord" placeholder="검색어를 입력해주세요"
				value="${searchWord != null ? searchWord : ''}">
			<button type="submit">검색</button>
		</form>
	</div>
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

			<!-- 오른쪽 검색 결과 섹션 -->
			<section class="section-container">
				<div class="page-bar">
					<div class="page-bar-text">
						<span class="big-text">[“<c:out value='${param.searchWord}' />”]
							검색 결과
						</span> <span class="small-text"><c:out value="${total}" />개 모든 팀
							> 모든 상품 유형</span>
					</div>
				</div>

				<!-- 검색 결과 상품 목록 -->
				<!-- 상품 리스트 -->
				<div class="product-container">
					<c:choose>
						<c:when test="${not empty sellPostList}">
							<c:forEach var="sellPost" items="${sellPostList}">
								<div class="product-list">
									<!-- 상품 이미지 -->
									<div class="product-img">
										<a
											href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=allproduct&action=detail&sellPostNumber=${sellPost.sellPostNumber}">
											<c:choose>
												<c:when test="${not empty sellPost.imagePath}">
													<img
														src="${pageContext.request.contextPath}/upload/${sellPost.imagePath}"
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
										<fmt:formatNumber value="${sellPost.pricePoint}"
											pattern="#,###" />
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
						</c:when>
						<c:otherwise>
							<div class="no-result-text">검색 결과가 없습니다.</div>
						</c:otherwise>
					</c:choose>
				</div>

				<!-- 페이징 -->
				<div class="page-container">
					<c:if test="${prev}">
						<div class="arrow-button">
							<a
								href="searchController.tr?page=${startPage-1}&searchWord=${param.searchWord}">◀</a>
						</div>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<div class="page-num ${i == page ? 'active' : ''}">
							<a
								href="searchController.tr?page=${i}&searchWord=${param.searchWord}">${i}</a>
						</div>
					</c:forEach>

					<c:if test="${next}">
						<div class="arrow-button">
							<a
								href="searchController.tr?page=${endPage+1}&searchWord=${param.searchWord}">▶</a>
						</div>
					</c:if>
				</div>
			</section>
		</div>
	</main>

	<div id="footer"></div>
</body>
<script>
	let memberNumber = "${sessionScope.memberNumber}";
</script>
</html>
