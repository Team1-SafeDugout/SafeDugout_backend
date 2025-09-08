<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>포인트 충전 내역</title>
  <link rel="stylesheet" href="/webapp/assets/css/pointCharge/pointChargeList.css">
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
            <li class="sidebar-button member-update"> <a href="./../memberInformation/informationInput.html"> 회원 정보 수정</a></li>
            <li class="sidebar-button member-quit"> <a href="./../memberWithDrawal/memberPassword.html"> 회원 탈퇴</a></li>
          </ul>
        </div>
      </section>

      <section class="main-content">
        <h3>포인트 충전 내역</h3>
        <div class="content-box">
          <div class="post-list">
            <li class="post-list-top">
              <div class="post-list-number">충전 금액</div>
              <div class="post-list-title">충전 후 포인트</div>
              <div class="post-list-date">충전 날짜</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.06</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.05</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.04</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.03</div>
            </li>
            <li class="post-list-row">
              <div class="post-list-number">10000 포인트</div>
              <div class="post-list-title">10000 포인트</div>
              <div class="post-list-date">2025.09.02</div>
            </li>
          </div>
          <div class="pagination">
            <a href="">◁</a>
            <ul id="numberlist-ul">
              <li><a href="">1</a></li>
              <li><a href="">2</a></li>
              <li><a href="">3</a></li>
              <li><a href="">4</a></li>
              <li><a href="">5</a></li>
            </ul>
            <a href="">▷</a>
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

    <section class="buyList">
      <h2>MY페이지</h2>
      <div>
        <ul>
          <li class="post"> <a href="./../myPostList/myPostList.html"> 내가 쓴 게시글</a> </li>
          <li class="commet"> <a href="./../myCommentList/"> 내가 쓴 댓글</a> </li>
          <li class="buy"> <a href="./../buyList/buyList.html"> 구매 내역</a> </li>
          <li class="sell"> <a href="./../sellList/sellList.html"> 판매 내역</a> </li>
          <li class="member-"> <a href="./../memberInformation/informationInput.html"> 회원 정보 수정</a> </li>
          <li class="sidebar-elements"> <a href="./../memberWithDrawal/memberPassword.html"> 회원 탈퇴</a> </li>
        </ul>
      </div>
    </section>

    <section class="pointRecharge-list">
      <h3>포인트 충전 내역</h3>
      <section>
        <div class="list-name">
          <li>충전 금액</li>
          <li>충전 후 포인트</li>
          <li>충전 날짜</li>
        </div>
      </section>

      <section class="point-list">
        <div class="point-listnumber">
          <li>10포인트</li>
          <li>10포인트</li>
          <li>2025.03.21</li>
        </div>
        <div class="point-listnumber">
          <li>10포인트</li>
          <li>20포인트</li>
          <li>2025.03.22</li>
        </div>
        <div class="point-listnumber">
          <li>10포인트</li>
          <li>30포인트</li>
          <li>2025.03.23</li>
        </div>
        <div class="point-listnumber">
          <li>10포인트</li>
          <li>40포인트</li>
          <li>2025.03.24</li>
        </div>
      </section>

      <div class="postlist-pagenumber">
        <form action="" method="get">
          <button type="button" id="left-button"> ◁ </button>
          <ul id="numberlist-ul">
            <li><a>1</a></li>
            <li><a>2</a></li>
            <li><a>3</a></li>
            <li><a>4</a></li>
            <li><a>5</a></li>
          </ul>
          <button type="button" id="right-button"> ▷ </button>
        </form>
      </div>




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