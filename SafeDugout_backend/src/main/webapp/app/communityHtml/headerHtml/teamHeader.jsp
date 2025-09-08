<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="team-header${sessionScope.teamNumber}">
  <div class="top-header">
    <div class="team-logo">
      <a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=${sessionScope.teamNumber}">
      	<c:choose>
      	<c:when test="${sessionScope.teamNumber == 1}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png" alt="두산 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 3}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/hanwha.png" alt="hanwha 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 9}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="kia 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 10}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kiwoom.png" alt="kiwoom 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 6}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png" alt="kt 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 2}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt="lg 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 8}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/lotte.png" alt="lotte 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 7}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png" alt="nc 로고">
        </c:when>
      	<c:when test="${sessionScope.teamNumber == 4}">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/samsung.png" alt="삼성 로고">
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
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=record&action=teamRecord">팀 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=record&action=playerRecord">선수 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=youtube&action=youtube">팀 유튜브</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=song&action=teamsong">팀 응원가</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=song&action=playersong">선수 응원가</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=postlist">게시판</a></li>
        <li><a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr">굿즈거래</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=stadium&action=stadium&teamNumber=${sessionScope.teamNumber}">경기장</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=news&action=news">팀뉴스</a></li>
        <li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=notice">공지사항</a></li>
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
