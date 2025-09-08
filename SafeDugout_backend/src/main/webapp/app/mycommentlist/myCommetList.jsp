<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내가 쓴 댓글</title>
  <link rel="stylesheet" href="./../../assets/css/myCommentList/myCommetList.css">
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
        <h3>내가 쓴 댓글</h3>
        <div class="content-box">
          <div class="comment-list">
            <li class="comment-list-top">
              <div class="post-title">게시글 제목</div>
              <div class="post-writer">작성자 ID</div>
              <div class="comment-list-title">작성 내용</div>
              <div class="comment-list-date">작성 일자</div>
              <button type="button" class="comment-list-delete"></button>
            </li>
            <li class="comment-list-row">
              <div class="post-title"><a href="">제목예시1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</a></div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
            </li>
            <li class="comment-list-row">
              <div class="post-title">제목예시1</div>
              <div class="post-writer">1</div>
              <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
              <div class="comment-list-date">2025.01.01</div>
              <button type="button" class="comment-list-delete">삭제하기</button>
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

</html>