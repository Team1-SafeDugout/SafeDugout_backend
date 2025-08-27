<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script> --%>
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamBoard.js"></script> --%>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main>
    <!-- 게시글 목록 -->
    <div class="team-board-container">
      <div class="team-board-tools-header">
        <h4>게시글</h4>
        <div class="team-board-tools">
          <!-- 검색 창 -->
          
	        <form action="${pageContext.request.contextPath}/trade/tradeFrontController2.tr" method="get">
	            <input type="hidden" name="team" value="search">
	            <input type="hidden" name="action" value="search"> 
	            <input type="text" name="searchWord" placeholder="검색어를 입력해주세요" value="${searchWord != null ? searchWord : ''}"> 
	            <button>
              		<img class="team-board-search" src="${pageContext.request.contextPath}/assets/img/communityImg/freeIconSearch.png" alt="">
            	</button>
	       </form>	
           
          <!-- 글쓰기 탭 -->
          <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=write" class="team-board-write">글쓰기</a>
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
       	<c:choose>
        	<c:when test="${not empty postList}">
        		<c:forEach var="community" items="${postList}">
        			<li class="team-board-list">
	        		<div>
	        			<c:out value="${community.postNumber}"/>
	        		</div>
	        		<div>
	        			<a herf=>
	        				<c:out value="${community.postTitle }"/>
	        			</a>
	        		</div>
	        		<div>
	        			<c:out value="${community.memberId}"/>
	        		</div>
	        		<div>
	        			<c:out value="${community.postDate}"/>
	        		</div>
	        		</li>	
      			</c:forEach>	      			
        	</c:when>
        </c:choose>
      </ul>
    </div>
    <!-- 페이지 네이션 -->
                <!-- 검색 결과 & 페이지네이션 -->
       <div class="pagination">
        <ul>     
          <c:if test="${prev}">
          	<li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=postlist&page=${startPage - 1}" class="prev">&lt;</a></li>
          </c:if>
          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
          	<c:choose>
          		<c:when test="${!(i == page) }">
          			<li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=postlist&page=${startPage - 1}" class="prev">
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
          	<li><a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=postlist&page=${endPage + 1}" class="next">&gt;</a></li>
          </c:if>
        </ul>
      </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
  <script >
    let memberNumber = "${sessionScope.memberNumber}";
  </script>
</body>
</html>