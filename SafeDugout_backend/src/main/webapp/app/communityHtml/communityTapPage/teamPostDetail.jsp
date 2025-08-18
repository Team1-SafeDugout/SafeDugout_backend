<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ê²ìê¸ ìì¸</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPostDetail.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamPostDetail.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main>
    <div class="team-post-container">
      <!-- ê²ìê¸ -->
      <section class="team-post-detail">
        <div class="team-post-header">
          <h2>ì ëª©</h2>
          <div>
            <!-- ìì  ì­ì  ë²í¼ -->
            <button><a href="./teamPostWriting.html">ìì </a></button>
            <button type="button">ì­ì </button>
          </div>
        </div>
        <!-- ìì±ì ì ë³´ -->
        <div class="team-post-info">
          <div class="team-post-num">ê¸ë²í¸:<p>1</p></div>
          <div class="team-post-writer">ìì±ìID:<p>pga0929</p></div>
          <div class="team-post-date">ìì±ì¼ì:<p>250808</p></div>
        </div>
        <!-- ë³¸ë¬¸ -->
        <article class="team-post-main">
          <p>ë´ì©</p>
        </article>
        <a href="./teamBoard.html"><button type="submit">ëª©ë¡</button></a>
      </section>
      <!-- ëê¸ -->
      <section class="team-post-comment">
        <div class="team-comment-header">
          <h2>ëê¸</h2>
        </div>
        <ul class="team-comment-list">
          <li class="comment-item">
            <!-- ëê¸ ì ë³´ -->
            <div class="team-comment-info">
              <span class="comment-author">ìì±ì ID: user01</span>
              <span class="comment-date">2025-08-08</span>
            </div>
            <!-- ëê¸ ë´ì© -->
            <p class="team-comment-text">ëê¸ ë´ì©</p>
            <div class="team-comment-button">
              <form action="">
                <!-- ìì  ì­ì  ë²í¼ -->
                <button type="submit">ìì </button>
                <button type="submit">ì­ì </button>
              </form>
            </div>
          </li>
          <!-- ëê¸ ë±ë¡ ì ë¤ì´ì¬ ê³µê° -->
        </ul>
        <div class="team-comment-area">
        <form action="" method="">
          <!-- ëê¸ ë±ë¡ ê³µê° -->
          <textarea name="" id=""></textarea>
          <button type="submit" class="team-btn-submit">ë±ë¡</button>
        </form>
        </div>
      </section>
    </div>
  </main>
  <div id="team-footer"></div>
</body>
</html>
