// 상품 등록 버튼
const registerBtn = document.getElementById('registerBtn');
// 취소 버튼
const cancelBtn = document.getElementById('cancelBtn');
// 이미지 표시  
const previewImg = document.getElementById('previewImg');
// 이미지 업로드 input 태그 
const uploadImg = document.getElementById('uploadImg');
// 이미지 삭제 버튼 
const deleteImg = document.getElementById('deleteImg');
// 팀 로고 
const teamLogo = document.querySelectorAll('.logo');
// 로고에 따른 value 가 들어갈 input 
const team = document.getElementById('team');

// 상품 정보 필수 입력값 
const productName = document.getElementById('productName');
const productType = document.getElementsByName('productType');
const tradeMethod = document.getElementsByName('tradeMethod');
const productPoint = document.getElementById('productPoint');

// 상품 종류 선택 여부
let isTypeChecked = false;
// 거래 방식 선택 여부 
let isMethodChecked = false;

// 입력값 누락 메시지 
// 가격 외
const errorMessage = document.getElementsByClassName('register-error-message');
// 가격 
const errorMessagePrice = document.getElementsByClassName('register-error-message-price')[0];

// 이벤트리스너
// 상품 등록 버튼 누를 시 작동
registerBtn.addEventListener('click', function () {
  // 입력값 누락 메시지 초기화
  for (const message of errorMessage) {
    message.style.visibility = 'hidden';
  }
  errorMessagePrice.style.visibility = 'hidden';

  // 모든 입력값 유효 여부 초기화
  let isValidAll = true;

  // 필수 입력값 누락 시 메시지 표시
  if (productName.value === "") {
    errorMessage[0].style.visibility = 'visible';
  }

  // 상품 종류 선택되어 있으면 선택 여부 true로 변경 
  for (radioBtn of productType) {
    if (radioBtn.checked) {
      isTypeChecked = true;
    }
  }

  // 상품 종류 선택되어 있지 않으면 메시지 표시 
  if (isTypeChecked === false) {
    errorMessage[1].style.visibility = 'visible';
  }

  // 거래 방식 선택되어 있으면 선택 여부 true로 변경 
  for (radioBtn of tradeMethod) {
    if (radioBtn.checked) {
      isMethodChecked = true;
    }
  }

  // 거래 방식 선택되어 있지 않으면 메시지 표시 
  if (isMethodChecked === false) {
    errorMessage[2].style.visibility = 'visible';
  }

  // 상품 가격 입력되어 있지 않으면 메시지 표시 
  if (productPoint.value === "") {
    errorMessagePrice.style.visibility = 'visible';
  }

  // 하나라도 입력 오류 메시지가 있으면 모든 입력값 유효 여부를 false로 변경
  for (const message of errorMessage) {
    if (message.style.visibility === 'visible') {
      isValidAll = false;
    }
  }
  if (errorMessagePrice.style.visibility === 'visible') {
    isValidAll = false;
  }

  // 모든 입력값이 유효하면 페이지 이동
  if (isValidAll === true) {
    location.href = "./productRegisterResult.html";
  }
});

// 취소 버튼 누를 시 작동
cancelBtn.addEventListener('click', function () {
  if (confirm("등록을 취소하시겠습니까?")) {
    location.href = "./tradeMain.html";
  } else {

  }
});

// 이미지 파일 업로드될 시 이미지 표시, 삭제 버튼 표시 
uploadImg.addEventListener('change', function () {
  const img = uploadImg.files[0];
  previewImg.src = URL.createObjectURL(img);
  deleteImg.style.display = 'inline';
});

// 이미지 삭제 버튼 누를 시 파일 업로드 해제, 기본 이미지 표시, 삭제 버튼 감추기
deleteImg.addEventListener('click', function () {
  uploadImg.value = "";
  previewImg.src = "./../../assets/img/communityImg/tradeLogo.png";
  deleteImg.style.display = 'none';
});

// 팀에 따른 value 값 배열 
const teamValue = ['doosan', 'HH', 'kia', 'kt', 'lg', 'LT', 'nc', 'SS', 'ssg', 'WO'];

// 팀 로고 누를 시 빨간 네모 표시, input 태그 value 설정 
teamLogo.forEach((logo, index) => {
  logo.addEventListener('click', function (e) {
    // 기존 빨간 네모 없애기 
    for (let targetLogo of teamLogo) {
      targetLogo.style.border = 'none';
    }

    // 빨간 네모 표시 
    e.currentTarget.style.border = '1px solid red';

    // input 태그 value 설정 
    team.value = teamValue[index];
  });
});
