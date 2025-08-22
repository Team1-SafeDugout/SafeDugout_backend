<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*, com.bullPenTalk.app.dto.MainNoticePostDTO" %>
<%
    List<MainNoticePostDTO> boardList = new ArrayList<>();
	MainNoticePostDTO b1 = new MainNoticePostDTO();
    b1.setNoticePostNumber(1);
    b1.setNoticePostTitle("첫 번째 공지");
    b1.setNoticePostDate("2025-08-21");
    boardList.add(b1);

    MainNoticePostDTO b2 = new MainNoticePostDTO();
    b2.setNoticePostNumber(2);
    b2.setNoticePostTitle("두 번째 공지");
    b2.setNoticePostDate("2025-08-22");
    boardList.add(b2);

    request.setAttribute("boardList", boardList);
%>

<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMenu/adminManagePosts.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  
  <script>
    let posts = [];
    <c:forEach var="board" items="${boardList}">
    	posts.push({
            number: "${board.noticePostNumber}",
            title: "${board.noticePostTitle}",
            date: "${board.noticePostDate}",
            type: "전체공지사항"
        });
    </c:forEach>
  </script>
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminMenu/adminManagePosts.js"></script>
</head>

<body>

  <div id="header"></div>
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

      <a href="./../adminDetailMenu/adminUserDetail.html"></a>

      <div class="sidebar-div-container">
        <div>
          <ul>
            <li class="sidebar-elements"> <a href="./adminSiteStatistics.html"> 사이트 통계</a> </li>
            <li class="sidebar-elements"> <a href="./adminManagePosts.html"> 게시글 / 공지사항</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageFreeCommunity.html"> 전체 커뮤니티 </a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTeamNews.html"> 팀 뉴스</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTeamYoutube.html"> 팀 유튜브</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTeamSong.html"> 팀 응원가</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageSell.html"> 판매글</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTrading.html"> 거래중인 글</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageMember.html"> 회원관리</a> </li>
          </ul>
        </div>
      </div>
    </section>
    <section class="body-container">
      <div class="body-container-name">
        전체 공지사항
      </div>

      <section class="body-container-list">
        <div class="list-background">

          <div class="list-names">
            <div>글번호</div>
            <div>제목</div>
            <div>작성일자</div>
            <div>글종류</div>
            <div></div>
          </div>
          
          <div class="list-container">          	
            <ul class="list-ul" id="list-ul">
            <!-- 조건으로 리스트에 무언가 추가 postNumberParam, postTitleParam, postDateParam, postTypeParam -->
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
	          	<li><a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad?page=${startPage - 1}" class="prev">&lt;</a></li>
	          </c:if>
	          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
	          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
	          	<c:choose>
	          		<c:when test="${!(i == page) }">
	          			<li><a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad?page=${i}">
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
	          	<li><a href="${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad?page=${endPage + 1}" class="next">&gt;</a>
	          </c:if>
	          
	        </ul>
	      </div>

          
        </div>
        
      </section>
    </section>
  </main>
  <div id="footer"></div>
  <script src="${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script>
  <script>
    	let memberNumber = "${sessionScope.memberNumber}";
   </script>
</body>

</html>