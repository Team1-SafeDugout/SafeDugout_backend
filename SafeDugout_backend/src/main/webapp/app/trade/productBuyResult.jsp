<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 구매 완료 페이지</title>
<link rel="stylesheet" href="./../../assets/css/trade/pointBuyResult.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="./../../assets/css/footer.css">
<script defer src="./../../assets/js/trade/pointBuyResult.js"></script>
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
					<div class="container-title">상품 구매 완료</div>
					<!-- 긴 검은선 -->
					<div class="long-line"></div>
					<!-- 출력 컨테이너 -->
					<div class="container-full">
						<!-- 출력 왼쪽 부분 -->
						<div class="pay-info-text">ê²°ì  ê¸ì¡ :</div>
						<!-- 포인트 종류 -->
						<div class="pay-value">100,000 ì</div>
					</div>
					<!-- ì¶ë ¥ê° ì»¨íì´ë -->
					<div class="container-full">
						<!-- ê²°ì  ì ë³´ íì¤í¸ -->
						<div class="pay-info-text">ê²°ì  ë°©ì :</div>
						<!-- ê²°ì  ì ë³´ ê° -->
						<div class="pay-value">ì¹´ë</div>
					</div>
					<!-- ê¸´ ê²ìì (ìëìª½) -->
					<div class="long-line-bottom"></div>
					<!-- ì¶ë ¥ê° ì»¨íì´ë(ìëìª½) -->
					<div class="container-full-bottom">
						<!-- í¬ì¸í¸ ì¢ë¥ -->
						<div class="point-name">íì¬ í¬ì¸í¸ :</div>
						<!-- í¬ì¸í¸ ê° -->
						<div class="point-amount">100000 ì</div>
					</div>
					<!-- 버튼 컨테이너 -->
					<div class="main-button-container">
						<!-- 버튼 컨테이너 a 태그 -->
						<a href="./../mypostlist/myPostList.html"> <!-- 확인 버튼 텍스트 -->
							<div class="main-button-next">íì¸</div>
						</a>
					</div>
				</div>
			</form>
		</div>
	</main>

	<!-- 푸터 -->
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
	<!-- 스크립트 -->
	<script src="./../../assets/js/include.js"></script>
</body>

</html>