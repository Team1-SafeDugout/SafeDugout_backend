<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>메인 공지사항 디테일 페이지</title>
  <link rel="stylesheet" href="./../../assets/css/mainNotice/mainNoticeDetail.css">
  <link rel="stylesheet" href="./../../assets/css/headerLogin.css">
  <link rel="stylesheet" href="./../../assets/css/headerNoLogin.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/mainNotice/mainNoticeDetail.js"></script>
</head>

<!-- 바디 -->

<body>
  <!-- 헤더 -->
  <div id="header"></div>
  <!-- 메인 -->
  <main>
    <!-- 공지사항 디테일 컨테이너 -->
    <div class="notice-board-detail">
      <!-- 컨테이너 제목 -->
      <h2>공지사항</h2>
      <!-- 공지사항 제목 박스 -->
      <div class="notice-board-header">
        <!-- '제목' -->
        <span>제목: </span>
        <!-- 공지사항 제목 텍스트 -->
        <p><c:out value="${mainNoticePost.getNoticePostTitle()}" /></p>
      </div>
      <!-- 공지사항 내용 -->
      <div class="notice-board-content">
      	<p><c:out value="${mainNoticePost.getNoticePostContent()}" /></p>
      </div>
      <!-- 버튼 컨테이너 -->
      <div class="notice-board-btn-container">
        <!-- 이전글, 다음글 버튼 -->
        <div class="notice-board-btn">
          <!-- 이전글 버튼 -->
          <c:if test="${prevPost}">
          <a href="${pageContext.request.contextPath}/main/selectMainDetailOk.ma?prevNext=prev&noticePostNumber=${mainNoticePost.getNoticePostNumber()}"><button type="button">이전글</button></a>
          </c:if>
          <!-- 다음글 버튼 -->
          <c:if test="${nextPost}">
          <a href="${pageContext.request.contextPath}/main/selectMainDetailOk.ma?prevNext=next&noticePostNumber=${mainNoticePost.getNoticePostNumber()}"><button type="button">다음글</button></a>
          </c:if>
        </div>
        <!-- 목록으로 버튼 -->
        <div class="btn-to-list"><a href="${pageContext.request.contextPath}/main/selectMainListOk.ma"><button type="button">목록으로</button></a></div></div>
      <!-- 게시 일자 -->
      <div class="notice-date">
      	작성일 : 
      	<span><c:out value="${mainNoticePost.getNoticePostDate()}" /></span><br>
      	<c:if test="${updateDate} != null" >
      	수정일 : 
      		<span>
      			<c:set var="updateDate" value="${mainNoticePost.getNoticePostUpdate()}" />
      		
      				<c:out value="${updateDate}" />
      		
      		</span>
      	</c:if>
      </div>
    </div>
  </main>
  <!-- 푸터 -->
  <div id="footer"></div>
  <!-- 스크립트 -->
  <script src="./../../assets/js/include.js"></script>
</body>

</html>