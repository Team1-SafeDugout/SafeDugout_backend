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
          <h2>${community.postTitle}</h2>
          <div>
            <!-- 수정 삭제 버튼 -->
            <c:if test="${sessionScope.memberNumber == coumminty.memberNumber}">
					<!-- 수정 버튼 -->
					<button type="button" class="modify-btn"
						data-board-number="${freePostDetail.postNumber}"
						data-member-number="${sessionScope.memberNumber}">수정</button>
					<!-- 삭제 버튼 -->
					<button type="button" class="delete-btn"
						data-board-number="${freePostDetail.postNumber}"
						data-member-number="${sessionScope.memberNumber}">삭제</button>
				</c:if>
          </div>
        </div>
        <!-- 작성자 정보 -->
        <div class="team-post-info">
          <div class="team-post-num">글번호:<p><c:out value="${freePostDetail.postNumber}" /></p></div>
          <div class="team-post-writer">작성자ID:<p><c:out value="${freePostDetail.memberNumber}" /></p></div>
          <div class="team-post-date">작성일자:<p><c:out value="${freePostDetail.postDate}" /></p></div>
        </div>
        <!-- 본문 -->
        <article class="team-post-main">
          <p><c:out value="${freePostDetail.postContent}" /></p>
        </article>
         <button type="button" class="list-btn"
					data-boardNumber="${freePostDetail.postNumber}"
					data-memberNumber="${sessionScope.memberNumber}">목록</button>
      </section>
      <!-- 댓글 -->
      <section class="team-post-comment">
        <div class="team-comment-header">
          <h2>댓글</h2>
        </div>
        <ul class="team-comment-list">
          <li class="comment-item">
            <!-- 댓글 정보 -->
            <div class="team-comment-info">
              <span class="comment-author">작성자 ID: user01</span>
              <span class="comment-date">2025-08-08</span>
            </div>
            <!-- 댓글 내용 -->
            <p class="team-comment-text">댓글 내용</p>
            <div class="team-comment-button">
              <form action="">
                <!-- 수정 삭제 버튼 -->
                <button type="submit">수정</button>
                <button type="submit">삭제</button>
              </form>
            </div>
          </li>
          <!-- 댓글 등록 시 들어올 공간 -->
        </ul>
        <div class="team-comment-area">
        <form action="" method="">
          <!-- 댓글 등록 공간 -->
          <textarea name="" id=""></textarea>
          <button type="submit" class="team-btn-submit">등록</button>
        </form>
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

