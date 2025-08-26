const payBtn = document.getElementById("payBtn");
const pointInput = document.getElementById("pointValue");

payBtn.addEventListener("click", () => {
    const amount = parseInt(pointInput.value);

    if (!amount || amount <= 0) {
        alert("충전할 금액을 입력하세요.");
        return;
    }

    // 실제 결제 처리 함수 호출
    requestKakaoPay(amount);
});


function requestKakaoPay(amount) {
    // 서버에 결제 준비 요청
    fetch('/payment/kakaoReady', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ amount: amount })
    })
    .then(res => res.json())
    .then(data => {
        if(data.next_redirect_pc_url) {
            // 카카오페이 결제 페이지로 이동
            window.location.href = data.next_redirect_pc_url;
        } else {
            alert("결제 준비 실패");
        }
    })
    .catch(err => console.error(err));
}