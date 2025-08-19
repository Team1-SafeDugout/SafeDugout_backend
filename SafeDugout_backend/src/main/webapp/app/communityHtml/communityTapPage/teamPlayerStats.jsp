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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPlayerStats.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamPlayerStats.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
</head>
<body>
  <div id="team-header"></div>
  <main class="team-player-stats">
<<<<<<< HEAD
    <h2>선수 기록</h2>
    <!-- 투수,타자 버튼 -->
    <div class="team-stats-switch">
      <button class="active" data-tab="pitcher">투수</button>
      <button data-tab="batter">타자</button>
    </div>
    <!-- 투수 기록 표 -->
    <div class="team-stats-table" id="team-pitcher-table">
      <div class="team-stats-header">
        <div>번호</div>
        <div>이름</div>
        <div>경기</div>
        <div>완투</div>
        <div>완봉</div>
        <div>선발</div>
        <div>승</div>
        <div>패</div>
        <div>세이브</div>
        <div>홀드</div>
        <div>이닝</div>
        <div>실점</div>
        <div>자책</div>
        <div>ERA</div>
        <div>피안타</div>
        <div>피홈런</div>
        <div>볼넷</div>
        <div>사구</div>
        <div>삼진</div>
        <div>보크</div>
        <div>폭투</div>
      </div>
      <div class="team-stats-data">
        <!-- 투수 데이터 들어갈 공간 -->
      </div>
    </div>
    <!-- 타자 기록 표 -->
    <!-- 타자 기록 표 -->
    <div class="team-stats-table" id="team-batter-table" style="display:none;">
      <div class="team-stats-header">
        <div>번호</div>
        <div>이름</div>
        <div>경기</div>
        <div>타율</div>
        <div>타석</div>
        <div>타수</div>
        <div>타점</div>
        <div>안타</div>
        <div>1루타</div>
        <div>2루타</div>
        <div>3루타</div>
        <div>HR</div>
        <div>볼넷</div>
        <div>고4</div>
        <div>사구</div>
        <div>삼진</div>
        <div>병살</div>
        <div>희타</div>
        <div>OPS</div>
        <div>도루</div>
        <div>도실</div>
      </div>
      <div class="team-stats-data">
        <!-- 타자 데이터 들어갈 공간 -->
=======
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
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
      </div>
    </div>
</main>
<div id="team-footer"></div>
</body>
</html>