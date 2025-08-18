<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ë¶íí í¬</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamBoard.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamBoard.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main>
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
          </li>
          <li class="team-notice-list">
            <a href="#">
              <div>1</div>
              <div>ê³µì§ ì ëª© ìì</div>
              <div>ê´ë¦¬ì</div>
              <div>2025-08-12</div>
            </a>
          </li>
          <!-- ê³µì§ê¸ ë ì¶ê° -->
        </ul>
      </div>
    </div> 

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
      <ul id = "numberlist-ul">
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>3</a></li>
        <li><a>4</a></li>
        <li><a>5</a></li>
      </ul>
      <div id ="right-button"> â· </div>
    </div>
  </main>
  <div id="team-footer"></div>
</body>
</html>