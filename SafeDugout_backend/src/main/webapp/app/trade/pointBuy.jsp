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
<title>포인트 충전 결제 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/pointBuy.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerLogin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerNoLogin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />

    <!-- 메인 -->
    <main>
        <div class="main-container">
            <form action="${pageContext.request.contextPath}/trade/sellPostFrontController2?category=charging&action=charging" method="post">
                
                <!-- 회원 번호 전달 -->
                <input type="hidden" name="memberNumber" value="${sessionScope.memberNumber}" />

                <!-- 메시지 박스 -->
                <div class="main-message-container">
                    <div class="container-title">포인트 충전</div>
                    <div class="long-line"></div>

                    <!-- 입력 오류 메시지 -->
                    <div class="input-error-message" style="display:none;">• 충전 금액을 입력하세요</div>

                    <!-- 포인트 입력 -->
                    <div class="container-full">
                        <div class="input-message">충전 금액 :</div>
                        <div class="point-amount">
                            <input type="number" name="chargePoint" placeholder="포인트 입력" id="pointValue" required>원                            
                        </div>
                    </div>

                    <div class="container-full"><div class="short-line"></div></div>
                    <div class="long-line"></div>

                    <!-- 버튼 -->
                    <div class="main-button-container">
                        <button type="submit" class="main-button-next" id="payBtn">결제</button>
                        <a href="${pageContext.request.contextPath}/mypostlist/myPostList.html">
                            <div class="main-button-cancel">취소</div>
                        </a>
                    </div>

                    <div class="container-full">결제 방식</div>
                    <div class="long-line"></div>

                    <!-- 결제방식 선택 (필요 시 추가) -->
                    <div class="pay-select-container"></div>
                </div>
            </form>
        </div>
    </main>

    <!-- 푸터 -->
    <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />

</body>
</html>
