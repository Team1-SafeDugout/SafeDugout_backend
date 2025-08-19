<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<<<<<<< HEAD
  <title>불펜토크</title>
=======
  <title>ë¶íí í¬</title>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamBoard.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamBoard.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main>
<<<<<<< HEAD
    <!-- 공지목록 -->
    <div class="team-notice-container">
      <h2>게시판</h2>
      <div class="team-notice-board">
        <h4>공지글</h4>
        <div class="team-notice-more"><a href="./teamNoticeBoard.html">더보기</a></div>
        <ul id="team-notice-content">
          <li class="team-notice-header">
            <div>글번호</div>
            <div>제목</div>
            <div>작성자</div>
            <div>작성일자</div>
=======
    <!-- ê³µì§ëª©ë¡ -->
    <div class="team-notice-container">
      <h2>ê²ìí</h2>
      <div class="team-notice-board">
        <h4>ê³µì§ê¸</h4>
        <div class="team-notice-more"><a href="./teamNoticeBoard.html">ëë³´ê¸°</a></div>
        <ul id="team-notice-content">
          <li class="team-notice-header">
            <div>ê¸ë²í¸</div>
            <div>ì ëª©</div>
            <div>ìì±ì</div>
            <div>ìì±ì¼ì</div>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
          </li>
          <li class="team-notice-list">
            <a href="#">
              <div>1</div>
<<<<<<< HEAD
              <div>공지 제목 예시</div>
              <div>관리자</div>
              <div>2025-08-12</div>
            </a>
          </li>
          <!-- 공지글 더 추가 -->
=======
              <div>ê³µì§ ì ëª© ìì</div>
              <div>ê´ë¦¬ì</div>
              <div>2025-08-12</div>
            </a>
          </li>
          <!-- ê³µì§ê¸ ë ì¶ê° -->
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
        </ul>
      </div>
    </div> 

<<<<<<< HEAD
    <!-- 게시글 목록 -->
    <div class="team-board-container">
      <div class="team-board-tools-header">
        <h4>게시글</h4>
        <div class="team-board-tools">
          <!-- 검색 창 -->
          <form action="">
            <span>검색</span>
            <input type="text">
            <button>
              <img class="team-board-search" src="${pageContext.request.contextPath}/assets/img/communityImg/freeIconSearch.png" alt="">
            </button>
          </form>
          <!-- 글쓰기 탭 -->
          <a href="./teamPostWriting.html" class="team-board-write">글쓰기</a>
        </div>
      </div>
      <!-- 게시글 리스트 헤더 -->
      <ul class="team-board-content">
        <li class="team-board-header">
          <div>글번호</div>
          <div>제목</div>
          <div>작성자</div>
          <div>작성일자</div>
        </li>
        <!-- 게시글 들어갈 공간 -->
      </ul>
    </div>
    <!-- 페이지 네이션 -->
    <div class = "list-pagenumber">
      <div id ="left-button"> ◁ </div>
=======
    <!-- ê²ìê¸ ëª©ë¡ -->
    <div class="team-board-container">
      <div class="team-board-tools-header">
        <h4>ê²ìê¸</h4>
        <div class="team-board-tools">
          <!-- ê²ì ì°½ -->
          <form action="">
            <span>ê²ì</span>
            <input type="text">
            <button>
              <img class="team-board-search" src="./../../../assets/img/communityImg/freeIconSearch.png" alt="">
            </button>
          </form>
          <!-- ê¸ì°ê¸° í­ -->
          <a href="./teamPostWriting.html" class="team-board-write">ê¸ì°ê¸°</a>
        </div>
      </div>
      <!-- ê²ìê¸ ë¦¬ì¤í¸ í¤ë -->
      <ul class="team-board-content">
        <li class="team-board-header">
          <div>ê¸ë²í¸</div>
          <div>ì ëª©</div>
          <div>ìì±ì</div>
          <div>ìì±ì¼ì</div>
        </li>
        <!-- ê²ìê¸ ë¤ì´ê° ê³µê° -->
      </ul>
    </div>
    <!-- íì´ì§ ë¤ì´ì -->
    <div class = "list-pagenumber">
      <div id ="left-button"> â </div>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
      <ul id = "numberlist-ul">
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>3</a></li>
        <li><a>4</a></li>
        <li><a>5</a></li>
      </ul>
<<<<<<< HEAD
      <div id ="right-button"> ▷ </div>
=======
      <div id ="right-button"> â· </div>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
    </div>
  </main>
  <div id="team-footer"></div>
</body>
</html>