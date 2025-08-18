<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ë¶íí í¬</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamYoutube.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamYoutube.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main>
    <section class="youtube-section">
      <!-- ì íë¸ ë¦¬ì¤í¸ í¤ë -->
      <div class="section-header">
        <h2>í ì íë¸</h2>
        <div class="header-links">
          <a href="#" class="site-link">í ì íë¸ ê³µì ì¬ì´í¸ ë°ë¡ê°ê¸°</a>
          <a href="./teamYoutubeList.html" class="more-link">ëë³´ê¸°</a>
        </div>
      </div>
      <!-- ì íë¸ ì¸ë¤ì¼ -->
      <div class="team-youtube">
        <!-- ì¬ë¼ì´ë© ë²í¼ -->
        <button class="last-youtube">&lt;</button>
        <!-- ì íë¸ ì¸ë¤ì¼ ë¦¬ì¤í¸ -->
        <ul class="thumb-list">
          <!-- ì¸ë¤ì¼ ë¤ì´ì¬ ê³µê° -->
        </ul>
        <!-- ì¬ë¼ì´ë© ë²í¼ -->
        <button class="next-youtube">&gt;</button>
      </div>
    </section>
  </main>
  <div id="team-footer"></div>
</body>
</html>