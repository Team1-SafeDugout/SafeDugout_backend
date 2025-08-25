<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 디테일 페이지(구매자)</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/assets/css/trade/productDetailBuyer.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/assets/css/headerLogin.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/assets/css/headerNoLogin.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
    src="${pageContext.request.contextPath}/assets/js/trade/productDetailBuyer.js"></script>
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />

    <main>
        <section class="section-background">

            <!-- 상단 요소들 -->
            <section class="section-top-menus">
                <div class="product-info">
                    작성자 : <c:out value="${sellPost.memberId}" />
                </div>
                <form action="" method="get">
                    <c:if test="${sellPost.memberNumber == sessionScope.memberNumber}">
                        <button class="post-button-delete" type="button"
                            onclick="">
                            삭제하기
                        </button>
                    </c:if>
                </form>
            </section>

            <!-- 중단 요소들 -->
            <section class="section-middle-menus">
                <div class="product-info-container">
                    <!-- 상품 이미지 슬라이드 -->
                    <div class="product-image">
                        <c:choose>
                            <c:when test="${not empty sellPost.attachment}">
                                <c:forEach var="file" items="${sellPost.attachment}" varStatus="status">
                                    <c:if test="${status.index == 0}">
                                        <img src="${pageContext.request.contextPath}/${file.attachmentPath}" alt="상품 이미지">
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png" alt="기본이미지">
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <!-- 카테고리 -->
                    <div class="product-info">
                        <c:out value="${sellPost.teamName}" /> > <c:out value="${sellPost.categoryName}" />
                    </div>

                    <!-- 등록 / 수정 날짜 -->
                    <div class="product-info">
                        게시일 : <fmt:formatDate value="${sellPost.sellPostCreationDate}" pattern="yyyy.MM.dd" />
                        <br>
                        수정일 : <fmt:formatDate value="${sellPost.sellPostUpdate}" pattern="yyyy.MM.dd" />
                    </div>
                </div>

                <!-- 상품 디테일 -->
                <div class="product-detail-container">
                    <div class="product-name">
                        상품 이름 :
                        <div><c:out value="${sellPost.sellPostTitle}" /></div>
                    </div>
                    <div class="product-description">
                        상품 설명 :
                        <div><c:out value="${sellPost.sellPostContent}" escapeXml="false"/></div>
                    </div>

                    <!-- 거래 정보 -->
                    <div class="trading-info-container">
                        <div class="trading-info">
                            거래 지역 :
                            <div><c:out value="${sellPost.tradingArea}" /></div>
                        </div>
                        <div class="trading-info">
                            거래 방식 :
                            <div><c:out value="${sellPost.dealType}" /></div>
                        </div>
                    </div>

                    <div class="line"></div>

                    <div class="text-button-container">
                        <div class="product-price">
                            상품 가격 :
                            <div><fmt:formatNumber value="${sellPost.pricePoint}" /> 포인트</div>
                        </div>
                        <a href="${pageContext.request.contextPath}/trade/productBuy.jsp?sellPostNumber=${sellPost.sellPostNumber}">
                            <div class="main-button-next">구매</div>
                        </a>
                    </div>
                </div>
            </section>

            <!-- 하단 버튼 -->
            <section class="section-bottom-menus">
                <button type="button" class="post-button"
                    onclick="location.href='${pageContext.request.contextPath}/trade/tradeMain.jsp'">목록으로</button>
            </section>
        </section>
    </main>
		<jsp:include page="/footer.jsp" />
    	<script>
    	let memberNumber = "${sessionScope.memberNumber}";
    	</script>
</body>
</html>
