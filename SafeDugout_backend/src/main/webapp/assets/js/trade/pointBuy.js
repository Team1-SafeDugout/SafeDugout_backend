// 버튼 
const payBtn = document.getElementById('payBtn');

// 포인트 입력값 
const pointValue = document.getElementById('pointValue');

// 포인트 입력 오류 메시지 
const pointRequiredMessage = document.getElementsByClassName('input-error-message')[0];

// 이벤트리스너
// 결제 버튼 누를 시 
payBtn.addEventListener('click', function () {
  if (pointValue.value === "") {
    pointRequiredMessage.style.visibility = 'visible';
  } else {
    location.href = "./pointBuyResult.html";
  }
});

