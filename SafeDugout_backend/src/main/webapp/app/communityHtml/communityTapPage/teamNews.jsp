<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ë¶íí í¬</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamNews.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamNews.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main>
    <div class="team-news-container">
      <h2>í ë´ì¤</h2>
      <!-- ë´ì¤ ë°ì¤ -->
      <ul id="team-news-box">
        <li class="team-news-list">
          <a href="./teamNewsDetail.html">
            <span><img src="./../../../assets/img/communityImg/lg.png" alt=""></span>
            <span>íê²© ê¸°ê³ë 4ë² íìë ìëë¤, LG íë°ê¸° íê²© 1ìë 'ìí¼ ë°±ì'</span>
          </a>
        </li>
        <!-- ë´ì¤ ì¶ê° ê³µê° -->
      </ul>
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
    </div>
  </main>
  <div id="team-footer"></div>
</body>
</html>