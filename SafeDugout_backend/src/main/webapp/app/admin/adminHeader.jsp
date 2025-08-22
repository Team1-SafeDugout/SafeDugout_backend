<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="admin-header">
	<div class="header-siteName"> <a> 불펜토크 </a> </div>

	<c:choose>
		<c:when test="${empty sessionScope.adminNumber}">
			<!-- 로그인 페이지 이동처리 -->
			<div class="header-loginButton"> <a href="${pageContext.request.contextPath}/admin/adminLogin.ad" class="login-btn">로그인</a> </div>
		</c:when>
		<c:otherwise>
			<div class="header-loginButton"> <a href="${pageContext.request.contextPath}/admin/adminLogout.ad" class="logout-btn">로그아웃</a> </div>
		</c:otherwise>
	</c:choose>
</header>