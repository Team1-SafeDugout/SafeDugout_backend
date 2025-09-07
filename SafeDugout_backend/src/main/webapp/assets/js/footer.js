// 약관 버튼 
const useTermFooter = document.getElementsByClassName('useTerm-footer')[0];
// 약관 모달창
const useTermModalFooter = document.getElementsByClassName('modal-all-footer')[0];
// 반투명하게 덮는 화면
const overlay = document.getElementById('overlay');
// 모달창 취소 버튼 
const modalCloseBtnFooter = document.getElementsByClassName('modal-button-close-footer')[0];

console.log(overlay);

// 이벤트리스너
// 이용약관 버튼 누를 시 동작
useTermFooter.addEventListener('click', function () {
  useTermModalFooter.style.display = 'flex';
  overlay.style.display = 'block';
});
// 모달창 취소 버튼 누를 시 동작 
modalCloseBtnFooter.addEventListener('click', function () {
  useTermModalFooter.style.display = 'none';
  overlay.style.display = 'none';
});
