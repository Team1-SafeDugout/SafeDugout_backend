<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kor">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminUserPostDetail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">

<!-- 댓글 목록 불러오기 -->

<script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminUserPostDetail.js"></script>
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
	<main>
		<section class="section-background">
			<section class="section-bottom-buttons">
				<a class="post-button" id="delete-button"> 삭제</a>
			</section>

			<!-- 본문 공간 -->
			<section class="section-post">
				<div class="post-title-container">
					<div class="title">${postDTO.postTitle}</div>
					<div class="author">작성자 : ${postDTO.memberId}</div>
				</div>
				    	
				<div class="post-content-container">
					<c:choose>
						<c:when test = "${!empty postDTO.attachment[0].attachmentPath}">
							<img width = 100% height = 500px src= "/upload/product/${postDTO.attachment[0].attachmentPath}"/>
						</c:when>
				  	</c:choose>
					${postDTO.postContent}
				</div>
			</section>
			<!-- 날짜 표시 -->
			<div class="post-date">${postDTO.postDate}</div>
			<!-- 댓글 공간 -->


			<section class="section-bottom-buttons">
				<a class="post-button" href = "${pageContext.request.contextPath}/admin/adminManageUserPostListOk.ad?currentTab=all" >목록으로</a>
			</section>
		</section>

		<br>

		<section class="section-comments-background">
			<section class="community-comment">
				<div class="community-comment-header">
					<h2>댓글</h2>
				</div>

				<!-- 댓글 리스트 -->
				<ul class="community-comment-list" id = "ul-li">
					
				</ul>
			</section>
		</section>
	</main>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
</body>

</html>