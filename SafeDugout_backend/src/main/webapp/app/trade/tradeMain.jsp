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
<title>중고거래 메인페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/tradeMain.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer src="${pageContext.request.contextPath}/assets/js/trade/tradeMain.js"></script>
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />

    <!-- 검색 폼 -->
    <div class="search-container">
        <form action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr" method="get">
            <input type="hidden" name="team" value="search">
            <input type="hidden" name="action" value="search"> 
            <input type="text" name="searchWord" placeholder="검색어를 입력해주세요" value="${searchWord != null ? searchWord : ''}"> 
            <button type="submit">검색</button>
       </form>
   </div>

    <!-- 메인 -->
    <main>
        <div class="main-container">
            <!-- 좌측 카테고리 -->
            <aside>
                <div class="aside-container">
                    <div class="aside-text">상품 카테고리</div>
                    <ul>
                        <c:set var="selectedTeam" value="${param.team != null ? param.team : 'allProduct'}" />

                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=list">모든 상품 유형</a></li>
                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=uniformList">유니폼</a></li>
                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=capList">모자</a></li>
                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=apparelList">의류</a></li>
                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=accessoriesList">잡화</a></li>
                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=cheeringitemList">응원용품</a></li>
                        <li><a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=${selectedTeam}&action=baseballgearList">야구용품</a></li>
                    </ul>
                </div>
            </aside>

            <!-- 우측 메인 영역 -->
            <section class="section-container">
                <!-- 팀 로고 바 -->
                <div class="team-bar">
                    <div class="team-bar-text">팀 선택</div>
                    <div class="team-bar-logo-container">
                        <c:set var="teamList" value="doosan,lg,HH,SS,ssg,kt,nc,LT,kia,WO" />
                        <c:forEach var="teamName" items="${fn:split(teamList, ',')}">
                            <div class="team-bar-logo">
                                <a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?category=allProduct&action=list&team=${teamName}">
                                    <img src="${pageContext.request.contextPath}/assets/img/communityImg/${teamName}.png" alt="${teamName}" title="${teamName}">
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                

                <!-- 검색 결과 & 페이지네이션 -->
                <div class="page-bar">
                    <div class="page-bar-text">
                        <span class="big-text">[<c:out value="${searchWord}" default="전체"/>] 검색 결과</span>
                        <span class="small-text">
                        <span id="productCount">${total}</span>개 모든 팀 > 모든 상품 유형</span>
                    </div>
                    <div class="page-container">
                        <c:if test="${prev}">
                            <a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?page=${startPage-1}${not empty searchWord ? '&searchWord=' + searchWord : ''}">◀</a>
                        </c:if>

                        <c:forEach var="p" begin="${startPage}" end="${endPage}">
                            <a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?page=${p}${not empty searchWord ? '&searchWord=' + searchWord : ''}" class="${p==page ? 'active' : ''}">${p}</a>
                        </c:forEach>

                        <c:if test="${next}">
                            <a href="${pageContext.request.contextPath}/trade/tradeFrontController2.tr?page=${endPage+1}${not empty searchWord ? '&searchWord=' + searchWord : ''}">▶</a>
                        </c:if>
                    </div>
                </div>

                <!-- 상품 리스트 -->
                <div class="product-container">
                    <c:if test="${empty sellPostList}">
                        <div class="no-result-text">결과 없음</div>
                    </c:if>

                    <c:forEach var="sellPost" items="${sellPostList}">
                        <div class="product-list">
                            <div class="product-img">
                                <a href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=${selectedTeam}&action=detail&sellPostNumber=${sellPost.sellPostNumber}">
                                    <img src="${sellPost.imagePath}" alt="상품이미지">
                                </a>
                            </div>
                            <div class="product-name">
                                <a href="${pageContext.request.contextPath}/trade/productDetailBuyer.tr?category=${selectedTeam}&action=detail&sellPostNumber=${sellPost.sellPostNumber}">
                                    ${sellPost.sellPostTitle}
                                </a>
                            </div>
                            <div class="product-price">
                                <fmt:formatNumber value="${sellPost.pricePoint}" pattern="#,###" /> 포인트
                            </div>
                            <div class="product-time">
                                <c:out value="${sellPost.sellPostCreationDate != null ? sellPost.sellPostCreationDate : '날짜 없음'}" />
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </div>
    </main>

    <!-- 푸터 -->
    <jsp:include page="/footer.jsp" />
    <script >
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>
</html>
