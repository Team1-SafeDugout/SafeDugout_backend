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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/tradeSearchResult.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"href="${pageContext.request.contextPath}/assets/css/trade/tradeSearchResult.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>
<body>
<jsp:include page="/header.jsp" />
<!-- 검색 폼 -->
<form action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr" method="get">
	    <input type="hidden" name="category" value="search">
	    <input type="hidden" name="action" value="search">
	    <input type="text" name="searchWord" placeholder="검색어를 입력해주세요"
	           value="${searchWord != null ? searchWord : ''}">
	    <button type="submit">검색</button>
	</form>
<main>
    <div class="main-container">
        <!-- 좌측 카테고리 -->
        <aside>
            <div class="aside-container">
                <div class="aside-text">상품 카테고리</div>
                <ul>
                    <li><div class="category"><a href="searchController.tr?category=all&searchWord=${param.searchWord}">모든 상품 유형</a></div></li>
                    <li><div class="category"><a href="searchController.tr?category=uniform&searchWord=${param.searchWord}">유니폼</a></div></li>
                    <li><div class="category"><a href="searchController.tr?category=cap&searchWord=${param.searchWord}">모자</a></div></li>
                    <li><div class="category"><a href="searchController.tr?category=apparel&searchWord=${param.searchWord}">의류</a></div></li>
                    <li><div class="category"><a href="searchController.tr?category=accessories&searchWord=${param.searchWord}">잡화</a></div></li>
                    <li><div class="category"><a href="searchController.tr?category=cheering&searchWord=${param.searchWord}">응원용품</a></div></li>
                    <li><div class="category"><a href="searchController.tr?category=gear&searchWord=${param.searchWord}">야구용품</a></div></li>
                </ul>
            </div>
        </aside>

        <!-- 오른쪽 검색 결과 섹션 -->
        <section class="section-container">
            <div class="page-bar">
                <div class="page-bar-text">
                    <span class="big-text">[“<c:out value='${param.searchWord}' />”] 검색 결과</span>
                    <span class="small-text"><c:out value="${total}" />개 모든 팀 > 모든 상품 유형</span>
                </div>
            </div>

            <!-- 검색 결과 상품 목록 -->
            <div class="product-container">
                <c:choose>
                    <c:when test="${not empty sellPostList}">
                        <c:forEach var="product" items="${sellPostList}">
                            <div class="product-list">
                                <div class="product-img">
                                    <a href="productDetail.tr?sellPostNumber=${product.sellPostNumber}">
                                        <img src="${pageContext.request.contextPath}/assets/img/tradeImg/${product.imagePath}" alt="">
                                    </a>
                                </div>
                                <div class="product-name">
                                    <a href="productDetail.tr?sellPostNumber=${product.sellPostNumber}">${product.sellPostTitle}</a>
                                </div>
                                <div class="product-price"><fmt:formatNumber value="${product.pricePoint}" type="number"/> 포인트</div>
                                <div class="product-time"><c:out value="${product.timeDiff}"/></div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="no-result">검색 결과가 없습니다.</div>
                    </c:otherwise>
                </c:choose>
            </div>

            <!-- 페이징 -->
            <div class="page-container">
                <c:if test="${prev}">
                    <div class="arrow-button"><a href="searchController.tr?page=${startPage-1}&searchWord=${param.searchWord}">◀</a></div>
                </c:if>

                <c:forEach var="i" begin="${startPage}" end="${endPage}">
                    <div class="page-num ${i == page ? 'active' : ''}">
                        <a href="searchController.tr?page=${i}&searchWord=${param.searchWord}">${i}</a>
                    </div>
                </c:forEach>

                <c:if test="${next}">
                    <div class="arrow-button"><a href="searchController.tr?page=${endPage+1}&searchWord=${param.searchWord}">▶</a></div>
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
