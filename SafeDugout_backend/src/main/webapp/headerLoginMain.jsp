<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
  <div class="header-container">
    <div class="header-left">
      <div class="main-logo">
        <a href="${pageContext.request.contextPath}/mainLogin.jsp"><img src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png" alt=""></a>
      </div>
    </div>

    <div class="header-right">
      <div class="notice"><a href="/main/selectMainListOk.ma">[메인공지] : 불펜토크 사이트 이용 안내</a></div>
      <div class="trade-logo">
        <a href="${pageContext.request.contextPath}/app/trade/productRegister.jsp"><img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png" alt=""></a>
      </div>
      <div class="welcome">조성재님 환영합니다.</div>
      <div class="logout"><a href="${pageContext.request.contextPath}/mainNoLogin.jsp">| logout</a></div>
      <div class="mypage">
        <a href="${pageContext.request.contextPath}/app/myPostList/myPostList.jsp"><img src="${pageContext.request.contextPath}/assets/img/communityImg/icoMypage.png" alt=""></a>
      </div>
    </div>
  </div>
</header>
