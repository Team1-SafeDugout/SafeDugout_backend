// 버튼
const checkDuplicate = document.querySelector('li:nth-child(2) button');
const sendCode = document.querySelector('li:nth-child(5) button');
const authenticate = document.querySelector('li:nth-child(6) button');
const findPostalCode = document.querySelector('li:nth-child(8) button');
const registerBtn = document.getElementById('registerBtn');

// 아이디 유효성 검사 (영문, 숫자 조합 6자 이상)
function checkIdValid(id) {
  const reg = /^[A-Za-z0-9]{6,}$/;
  return reg.test(id);
}

// 아이디 중복 여부
let isDuplicate = false;

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

// 인증번호 일치 여부
let isCodeSame = true;

// 입력값
const userName = document.getElementById("userName");
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const rePw = document.getElementById("rePw");
const phoneNumber = document.getElementById("phoneNumber");
const code = document.getElementById("code");
const email = document.getElementById("email");
const postalCode = document.getElementById("postalCode");
const address = document.getElementById("address");
const detailAddress = document.getElementById("detailAddress")
const myTeam = document.getElementById("myTeam");

// 입력 오류 메시지
const errorMessage = document.querySelectorAll('.main-input-error-message span');
const inputMissingMessage = document.getElementsByClassName('requiredValue');
const invalidIdMessage = document.querySelector('li:nth-child(2) span:nth-child(2)');
const duplicateMessage = document.querySelector('li:nth-child(2) span:nth-child(3)');
const invalidPwMessage = document.querySelector('li:nth-child(3) span:last-child');
const pwMismatchMessage = document.querySelector('li:nth-child(4) span');
const codeMismatchMessage = document.querySelector('li:nth-child(6) span');
const requiredMessage = document.querySelector('li:nth-child(6) span:last-child');
const invalidEmail = document.querySelector('li:nth-child(7) span:last-child');

// 이벤트리스너
// 회원 가입 버튼 누를 시 메시지 표시 
registerBtn.addEventListener('click', function () {

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
  if (pw.value === "") {
    inputMissingMessage[2].style.display = 'inline';
  }
  if (phoneNumber.value === "") {
    inputMissingMessage[3].style.display = 'inline';
  }
  if (email.value === "") {
    inputMissingMessage[4].style.display = 'inline';
  }

  // 아이디가 유효하지 않을 경우 메시지 표시 
  if (checkIdValid(id.value) === false) {
    invalidIdMessage.style.display = 'inline';
  }

  // 아이디가 중복되었거나 중복 확인 안 된 경우 메시지 표시
  if (isDuplicate === true) {
    duplicateMessage.style.display = 'inline';
  }

  // 비밀번호가 유효하지 않을 경우 메시지 표시 
  if (checkPwValid(pw.value) === false) {
    invalidPwMessage.style.display = 'inline';
  }

  // 비밀번호 재입력이 일치하지 않을 경우 메시지 표시 
  if (checkPwSame(pw.value, rePw.value) === false) {
    pwMismatchMessage.style.display = 'inline';
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

  // 모든 입력값이 유효하면 페이지 이동, MY팀 선택 여부에 따라 다른 페이지로 이동
  if (isValidAll === true) {
    if (myTeam.value === "unselected") {
      location.href = "./RegisterResultMyTeamUnselected.html";
    } else {
      location.href = "./RegisterResultMyTeamSelected.html";
    }
  }
});

// 중복 확인 버튼 누를 시 아이디 중복 검사
checkDuplicate.addEventListener('click', function () {
  // 아이디 중복 검사 

  // 중복 아닌 경우 메시지 감추기
  if (isDuplicate === false) {
    duplicateMessage.style.display = 'none';
  }
});

// 인증번호 발송 버튼 누를 시 인증번호 발송 
sendCode.addEventListener('click', function () {

});

// 인증 버튼 누를 시 인증번호 확인
authenticate.addEventListener('click', function () {
  // 인증번호 확인 

  // 인증번호가 확인된 경우 메시지 감추기 
  if (isCodeSame === true) {
    codeMismatchMessage.style.display = 'none';
  }
});

// 우편번호 버튼 누를 시 우편번호 검색
postalCode.addEventListener('click', function () {

});

// 우편번호가 입력될 경우 상세 주소 입력 가능 
postalCode.addEventListener('input', function () {
  if (postalCode.value != "") {
    detailAddress.style.placeholder = "상세 주소 입력"
    detailAddress.readonly = false;
    detailAddress.style.pointerEvents = "auto";
  }
  if (postalCode.value === "") {
    detailAddress.style.placeholder = undefined;
    detailAddress.readonly = true;
    detailAddress.style.pointerEvents = "none";
  }
});

