// 확인 버튼 
const okBtn = document.getElementById('okBtn');

// 입력 필수값 
const pw = document.getElementById("pw");
// 재입력 비밀번호
const rePw = document.getElementById("rePw");

// 비밀번호 유효성 검사 (영문, 숫자, 특수문자 조합, 각자 1글자 이상 포함, 8자 이상)
function checkPwValid(pw) {
  const reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()])[A-Za-z\d!@#$%^&*()]{8,}$/
  return reg.test(pw);
}

// 비밀번호 재입력 일치 여부 검사
function checkPwSame(pw, rePw) {
  if (pw === rePw) {
    return true;
  } else {
    return false;
  }
}

// 모든 오류 메시지 
const errorMessage = document.querySelectorAll('.main-error-message span');
// 필수 입력값 누락 메시지 
const inputMissingMessage = document.querySelector('.main-input-list:first-child span:nth-child(2)');
// 유효하지 않은 비밀번호 메시지
const invalidPwMessage = document.querySelector('.main-input-list:first-child span:nth-child(1)');
// 비밀번호 불일치 메시지
const pwMismatchMessage = document.querySelector('.main-input-list:last-child span:nth-child(1)');

// 확인 버튼 누를 시 동작 
okBtn.addEventListener('click', function () {

  // 입력 오류 메시지 초기화
  for (const message of errorMessage) {
    message.style.display = 'none';
  }

  // 모든 입력값 유효 여부 초기화
  let isValidAll = true;

  // 필수값 누락 시 메시지 표시
  if (pw.value === "") {
    inputMissingMessage.style.display = 'inline';
  }

  // 비밀번호 유효하지 않을 시 메시지 표시 
  if (checkPwValid(pw.value) === false) {
    invalidPwMessage.style.display = 'inline';
  }

  // 비밀번호 재입력이 일치하지 않을 경우 메시지 표시 
  if (checkPwSame(pw.value, rePw.value) === false) {
    pwMismatchMessage.style.display = 'inline';
  }

  // 하나라도 입력 오류 메시지가 있으면 모든 입력값 유효 여부를 false로 변경
  for (const message of errorMessage) {
    if (message.style.display === 'inline') {
      isValidAll = false;
    }
  }

  // 모든 입력값이 유효하면 비밀번호 재설정 페이지로 이동
  if (isValidAll === true) {
    location.href = "./findPwChangeResult.html";
  }
});