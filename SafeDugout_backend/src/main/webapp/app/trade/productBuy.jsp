<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 구매 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/productBuy.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/productBuy.js"></script>
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
					<div class="container-title">상품 구매</div>
					<!-- 긴 검은선 -->
					<div class="long-line"></div>
					<!-- 출력 컨테이너 -->
					<div class="container-full">
						<!-- 출력 왼쪽 부분 -->
						<div class="container-left">
							<!-- 포인트 종류 -->
							<div class="point-name">
								현재 보유 포인트 <br> <br>
							</div>
							<!-- 포인트 값 -->
							<div class="point-amount">
								163000 포인트 <br> <br> <br>
							</div>
							<!-- 포인트 종류 -->
							<div class="point-name">
								상품 가격 <br> <br>
							</div>
							<!-- 포인트 값 -->
							<div class="point-amount">
								20000 포인트 <br> <br>
							</div>
						</div>
						<!-- 출력 오른쪽 부분 -->
						<div class="container-right">
							<!-- 상품 이미지 -->
							<div class="product-img">
								<img
									src="${pageContext.request.contextPath}/assets/img/tradeImg/product6.jpg"
									alt="">
							</div>
							<!-- 상품 정보 텍스트 -->
							<div class="product-text">상품 명 : 상품 명 : [두산] 두산베어스X케이스티파이
								TICKET 케이스</div>
							<!-- 상품 정보 텍스트 -->
							<div class="product-text">거래 방식 : 택배 발송 / 직거래</div>
						</div>
					</div>
					<!-- 짧은 검은선 -->
					<div class="short-line"></div>
					<!-- 출력 컨테이너 -->
					<div class="container-full">
						<!-- 출력 왼쪽 아래 -->
						<div class="container-left-bottom">
							<!-- 포인트 종류 -->
							<div class="point-name">
								결제 후 잔여 포인트 <br> <br>
							</div>
							<!-- 포인트 값 -->
							<div class="point-amount">
								143000 포인트 <br> <br>
							</div>
						</div>
						<div></div>
					</div>
					<!-- 긴 검은선 -->
					<div class="long-line"></div>
					<!-- 버튼 컨테이너 -->
					<div class="main-button-container">
						<!-- 버튼 컨테이너 a 태그 -->
						<a id="payBtn"> <!-- 결제 버튼 텍스트 -->
							<div class="main-button-next">결제</div>
						</a>
						<!-- 버튼 컨테이너 a 태그 -->
						<a href="./productDetailBuyer.html"> <!-- 취소 버튼 텍스트 -->
							<div class="main-button-cancel">취소</div>
						</a>
					</div>
				</div>
			</form>
		</div>
	</main>

	<!-- 푸터 -->
	<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
	<!-- 스크립트 -->
	<script src="${pageContext.request.contextPath}/assets/js/include.js"></script>
</body>

</html>