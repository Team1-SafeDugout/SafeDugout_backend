<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminNoticePost.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminNoticePost.js"></script>
  <script>
    const isLogin = <%= (session.getAttribute("adminNumber") != null) ? "true" : "false" %>;
  </script>
  <script src = "${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script> 
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <!-- 상단 버튼 -->
      <section class="section-top-buttons">
        <form action="" method="get">    
          <!-- <button class="post-button" type="button" > 수정 </button> -->
          <button class="post-button" type="button" id="delete-button"> 삭제 </button>
        </form>        
      </section>

      <!-- 본문 공간 -->
      <section class="section-post">
        <div class="post-title-container">
          <div> 제목 </div>
          <div class="title"> <c:out value= "${mainNotice.getNoticePostTitle()}" /> </div>
        </div>

        <div class="line"> </div>

        <div class="post-content-container">
          <div> 내용 </div>
          <div class="post-content">
          	<c:choose>
				<c:when test = "${!empty mainNotice.attachment[0].attachmentPath}">	
					<img width = 100% height = 500px src= "${mainNotice.attachment[0].attachmentPath}${mainNotice.attachment[0].attachmentName}"/>
				</c:when>
			</c:choose>
          	
            <c:out value= "${mainNotice.getNoticePostContent()}" />
          </div>
        </div>
      </section>

      <div class="post-date"> <c:out value= "${mainNotice.getNoticePostUpdate()}" /> </div>

      <!-- 하단 버튼 -->
      <section class="section-bottom-buttons">
        <form action="" method="get">
          <button class="post-button" type="button" onclick="location.href = '${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad' ">
            목록으로
          </button>
        </form>

        <form action="" method="get">
<%--           <button class="post-button" type="button" onclick="location.href = '${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad' ">
            이전 글 </button>
          <button class="post-button" type="button" onclick="location.href = '${pageContext.request.contextPath}/admin/adminMainNoticeListOk.ad' ">
            다음 글 </button> --%>
        </form>
      </section>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>
</html>