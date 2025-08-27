document.addEventListener('DOMContentLoaded', function () {
    const payBtn = document.getElementById('payBtn');

    payBtn.addEventListener('click', function(e) {
        // 먼저 결제 확인
        if (!confirm("결제하시겠습니까?")) {
            e.preventDefault(); // 취소 시 submit 막기
            return;
        }

        // 포인트 부족 체크
        const currentPoint = parseInt('${sessionScope.memberPoint != null ? sessionScope.memberPoint : 0}');
        const pricePoint = parseInt('${sellPostDetail.pricePoint != null ? sellPostDetail.pricePoint : 0}');

        if (currentPoint < pricePoint) {
            e.preventDefault(); // submit 막기
            if (confirm(`포인트가 부족합니다. 충전 페이지로 이동하시겠습니까?\n현재 포인트: ${currentPoint}\n필요 포인트: ${pricePoint}`)) {
                // 충전 페이지로 이동
                window.location.href = '${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=buy&action=charging';
            }
            return;
        }

        // 충분하면 submit 그대로 진행
    });
});
