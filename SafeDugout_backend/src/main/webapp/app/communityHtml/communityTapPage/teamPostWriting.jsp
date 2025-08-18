<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ë¶íí í¬</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPsotWriting.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamPostWriting.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <!-- ê²ìê¸ ìì± ì»¨íì´ë -->
  <main class="team-post-container">
    <h2 class="team-post-title">ê²ìë¬¼ ìì±</h2>
    <div class="team-form-row">
      <!-- ê²ìê¸ ì ëª© ìë ¥ -->
      <label class="team-label">ì ëª©:</label>
      <input type="text" class="team-input" placeholder="ì ëª©ì ìë ¥íì¸ì">
    </div>
    <!-- ê²ìê¸ ìì±ì ì ë³´ ìë ¥ -->
    <div class="team-form-row">
      <label class="team-label">ìì±ì:</label>
      <input type="text" class="team-input" placeholder="ìì±ì ì´ë¦">
    </div>
    <div class="team-form-section">
      <!-- ê¸ê¼´ ë° ìì ê³µê° -->
      <div class="team-section-header">ê¸ê¼´ ë° ìì</div>
      <div class="team-textarea-wrap">
        <!-- ë³¸ë¬¸ ë´ì©ìì±ê³µê° -->
        <label class="team-label">ë´ì©ìì±</label>
        <textarea class="team-textarea" placeholder="ë´ì©ì ìë ¥íì¸ì"></textarea>
      </div>
    </div>
    <!-- íì¼ ì²¨ë¶ -->
    <div class="team-file-section">
      <span class="team-file-info">* íì¼ì 1ê°ë§ ìë¡ë ê°ë¥í©ëë¤
      * ì´ë¯¸ì§íì¼ 10MB ì´ì ë¶ê°
      * ìì  ì ì²¨ë¶ë íì¼ì´ ì­ì ë©ëë¤</span>
      <div class="team-file-actions">
        <button class="team-file-btn">íì¼ ìë¡ë</button>
        <button class="team-file-btn team-delete-btn">ì­ì </button>
      </div>
    </div>
    <!-- ë±ë¡ ì·¨ì ë²í¼ -->
    <div class="team-button-wrap">
      <!-- <form action=""> -->
        <button class="team-submit-btn">ë±ë¡</button>
        <button class="team-cancel-btn">ì·¨ì</button>
      <!-- </form> -->
    </div>
  </main>
  <div id="team-footer"></div>
</body>
</html>
