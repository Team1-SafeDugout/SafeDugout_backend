<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 등록 완료 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/productRegisterResult.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/productRegisterResult.js"></script>
</head>

<!-- 바디 -->

<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />
	<!-- 폼 태그 -->
	<form action="" method="get">
		<!-- 검색 컨테이너 -->
		<div class="search-container">
			<!-- 검색어 입력칸 -->
			<input type="text" placeholder="검색어를 입력해주세요">
			<!-- 검색 버튼 -->
			<button type="button"
				onclick="location.href='./tradeSearchResult.html'">검색</button>
		</div>
	</form>
	<!-- 메인 -->
	<main>
		<!-- 메인 컨테이너 -->
		<div class="main-container">
			<!-- 폼 태그 -->
			<form action="" method="post">
				<!-- 메시지 박스 -->
				<div class="main-message-container">
					<!-- 컨테이너 제목 -->
					<div class="container-title">상품 등록 완료</div>
					<!-- 긴 검은선 -->
					<div class="long-line"></div>
					<!-- 상품 정보 항목 -->
					<div class="container-full">
						<!-- 상품 정보 텍스트 -->
						<div class="register-info-text">상품 명 :</div>
						<!-- 등록 값 -->
						<div class="register-value">[두산베어스] 오리지널 모자</div>
					</div>
					<div class="container-full">
						<div class="register-info-text">거래 방식 :</div>
						<div class="register-value">직거래</div>
					</div>
					<div class="container-full">
						<div class="register-info-text">거래 희망 지역 :</div>
						<div class="register-value">구리</div>
					</div>
					<!-- 긴 검은선 -->
					<div class="long-line"></div>
					<div class="container-full-bottom">
						<div class="register-info-text">상품 가격 :</div>
						<!-- 포인트 값 -->
						<div class="point-amount">15000 포인트</div>
					</div>
				</div>
			</form>
			<!-- 버튼 컨테이너 -->
			<div class="main-button-container">
				<!-- 메인 버튼 컨테이너 -->
				<a href="./productDetailSeller.html"> <!-- 확인 버튼 텍스트 -->
					<div class="main-button-next">확인</div>
				</a>
			</div>
		</div>
	</main>
	<!-- 푸터 -->
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
	<!-- 스크립트 -->
	<script src="${pageContext.request.contextPath}/assets/js/include.js"></script>
</body>

</html>