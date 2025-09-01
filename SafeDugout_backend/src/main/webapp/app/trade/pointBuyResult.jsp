<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>포인트 충전 완료 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/pointBuyResult.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/pointBuyResult.js"></script>
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />

    <!-- 메인 -->
    <main>
        <div class="main-container">
            <div class="main-message-container">
                <div class="container-title">포인트 충전 완료</div>
                <div class="long-line"></div>

                <!-- 결제 정보 -->
                <div class="container-full">
                    <div class="pay-info-text">결제 금액 :</div>
                    <div class="pay-value">
                        <fmt:formatNumber value="${chargeAmount}" pattern="#,###" /> 원
                    </div>
                </div>

                <div class="container-full">
                    <div class="pay-info-text">결제 방식 :</div>
                    <div class="pay-value">
                        <c:out value="${payMethod}" />
                    </div>
                </div>

                <div class="long-line-bottom"></div>

                <!-- 현재 포인트 -->
                <div class="container-full-bottom">
                    <div class="point-name">현재 포인트 :</div>
                    <div class="point-amount">
                        <fmt:formatNumber value="${currentPoint}" pattern="#,###" /> 원
                    </div>
                </div>

                <!-- 확인 버튼 -->
                <div class="main-button-container">
                    <a href="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=allproduct&action=list">
                        <div class="main-button-next">확인</div>
                    </a>
                </div>
            </div>
        </div>
    </main>

    <!-- 푸터 -->
    <jsp:include page="/footer.jsp" />
</body>
</html>
