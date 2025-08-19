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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamStats.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
  
</head>
<body>
  <div id="team-header"></div>
  <main class="team-stats">
    <div class="team-stats-top-section">
      <div class="team-stats">
<<<<<<< HEAD
        <!-- 시즌 기록 -->
        <section class="team-stats-box">
          <h3>시즌 기록</h3>
          <div class="team-stats-header">
            <div>순위</div>
            <div>경기수</div>
            <div>승</div>
            <div>무</div>
            <div>패</div>
            <div>승률</div>
            <div>타율</div>
            <div>방어율</div>
            <div>득점</div>
            <div>실점</div>
=======
        <!-- ìì¦ ê¸°ë¡ -->
        <section class="team-stats-box">
          <h3>ìì¦ ê¸°ë¡</h3>
          <div class="team-stats-header">
            <div>ìì</div>
            <div>ê²½ê¸°ì</div>
            <div>ì¹</div>
            <div>ë¬´</div>
            <div>í¨</div>
            <div>ì¹ë¥ </div>
            <div>íì¨</div>
            <div>ë°©ì´ì¨</div>
            <div>ëì </div>
            <div>ì¤ì </div>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
          </div>
          <div class="team-stats-row">
          </div>
        </section>
<<<<<<< HEAD
        <!-- 투수 기록 -->
        <section class="team-stats-box">
          <h3>투수 기록</h3>
          <div class="team-stats-header">
            <div>ERA</div>
            <div>선발 ERA</div>
            <div>구원 ERA</div>
            <div>경기</div>
            <div>승</div>
            <div>패</div>
            <div>세이브</div>
            <div>홀드</div>
            <div>삼진</div>
            <div>피안타</div>
            <div>피홈런</div>
            <div>볼넷</div>
            <div>사구</div>
            <div>실점</div>
            <div>자책점</div>
          </div>
          <div class="team-stats-row"></div>
        </section>
        <!-- 타자 기록 -->
        <section class="team-stats-box">
          <h3>타자 기록</h3>
          <div class="team-stats-header">
            <div>AVG</div>
            <div>경기</div>
            <div>타수</div>
            <div>타점</div>
            <div>득점</div>
            <div>1루타</div>
            <div>2루타</div>
            <div>3루타</div>
            <div>HR</div>
            <div>장타율</div>
            <div>출루율</div>
            <div>볼넷</div>
            <div>삼진</div>
          </div>
          <div class="record-row"></div>
        </section>
        <!-- 수비/주루 기록 -->
        <section class="team-stats-box">
          <h3>수비/주루</h3>
          <div class="team-stats-header">
            <div>경기</div>
            <div>실책</div>
            <div>방출</div>
            <div>도루허용</div>
            <div>도루저지</div>
            <div>도루성공률</div>
            <div>견제성공</div>
            <div>견제사</div>
=======
        <!-- í¬ì ê¸°ë¡ -->
        <section class="team-stats-box">
          <h3>í¬ì ê¸°ë¡</h3>
          <div class="team-stats-header">
            <div>ERA</div>
            <div>ì ë° ERA</div>
            <div>êµ¬ì ERA</div>
            <div>ê²½ê¸°</div>
            <div>ì¹</div>
            <div>í¨</div>
            <div>ì¸ì´ë¸</div>
            <div>íë</div>
            <div>ì¼ì§</div>
            <div>í¼ìí</div>
            <div>í¼íë°</div>
            <div>ë³¼ë·</div>
            <div>ì¬êµ¬</div>
            <div>ì¤ì </div>
            <div>ìì±ì </div>
          </div>
          <div class="team-stats-row"></div>
        </section>
        <!-- íì ê¸°ë¡ -->
        <section class="team-stats-box">
          <h3>íì ê¸°ë¡</h3>
          <div class="team-stats-header">
            <div>AVG</div>
            <div>ê²½ê¸°</div>
            <div>íì</div>
            <div>íì </div>
            <div>ëì </div>
            <div>1ë£¨í</div>
            <div>2ë£¨í</div>
            <div>3ë£¨í</div>
            <div>HR</div>
            <div>ì¥íì¨</div>
            <div>ì¶ë£¨ì¨</div>
            <div>ë³¼ë·</div>
            <div>ì¼ì§</div>
          </div>
          <div class="record-row"></div>
        </section>
        <!-- ìë¹/ì£¼ë£¨ ê¸°ë¡ -->
        <section class="team-stats-box">
          <h3>ìë¹/ì£¼ë£¨</h3>
          <div class="team-stats-header">
            <div>ê²½ê¸°</div>
            <div>ì¤ì±</div>
            <div>ë°©ì¶</div>
            <div>ëë£¨íì©</div>
            <div>ëë£¨ì ì§</div>
            <div>ëë£¨ì±ê³µë¥ </div>
            <div>ê²¬ì ì±ê³µ</div>
            <div>ê²¬ì ì¬</div>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
          </div>
          <div class="team-stats-row"></div>
        </section>
      </div>
<<<<<<< HEAD
      <!-- 역대순위 -->
      <aside class="team-stats-history-ranking">
        <h3>역대 순위</h3>
        <div class="team-stats-history-header">
          <div>연도</div>
          <div>경기</div>
          <div>승</div>
          <div>패</div>
          <div>무</div>
          <div>승률</div>
          <div>순위</div>
=======
      <!-- ì­ëìì -->
      <aside class="team-stats-history-ranking">
        <h3>ì­ë ìì</h3>
        <div class="team-stats-history-header">
          <div>ì°ë</div>
          <div>ê²½ê¸°</div>
          <div>ì¹</div>
          <div>í¨</div>
          <div>ë¬´</div>
          <div>ì¹ë¥ </div>
          <div>ìì</div>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
        </div>
        <div class="team-stats-history-row"></div>
      </aside>
    </div>
<<<<<<< HEAD
    <!-- 하단: 우승 년도 -->
    <section class="team-stats-championships">
      <h3>우승 년도</h3>
=======
    <!-- íë¨: ì°ì¹ ëë -->
    <section class="team-stats-championships">
      <h3>ì°ì¹ ëë</h3>
>>>>>>> 1aa90bbfce7ced51fcb73c7408310f55a6e5dc47
      <div class="team-logo-list">
      </div>
    </section>
  </main>
  <div id="team-footer"></div>
</body>
</html>
