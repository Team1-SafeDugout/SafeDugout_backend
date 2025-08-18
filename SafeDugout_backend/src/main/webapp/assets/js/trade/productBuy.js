// 사용자 포인트 
let userPoint = 10000;

// 상품 포인트 
let productPoint = 20000;

// 결제 버튼 
const payBtn = document.getElementById('payBtn');

// 이벤트리스너 
// 결제 여부를 묻고 포인트가 부족하면 충전 여부를 묻기 
payBtn.addEventListener('click', function () {
  if (confirm("결제 하시겠습니까?")) {
    if (userPoint < productPoint) {
      if (confirm("포인트가 부족합니다.\n충전하시겠습니까?")) {
        window.location.href = "./pointBuy.html";
      } else {

      }
    } else {
      location.href = "./productBuyResult.html";
    }
  } else {

  }
});

