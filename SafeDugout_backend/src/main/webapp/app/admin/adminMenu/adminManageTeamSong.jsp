<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>팀 응원가</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMenu/adminManageTeamSong.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  
  <script>
    let posts = [];
    <c:forEach var="board" items="${boardList}">
    	posts.push({
            number: "${board.postNumber}", 
            teamtype: "${board.teamNumber}",
            title: "${board.postTitle}",
            link: "${board.postLink}",
            date: "${board.postDate}"
        });
    	console.log("${board.teamNumber}");
    </c:forEach>
    const contextPath = "${pageContext.request.contextPath}";
  </script>  
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminMenu/adminManageTeamSong.js"></script>
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
          <div> 관리자 : ${sessionScope.adminInfo.adminId} </div>
          <div> 관리자 이메일 : ${sessionScope.adminInfo.adminEmail}</div>
        </div>
      </div>

      <div class="sidebar-div-container">
        <div>
          <ul>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminSiteStatisticsOk.ad"> 사이트 통계</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad?currentTab=all"> 공지사항</a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageFreeCommunityListOk.ad"> 전체 커뮤니티 </a> </li>
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminManageUserPostListOk.ad?currentTab=all"> 게시글 </a> </li>
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
        팀 응원가
      </div>

      <section class="body-container-list">
        <div class="list-background">

          <div class="list-names">
            <div>글 번호</div>
            <div>팀 명</div>
            <div>응원가명</div>
            <div>링크</div>
            <div>수정일자</div>
            <div>
              <form action="" method="get" class="add-button">
                <button type="button" id="add-song-button"> 추가하기+ </button>
              </form>
            </div>
          </div>
          <div class="list-container">
            <ul class="list-ul" id="list-ul">

            </ul>
          </div>

	      <div class="pagination">
	        <ul>
	          
	          <c:if test="${prev}">
	          	<li><a href="${pageContext.request.contextPath}/admin/adminManageTeamSongListOk.ad?page=${startPage - 1}" class="prev">&lt;</a></li>
	          </c:if>
	          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
	          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
	          	<c:choose>
	          		<c:when test="${!(i == page) }">
	          			<li><a href="${pageContext.request.contextPath}/admin/adminManageTeamSongListOk.ad?page=${i}">
	          				<c:out value="${i}" />
	          			</a></li>
	          		</c:when>
	          		<c:otherwise>
	          			<li><a href="#" class="active">
	          				<c:out value="${i}" />
	          			</a></li>
	          		</c:otherwise>
	          	</c:choose>
	          </c:forEach>
	          
	          <c:if test="${next}">
	          	<li><a href="${pageContext.request.contextPath}/admin/adminManageTeamSongListOk.ad?page=${endPage + 1}" class="next">&gt;</a>
	          </c:if>
	          
	        </ul>
	      </div>

        </div>
      </section>
    </section>
  </main>
  
  <section class="section-modal" id="section-modal">
    <div class="modal-background"></div>
    <form method="post" id="modal-form" enctype="multipart/form-data">

      <div class="modal-input-text">
        <label for='song-title'> 응원가명 : </label>
        <input type="text" id="song-title" name="songTitle" required>
      </div>

      <div class="modal-input-text">
        <label for="song-url"> 응원가 주소 : </label>
        <input type="url" id="song-url" name="songUrl" required>
      </div>

      <div class = "team-player-radio">
        카테고리 선택
        <input type="radio" id = "team" value="team" name="team-player" required>
        <label for="team"> 팀 </label>

        <input type="radio" id = "player" value="player" name="team-player" required>
        <label for="player"> 선수 </label>
      </div>

      <div class="modal-input-radio">

			<input type="radio" id="lg" value="lg" name="team-categories" required> 
			<label for="lg"> 
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png">
			</label> 
			
			<input type="radio" id="hh" value="hh" name="team-categories" required> 
			<label for="hh"> 
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/hanwha.png">
			</label> 
			
			<input type="radio" id="lotte" value="lotte" name="team-categories" required> 
			<label for="lotte">
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/lotte.png">
			</label> 
			
			<input type="radio" id="ssg" value="ssg" name="team-categories" required> 
			<label for="ssg"> 
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png">
			</label>
			 
			<input type="radio" id="kia" value="kia" name="team-categories" required> 
			<label for="kia"> 
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png">
			</label> 
			
			<input type="radio" id="kt" value="kt" name="team-categories" required> 
			<label for="kt">
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png">
			</label> 
			
			<input type="radio" id="nc" value="nc" name="team-categories" required> 
			<label for="nc"> 
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png">
			</label> 
			
			<input type="radio" id="samsung" value="samsung" name="team-categories" required> 
			<label for="samsung">
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/samsung.png">
			</label> 
			
			<input type="radio" id="doosan" value="doosan" name="team-categories" required> 
			<label for="doosan">
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png">
			</label> 
			
			<input type="radio" id="kiwoom" value="kiwoom" name="team-categories" required> 
			<label for="kiwoom">
				<img src="${pageContext.request.contextPath}/assets/img/communityImg/kiwoom.png">
			</label>

      </div>

      <div class="modal-buttons">
        <button type="submit" id="save-button"> 저장 </button>
        <button type="button" id="cancle-button"> 취소 </button>
      </div>

    </form>
  </section>

  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>