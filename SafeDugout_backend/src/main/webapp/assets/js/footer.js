// 약관 버튼 
const useTerm = document.getElementById('useTerm');
// 약관 모달창
const useTermModal = document.getElementById('useTermModal');
// 모달창 버튼 컨테이너 
const modalBtns = document.getElementsByClassName('modal-button-container')[0];
// 전체 화면
const fullScreen = document.getElementsByClassName('full-screen')[0];
// 모달창 취소 버튼 
const modalCloseBtnBtn = document.getElementsByClassName('modal-button-close')[0];

console.log(consentBtn);

// 이벤트리스너
// 이용약관 버튼 누를 시 동작
useTerm.addEventListener('click', function () {
  useTermModal.style.display = 'flex';
  fullScreen.style.filter = 'brightness(0.5)';
  fullScreen.style.zIndex = '150';
  fullScreen.style.pointerEvents = 'none';
  fullScreen.style.userSelect = 'none';
  modalBtns.style.display = 'block';
});
// 모달창 취소 버튼 누를 시 동작 
modalCloseBtn.addEventListener('click', function () {
  useTermModal.style.display = 'none';
  consentUsePIModal.style.display = 'none';
  fullScreen.style.filter = 'none';
  fullScreen.style.zIndex = 'auto';
  fullScreen.style.pointerEvents = 'auto';
  fullScreen.style.userSelect = 'auto';
  modalBtns.style.display = 'none';
});
