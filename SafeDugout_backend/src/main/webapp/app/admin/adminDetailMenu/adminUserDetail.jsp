<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="kor">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>불펜토크 관리자</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminDetailMenu/adminUserDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  
  <script>
    let posts = [];
    <c:forEach var="board" items="${boardList}">
    	posts.push({
            number: "${board.postNumber}",
            title: "${board.postTitle}",
            type: "${board.postType}"
        });
    </c:forEach>
    const contextPath = "${pageContext.request.contextPath}";
  </script>
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminDetailMenu/adminUserDetail.js"></script>
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
  <main>
    <section class="section-background">
      <!-- 출력값 -->
      <!-- 최상단 : 유저 아이디, 응원팀, 탈퇴 버튼 -->
      <section class="section-user-info">
        <form action="" method="post">

          <div class="user-info-value">
            ID : <div id="user-id" name="userId"> ${memberDetail.memberId} </div>
          </div>

          <div class="user-info-value">
            응원팀 : <div id="user-team" name="userTeam"> ${myTeam} </div>
          </div>

          <div class="user-info-value">
            <!-- <button type = "button" id = "delete-user-button" class = "delete-btn"> 탈퇴 </button> -->
          </div>
        </form>
      </section>
      <!-- 중단 : 판매글 목록 -->
      <section class= "section-user-sellist">
        <div class="list-background">
          <div class="list-title"> 유저 작성글 목록 </div>

          <div class="list-container">
            <div class="list-names">
              <div>글번호</div>
              <div>제목</div>
              <div>글종류</div>
            </div>

            <ul class="list-ul" id = "list-ul">
            <c:choose>
				<c:when test="${empty boardList}">
					<div>
   						<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
   					</div>
				</c:when>
			</c:choose>	
            </ul>
          </div>

	      <div class="pagination">
	        <ul>
	          
	          <c:if test="${prev}">
	          	<li><a href="${pageContext.request.contextPath}/admin/adminReadMemberOk.ad?memberNumber=${memberDetail.memberNumber}&page=${startPage - 1}" class="prev">&lt;</a></li>
	          </c:if>
	          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
	          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
	          	<c:choose>
	          		<c:when test="${!(i == page) }">
	          			<li><a href="${pageContext.request.contextPath}/admin/adminReadMemberOk.ad?memberNumber=${memberDetail.memberNumber}&page=${i}">
	          				<c:out value="${i}" />
	          			</a></li>
	          		</c:when>
	          		<c:otherwise>
	          			<li><a href="#" class="active">
	          				<c:out value="${i}" />
	          			</a></li>
	          		</c:otherwise>
	          	</c:choose>
	          </c:forEach>
	          
	          <c:if test="${next}">
	          	<li><a href="${pageContext.request.contextPath}/admin/adminReadMemberOk.ad?memberNumber=${memberDetail.memberNumber}&page=${endPage + 1}" class="next">&gt;</a>
	          </c:if>
	          
	        </ul>
	      </div>
        </div>
      </section>

      <!-- 최하단 : 목록으로 버튼 -->
      <section class="section-button">
        <form action="" method="post">
          <button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/adminManageMemberListOk.ad'"> 목록으로 </button>
        </form>
      </section>
    </section>  
  </main>
  <jsp:include page="${pageContext.request.contextPath}/app/admin/adminFooter.jsp" />
 </body>
</html>