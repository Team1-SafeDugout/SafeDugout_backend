<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="team-header">
  <div class="top-header">
    <div class="team-logo">
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma">
      	<c:choose>
      	<c:when test="${sessionScope.teamNumber == 1}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png" alt="두산 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 3}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/HH.png" alt="hanwha 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 9}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="kia 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 10}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/WO.png" alt="kiwoom 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 6}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png" alt="kt 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 2}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt="lg 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 8}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/LT.png" alt="lotte 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 7}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png" alt="nc 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 4}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/SS.png" alt="삼성 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 5}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png" alt="ssg 로고">
        </c:when>
    	</c:choose>
      </a>
    </div>
    <div class="team-right-link">
      <a href="${pageContext.request.contextPath}/main/selectMainListOk.ma" class="main-notice">
      <c:out value="${recentMainTitle}"/>
      </a>
      <a href="${pageContext.request.contextPath}/main.ma" class="main-logo">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/icoBall.png" alt="메인페이지 로고">
      </a>
    </div>
  </div>
  <div class="bottom-header">
    <nav>
      <ul class="team-menu">
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamStats.html">팀 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamPlayerStats.html">선수 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamYoutube.html">팀 유튜브</a></li>
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamSong.html">팀 응원가</a></li>
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamBoard.html">게시판</a></li>
        <li><a href="${pageContext.request.contextPath}/app/trade/tradeMain.html">굿즈거래</a></li>
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamStadium.html">경기장</a></li>
        <li><a href="${pageContext.request.contextPath}/app/communityHtml/communityTapPage/teamNews.html">팀뉴스</a></li>
        <li class="nav-search">
          <form action="" method="get">
            <input type="text" placeholder="검색">
            <button>
              <img src="${pageContext.request.contextPath}/assets/img/communityImg/freeIconSearch.png" alt="검색">
            </button>
          </form>
        </li>
        <li class="mypage">
        	<c:choose>
        	<c:when test="${empty sessionScope.memberNumber}">
        	<a href="${pageContext.request.contextPath}/member/login.me">로그인</a>
        	</c:when>
        	<c:otherwise>
          	<a href="${pageContext.request.contextPath}/app/mypostlist/myPostList.jsp">
            <img src="${pageContext.request.contextPath}/assets/img/communityImg/icoMypage.png" alt="마이페이지">
          	</a>
          	</c:otherwise>
          	</c:choose>
        </li>
      </ul>
    </nav>
  </div>
</header>
