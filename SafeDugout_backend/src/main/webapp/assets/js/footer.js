// 이용약관 버튼 
const useTermFooter = document.getElementsByClassName('useTerm-footer')[0];
// 개인정보처리방침 버튼 
const piPolicyFooter = document.getElementsByClassName('piPolicy-footer')[0];
// 중고거래 운영 정책 버튼 
const tradePolicyFooter = document.getElementsByClassName('tradePolicy-footer')[0];
// 이용약관 모달창
const useTermModalFooter = document.getElementsByClassName('modal-useterm-footer')[0];
// 개인정보처리방침 모달창
const piPolicyModalFooter = document.getElementsByClassName('modal-pipolicy-footer')[0];
// 중고거래 운영 정책 모달창
const tradePolicyModalFooter = document.getElementsByClassName('modal-tradepolicy-footer')[0];
// 반투명하게 덮는 화면
const overlay = document.getElementById('overlay');
// 모달창 취소 버튼 
const modalCloseBtnFooter = document.querySelectorAll('.modal-button-close-footer');

console.log(overlay);

// 이벤트리스너
// 이용약관 버튼 누를 시 동작
useTermFooter.addEventListener('click', function () {
  useTermModalFooter.style.display = 'flex';
  overlay.style.display = 'block';
});
// 개인정보처리방침 버튼 누를 시 동작
piPolicyFooter.addEventListener('click', function () {
  piPolicyModalFooter.style.display = 'flex';
  overlay.style.display = 'block';
});
// 중고거래 운영 정책 버튼 누를 시 동작
tradePolicyFooter.addEventListener('click', function () {
  tradePolicyModalFooter.style.display = 'flex';
  overlay.style.display = 'block';
});
// 모달창 취소 버튼 누를 시 동작 
modalCloseBtnFooter.forEach(btn => {
  btn.addEventListener('click', function() {
    useTermModalFooter.style.display = 'none';
    piPolicyModalFooter.style.display = 'none';
    tradePolicyModalFooter.style.display = 'none';
    overlay.style.display = 'none';
  });
});

modalCloseBtnFooter.addEventListener('click', function () {
  useTermModalFooter.style.display = 'none';
  overlay.style.display = 'none';
});
