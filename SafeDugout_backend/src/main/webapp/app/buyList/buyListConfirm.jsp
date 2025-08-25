<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>구매 확정 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/buyList/buyListConfirm.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <section class="buy-confirm">
      <h2>확정이 필요한 제품 정보</h2>
      <div class="trade">
        <li>상품 이름 : 국가대표 모자 </li>
        <li>상품 설명 : </li>
        <li>거래 방식 :</li>
        <li>택배 발송 / 직거래</li>
        <li>거래 희망 지역 : 서울</li>
        <li>판매자 : 소*****</li>
        <li>_____________________________________________</li>
      </div>
      <div class="price">
        <h3>상품가격</h3>
        <li>100포인트</li>
      </div>
      <button type="button">확정</button>
      <button type="button">취소</button>
    </section>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
  <script src="${pageContext.request.contextPath}/assets/js/include.js"></script>
</body>

</html>