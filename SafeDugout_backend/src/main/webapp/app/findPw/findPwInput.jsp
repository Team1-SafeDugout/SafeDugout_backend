<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원정보 입력 페이지(비밀번호찾기)</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/findPw/findPwInput.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/findPw/findPwInput.js"></script>
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
        비밀번호 찾기
      </div>
      <div class="main-small-title">

      </div>

      <!-- 폼 태그 -->
      <form action="" method="post">
        <!-- 폼 박스 -->
        <div class="main-form-box">
          <!-- 폼 제목 -->
          <div class="main-form-title">
            <!-- 폼 제목 텍스트 -->
            <span>●</span>&nbsp;회원 가입시 등록한 정보로 비밀번호를 찾을 수 있습니다.
          </div>
          <!-- 입력 컨테이너 -->
          <div class="main-input-container">
            <!-- 입력 항목 -->
            <div class="main-input-list">
              <!-- 입력메시지 -->
              <div class="main-input-name">이름</div>
              <!-- 오른쪽 네모칸 -->
              <div class="main-input-box">
                <!-- 입력 오류 메시지 -->
                <div class="main-error-message"></div>
                <!-- 입력칸 -->
                <input type="text" placeholder="이름을 입력하세요" id="userName">
              </div>
            </div>
            <div class="main-input-list">
              <div class="main-input-name">아이디</div>
              <div class="main-input-box">
                <div class="main-error-message"><span></div>
                <input type="text" placeholder="아이디를 입력하세요" id="id">
              </div>
            </div>
            <div class="main-input-list">
              <div class="main-input-name">이메일</div>
              <div class="main-input-box">
                <div class="main-error-message"></div>
                <input type="email" placeholder="이메일을 입력하세요" id="email">
              </div>
            </div>
            <div class="main-input-list">
              <div class="main-input-name">핸드폰 번호</div>
              <div class="main-input-box">
                <div class="main-error-message"></div>
                <input type="text" placeholder="핸드폰 번호를 입력하세요" id="phoneNumber">
                <button type="button" id="sendCode">인증 번호 발송</button>
              </div>
            </div>
            <div class="main-input-list">
              <div class="main-input-name">인증번호 입력</div>
              <div class="main-input-box">
                <div class="main-error-message"></div>
                <input type="text" placeholder="인증 번호 입력" id="code">
                <!-- 오른쪽 네모칸 인증 버튼 -->
                <button type="button" id="authenticate">인증</button>
              </div>
            </div>
          </div>
          <div class="find-fail-message">입력하신 정보로 계정을 찾을 수 없습니다.</div>
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