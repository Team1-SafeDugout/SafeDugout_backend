<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ë¶íí í¬</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPlayerStats.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamPlayerStats.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main class="team-player-stats">
    <h2>ì ì ê¸°ë¡</h2>
    <!-- í¬ì,íì ë²í¼ -->
    <div class="team-stats-switch">
      <button class="active" data-tab="pitcher">í¬ì</button>
      <button data-tab="batter">íì</button>
    </div>
    <!-- í¬ì ê¸°ë¡ í -->
    <div class="team-stats-table" id="team-pitcher-table">
      <div class="team-stats-header">
        <div>ë²í¸</div>
        <div>ì´ë¦</div>
        <div>ê²½ê¸°</div>
        <div>ìí¬</div>
        <div>ìë´</div>
        <div>ì ë°</div>
        <div>ì¹</div>
        <div>í¨</div>
        <div>ì¸ì´ë¸</div>
        <div>íë</div>
        <div>ì´ë</div>
        <div>ì¤ì </div>
        <div>ìì±</div>
        <div>ERA</div>
        <div>í¼ìí</div>
        <div>í¼íë°</div>
        <div>ë³¼ë·</div>
        <div>ì¬êµ¬</div>
        <div>ì¼ì§</div>
        <div>ë³´í¬</div>
        <div>í­í¬</div>
      </div>
      <div class="team-stats-data">
        <!-- í¬ì ë°ì´í° ë¤ì´ê° ê³µê° -->
      </div>
    </div>
    <!-- íì ê¸°ë¡ í -->
    <!-- íì ê¸°ë¡ í -->
    <div class="team-stats-table" id="team-batter-table" style="display:none;">
      <div class="team-stats-header">
        <div>ë²í¸</div>
        <div>ì´ë¦</div>
        <div>ê²½ê¸°</div>
        <div>íì¨</div>
        <div>íì</div>
        <div>íì</div>
        <div>íì </div>
        <div>ìí</div>
        <div>1ë£¨í</div>
        <div>2ë£¨í</div>
        <div>3ë£¨í</div>
        <div>HR</div>
        <div>ë³¼ë·</div>
        <div>ê³ 4</div>
        <div>ì¬êµ¬</div>
        <div>ì¼ì§</div>
        <div>ë³ì´</div>
        <div>í¬í</div>
        <div>OPS</div>
        <div>ëë£¨</div>
        <div>ëì¤</div>
      </div>
      <div class="team-stats-data">
        <!-- íì ë°ì´í° ë¤ì´ê° ê³µê° -->
      </div>
    </div>
</main>
<div id="team-footer"></div>
</body>
</html>