<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/login/adminlogin.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminlogin/adminLogin.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
    <section class="section-background">
      <section class="section-top-menus">
        <div class="product-info"> 작성자 </div>
        <form action="" method="get">
          <button class="post-button" type="button" id = "delete-button"> 삭제하기 </button>
        </form>
      </section>

      <section class="section-middle-menus">
        <div class="product-info-container">
          <div class="product-image">
            <img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png" alt="">
            <div class="product-slide-buttons">
              <div id="left-slide-button"> ◁ </div>
              <div id="right-slide-button"> ▷ </div>
            </div>
          </div>
          <div class="product-info"> 두산>야구용품 </div>
          <div class="product-info"> 0000.00.00 </div>
        </div>

        <div class="product-detail-container">
          <div class="product-name">
            상품 이름 :
            <div>
              dfd
            </div>
          </div>
          <div class="product-description">
            상품 설명 :
            <div>
              dfdfdfdfdf
            </div>
          </div>

          <div class="trading-info-container">
            <div class="trading-info">
              거래 지역 :
              <div>
                구리
              </div>
            </div>

            <div class="trading-info">
              거래 방식 :
              <div>
                택배,직거래
              </div>
            </div>
          </div>

          <div class="line"></div>

          <div class="product-price">
            상품 가격 :
            <div>
              5000 포인트
            </div>
          </div>
        </div>
      </section>

      <section class="section-bottom-menus">
        <div>
          <form action="" method="get">
            <button type = "button" class = "post-button" onclick = "location.href = './../adminMenu/adminManageSell.html' "> 목록으로 </button>
          </form>
        </div>
      </section>
    </section>
  </main>
  <div id="footer"></div>
  <script src="${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script>
</body>

</html>