<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>포인트 충전 내역</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pointCharge/pointChargeList.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <script>
    let pays = [];
    <c:forEach var="pay" items="${payList}">
    pays.push({
    		Amonut: "${pay.amount}",
            date: "${pay.paidAt}"
        });
    </c:forEach>
    console.log(pays[0]);
    const contextPath = "${pageContext.request.contextPath}";

  </script>
  <script defer src="${pageContext.request.contextPath}/assets/js/pointCharge/pointChareList.js"></script>  
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <div class="main-full">
      <section class="sidebar">
        <h2>MY페이지</h2>
        <div>
          <ul>
            <li class="sidebar-button post"> <a href="${pageContext.request.contextPath}/myPage/postList.mp"> 내가 쓴 게시글</a> </li>
            <li class="sidebar-button commet"> <a href="${pageContext.request.contextPath}/myPage/commentList.mp"> 내가 쓴 댓글</a> </li>
            <li class="sidebar-button buy"> <a href="${pageContext.request.contextPath}/myPage/tradeList.mp"> 구매 내역</a> </li>
            <li class="sidebar-button sell"> <a href="${pageContext.request.contextPath}/myPage/sellList.mp"> 판매 내역</a> </li>
            <li class="sidebar-button member-update"> <a href="${pageContext.request.contextPath}/myPage/changeInfo.mp"> 회원 정보 수정</a></li>
            <li class="sidebar-button member-quit"> <a href="${pageContext.request.contextPath}/myPage/unSubscribe.mp"> 회원 탈퇴</a></li>
          </ul>
        </div>
      </section>

      <section class="main-content">
        <h3>포인트 충전 내역</h3>
        <div class="content-box">
          <div class="post-list-top">
            <div class="post-list-number">충전 번호</div>
            <div class="post-list-title">충전 포인트</div>
            <div class="post-list-date">충전 날짜</div>
          </div>
          <ul class="post-list" id = "ul-li">
            <c:choose>
				<c:when test="${empty payList}">
					<div>
   						<div colspan="5" align="center">결제 기록이 없습니다.</div>
   					</div>
				</c:when>
			</c:choose>          
          </ul>
          <div class="pagination">           
	        <ul id="numberlist-ul">
	          
	          <c:if test="${prev}">
	          	<li><a href="${pageContext.request.contextPath}/myPage/pointCharge.mp?page=${startPage - 1}" class="prev">&lt;</a></li>
	          </c:if>
	          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
	          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
	          	<c:choose>
	          		<c:when test="${!(i == page) }">
	          			<li><a href="${pageContext.request.contextPath}/myPage/pointCharge.mp?page=${i}">
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
	          	<li><a href="${pageContext.request.contextPath}/myPage/pointCharge.mp?page=${endPage + 1}" class="next">&gt;</a>
	          </c:if>
	          
	        </ul>            
          </div>
        </div>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value">
          <span>${myPoint}</span><span>P</span>
        </div>
        <a href="${pageContext.request.contextPath}/myPage/pointCharge.mp" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=buy&action=charging" class="charge-btn">충전</a>
      </section>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>