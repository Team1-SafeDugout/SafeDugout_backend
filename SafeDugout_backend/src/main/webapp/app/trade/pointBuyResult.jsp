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
<title>포인트 충전 완료 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/pointBuyResult.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/pointBuyResult.js"></script>
</head>

<!-- 바디 -->
<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />
	<!-- 메인 -->
	<main>
		<!-- 메인 컨테이너 -->
		<div class="main-container">
			<!-- 폼 태그 -->
			<form action="" method="post">
				<!-- 메시지 박스 -->
				<div class="main-message-container">
					<!-- 메시지 박스 제목 -->
					<div class="container-title">포인트 충전 완료</div>
					<!-- 긴 검은선 -->
					<div class="long-line"></div>
					<!-- 출력값 컨테이너 -->
					<div class="container-full">
						<!-- 결제 정보 텍스트 -->
						<div class="pay-info-text">결제 금액 :</div>
						<!-- 결제 정보 값 -->
						<div class="pay-value">100,000 원</div>
					</div>
					<!-- 출력값 컨테이너 -->
					<div class="container-full">
						<!-- 결제 정보 텍스트 -->
						<div class="pay-info-text">결제 방식 :</div>
						<!-- 결제 정보 값 -->
						<div class="pay-value">카드</div>
					</div>
					<!-- 긴 검은선(아래쪽) -->
					<div class="long-line-bottom"></div>
					<!-- 출력값 컨테이너(아래쪽) -->
					<div class="container-full-bottom">
						<!-- 포인트 종류 -->
						<div class="point-name">현재 포인트 :</div>
						<!-- 포인트 값 -->
						<div class="point-amount">100000 원</div>
					</div>
					<!-- 버튼 컨테이너 -->
					<div class="main-button-container">
						<!-- 버튼 컨테이너 a 태그 -->
						<a href=""> <!-- 확인 버튼 텍스트 -->
							<div class="main-button-next">확인</div>
						</a>
					</div>
				</div>
			</form>
		</div>
	</main>

	<!-- 푸터 -->
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
    <script>
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>

</html>