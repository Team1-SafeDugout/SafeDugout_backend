<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 정보 수정 비밀번호 입력</title>
  <link rel="stylesheet" href="/webapp/assets/css/memberUpdate/updateInputPassword.css">
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
        <h3>회원 정보 수정</h3>
        <div class="content-box">
          <h3>&nbsp</h3>
          <div class="box-content">
            <span>비밀번호를 입력해주세요.</span>
            <form action=""><span>* 비밀번호가 일치하지 않습니다.</span><input type="text"></form>
          </div>
          <div class="button-container">
            <!-- 확인 버튼 -->
            <a>
              <div class="button-confirm">확인
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

    <section class="buyList">
      <h2>MY페이지</h2>
      <div>
        <ul>
          <li class="post"> <a href="./../myPostList/myPostList.html"> 내가 쓴 게시글</a> </li>
          <li class="commet"> <a href="./../myCommentList/"> 내가 쓴 댓글</a> </li>
          <li class="buy"> <a href="./../buyList/buyList.html"> 구매 내역</a> </li>
          <li class="sell"> <a href="./../buyList/buyList.html"> 판매 내역</a> </li>
          <li class="member-"> <a href="./password.html"> 회원 정보 수정</a> </li>
          <li class="sidebar-elements"> <a href="./../memberWithDrawal/memberPassword.html"> 회원 탈퇴</a> </li>
        </ul>
      </div>
    </section>

    <section class="member-Password">
      <h3>회원 정보 수정</h3>
      <section>
      <li>비밀번호를 입력하시오</li>
      <input type="text" class="team-input" placeholder="">
      <button type="button">확인</button>   
      </section>
    </section>

    <section class="my-point">내 포인트 P</section>
    <a href="./../pointRecharge/pointList.html">포인트 충전 내역 보기</a>
    <a href="./../trade/pointBuy.html">충전</a>
    </section>
  </main>
  <div id="footer"></div>
  <script src="/webapp/assets/js/myPageInclude.js"></script>
</body> -->

</html>