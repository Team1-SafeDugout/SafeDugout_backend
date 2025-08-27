<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminUserDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminUserDetail.js"></script>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <!-- 출력값 -->
      <!-- 최상단 : 유저 아이디, 응원팀, 탈퇴 버튼 -->
      <section class="section-user-info">
        <form action="" method="post">

          <div class="user-info-value">
            ID : <div id="user-id" name="userId"> ${memberDetail.memberId} </div>
          </div>

          <div class="user-info-value">
            응원팀 : <div id="user-team" name="userTeam"> ${myTeam} </div>
          </div>

          <div class="user-info-value">
            <!-- <button type = "button" id = "delete-user-button" class = "delete-btn"> 탈퇴 </button> -->
          </div>
        </form>
      </section>
      <!-- 중단 : 판매글 목록 -->
      <section class= "section-user-sellist">
        <div class="list-background">
          <div class="list-title"> 판매글 목록 </div>

          <div class="list-container">
            <div class="list-names">
              <div>글번호</div>
              <div>제목</div>
              <div>작성일자</div>
            </div>

            <ul class="list-ul" id = "sell-post-list">
              <li class="list-li">
                <div>1</div>
                <div>1</div>
                <div>1</div>
              </li>
            </ul>
          </div>

          <div class = "page-buttons">
            <form action="" method="get">
              <button type="button" id="left-button"> ◁ </button>
              <ul id="numberlist-ul">
                <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
                <li><a>4</a></li>
                <li><a>5</a></li>
              </ul>
              <button type="button" id="right-button"> ▷ </button>
            </form>
          </div>
        </div>
      </section>
      <!-- 중단 : 거래 중인 글 목록 -->
      <section class="section-user-tradinglist">
        <div class="list-background">
          <div class="list-title"> 거래 중 글 목록 </div>

          <div class="list-container">
            <div class="list-names">
              <div>글번호</div>
              <div>제목</div>
              <div>작성일자</div>
              <div>구매자ID</div>
            </div>

            <ul class="list-ul" id = "trade-post-list">
              <li class="list-li">
                <div>1</div>
                <div>1</div>
                <div>1</div>
                <div>1</div>
              </li>
            </ul>
          </div>

          <div class = "page-buttons">
            <form action="" method="get">
              <button type="button" id="left-button"> ◁ </button>
              <ul id="numberlist-ul">
                <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
                <li><a>4</a></li>
                <li><a>5</a></li>
              </ul>
              <button type="button" id="right-button"> ▷ </button>
            </form>
          </div>
        </div>
      </section>

      <!-- 중단 : 게시 글 목록 -->
      <section class="section-user-postlist">
        <div class="list-background">
          <div class="list-title"> 커뮤니티 글 목록 </div>

          <div class="list-container">
            <div class="list-names">
              <div>글번호</div>
              <div>제목</div>
              <div>작성일자</div>
            </div>

            <ul class="list-ul" id = "community-post-list">
              <li class="list-li">
                <div>1</div>
                <div>1</div>
                <div>1</div>
              </li>
            </ul>
          </div>

          <div class = "page-buttons">
            <form action="" method="get">
              <button type="button" id="left-button"> ◁ </button>
              <ul id="numberlist-ul">
                <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
                <li><a>4</a></li>
                <li><a>5</a></li>
              </ul>
              <button type="button" id="right-button"> ▷ </button>
            </form>
          </div>
        </div>
      </section>
      <!-- 최하단 : 목록으로 버튼 -->
      <section class="section-button">
        <form action="" method="post">
          <button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/adminManageMemberListOk.ad'"> 목록으로 </button>
        </form>
      </section>
    </section>  
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
 </body>
</html>