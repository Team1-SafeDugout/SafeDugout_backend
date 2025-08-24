<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 등록/수정 페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/trade/productRegister.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerLogin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerNoLogin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/trade/productRegister.js"></script>
</head>

<body>
	<!-- 헤더 -->
	<jsp:include page="/headerLogin.jsp" />

	<!-- 메인 -->
	<main>
		<div class="main-container">
			<form action="${pageContext.request.contextPath}/sellPostWriteOk.tr"
				method="post" enctype="multipart/form-data"
				onsubmit="return validateForm();">

				<div class="register-container">
					<!-- 이미지 업로드 -->
					<div class="img-container">
						<div class="img-box">
							<img
								src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png"
								alt="" id="previewImg">
							<div>
								<label for="uploadImg">사진 등록 + <input type="file"
									id="uploadImg" name="uploadFile" accept="image/*">
								</label> <span id="deleteImg">삭제 X</span>
							</div>
						</div>
					</div>

					<!-- 중앙 컨테이너 -->
					<div class="middle-container">
						<!-- 상품명 -->
						<div class="name-input-container">
							<div class="register-error-message">• 상품명을 입력하세요</div>
							<div class="product-name-text">
								상품 명 : <input type="text" id="productName" name="sellPostTitle"
									required>
							</div>
						</div>

						<!-- 카테고리 -->
						<div class="category-input-container">
							<div class="product-category-text">
								<span>카테고리 설정</span>
							</div>
							<div class="product-team-text">팀 선택  • 팀을 선택하지 않으면 기타로
								설정됩니다.</div>
							<div class="logo-container">
								<!-- 팀 로고 클릭 시 JS로 value 설정 -->
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png"
										alt="두산" data-team-id="1">
								</div>
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png"
										alt="lg" data-team-id="2">
								</div>
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/HH.png"
										alt="한화" data-team-id="3">
								</div>
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/SS.png"
										alt="삼성" data-team-id="4">
								</div>	
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png"
										alt="ssg" data-team-id="5">
								</div>
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png"
										alt="kt" data-team-id="6">
								</div>
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png"
										alt="nc" data-team-id="7">
								</div>								
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/LT.png"
										alt="롯데" data-team-id="8">
								</div>																						
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png"
										alt="기아" data-team-id="9">
								</div>
								<div class="logo">
									<img
										src="${pageContext.request.contextPath}/assets/img/communityImg/WO.png"
										alt="키움" data-team-id="10">
								</div>
								<input type="text" id="team" name="teamId" readonly>
							</div>
							<div class="product-type-text-container">
								<div class="product-type-text">굿즈 종류 선택</div>
								<div class="register-error-message">굿즈 종류를 하나 선택해 주세요</div>
							</div>
							<div class="product-type">
								<label>유니폼</label><input type="radio" name="categoryId"
									value="uniform">
							</div>
							<div class="product-type">
								<label>모자</label><input type="radio" name="categoryId"
									value="hat">
							</div>
							<div class="product-type">
								<label>의류</label><input type="radio" name="categoryId"
									value="cloths">
							</div>
							<div class="product-type">
								<label>잡화</label><input type="radio" name="categoryId"
									value="etc">
							</div>
							<div class="product-type">
								<label>응원 도구</label><input type="radio" name="categoryId"
									value="cheeringTool">
							</div>
							<div class="product-type">
								<label>야구 용품</label><input type="radio" name="categoryId"
									value="baseballEqu">
							</div>
						</div>
					</div>

					<!-- 오른쪽 컨테이너 -->
					<div class="right-container">
						<div class="product-explain-text">상품 설명</div>
						<div class="product-explain-blank">
							<textarea name="sellPostContent" id="productContent" required></textarea>
						</div>

						<div class="trade-location-container">
							<div>희망 지역 :</div>
							<input type="text" name="tradingArea" required>
						</div>

						<div class="short-line"></div>

						<div class="register-error-message">거래 방식을 선택해 주세요</div>
						<div class="trade-method-container">
							<div>거래 방식 :</div>
							<div class="trade-method-checkbox">
								<span>배송</span> <input type="radio" name="dealTypeId"
									value="deliver"> <span>직거래</span> <input type="radio"
									name="dealTypeId" value="meet">
							</div>
						</div>
						<div class="short-line"></div>
						<div class="register-error-message-price">가격을 입력하세요</div>
						<div class="bottom-container">
							<div class="price-container">
								<div>상품 가격 :</div>
								<input type="number" id="productPoint" name="pricePoint"
									required>
							</div>
							<div class="main-button-container">
								<button type="submit" class="main-button-next" id="registerBtn">상품등록</button>
								<button type="reset" class="main-button-cancel" id="cancelBtn">취소</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</main>
	<!-- 푸터 -->
	<jsp:include page="/footer.jsp" />
	<script>
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>
</html>