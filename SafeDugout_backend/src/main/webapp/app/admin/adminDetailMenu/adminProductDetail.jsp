<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminProductDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminProductDetail.js"></script>
  <script>
    const isLogin = <%= (session.getAttribute("adminNumber") != null) ? "true" : "false" %>;
  </script>
  <script src = "${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script> 
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <section class="section-top-menus">
        <div class="product-info"> 작성자 : ${sellPostDetail.memberId} </div>
        <form action="" method="get">
          <button class="post-button" type="button" id = "delete-button"> 삭제하기 </button>
        </form>
      </section>

      <section class="section-middle-menus">
        <div class="product-info-container">
          <div class="product-image">
            <c:choose>
				<c:when test = "${!empty sellPostDetail.attachmentPath}">
					<img src= "/upload/product/${sellPostDetail.attachmentPath}"/>
				</c:when>
				<c:otherwise>
					<img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png" alt="">
				</c:otherwise>
			</c:choose>
            <div class="product-slide-buttons">
              <div id="left-slide-button"> ◁ </div>
              <div id="right-slide-button"> ▷ </div>
            </div>
          </div>
          <div class="product-info"> ${sellPostDetail.teamName}>${sellPostDetail.categoryName} </div>
          <div class="product-info"> ${sellPostDetail.sellPostUpdate} </div>
        </div>

        <div class="product-detail-container">
          <div class="product-name">
            상품 이름 :
            <div>
              ${sellPostDetail.sellPostTitle}
            </div>
          </div>
          <div class="product-description">
            상품 설명 :
            <div>
              ${sellPostDetail.sellPostContent}
            </div>
          </div>

          <div class="trading-info-container">
            <div class="trading-info">
              거래 지역 :
              <div>
                ${sellPostDetail.tradingArea}
              </div>
            </div>

            <div class="trading-info">
              거래 방식 :
              <div>
                ${sellPostDetail.dealTypeName}
              </div>
            </div>
          </div>

          <div class="line"></div>

          <div class="product-price">
            상품 가격 :
            <div>
              ${sellPostDetail.pricePoint}
            </div>
          </div>
        </div>
      </section>

      <section class="section-bottom-menus">
        <div>
          <form action="" method="get">
            <button type = "button" class = "post-button" onclick = "location.href = '${pageContext.request.contextPath}/admin/adminManageSellListOk.ad' "> 목록으로 </button>
          </form>
        </div>
      </section>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>