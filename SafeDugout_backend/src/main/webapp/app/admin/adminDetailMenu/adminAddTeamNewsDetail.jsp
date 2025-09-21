<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>팀뉴스 추가</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminAddTeamNewsDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminAddTeamNewsDetail.js"></script>
  <script>
    const isLogin = <%= (session.getAttribute("adminNumber") != null) ? "true" : "false" %>;
  </script>
  <script src = "${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script> 
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <!-- 필수 입력 정보 : 제목, URL -->
      <!-- 선택 입력 정보 : 내용, 첨부파일 -->
      <form action="/admin/adminCreatePostOk.ad?boardCategory=teamnews" method="post" name="adminNewsPost" enctype="multipart/form-data">

        <!-- 제목 추가 부분 -->
        <section class="title">
          <label for="title-text"> 제목 </label>
          <input type="text" name="title-text" required>
        </section>

        <!-- URL 추가 부분 -->
        <section class="url">
          <label for="url-text"> URL </label>
          <input type="url" id = "url-text" name="url-text" required>
          <label for="journal-text"> 기자 </label>
          <input type="text" id = "journal-text" name="journal-text" required>
        </section>

        <!-- 게시글 선택 -->
        <label for = "team-categories"> 팀 선택 </label>
        <select class="select-team" name="team-categories" id = "team-categories">
          <option name="team-category" value="lg"> LG </option>
          <option name="team-category" value="hh"> 한화 </option>
          <option name="team-category" value="lotte"> 롯데 </option>
          <option name="team-category" value="ssg"> SSG </option>
          <option name="team-category" value="kia"> 가어 </option>
          <option name="team-category" value="kt"> KT </option>
          <option name="team-category" value="nc"> NC </option>
          <option name="team-category" value="samsung"> 삼성 </option>
          <option name="team-category" value="doosan"> 두산 </option>
          <option name="team-category" value="kiwoom"> 키움 </option>
        </select>

        <hr class=line>

        <!-- 본문 추가 부분 -->
        <section class="content">
          <label for="content-textarea"> 내용 </label>
          <div> 서식 API </div>
          <textarea name="content" id="content-textarea"> </textarea>
        </section>
        
        <!-- 첨부 파일 -->
        <section class = "file">
          <label for = "file-area"> 
            <div class = "file-button-style"> 파일 첨부 </div>
          </label>
          <input type= "file" name = "file" id = "file-area" accept=".jpg, .jpeg, .png">
          <div> ※ 파일은 1개만 올리기 가능합니다   ※  글 수정 시 첨부된 파일이 삭제 됩니다(<span class="cnt">0</span>/1) </div>
<!--           <div id = "delete-file"> 파일 삭제 </div> -->
        </section>
        <div class="img-controller-box">
			<ul class="file-list">

			</ul>
		</div>

        <!-- 버튼 추가 부분 -->
        <section class="buttons">
          <button id="save-button"> 저장 </button>
          <a id="cancle-button"> 취소 </a>
        </section>
      </form>

    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>