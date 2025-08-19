<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="team-header">
  <div class="top-header">
    <div class="team-logo">
      <a href="${pageContext.request.contextPath}/app/communityHtml/communityMainPage.html">
        <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="kia 로고">
      </a>
    </div>
    <div class="team-right-link">
      <a href="${pageContext.request.contextPath}/app/mainNotice/mainNoticeList.html" class="main-notice">[메인공지]: 불펜토크 사이트 이용 안내</a>
      <a href="${pageContext.request.contextPath}/main.html" class="main-logo">
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
            <input type="text" placeholder="검색" />
            <button>
              <img src="${pageContext.request.contextPath}/assets/img/communityImg/freeIconSearch.png" alt="검색" />
            </button>
          </form>
        </li>
        <li class="mypage">
          <a href="${pageContext.request.contextPath}/app/mypostlist/myPostList.html">
            <img src="${pageContext.request.contextPath}/assets/img/communityImg/icoMypage.png" alt="마이페이지" />
          </a>
        </li>
      </ul>
    </nav>
  </div>
</header>
