<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>포인트 충전 결제 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/trade/pointBuy.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerNoLogin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/header.jsp" />

    <!-- 메인 -->
    <main>
        <div class="main-container">
            <!-- 한 폼으로 통합 -->
            <form id="chargeForm" action="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr" method="post"> 
                <!-- 숨겨진 값들 -->
                <input type="hidden" name="category" value="buy" />
                <input type="hidden" name="action" value="chargingok" />
                <input type="hidden" name="memberNumber" value="${sessionScope.memberNumber}" />
                <input type="hidden" name="paymentId" id="paymentId">
				<input type="hidden" name="merchantUid" id="merchantUid">
				<input type="hidden" name="payMethod" id="payMethod">
				<input type="hidden" name="paidAt" id="paidAt">
				<input type="hidden" name="amount" id="amount">

                <!-- 메시지 박스 -->
                <div class="main-message-container">
                    <div class="container-title">포인트 충전</div>
                    <div class="long-line"></div>

                    <!-- 입력 오류 메시지 -->
                    <div class="input-error-message" style="display:none; color:red;">• 충전 금액을 입력하세요</div>

                    <!-- 포인트 입력 -->
                    <div class="container-full">
                        <div class="input-message">충전 금액 :</div>
                        <div class="point-amount">
                            <input type="number" name="chargePoint" placeholder="포인트 입력" id="pointValue" required>원                            
                        </div>
                    </div>

                    <div class="container-full"><div class="short-line"></div></div>
                    <div class="long-line"></div>

                    <!-- 버튼 -->
                    <div class="main-button-container">
                        <button type="button" class="main-button-next" id="payBtn">결제</button>
                                               
                        <a href="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=allproduct&action=list">
                            <div class="main-button-cancel">취소</div>
                        </a>
                    </div>

                    <div class="container-full">결제 방식</div>
                   	<script src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
					<script>
					document.getElementById("payBtn").addEventListener("click", function(event) {
					    event.preventDefault();
					    let chargePoint = document.getElementById("pointValue").value;
					    if(!chargePoint || chargePoint <= 0){
					        alert("충전할 금액을 입력해주세요!");
					        return;
					    }
					
					    var IMP = window.IMP;
					    IMP.init(''); // 테스트 모드용 가맹점 코드
					
					    IMP.request_pay({
					        pg: 'kakaopay.TC0ONETIME',
					        pay_method: 'card',
					        merchant_uid: 'test_' + new Date().getTime(),
					        name: '포인트 충전',
					        amount: chargePoint,
					        buyer_name: '${sessionScope.memberName}',
					        buyer_tel: '${sessionScope.memberPhone}',
					        buyer_email: '${sessionScope.memberEmail}'
					    }, function(rsp) {
					        if (rsp.success) {
								// form태그 아이 값으로 선택
					            let form = document.getElementById("chargeForm");
								// 요청 파라미터 값 설정
								document.getElementById("paymentId").value = rsp.imp_uid;
								document.getElementById("merchantUid").value = rsp.merchant_uid;
								document.getElementById("payMethod").value = rsp.pay_method;
								document.getElementById("paidAt").value = rsp.paid_at;
								document.getElementById("amount").value = chargePoint;
					            form.submit();
					        } else {
					            alert("결제 실패: " + rsp.error_msg);
					        }
					    });
					});
					</script>
                    <div class="long-line"></div>
                    <div class="pay-select-container"></div>
                </div>
            </form>
        </div>
    </main>

    <!-- 푸터 -->
    <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
    <script >
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>
</html>
