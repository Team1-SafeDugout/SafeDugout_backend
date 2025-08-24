<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 수정/등록 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/productRegister.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/productRegister.js"></script>
</head>
<body>

<jsp:include page="/header.jsp" />
<main>
    <div class="main-container">
        <form action="${pageContext.request.contextPath}/sellPostUpdateOk.tr"
              method="post" enctype="multipart/form-data" onsubmit="return validateForm();">

            <input type="hidden" name="sellPostNumber" value="${sellPost.sellPostNumber}">

            <div class="register-container">

                <!-- 이미지 업로드 -->
                <div class="img-container">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png"
                             alt="" id="previewImg">
                        <div>
                            <label for="uploadImg">사진 등록 + 
                                <input type="file" id="uploadImg" name="uploadFile" accept="image/*">
                            </label>
                            <span id="deleteImg">삭제 X</span>
                        </div>
                    </div>
                </div>

                <!-- 중앙 컨테이너 -->
                <div class="middle-container">
                    <!-- 상품명 -->
                    <div class="name-input-container">
                        <div class="register-error-message">• 상품명을 입력하세요</div>
                        <div class="product-name-text">
                            상품 명 : 
                            <input type="text" id="productName" name="sellPostTitle" value="${sellPost.sellPostTitle}" required>
                        </div>
                    </div>

                    <!-- 카테고리 -->
                    <div class="category-input-container">
                        <div class="product-category-text"><span>카테고리 설정</span></div>
                        <div class="product-team-text">팀 선택 • 팀을 선택하지 않으면 기타로 설정됩니다.</div>
                        <div class="logo-container">
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png" alt="두산" data-team-id="1" ${sellPost.teamId == 1 ? 'class="selected"' : ''}>
                            </div>
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt="lg" data-team-id="2" ${sellPost.teamId == 2 ? 'class="selected"' : ''}>
                            </div>
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/HH.png" alt="한화" data-team-id="3" ${sellPost.teamId == 3 ? 'class="selected"' : ''}>
                            </div>
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/SS.png" alt="삼성" data-team-id="4" ${sellPost.teamId == 4 ? 'class="selected"' : ''}>
                            </div>  
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png" alt="ssg" data-team-id="5" ${sellPost.teamId == 5 ? 'class="selected"' : ''}>
                            </div>
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png" alt="kt" data-team-id="6" ${sellPost.teamId == 6 ? 'class="selected"' : ''}>
                            </div>
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png" alt="nc" data-team-id="7" ${sellPost.teamId == 7 ? 'class="selected"' : ''}>
                            </div>                              
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/LT.png" alt="롯데" data-team-id="8" ${sellPost.teamId == 8 ? 'class="selected"' : ''}>
                            </div>                                                                                      
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="기아" data-team-id="9" ${sellPost.teamId == 9 ? 'class="selected"' : ''}>
                            </div>
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/WO.png" alt="키움" data-team-id="10" ${sellPost.teamId == 10 ? 'class="selected"' : ''}>
                            </div>
                            <input type="text" id="team" name="teamId" readonly value="${sellPost.teamId}">
                        </div>

                        <div class="product-type-text-container">
                            <div class="product-type-text">굿즈 종류 선택</div>
                        </div>

                        <div class="product-type">
                            <label>유니폼</label>
                            <input type="radio" name="categoryId" value="uniform" ${sellPost.categoryId == 'uniform' ? 'checked' : ''}>
                        </div>
                        <div class="product-type">
                            <label>모자</label>
                            <input type="radio" name="categoryId" value="hat" ${sellPost.categoryId == 'hat' ? 'checked' : ''}>
                        </div>
                        <div class="product-type">
                            <label>의류</label>
                            <input type="radio" name="categoryId" value="cloths" ${sellPost.categoryId == 'cloths' ? 'checked' : ''}>
                        </div>
                        <div class="product-type">
                            <label>잡화</label>
                            <input type="radio" name="categoryId" value="etc" ${sellPost.categoryId == 'etc' ? 'checked' : ''}>
                        </div>
                        <div class="product-type">
                            <label>응원 도구</label>
                            <input type="radio" name="categoryId" value="cheeringTool" ${sellPost.categoryId == 'cheeringTool' ? 'checked' : ''}>
                        </div>
                        <div class="product-type">
                            <label>야구 용품</label>
                            <input type="radio" name="categoryId" value="baseballEqu" ${sellPost.categoryId == 'baseballEqu' ? 'checked' : ''}>
                        </div>
                    </div>
                </div>

                <!-- 오른쪽 컨테이너 -->
                <div class="right-container">
                    <div class="product-explain-text">상품 설명</div>
                    <div class="product-explain-blank">
                        <textarea name="sellPostContent" id="productContent" required>${sellPost.sellPostContent}</textarea>
                    </div>

                    <div class="trade-location-container">
                        <div>희망 지역 :</div>
                        <input type="text" name="tradingArea" value="${sellPost.tradingArea}" required>
                    </div>

                    <div class="short-line"></div>

                    <div class="register-error-message">거래 방식을 선택해 주세요</div>
                    <div class="trade-method-container">
                        <div>거래 방식 :</div>
                        <div class="trade-method-checkbox">
                            <span>배송</span>
                            <input type="radio" name="dealTypeId" value="deliver" ${sellPost.dealtypeIdStr == 'deliver' ? 'checked' : ''}>
                            <span>직거래</span>
                            <input type="radio" name="dealTypeId" value="meet" ${sellPost.dealtypeIdStr == 'meet' ? 'checked' : ''}>
                        </div>
                    </div>

                    <div class="short-line"></div>
                    <div class="register-error-message-price">가격을 입력하세요</div>
                    <div class="bottom-container">
                        <div class="price-container">
                            <div>상품 가격 :</div>
                            <input type="number" id="productPoint" name="pricePoint" value="${sellPost.pricePoint}" required>
                        </div>
                        <div class="main-button-container">
                            <button type="submit" class="main-button-next">수정 완료</button>
                            <button type="button" class="main-button-cancel" onclick="history.back();">취소</button>
                        </div>
                    </div>
                </div>

            </div>
        </form>
    </div>
</main>

<jsp:include page="/footer.jsp" />

</body>
</html>
