<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminAddNoticePostDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminAddNoticePostDetail.js"></script>
</head>
<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <!-- 필수 입력 정보 : 제목 -->
       <!-- 선택 입력 정보 : 내용, 파일 -->
      <form action="${pageContext.request.contextPath}/admin/adminCreateMainNoticeOk.ad" method="post" name = "adminNoticePost" enctype="multipart/form-data">

        <!-- 제목 -->
        <section class = "title">
          <label for ="title-text"> 제목 </label>
          <input type="text" name = "title-text"  id = "title-text" required>
        </section>

        <!-- 카테고리 설정 -->
         <section class = "category">
          <div> 카테고리 선택 : </div>
          <input type = "radio" name = "post-categories" value = "main" required> 전체공지
          <input type = "radio" name = "post-categories" value = "guide" required> 입문 가이드
          <input type = "radio" name = "post-categories" value = "team" required> 
          <label for = "select-team"> 팀 공지 </label>
          <select class = "select-team" id = "select-team" name = "team-categories">
            <option name = "team-category" value = "lg"> LG </option>
            <option name = "team-category" value = "hh"> 한화 </option>
            <option name = "team-category" value = "lotte"> 롯데 </option>
            <option name = "team-category" value = "ssg"> SSG </option>
            <option name = "team-category" value = "kia"> 가어 </option>
            <option name = "team-category" value = "kt"> KT </option>
            <option name = "team-category" value = "nc"> NC </option>
            <option name = "team-category" value = "samsung"> 삼성 </option>
            <option name = "team-category" value = "doosan"> 두산 </option>
            <option name = "team-category" value = "kiwoom"> 키움 </option>
          </select>
          
         </section>

        <!-- 중간에 선으로 구분 -->
        <hr class = line>

        <!-- 본문 내용 -->
        
        <section class = "content">
          <label for ="content-textarea"> 내용 </label>
          <div> 서식 API </div>
          <textarea name="content" id="content-textarea" required></textarea>
        </section>

        <!-- 중간에 선으로 구분 -->
        <hr class = line>

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

        <!-- 확인 혹은 취소 버튼 -->
        <section class = "buttons">
         <button id = "save-button" type = "submit"> 저장 </button>
         <a id = "cancle-button"> 취소 </a>
        </section>
      </form>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>
</html>