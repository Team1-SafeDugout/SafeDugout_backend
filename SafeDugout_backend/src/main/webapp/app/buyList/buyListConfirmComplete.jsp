<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>구매 확정 완료 화면</title>
  <link rel="stylesheet" href="./../../assets/css/buyList/buyListConfirmComplete.css">
  <link rel="stylesheet" href="/webapp/assets/css/footer.css">
  <link rel="stylesheet" href="/webapp/assets/css/headerLogin.css">
  <link rel="stylesheet" href="/webapp/assets/css/headerNoLogin.css">
</head>

<body>
  <div id="header"></div>
  <main>
    <div class="main-full">
      <section class="sidebar">
        <h2>MY페이지</h2>
        <div>
          <ul>
            <li class="sidebar-button post"> <a href="./myPostList.html"> 내가 쓴 게시글</a> </li>
            <li class="sidebar-button commet"> <a href="./../myCommentList/myCommetList.html"> 내가 쓴 댓글</a> </li>
            <li class="sidebar-button buy"> <a href="./../buyList/buyList.html"> 구매 내역</a> </li>
            <li class="sidebar-button sell"> <a href="./../sellList/sellList.html"> 판매 내역</a> </li>
            <li class="sidebar-button member-update"> <a href="./../memberInformation/informationInput.html"> 회원 정보
                수정</a></li>
            <li class="sidebar-button member-quit"> <a href="./../memberWithDrawal/memberPassword.html"> 회원 탈퇴</a></li>
          </ul>
        </div>
      </section>

      <section class="main-content">
        <h3>&nbsp</h3>
        <div class="content-box">
          <h3>구매 확정 되었습니다.</h3>
          <div class="post-list">
            <li class="post-list-row">
              <div class="product-list-img">
                <a href="">
                  <img src="/webapp/assets/img/communityImg/tradeLogo.png" alt="">
                </a>
              </div>
              <div class="product-list-info-middle">
                <div class="product-list-title">
                  글 제목 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="">따끈따끈한 글로브 입니다</a>
                </div>
                <div class="product-list-deal-type">
                  <span>거래 방식 :</span> <span>배송</span>
                </div>
                <div class="product-list-seller">
                  <span>판매자 ID :</span> <span>sfeq8474</span>
                </div>
              </div>
              <div class="product-list-info-right">
                <div class="product-list-minus-point">- 1000000 포인트</div>
                <div class="product-list-remain-point">
                  <span>잔여 포인트 :</span> <span>1000000 포인트</span>
                </div>
                <div class="product-list-buy-date">
                  <span>구매 일자 :</span> <span>2025-09-04</span>
                </div>
              </div>
            </li>
          </div>
          <div class="product-list-button-container">
            <!-- 확인 버튼 -->
            <a>
              <div class="product-list-button-confirm">확인
              </div>
            </a>
          </div>
        </div>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value">
          <span>20000</span><span>P</span>
        </div>
        <a href="./../pointRecharge/pointList.html" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="./../trade/pointBuy.html" class="charge-btn">충전</a>
      </section>
    </div>
  </main>
  <div id="footer"></div>
  <script src="/webapp/assets/js/myPageInclude.js"></script>
</body>

<!-- <body>
  <div id="header"></div>
  <main>

    <section class="buy-complete">
      <h2>MY페이지</h2>
      <div>
        <ul>
          <li class="post"> <a href="./../myPostList/myPostList.html"> 내가 쓴 게시글</a> </li>
          <li class="commet"> <a href="./../myCommentList/"> 내가 쓴 댓글</a> </li>
          <li class="buy"> <a href="./buyList.html"> 구매 내역</a> </li>
          <li class="sell"> <a href="./../sellList/sellList.html"> 판매 내역</a> </li>
          <li class="member-"> <a href="./../memberInformation/informationInput.html"> 회원 정보 수정</a> </li>
          <li class="sidebar-elements"> <a href="./../memberWithDrawal/memberPassword.html"> 회원 탈퇴</a> </li>
        </ul>
      </div>
    </section>

    <section class="buy-complete">
      <h3>구매 확정 되었습니다.</h3>
      <section>
        <img src="./../../assets/img/tradeImg/b.png" alt="">
        <div class="left">
          <li>제목 : 야구대표팀 모자팝니다!</li>
          <li>거래 방식 : 직거래</li>
          <li>상품 이름 : 야구대표팀 모자</li>
          <li>판매자 ID : th******</li>
        </div>
        <div class="right">
          <li>가격 : 포인트</li>
          <li>잔여 포인트 : 포인트</li>
          <button type="button">확인</button>
        </div>
      </section>
    </section>

    <section class="my-point">내 포인트 P</section>
    <a href="./../pointRecharge/pointList.html">포인트 충전 내역 보기</a>
    <a href="./../trade/pointBuy.html">충전</a>
    </section>
  </main>
  <div id="footer"></div>
  <script src="/webapp/assets/js/include.js"></script>
</body> -->

</html>