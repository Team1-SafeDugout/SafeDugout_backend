<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMenu/adminManageTeamYoutube.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminMenu/adminManageTeamYoutube.js"></script>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="body-sidebar">
      <div class="sidebar-div-name">
        관리자 메뉴
      </div>

      <div class="sidebar-div-info">
        <div>
          <div> 관리자 : 백정이 </div>
          <div> 관리자 이메일 : ohohoho@naver.com</div>
        </div>
      </div>

      <div class="sidebar-div-container">
        <div>
          <ul>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminSiteStatisticsOk.ad"> 사이트 통계</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad"> 게시글 / 공지사항</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageFreeCommunityListOk.ad"> 전체 커뮤니티 </a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad"> 팀 뉴스</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTeamYoutubeListOk.ad"> 팀 유튜브</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTeamSongListOk.ad"> 팀 응원가</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageSellListOk.ad"> 판매글</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageTradingListOk.ad"> 거래중인 글</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageMemberListOk.ad"> 회원관리</a> </li>
          </ul>
        </div>
      </div>
    </section>
    <section class="body-container">
      <div class="body-container-name">
        팀유튜브
      </div>
      
      <section class="body-container-list">
        <div class="list-background">

          <div class="list-names">
            <div>글 번호</div>
            <div>팀 명</div>
            <div>유튜브 링크</div>
            <div>수정일자</div>
            <div>
              <form action="" method="get" class="add-button">
                <button type="button" id="add-youtube-button"> 추가하기+ </button>
              </form>
            </div>
          </div>
          <div class="list-container">
            <ul class="list-ul" id="list-ul">

            </ul>
          </div>

          <div class="page-buttons">
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
    </section>

    <section class="section-modal" id="section-modal">
      <div class="modal-background"></div>
      <form action="" method="get" id="modal-form">

        <div class="modal-input-text">
          <label for="song-url"> 유튜브 주소 : </label>
          <input type="url" id="song-url" name=songUrl required>
        </div>

        <div class="modal-input-radio">

          <input type="radio" id="lg" name="team" required>
          <label for="lg"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png"> </label>

          <input type="radio" id="hh" name="team" required>
          <label for="hh"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/HH.png"> </label>

          <input type="radio" id="lotte" name="team" required>
          <label for="lotte"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/LT.png"> </label>

          <input type="radio" id="ssg" name="team" required>
          <label for="ssg"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png"> </label>

          <input type="radio" id="kia" name="team" required>
          <label for="kia"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png"> </label>

          <input type="radio" id="kt" name="team" required>
          <label for="kt"> <img src=".${pageContext.request.contextPath}/assets/img/communityImg/kt.png"> </label>

          <input type="radio" id="nc" name="team" required>
          <label for="nc"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png"> </label>

          <input type="radio" id="samsung" name="team" required>
          <label for="samsung"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/SS.png"> </label>

          <input type="radio" id="doosan" name="team" required>
          <label for="doosan"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png"> </label>

          <input type="radio" id="kiwoom" name="team" required>
          <label for="kiwoom"> <img src="${pageContext.request.contextPath}/assets/img/communityImg/WO.png"> </label>

        </div>

        <div class="modal-buttons">
          <button type="submit" id="save-button"> 저장 </button>
          <button type="button" id="cancle-button"> 취소 </button>
        </div>

      </form>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>