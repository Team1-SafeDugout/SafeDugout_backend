<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamPostDetail.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/freeCommunityDetail.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <div class="team-post-container">
      <!-- 게시글 -->
      <section class="team-post-detail">
        <div class="team-post-header">
          <h2>${freePostDetail.postTitle}</h2>
          <div>
            <!-- 수정 삭제 버튼 -->
            <c:if test="${sessionScope.memberNumber == freePostDetail.memberNumber}">
					<!-- 수정 버튼 -->
					<a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityUpdate.fc?postNumber=${freePostDetail.postNumber}" 
					class="modify-btn">수정</a>
					<a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityDelete.fc?postNumber=${freePostDetail.postNumber}"
					class="delete-btn">삭제</a>
			</c:if>
          </div>
        </div>
        <!-- 작성자 정보 -->
        <div class="team-post-info">
          <div class="team-post-num">글번호:<p><c:out value="${freePostDetail.postNumber}" /></p></div>
          <div class="team-post-writer">작성자ID:<p><c:out value="${freePostDetail.memberNumber}" /></p></div>
          <div class="team-post-date">작성일자:<p><fmt:formatDate value="${freePostDetail.postDate}" pattern="yyyy-MM-dd" /></p></div>
        </div>
        <!-- 본문 -->
        <article class="team-post-main">
          <p><c:out value="${freePostDetail.postContent}" /></p>
        </article>
	      <div class="free-guide-board-btn">
	        <a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityList.fc">목록</a>
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
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
  <script>
	let memberNumber = "${sessionScope.memberNumber}";
  </script>
</body>
</html>

