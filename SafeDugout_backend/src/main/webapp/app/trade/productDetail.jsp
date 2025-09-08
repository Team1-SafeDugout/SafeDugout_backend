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
<title>상품 디테일 페이지</title>
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/productDetailBuyer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">

</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />
    <main>
        <section class="section-background">
            <!-- 상단 작성자/삭제 버튼 -->
			<section class="section-top-menus">
			    <div class="product-info">
			        작성자: <c:out value="${sellPostDetail.memberId}" />
			    </div>
			    <!-- 삭제 버튼: 로그인한 멤버와 작성자 번호가 같으면 표시 -->
			    <form id="deleteForm" action="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr?category=allproduct&action=deletepostok"  method="post">  
			    	<input type="hidden" name="sellPostNumber" value="${sellPostDetail.sellPostNumber}">         
				    <c:if test="${sellPostDetail.memberNumber != null and sessionScope.memberNumber != null and sellPostDetail.memberNumber.toString() == sessionScope.memberNumber.toString()}">	        
				        <button id="deleteButton" class="post-button-delete" >
				            삭제하기
				        </button>
				    </c:if>
			    </form> 
			</section>

            <!-- 중단 요소 -->
            <section class="section-middle-menus">
                <div class="product-info-container">
                    <!-- 상품 이미지 -->
                    <div class="product-image">
                        <c:choose>
                            <c:when test="${not empty sellPostDetail.attachment}">
                                <c:forEach var="file" items="${sellPostDetail.attachment}" varStatus="status">
                                    <c:if test="${status.index == 1}">
                                        <img src="/upload/product/${file.attachmentPath}" alt="상품 이미지">
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png" alt="기본이미지">
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <!-- 카테고리 / 팀 -->
                    <div class="product-info">
                        <c:out value="${sellPostDetail.teamName}" /> > <c:out value="${sellPostDetail.categoryName}" />
                    </div>

                    <!-- 등록 / 수정 날짜 -->
					<!-- 등록 / 수정 날짜 -->
					<div class="product-info">
					    <!-- String -> Date 변환 -->
					    <fmt:parseDate value="${sellPostDetail.sellPostCreationDate}" pattern="yyyy-MM-dd HH:mm:ss" var="creationDate"/>
					    <fmt:parseDate value="${sellPostDetail.sellPostUpdate}" pattern="yyyy-MM-dd HH:mm:ss" var="updateDate"/>
					
					    게시일: <fmt:formatDate value="${creationDate}" pattern="yyyy.MM.dd"/>
					    <br>
					    수정일: <fmt:formatDate value="${updateDate}" pattern="yyyy.MM.dd"/>
					</div>
                </div>

                <!-- 상품 디테일 -->
                <div class="product-detail-container">
                    <div class="product-name">
                        상품 이름:
                        <div><c:out value="${sellPostDetail.sellPostTitle}" /></div>
                    </div>

                    <div class="product-description">
                        상품 설명:
                        <div><c:out value="${sellPostDetail.sellPostContent}" escapeXml="false" /></div>
                    </div>

                    <!-- 거래 정보 -->
                    <div class="trading-info-container">
                        <div class="trading-info">
                            거래 지역:
                            <div><c:out value="${sellPostDetail.tradingArea}" /></div>
                        </div>
                        <div class="trading-info">
                            거래 방식:
                            <div><c:out value="${sellPostDetail.dealtypeName}" /></div>
                        </div>
                    </div>

                    <div class="line"></div>

                    <div class="text-button-container">
                        <div class="product-price">
                            상품 가격:
                            <div>
                                <fmt:formatNumber value="${sellPostDetail.pricePoint}" pattern="#,###" /> 포인트
                            </div>
                        </div>
                        <form action="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr?category=buy&action=buy" method="get">
						    <input type="hidden" name="sellPostNumber" value="${sellPostDetail.sellPostNumber}">
						    <input type="hidden" name="category" value="buy">
    						<input type="hidden" name="action" value="buy">
						    <button type="submit" class="main-button-next">구매</button>
						</form>
                    </div>
                </div>
            </section>

            <!-- 하단 버튼 -->
            <section class="section-bottom-menus">
                <button type="button" class="post-button"
                    onclick="location.href='${pageContext.request.contextPath}/trade/tradeMain.tr'">
                    목록으로
                </button>
            </section>

        </section>
    </main>

    <!-- 푸터 -->
    <jsp:include page="/footer.jsp" />
    <script >
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
   <script src="${pageContext.request.contextPath}/assets/js/trade/productDetail.js"></script>
</body>
</html>
