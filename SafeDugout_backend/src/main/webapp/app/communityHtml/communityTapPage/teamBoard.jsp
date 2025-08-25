<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamBoard.css">
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
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamBoard.js"></script>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main>
    <!-- 공지목록 -->
    <div class="team-notice-container">
      <h2>게시판</h2>
      <div class="team-notice-board">
        <h4>공지글</h4>
        <div class="team-notice-more"><a href="./teamNoticeBoard.html">더보기</a></div>
        <ul id="team-notice-content">
          <li class="team-notice-header">
            <div>글번호</div>
            <div>제목</div>
            <div>작성자</div>
            <div>작성일자</div>
          </li>
          <li class="team-notice-list">
            <a href="#">
              <div>1</div>
              <div>공지 제목 예시</div>
              <div>관리자</div>
              <div>2025-08-12</div>
            </a>
          </li>
          <!-- 공지글 더 추가 -->
        </ul>
      </div>
    </div> 

    <!-- 게시글 목록 -->
    <div class="team-board-container">
      <div class="team-board-tools-header">
        <h4>게시글</h4>
        <div class="team-board-tools">
          <!-- 검색 창 -->
          <form action="">
            <span>검색</span>
            <input type="text">
            <button>
              <img class="team-board-search" src="${pageContext.request.contextPath}/assets/img/communityImg/freeIconSearch.png" alt="">
            </button>
          </form>
          <!-- 글쓰기 탭 -->
          <a href="./teamPostWriting.html" class="team-board-write">글쓰기</a>
        </div>
      </div>
      <!-- 게시글 리스트 헤더 -->
      <ul class="team-board-content">
        <li class="team-board-header">
          <div>글번호</div>
          <div>제목</div>
          <div>작성자</div>
          <div>작성일자</div>
        </li>
        <!-- 게시글 들어갈 공간 -->
      </ul>
    </div>
    <!-- 페이지 네이션 -->
    <div class = "list-pagenumber">
      <div id ="left-button"> ◁ </div>
      <ul id = "numberlist-ul">
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>3</a></li>
        <li><a>4</a></li>
        <li><a>5</a></li>
      </ul>
      <div id ="right-button"> ▷ </div>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>