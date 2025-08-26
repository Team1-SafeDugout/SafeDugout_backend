<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminProductTradingDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script src="${pageContext.request.contextPath}/adminDetailMenu/adminProductTradingDetail.js"></script>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <section class="section-middle-menus">
        <div class="product-info-container">
          <div class="product-image">
            <img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png" alt="">
            <div class="product-slide-buttons">
              <div id="left-slide-button"> ◁ </div>
              <div id="right-slide-button"> ▷ </div>
            </div>
          </div>
        </div>

        <div class="product-detail-container">
          <div class="product-info">
            상품 이름 :
            <div>
              ${sellPostDetail.attachmentPath}
            </div>
          </div>

          <div class="product-price">
            상품 가격 :
            <div>
              ${sellPostDetail.attachmentPath}
            </div>
          </div>

          <div class="product-info">
            상품 카테고리 :
            <div>
              ${sellPostDetail.attachmentPath}>${sellPostDetail.attachmentPath}
            </div>
          </div>

          <div class="product-info">
            판매자 ID :
            <div>
              ${sellPostDetail.attachmentPath}
            </div>
          </div>

          <div class="product-info">
            구매자 ID :
            <div>
              ${sellPostDetail.attachmentPath}
            </div>
          </div>

          <div class="product-info">
            거래 일자 :
            <div>
              ${sellPostDetail.sellPostUpdate}
            </div>
          </div>
        </div>
      </section>

      <section class="section-bottom-menus">
        <div>
          <form action="" method="get">
            <button type = "submit" class = "post-button"> <a href = "${pageContext.request.contextPath}/adminMenu/adminManageTrading.jsp"> 목록으로 </a> </button>
          </form>
        </div>
      </section>
    </section>
  </main>
  <div id="footer"></div>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>
