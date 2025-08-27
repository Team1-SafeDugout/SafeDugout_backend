<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원관리</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminTeamNewesDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script async src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminTeamNewesDetail.js"></script>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <seciont class="section-background">
      <!-- 상단 버튼 -->
      <section class = "section-bottom-buttons">
        <form action="" method="get">
          <button class = "post-button" type ="button" id = "delete-button"> 삭제 </button>
        </form>
      </section>

      <!-- 본문 공간 -->
      <section class="section-post">
        <div class="post-title-container">
          <div class="title"> 제목 :  <div> ${newsDTO.postTitle} </div> </div>
          <div class="author"> 작성자 :  <div> ${newsDTO.journalist} </div> </div>
        </div>

        <div class = "line"> </div>

        <div class="post-content-container">
          <div> 내용 </div>
          <div class="post-content"> ${newsDTO.postContent} </div>
        </div>
      </section>

      <section class = "section-bottom">
        <div class="post-date"> ${newsDTO.postDate} </div>
        <div class="post-url"> <a href ="${newsDTO.postLink}"> 기사 원문 </a> </div>
      </section>


      <!-- 하단 버튼 -->
      <section class = "section-bottom-buttons">
        <form action="" method="get">
          <button class = "post-button" type ="button" onclick = "location.href = '${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad' " > 
            목록으로 
          </button>
        </form>

        <%-- <form action="" method="get">
          <button class = "post-button" type ="submit" onclick = "location.href = '${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad'?postNumber=${postNumber -1}&boardId=3"> 이전 글 </button>
          <button class = "post-button" type ="submit" onclick = "location.href = '${pageContext.request.contextPath}/admin/adminManageTeamNewsListOk.ad'?postNumber=${postNumber -1}&boardId=3"> 다음 글 </button>
        </form> --%>
      </section>
    </seciont>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>