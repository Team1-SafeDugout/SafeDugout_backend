<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>구매 확정 완료 화면</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/buyList/buyListConfirmComplete.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
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
        <h3>&nbsp</h3>
        <div class="content-box">
          <h3>구매 확정 되었습니다.</h3>
          <div class="post-list">
            <li class="post-list-row">
              <div class="product-list-img">
                <a href="">
                  <img src=${sellPost.attachment[0].attachmentPath} alt="">
                </a>
              </div>
              <div class="product-list-info-middle">
                <div class="product-list-title">
                  글 제목 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="">${sellPost.title}</a>
                </div>
                <div class="product-list-deal-type">
                  <span>거래 방식 :</span> <span>${sellPost.dealType}</span>
                </div>
                <div class="product-list-seller">
                  <span>판매자 ID :</span> <span>${sellPost.sellerMemberId}</span>
                </div>
              </div>
              <div class="product-list-info-right">
                <div class="product-list-minus-point"></div>
                <div class="product-list-remain-point">
                  <span>사용 포인트 :</span> <span>${sellPost.pricePoint} 포인트</span>
                </div>
                <div class="product-list-buy-date">
                  <span>구매 일자 :</span> <span>${sellPost.confirmDate}</span>
                </div>
              </div>
            </li>
          </div>
          <div class="product-list-button-container">
            <!-- 확인 버튼 -->
            <a href = "/myPage/tradeList.mp">
              <div class="product-list-button-confirm">확인
              </div>
            </a>
          </div>
        </div>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value">
          <span>20000</span><span>P</span>
        </div>
        <a href="./../pointRecharge/pointList.html" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="./../trade/pointBuy.html" class="charge-btn">충전</a>
      </section>
    </div>
  </main>
  <div id="footer"></div>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>