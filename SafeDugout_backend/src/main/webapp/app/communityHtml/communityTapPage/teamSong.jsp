<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ë¶íí í¬</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamSong.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamSong.js"></script>
  <script defer src="/webapp/assets/js/communityJs/teamInclude.js"></script>
</head>
<body>
  <div id="team-header">

  </div>
  <main>
    <!-- í ììê° -->
    <section class="cheer-section">
      <div class="section-header">
        <h2>í ììê°</h2>
        <a href="./teamSongTeamList.html" class="more-link">ëë³´ê¸°</a>
      </div>
      <div class="cheer-song">
        <button class="last_song">&lt;</button>
        <ul class="thumb-list">
          <!-- <li><div class="thumb"><a href="#">ììê° 1</a></div></li>
          <li><div class="thumb"><a href="#">ììê° 2</a></div></li>
          <li><div class="thumb"><a href="#">ììê° 3</a></div></li>
          <li><div class="thumb"><a href="#">ììê° 4</a></div></li>
          <li><div class="thumb"><a href="#">ììê° 5</a></div></li> -->
        </ul>
        <button class="next_song" >&gt;</button>
      </div>
    </section>
    <!-- ì ì ììê° -->
    <section class="cheer-section">
      <div class="section-header">
        <h2>ì ì ììê°</h2>
        <a href="./teamSongPlayerList.html" class="more-link">ëë³´ê¸°</a>
      </div>
      <div class="cheer-song">
        <button class="last_song">&lt;</button>
        <ul class="thumb-list">
          <li><div class="thumb">
            <a href="https://www.youtube.com/results?search_query=%ED%99%8D%EC%B0%BD%EA%B8%B0+%EC%9D%91%EC%9B%90%EA%B0%80">ììê° 1</a>
          </li>
          <!-- ì ìììê° ì¶ê° ê³µê° -->
        </ul>
        <!-- ì¬ë¼ì´ë© ë²í¼ -->
        <button class="next_song">&gt;</button>
      </div>
    </section>
  </main>
  <div id="team-footer"></div>
</body>
</html>
