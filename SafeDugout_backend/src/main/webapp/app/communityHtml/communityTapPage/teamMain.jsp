<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communitMainPage.css">
  <c:choose>
  	<c:when test="${sessionScope.teamNumber == 1}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/doosanHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/doosanFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 2}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lgHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lgFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 3}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/hanwhaHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/hanwhaFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 4}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/samsungHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/samsungFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 5}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ssgHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ssgFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 6}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ktHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ktFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 7}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ncHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ncFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 8}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lotteHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lotteFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 9}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiaHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiaFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 10}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiwoomHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiwoomFooter.css">
  	</c:when>
  </c:choose>
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script> --%>
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityMainPage.js"></script> --%>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main>
    <div class="main-container">
      <!-- 메인페이지 뉴스 탭 -->
      <section class="team-news">
        <div class="top-section">
          <h2>팀 뉴스</h2>
          <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=news&action=news">더보기</a>
        </div>
        <div class="main-news">
        </div>
        <ul class="news-list">
          <!-- 뉴스리스트 들어갈 공간 -->
          <c:forEach var="newsRow" items="${newsList}">
          	<li>
          	<a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=news&action=newsdetail&postNumber=${newsRow.newsPostNumber}">
          	<c:out value="${newsRow.newsPostTitle}"/>
          	</a>
          	</li>
          </c:forEach>
        </ul>
      </section>
      <!-- 메인페이지 유튜브 탭 -->
      <section class="team-youtube">
        <div class="top-section">
          <h2>팀 유튜브</h2>
          <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=youtube&action=youtube">더보기</a>
        </div>
        <ul class="thumb-list">
        <c:forEach var="youTube" items="${youTubeList}">
        <li><div class="thumb"><a href="<c:out value="${youTube.postLink}"/>" target="_blank">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png<%-- <c:out value="${youTube.attachmentPath}"/> --%>"></a></div></li>
        </c:forEach>
        </ul>
      </section>
      <!-- 메인페이지 경기일정 탭 -->
      <section class="games">
        <h2>경기 일정</h2>
        <div class="game-schedule-group">
          <h4>주중 경기</h4>
          <div class="game-schedule">
          <c:forEach var="scheduleWeekdaysRow" items="${teamScheduleWeekdays}">
            <div class="game-box">
            	<div class="schedule-li-home"><c:out value="${scheduleWeekdaysRow.awayTeamName}"/></div>
                <div class="schedule-li-loc">
                  <div class="schedule-li-loc-text">
                    <c:out value="${scheduleWeekdaysRow.stadiumName}"/>
                  </div>
                </div>
                <div class="schedule-li-away"><c:out value="${scheduleWeekdaysRow.homeTeamName}"/></div>
                <div class="schedule-li-time"><c:out value="${scheduleWeekdaysRow.scheduleDate}"/></div>
            </div>
          </c:forEach>
          </div>
          <h4>주말 경기</h4>
          <div class="game-schedule">
          <c:forEach var="scheduleWeekendsRow" items="${teamScheduleWeekends}">
            <div class="game-box">
            	<div class="schedule-li-home"><c:out value="${scheduleWeekendsRow.awayTeamName}"/></div>
                <div class="schedule-li-loc">
                  <div class="schedule-li-loc-text">
                    <c:out value="${scheduleWeekendsRow.stadiumName}"/>
                  </div>
                </div>
                <div class="schedule-li-away"><c:out value="${scheduleWeekendsRow.homeTeamName}"/></div>
                <div class="schedule-li-time"><c:out value="${scheduleWeekendsRow.scheduleDate}"/></div>
            </div>
          </c:forEach>
          </div>
        </div>
      </section>
      <!-- 게시판 -->
      <section class="team-board">
        <div class="top-section">
          <h2>게시판</h2>
          <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=postlist">더보기</a>
        </div>
        <ul class="team-board-list">
        	<c:forEach var="postRow" items="${postList}">
			<li>
			<a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=detail&postNumber=${postRow.postNumber}">
			<span><c:out value="${postRow.getPostNumber()} | "/></span>
			<span><c:out value="${postRow.getMemberId()} | "/></span>
			<span><c:out value="${postRow.getPostTitle()} | "/></span>
			<span><c:out value="${postRow.getPostDate()}"/></span>
			</li>
			</a>
			</c:forEach>
        </ul>
      </section>
      <!-- 메인페이지 경기장 정보 탭 -->
      <section class="stadium">
        <div class="top-section">
          <h2>경기장 정보</h2>
          <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=stadium&action=stadium&teamNumber=${sessionScope.teamNumber}">더보기</a>
        </div>
        <div class="stadium-img">
        <c:choose>
	      <c:when test="${sessionScope.teamNumber == 1}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/doosanStadium.webp" alt="두산 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 2}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/lgStadium.jpg" alt="lg 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 3}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/hanwhaStadium.webp" alt="한화 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 4}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/samsungStadium.png" alt="삼성 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 5}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/ssgStadium.webp" alt="ssg 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 6}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/ktStadium.jpg" alt="kt 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 7}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/ncStadium.webp" alt="nc 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 8}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/lotteStadium.webp" alt="롯데 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 9}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/kiaStadium.webp" alt="kia 경기장">
	      </c:when>
	      <c:when test="${sessionScope.teamNumber == 10}">
	        <img src="${pageContext.request.contextPath}/assets/img/stadium/kiwoomStadium.webp" alt="키움 경기장">
	      </c:when>	      	      	      	      	      	      	      	      
	    </c:choose>  
        </div>
      </section>
      <!-- 메인페이지 팀순위 탭 -->
      <section class="team-ranking">
        <h2>팀순위</h2>
        <ul class="ranking-list">
          <li class="ranking-list-header">
            <div>순위</div>
            <div>팀</div>
            <div>경기수</div>
            <div>승</div>
            <div>무</div>
            <div>패</div>
            <div>승률</div>
            <div>게임차</div>
          </li>
          <c:forEach var="rankRow" items="${rankList}">
          <li class="ranking-list-team">
            <div><c:out value="${rankRow.teamRank}"/></div>
            <div><c:out value="${rankRow.teamName}"/></div>
            <div><c:out value="${rankRow.gameCount}"/></div>
            <div><c:out value="${rankRow.teamWin}"/></div>
            <div><c:out value="${rankRow.teamDraw}"/></div>
            <div><c:out value="${rankRow.teamLose}"/></div>
            <div><c:out value="${rankRow.teamWinRate}"/></div>
            <div><c:out value="${rankRow.teamGB}"/></div>
          </li>
          </c:forEach>
        </ul>
      </section>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
<!--   <script>
  	let memberNumber = ${sessionScope.memberNumber};
  	let teamNumber = ${sessionScope.teamNumber};
  </script> -->
</body>
</html>