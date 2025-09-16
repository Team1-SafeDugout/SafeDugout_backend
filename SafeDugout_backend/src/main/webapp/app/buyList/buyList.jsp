<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>구매 내역</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/buyList/buyList.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/buyList/buyListConfirm.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <script>
  /* imgSourceParam, titleParam, dealTypeParam, tradeStatusParam, addDateParam, pointChangeParam, pointLeftParam, buyDateParam, confirmDateParam, postNumber */
    let posts = [];
    <c:forEach var="board" items="${boardList}">
    	posts.push({
            imgSource: "${board.attachment[0].attachmentPath}",
            title: "${board.title}",
            dealType: "${board.dealType}",
            tradeStatus: "${board.tradeStatus}",
            pointChange : "${board.pricePoint}",
            pointLeft : "${board.pricePoint}",
            buyDate : "${board.buyDate}",
            confirmDate : "${board.confirmDate}",
            postNumber : "${board.sellPostNumber}",
            seller : "${board.sellerMemberId}"
        });
    </c:forEach>
    console.log(posts);
    const contextPath = "${pageContext.request.contextPath}";
  </script>
  <script defer src="${pageContext.request.contextPath}/assets/js/buyList/buyList.js"></script>
  <script defer src = "${pageContext.request.contextPath}/assets/js/myPostList/getPoint.js"></script>
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
        <h3>구매 내역</h3>
        <div class="content-box">
          <ul class="post-list" id = "ul-li">
            <c:choose>
				<c:when test="${empty boardList}">
					<div>
   						<div colspan="5" align="center">구매한 물품이 없습니다.</div>
   					</div>
				</c:when>
			</c:choose>                 
          </ul>
          <div class="pagination">
	        <ul id="numberlist-ul">
	          
	          <c:if test="${prev}">
	          	<li><a href="${pageContext.request.contextPath}/myPage/tradeList.mp?page=${startPage - 1}" class="prev">&lt;</a></li>
	          </c:if>
	          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
	          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
	          	<c:choose>
	          		<c:when test="${!(i == page) }">
	          			<li><a href="${pageContext.request.contextPath}/myPage/tradeList.mp?page=${i}">
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
	          	<li><a href="${pageContext.request.contextPath}/myPage/tradeList.mp?page=${endPage + 1}" class="next">&gt;</a>
	          </c:if>
	          
	        </ul> 
          </div>
        </div>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value" id = "my-point">
          <span>20000</span><span>P</span>
        </div>
        <a href="./../pointRecharge/pointList.html" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="./../trade/pointBuy.html" class="charge-btn">충전</a>
      </section>
      
      <div id="buy-overlay"></div>
      <div class="content-box-modal" id = "buy-modal">
        <h3>구매 확정 되었습니다.</h3>
        <ul class="post-list-modal">
          <li class="post-list-row-modal-product-title">
            <span>상품 이름 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span>따끈따끈한 글로브 입니다</span>
          </li>
          <li class="post-list-row-modal-product-content">
            <span>상품 설명 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span>따근따근한 글로브, 상태 양호, 착용감 좋음</span>
          </li>
          <li class="post-list-row-modal">
            <span>거래 방식 :</span> <span>배송</span>
          </li>
          <li class="post-list-row-modal">
            <span>거래 희망 지역 :</span> <span>인천</span>
          </li>
          <li class="post-list-row-modal">
            <span>판매자 ID :</span> <span>sfeq8474</span>
          </li>
          <li class="post-list-row-modal-product-price">
            <div class="product-price">
              <span>상품 가격 :</span> <span>1000000 포인트</span>
            </div>
          </li>
        </ul>
        <div class="product-list-button-container-modal">
          <!-- 확인 버튼 -->
          <a>
            <div class="product-list-button-confirm-modal" id = "confirm-trade-button">확인
            </div>
          </a>
          <!-- 취소 버튼 -->
          <a>
            <div class="product-list-button-cancel-modal" id = "close-modal-button">취소
            </div>
          </a>
        </div>
      </div>
      
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>