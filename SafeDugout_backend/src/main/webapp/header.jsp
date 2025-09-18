<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<div class="header-container">
		<div class="header-left">
			<div class="main-logo">
				<a href="${pageContext.request.contextPath}/main.ma"><img
					src="${pageContext.request.contextPath}/assets/img/communityImg/mainLogo.png"
					alt=""></a>
			</div>
		</div>

		<c:choose>
			<c:when test="${empty sessionScope.memberNumber}">
				<div class="header-right">
					<%-- <div class="guide-notice">
						<a href="${pageContext.request.contextPath}/main/selectMainListOk.ma">
							<c:out value="${recentGuideTitle}"/></a>
					</div> --%>
					<div class="notice">
						[전체공지]&nbsp<a href="${pageContext.request.contextPath}/main/selectMainListOk.ma">
							<%-- <c:out value="${recentMainTitle}"/> --%></a>
					</div>
					<div class="trade-logo">
						<a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr">
							<img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeMainLogo.png" alt="중고거래 로고">
						</a>
					</div>
					<div class="login">
						<a href="${pageContext.request.contextPath}/member/login.me">
							로그인</a>
					</div>
					<div class="register">
						<a href="${pageContext.request.contextPath}/member/terms.me">
							<span>|</span> 회원가입</a>
					</div>
					<div class=""></div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="header-right">
					<%-- <div class="guide-notice">
						<a href="${pageContext.request.contextPath}/main/selectMainListOk.ma">
							<c:out value="${recentGuideTitle}"/></a>
					</div> --%>
					<div class="notice">
						[전체공지]&nbsp<a href="${pageContext.request.contextPath}/main/selectMainListOk.ma">
							<%-- <c:out value="${recentMainTitle}"/> --%></a>
					</div>
					<div class="trade-logo">
						<a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr">
							<img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeMainLogo.png" alt="중고거래 로고">
						</a>
						<a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr?category=tradewirte&action=write">
							<img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png" alt="">
						</a>
					</div>
					<div class="welcome"><span><c:out value="${sessionScope.memberName}" /></span>님 환영합니다.</div>
					<div class="logout">
						<a href="${pageContext.request.contextPath}/member/logOutOk.me?curPage=main">
						<span>|</span> 로그아웃</a>
					</div>
					<div class="mypage">
						<a href="${pageContext.request.contextPath}/myPage/postList.mp">
						<img src="${pageContext.request.contextPath}/assets/img/communityImg/icoMypage.png" alt=""></a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</header>
<!-- js 파일 -->
<script src="${pageContext.request.contextPath}/assets/js/header.js"></script>
