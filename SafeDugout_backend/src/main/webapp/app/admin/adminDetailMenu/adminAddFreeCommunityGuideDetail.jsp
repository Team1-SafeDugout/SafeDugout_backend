<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminAddFreeCommunityGuideDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminAddFreeCommunityGuideDetail.js"></script>
  <script>
    const isLogin = <%= (session.getAttribute("adminNumber") != null) ? "true" : "false" %>;
  </script>
  <script src = "${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script> 
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <!-- 필수 입력 정보 : 제목 -->
       <!-- 선택 입력 정보 : 내용, 파일 -->
      <form action="" method="post" name = "adminNoticePost">

        <!-- 제목 -->
        <section class = "title">
          <label for ="title-text"> 제목 </label>
          <input type="text" name = "title-text" required>
        </section>

        <!-- 중간에 선으로 구분 -->
        <hr class = line>

        <!-- 본문 내용 -->
        <section class = "content">
          <label for ="content-textarea"> 내용 </label>
          <div> 서식 API </div>
          <textarea name="content" id="content-textarea"></textarea>
        </section>

        <!-- 중간에 선으로 구분 -->
        <hr class = line>

        <!-- 첨부 파일 -->
        <section class = "file">
          <label for = "file-area"> 
            <div class = "file-button-style"> 파일 첨부 </div>
          </label>
          <input type= "file" name = "file" id = "file-area">
          <div> ※ 파일은 1개만 올리기 가능합니다   ※  글 수정 시 첨부된 파일이 삭제 됩니다 </div>
          <div id = "delete-file"> 파일 삭제 </div>
        </section>

        <!-- 확인 혹은 취소 버튼 -->
        <section class = "buttons">
         <button id = "save-button" type = "button" onclick = "location.href = '${pageContext.request.contextPath}/admin/adminManageFreeCommunityListOk.ad'"> 저장 </button>
         <a id = "cancle-button"> 취소 </a>
        </section>
      </form>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>