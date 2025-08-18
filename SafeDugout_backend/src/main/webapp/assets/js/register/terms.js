// 약관 버튼 
const useTerm = document.getElementById('useTerm');
const consentUsePI = document.getElementById('consentUsePI');
// 약관 모달창
const useTermModal = document.getElementById('useTermModal');
const consentUsePIModal = document.getElementById('consentUsePIModal');
// 모달창 버튼 컨테이너 
const modalBtns = document.getElementsByClassName('modal-button-container')[0];
// 전체 화면
const fullScreen = document.getElementsByClassName('full-screen')[0];
// 모달창 동의 버튼 
const consentBtn = document.getElementsByClassName('modal-button-agree')[0];
// 모달창 취소 버튼 
const modalCancelBtn = document.getElementsByClassName('modal-button-cancel')[0];
// 체크박스 
const useTermCheckBox = document.getElementById('useTermCheckBox');
const consentUsePICheckBox = document.getElementById('consentUsePICheckBox');
// 다음 버튼 
const nextBtn = document.getElementById('nextBtn');
const cancelBtn = document.getElementById('cancelBtn');

// 이벤트리스너
// 이용약관 버튼 누를 시 동작
useTerm.addEventListener('click', function () {
  useTermModal.style.display = 'block';
  fullScreen.style.filter = 'brightness(0.5)';
  fullScreen.style.zIndex = '150';
  fullScreen.style.pointerEvents = 'none';
  fullScreen.style.userSelect = 'none';
  modalBtns.style.display = 'block';
});
// 개인정보 수집/이용 동의 누를 시 동작 
consentUsePI.addEventListener('click', function () {
  consentUsePIModal.style.display = 'block';
  fullScreen.style.filter = 'brightness(0.5)';
  fullScreen.style.zIndex = '150';
  fullScreen.style.pointerEvents = 'none';
  fullScreen.style.userSelect = 'none';
  modalBtns.style.display = 'block';
});
// 모달창 동의 버튼 누를 시 동작 
consentBtn.addEventListener('click', function () {
  if (useTermModal.style.display === 'block') {
    useTermCheckBox.checked = true;
  }
  if (consentUsePIModal.style.display === 'block') {
    consentUsePICheckBox.checked = true;
  }
  useTermModal.style.display = 'none';
  consentUsePIModal.style.display = 'none';
  fullScreen.style.filter = 'none';
  fullScreen.style.zIndex = 'auto';
  fullScreen.style.pointerEvents = 'auto';
  fullScreen.style.userSelect = 'auto';
  modalBtns.style.display = 'none';
});
// 모달창 취소 버튼 누를 시 동작 
modalCancelBtn.addEventListener('click', function () {
  useTermModal.style.display = 'none';
  consentUsePIModal.style.display = 'none';
  fullScreen.style.filter = 'none';
  fullScreen.style.zIndex = 'auto';
  fullScreen.style.pointerEvents = 'auto';
  fullScreen.style.userSelect = 'auto';
  modalBtns.style.display = 'none';
});
// 다음 버튼 누를 시 동작 
nextBtn.addEventListener('click', function () {
  if (useTermCheckBox.checked && consentUsePICheckBox.checked) {
    location.href = './RegisterInput.html';
  } else {
    alert("약관에 동의해주세요.")
  }
});
// 취소 버튼 누를 시 동작 
cancelBtn.addEventListener('click', function () {
  location.href = './../../mainNoLogin.html';
});