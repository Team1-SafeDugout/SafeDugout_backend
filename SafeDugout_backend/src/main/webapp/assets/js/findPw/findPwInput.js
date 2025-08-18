// 확인 버튼 
const okBtn = document.getElementById('okBtn');
// 인증 버튼
const authenticate = document.querySelector('.main-input-list:nth-child(4) button');
// 인증 번호 발송 버튼 
const sendCode = document.getElementById('sendCode');

// 입력 필수값 
const userName = document.getElementById("userName");
const id = document.getElementById("id");
const email = document.getElementById("email");
const phoneNumber = document.getElementById("phoneNumber");
// 인증 번호
const code = document.getElementById("code");

// 회원 정보 등록 여부 확인
function checkNameRegistered(userName) {
  return true;
}
function checkIdRegistered(id) {
  return true;
}
function checkEmailRegistered(email) {
  return true;
}
function checkPhoneNumberRegistered(phoneNumber) {
  return true;
}
// 인증번호 일치 여부
let isCodeSame = true;

// 모든 오류 메시지 
const errorMessage = document.querySelectorAll('.main-error-message span');
// 필수 입력값 누락 메시지 
const inputMissingMessage = document.querySelectorAll('.main-error-message span:nth-child(2)');
// 등록되지 않은 회원정보 메시지 
const noNameMessage = document.querySelector('.main-input-list:nth-child(1) span:first-child');
const noIdMessage = document.querySelector('.main-input-list:nth-child(2) span:first-child');
const noEmailMessage = document.querySelector('.main-input-list:nth-child(3) span:first-child');
const noPhoneNumberMessage = document.querySelector('.main-input-list:nth-child(4) span:first-child');
// 인증번호 일치하지 않거나 인증번호 확인 안 되었을 경우 메시지
const codeMismatchMessage = document.querySelector('.main-input-list:nth-child(5) span');

// 확인 버튼 누를 시 동작 
okBtn.addEventListener('click', function () {

  // 입력 오류 메시지 초기화
  for (const message of errorMessage) {
    message.style.display = 'none';
  }

  // 모든 입력값 유효 여부 초기화
  let isValidAll = true;

  // 필수값 누락 시 메시지 표시
  if (userName.value === "") {
    inputMissingMessage[0].style.display = 'inline';
  }
  if (id.value === "") {
    inputMissingMessage[1].style.display = 'inline';
  }
  if (email.value === "") {
    inputMissingMessage[2].style.display = 'inline';
  }
  if (phoneNumber.value === "") {
    inputMissingMessage[3].style.display = 'inline';
  }


  // 등록되어있지 않으면 메시지 표시 
  if (checkNameRegistered(userName.value) === false) {
    noNameMessage.style.display = 'inline';
  }
  if (checkEmailRegistered(email.value) === false) {
    noEmailMessage.style.display = 'inline';
  }
  if (checkPhoneNumberRegistered(phoneNumber.value) === false) {
    noPhoneNumberMessage.style.display = 'inline';
  }

  // 인증번호가 일치하지 않거나 확인 안 된 경우 메시지 표시
  if (isCodeSame === false) {
    codeMismatchMessage.style.display = 'inline';
  }

  // 하나라도 입력 오류 메시지가 있으면 모든 입력값 유효 여부를 false로 변경
  for (const message of errorMessage) {
    if (message.style.display === 'inline') {
      isValidAll = false;
    }
  }

  // 모든 입력값이 유효하면 비밀번호 재설정 페이지로 이동
  if (isValidAll === true) {
    location.href = "./findPwChange.html";
  }
});