document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("chargeForm");
    const pointInput = document.getElementById("pointValue");

    form.addEventListener("submit", function(e) {
        e.preventDefault(); // 폼 기본 제출 막기
        const point = parseInt(pointInput.value);

        if (!point || point <= 0) {
            alert("충전 금액을 입력하세요");
            return;
        }

        var IMP = window.IMP;
        IMP.init('imp81327187'); // 아임포트 키 입력

        IMP.request_pay({
            pg: 'html5_inicis',
            pay_method: 'card',
            merchant_uid: 'charge_' + new Date().getTime(),
            name: '포인트 충전',
            amount: point
        }, function(rsp) {
            if (rsp.success) {
                // 결제 성공하면 폼에 imp_uid, merchant_uid 추가 후 제출
                let impUidInput = document.createElement("input");
                impUidInput.type = "hidden";
                impUidInput.name = "impUid";
                impUidInput.value = rsp.imp_uid;
                form.appendChild(impUidInput);

                let merchantUidInput = document.createElement("input");
                merchantUidInput.type = "hidden";
                merchantUidInput.name = "merchantUid";
                merchantUidInput.value = rsp.merchant_uid;
                form.appendChild(merchantUidInput);

                form.submit();
            } else {
                alert("결제 실패: " + rsp.error_msg);
            }
        });
    });
});