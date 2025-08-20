<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
  <div class="header-container">
    <div class="header-left">
      <div class="main-logo">
        <a href="${pageContext.request.contextPath}/mainNoLogin.jsp"><img src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png" alt=""></a>
      </div>
    </div>


    <div class="header-right">
      <div class="notice"><a href="${pageContext.request.contextPath}/app/mainNotice/mainNoticeList.jsp"> [메인공지] : 불펜토크 사이트 이용 안내</a></div>
      <div class="login"><a href="${pageContext.request.contextPath}/app/login/login.jsp"> 로그인</a></div>
      <div class="register"><a href="${pageContext.request.contextPath}/app/register/terms.jsp"> | 회원가입</a></div>
      <div class=""></div>
    </div>
  </div>
</header>

