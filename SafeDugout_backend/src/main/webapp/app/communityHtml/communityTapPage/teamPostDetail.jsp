<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글 상세</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPostDetail.css">
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
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamPostDetail.js"></script>
  <%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script> --%>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
  <main>
    <div class="team-post-container">
      <!-- 게시글 -->
      <section class="team-post-detail">
        <div class="team-post-header">
          <h2>${community.postTitle}</h2>
          <div>
            <!-- 수정 삭제 버튼 -->
			<c:if test="${sessionScope.memberNumber == community.memberNumber}">
			    <!-- 수정 버튼 -->
			    <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=update&postNumber=${community.postNumber}" 
			       class="modify-btn">수정</a>
			    <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=delete&postNumber=${community.postNumber}"
			       class="delete-btn">삭제</a>
			</c:if>
          </div>
        </div>
        <!-- 작성자 정보 -->
        <div class="team-post-info">
          <div class="team-post-num">글번호:<p><c:out value="${community.postNumber}" /></p></div>
          <div class="team-post-writer">작성자ID:<p><c:out value="${community.memberId}" /></p></div>
          <div class="team-post-date">작성일자:<p><fmt:formatDate value="${community.postDate}" pattern="yyyy-MM-dd" /></p></div>
        </div>
        <!-- 본문 -->
        <article class="team-post-main">
          <c:if test="${fn:length(community.attachment) > 0}">
		    <img src="/upload/product/${community.attachment[0].attachmentPath}" alt="게시글 이미지">
		  </c:if>
          <p><c:out value="${community.postContent}" /></p>
        </article>
		<div class="free-guide-board-btn">
		    <a href="${pageContext.request.contextPath}/community/teamCommunityFrontController.tc?category=board&action=postlist">목록</a>
		</div>
      </section>
      <!-- 댓글 -->
      <section class="team-post-comment">
        <div class="team-comment-header">
          <h2>댓글</h2>
        </div>
        
        <ul class="team-comment-list" id = "ul-li">
        	
        </ul>
        
        <div class="team-comment-area">
        	<textarea name="" id="comment-content-area"></textarea>
          	<button type="button" class="team-btn-submit" id = "add-comment">등록</button>
        </div>
      </section>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
  <script>
	let memberNumber = "${sessionScope.memberNumber}";
  </script>
</body>
</html>
