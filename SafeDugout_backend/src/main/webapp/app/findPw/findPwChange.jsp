<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>비밀번호 재설정 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/findPw/findPwChange.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/findPw/findPwChange.js"></script>
</head>

<!-- 바디 -->

<body>
  <!-- 헤더 -->
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <!-- 메인 -->
  <main>
    <!-- 메인 컨테이너 -->
    <div class="main-container">
      <!-- 페이지 큰 제목 -->
      <div class="main-title">
        비밀번호 재설정
      </div>
      <div class="main-small-title">

      </div>
      <!-- 폼 태그 -->
      <form action="${pageContext.request.contextPath}/member/findPwChangeOk.me?memberNumber=${memberNumber}" method="post" id="pwForm">
        <!-- 폼 박스 -->
        <div class="main-form-box">
          <!-- 폼 박스 제목 -->
          <div class="main-form-title">
            <!-- 폼 제목 텍스트 -->
            <span>●</span>&nbsp;재설정할 비밀번호 입력
          </div>
          <!-- 입력 컨테이너 -->
          <div class="main-input-container">
            <!-- 입력 항목 -->
            <div class="main-input-list">
              <!-- 입력메시지 -->
              <div class="main-input-name">비밀번호</div>
              <!-- 오른쪽 네모칸 -->
              <div class="main-input-box">
                <!-- 입력 오류 메시지 -->
                <div class="main-error-message"><span>비밀번호가 유효하지 않습니다.</span><span>필수 입력값입니다.</span></div>
                <!-- 비밀번호 입력칸 -->
                <input type="password" placeholder="숫자 영대소문자 특수문자 조합 8자리 이상" id="pw" name="newPw">
              </div>
            </div>
            <!-- 입력 컨테이너 -->
            <div class="main-input-list">
              <!-- 입력메시지 -->
              <div class="main-input-name">비밀번호 재입력</div>
              <!-- 오른쪽 네모칸 -->
              <div class="main-input-box">
                <!-- 입력 오류 메시지 -->
                <div class="main-error-message"><span>비밀번호가 일치하지 않습니다.</span></div>
                <!-- 비밀번호 입력칸 -->
                <input type="password" placeholder="" id="rePw" name="newPwAgain">
              </div>
            </div>

          </div>
          <!-- 버튼 컨테이너 -->
          <div class="main-button-container">
            <!-- 확인 버튼 -->
            <button type="button" id="okBtn">
              확인
            </button>
          </div>
        </div>
      </form>
    </div>
  </main>
  <!-- 푸터 -->
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
  <!-- 스크립트 -->
  <script src="./../../assets/js/include.js"></script>
</body>

</html>