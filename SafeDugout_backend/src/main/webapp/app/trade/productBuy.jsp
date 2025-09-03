<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 구매 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/productBuy.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />

    <!-- 메인 -->
    <main>
        <div class="main-container">
            <form id="buyForm" method="post" action="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr">
                <input type="hidden" name="sellPostNumber" value="${sellPostDetail.sellPostNumber}" />
                <input type="hidden" name="buyerNumber" value="${sessionScope.memberNumber}" />
                <input type="hidden" name="sellerNumber" value="${sellPostDetail.memberNumber}" />
                <input type="hidden" name="pricePoint" value="${sellPostDetail.pricePoint}" />
                <input type="hidden" name="category" value="buy" />
                <input type="hidden" name="action" value="payment" />

                <div class="main-message-container">
                    <div class="container-title">상품 구매</div>
                    <div class="long-line"></div>

                    <div class="container-full">
                        <!-- 좌측 포인트 정보 -->
                        <div class="container-left">
                            <div class="point-name">현재 보유 포인트</div>
                            <div class="point-amount">
                                <c:out value="${sessionScope.memberPoint != null ? sessionScope.memberPoint : 0}" /> 포인트
                            </div>

                            <div class="point-name">상품 가격</div>
                            <div class="point-amount">
                                <c:out value="${sellPostDetail.pricePoint != null ? sellPostDetail.pricePoint : 0}" /> 포인트
                            </div>
                        </div>

                        <!-- 우측 상품 정보 -->
                        <div class="container-right">
                            <c:forEach var="img" items="${sellPostDetail.attachment}">
                                <div class="product-img">
                                    <img src="<c:out value='${img.attachmentPath != null ? (pageContext.request.contextPath + "/upload/" + img.attachmentPath) : (pageContext.request.contextPath + "/assets/img/tradeImg/default.jpg")}' />" alt="상품 이미지">
                                </div>
                            </c:forEach>
                            <div class="product-text">상품명: <c:out value="${sellPostDetail.sellPostTitle}" /></div>
                            <div class="product-text">거래 방식: <c:out value="${sellPostDetail.dealtypeName != null ? sellPostDetail.dealtypeName : '정보 없음'}" /></div>
                        </div>
                    </div>

                    <div class="short-line"></div>

                    <!-- 결제 후 잔여 포인트 -->
                    <div class="container-full">
                        <div class="container-left-bottom">
                            <div class="point-name">결제 후 잔여 포인트</div>
                            <div class="point-amount">
                                <c:out value="${(sessionScope.memberPoint != null && sellPostDetail.pricePoint != null) ? (sessionScope.memberPoint - sellPostDetail.pricePoint) : 0}" /> 포인트
                            </div>
                        </div>
                    </div>

                    <div class="long-line"></div>

                    <!-- 버튼 -->
                    <div class="main-button-container">
                        <button type="submit" class="main-button-next" id="payBtn">결제</button>
                        <a href="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=allproduct&action=list">
                            <div class="main-button-cancel">취소</div>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </main>

    <!-- 푸터 -->
    <jsp:include page="/footer.jsp" />
    <script >
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>
</html>
