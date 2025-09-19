<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPlayerStats.css">
  <c:choose>
  	<c:when test="${sessionScope.teamNumber == 1}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/doosanHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/doosanFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 3}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/hanwhaHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/hanwhaFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 9}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiaHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiaFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 10}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiwoomHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiwoomFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 6}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ktHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ktFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 2}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lgHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lgFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 8}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lotteHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lotteFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 7}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ncHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ncFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 4}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/samsungHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/samsungFooter.css">
  	</c:when>
  	<c:when test="${sessionScope.teamNumber == 5}">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ssgHeader.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ssgFooter.css">
  	</c:when>
  </c:choose>
  <script src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamPlayerStats.js"></script>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main class="team-player-stats">
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
        <div>팀명</div>
        <div>ERA</div>
        <div>경기</div>
        <div>승</div>
        <div>패</div>
        <div>세이브</div>
        <div>홀드</div>
        <div>승률</div>
        <div>이닝</div>
        <div>피안타</div>
        <div>피홈런</div>
        <div>볼넷</div>
        <div>사구</div>
        <div>삼진</div>
        <div>실점</div>
        <div>자책점</div>
        <div>WHIP</div>
      </div>
      <div class="team-stats-data">
        <!-- 투수 데이터 들어갈 공간 -->
         <div class="team-stats-data">
         <c:forEach var="pitcher" items="${playerStatsList}">
            <div class="player-row">
                <div><c:out value="${pitcher.playerNumber}"/></div>
                <div><c:out value="${pitcher.playerName}"/></div>
                <div><c:out value="${pitcher.teamName}"/></div>
                <div><c:out value="${pitcher.era}"/></div>
                <div><c:out value="${pitcher.game}"/></div>
                <div><c:out value="${pitcher.w}"/></div>
                <div><c:out value="${pitcher.l}"/></div>
                <div><c:out value="${pitcher.sv}"/></div>
                <div><c:out value="${pitcher.hld}"/></div>
                <div><c:out value="${pitcher.wpct}"/></div>
                <div><c:out value="${pitcher.ip}"/></div>
                <div><c:out value="${pitcher.h}"/></div>
                <div><c:out value="${pitcher.hr}"/></div>
                <div><c:out value="${pitcher.bb}"/></div>
                <div><c:out value="${pitcher.hbp}"/></div>
                <div><c:out value="${pitcher.so}"/></div>
                <div><c:out value="${pitcher.r}"/></div>
                <div><c:out value="${pitcher.er}"/></div>
                <div><c:out value="${pitcher.whip}"/></div>
            </div>
        </c:forEach>
      </div>
        
      </div>
    </div>
    <!-- 타자 기록 표 -->
    <div class="team-stats-table" id="team-batter-table" style="display:none;">
      <div class="team-stats-header">
        <div>번호</div>
        <div>이름</div>
        <div>팀명</div>
        <div>타율</div>
        <div>경기</div>   
        <div>타석</div>
        <div>타수</div>
        <div>득점</div>
        <div>안타</div>
        <div>2루타</div>
        <div>3루타</div>
        <div>홈런</div>
		<div>루타</div>
		<div>타점</div>
		<div>희생번트</div>
		<div>희생플라이</div>
      </div>
      <div class="team-stats-data">
        <!-- 타자 데이터 들어갈 공간 -->
        <c:forEach var="batter" items="${playerStatsList}">
            <div class="player-row">
                <div><c:out value="${batter.playerNumber}"/></div>
                <div><c:out value="${batter.plyerName}"/></div>
                <div><c:out value="${batter.teamName}"/></div>
                <div><c:out value="${batter.avg}"/></div>
                <div><c:out value="${batter.game}"/></div>
                <div><c:out value="${batter.pa}"/></div>
                <div><c:out value="${batter.ab}"/></div>
                <div><c:out value="${batter.r}"/></div>
                <div><c:out value="${batter.h}"/></div>
                <div><c:out value="${batter.doublehit}"/></div>
                <div><c:out value="${batter.triplehit}"/></div>
                <div><c:out value="${batter.hr}"/></div>
                <div><c:out value="${batter.tb}"/></div>
                <div><c:out value="${batter.rib}"/></div>
                <div><c:out value="${batter.sac}"/></div>
                <div><c:out value="${batter.sf}"/></div>
            </div>
        </c:forEach>
      </div>
    </div>
</main>
<jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
  <script >
    let memberNumber = "${sessionScope.memberNumber}";
    let teamNumber ="${sessionScope.teamNumber}";
  </script>
</body>
</html>
