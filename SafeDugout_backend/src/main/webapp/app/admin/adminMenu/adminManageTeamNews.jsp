<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMenu/adminManageTeamNews.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminMenu/adminManageTeamNews.js"></script>
  <script>
    let posts = [];
    <c:forEach var="board" items="${boardList}">
    	posts.push({
    		number: "${board.postNumber}",
            title: "${board.postTitle}",
            date: "${board.postDate}",
            type: "${board.teamNumber}",
            teamtype: "${board.teamNumber}"
        });
    </c:forEach>
    const contextPath = "${pageContext.request.contextPath}";
  </script>
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
            <li class="sidebar-elements"> <a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad"> 공지사항</a> </li>
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
        팀 뉴스
      </div>

      <section class="body-container-list">
        <div class="list-background">

          <div class="list-names">
            <div>글 번호</div>
            <div>뉴스 제목</div>
            <div>작성 일자</div>
            <div>팀</div>
            <div class="add-button"> <a href="${pageContext.request.contextPath}/admin/adminCreatePost.ad" id="add-news-button"> 추가하기+ </a> </div>
          </div>
          <div class="list-container">
            <ul class="list-ul" id="list-ul">
            <c:choose>
				<c:when test="${empty boardList}">
					<div>
   						<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
   					</div>
				</c:when>
			</c:choose>	

            </ul>
          </div>

	      <div class="pagination">
	        <ul>
	          
	          <c:if test="${prev}">
	          	<li><a href="${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad?page=${startPage - 1}" class="prev">&lt;</a></li>
	          </c:if>
	          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
	          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
	          	<c:choose>
	          		<c:when test="${!(i == page) }">
	          			<li><a href="${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad?page=${i}">
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
	          	<li><a href="${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad?page=${endPage + 1}" class="next">&gt;</a>
	          </c:if>
	          
	        </ul>
	      </div>

        </div>
      </section>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>
</html>