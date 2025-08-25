<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>중고거래 메인페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/tradeMain.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/tradeMain.js"></script>
</head>

<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />

	<!-- 검색 폼 -->
	<div class="search-container">
		<form action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr" method="get">
	 		<input type="hidden" name="team" value="search">
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
					<ul>
						<!-- 선택된 팀 유지, 없으면 전체팀 -->
						<c:set var="selectedTeam" value="${param.team != null ? param.team : 'list'}" />

						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=list">모든 상품 유형</a>
							</div>
						</li>
						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=uniformList">유니폼</a>
							</div>
						</li>
						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=capList">모자</a>
							</div>
						</li>
						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=apparelList">의류</a>
							</div>
						</li>
						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=accessoriesList">잡화</a>
							</div>
						</li>
						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=cheeringitemList">응원용품</a>
							</div>
						</li>
						<li>
							<div class="category">
								<a href="SelectController.tr?team=${selectedTeam}&action=baseballgearList">야구용품</a>
							</div>
						</li>
					</ul>
				</div>
			</aside>

			<!-- 우측 메인 영역 -->
			<section class="section-container">
				<!-- 팀 로고 바 -->
				<div class="team-bar">
					<div class="team-bar-text">팀 선택</div>
					<div class="team-bar-logo-container">
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=doosan&action=list">
								<img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png" alt="두산" title="두산">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=lg&action=list"> 
								<img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt="lg" title="lg">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=hanwha&action=list">
								<img src="${pageContext.request.contextPath}/assets/img/communityImg/HH.png" alt="한화" title="한화">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=samsung&action=list"> 
								<img src="${pageContext.request.contextPath}/assets/img/communityImg/SS.png" alt="삼성" title="삼성">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=ssg&action=list"> 
								<img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png" alt="ssg" title="ssg">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=kt&action=list">
								<img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png" alt="kt" title="kt">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=nc&action=list">
								 <img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png" alt="nc" title="nc">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=lotte&action=list">
								 <img src="${pageContext.request.contextPath}/assets/img/communityImg/LT.png" alt="롯데" title="롯데">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=kia&action=list">
								 <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="kia" title="kia">
							</a>
						</div>
						<div class="team-bar-logo">
							<a href="SelectController.tr?team=kiwoom&action=list">
								 <img src="${pageContext.request.contextPath}/assets/img/communityImg/WO.png" alt="키움" title="키움">
							</a>
						</div>
					</div>
				</div>

				<!-- 검색 결과 & 페이지네이션 -->
				<div class="page-bar">
					<div class="page-bar-text">
						<span class="big-text">[“<c:out value="${sellPost.Search}" default="전체" />”]검색 결과</span>
						<span class="small-text">
						<span id="productCount">${total}</span>개 모든 팀 > 모든 상품 유형</span>
					</div>

					<div class="page-container">
					    <c:if test="${prev}">
					        <div class="arrow-button">
					            <a href="tradeFrontController2.tr?page=${startPage-1}
					                <c:if test='${not empty searchWord}'>&searchWord=${searchWord}</c:if>">◀</a>
					        </div>
					    </c:if>
					
					    <c:forEach var="p" begin="${startPage}" end="${endPage}">
					        <div class="page-num">
					            <a href="tradeFrontController2.tr?page=${p}
					                <c:if test='${not empty searchWord}'>&searchWord=${searchWord}</c:if>"
					               class="${p==page ? 'active' : ''}">${p}</a>
					        </div>
					    </c:forEach>
					
					    <c:if test="${next}">
					        <div class="arrow-button">
					            <a href="tradeFrontController2.tr?page=${endPage+1}
					                <c:if test='${not empty searchWord}'>&searchWord=${searchWord}</c:if>">▶</a>
					        </div>
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
								<a href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=allProduct&action=detail&sellPostNumber=${sellPost.sellPostNumber}">
									<img src="${sellPost.imagePath}" alt="상품이미지">
								</a>
							</div>
							<div class="product-name">
								<a href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=allProduct&action=detail&sellPostNumber=${sellPost.sellPostNumber}"">
									${sellPost.sellPostTitle}
								</a>
							</div>
							<div class="product-price">
								<fmt:formatNumber value="${sellPost.pricePoint}" pattern="#,###" />
								포인트
							</div>
							<div class="product-time">${sellPost.sellPostCreationDate}</div>
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
