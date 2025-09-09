// 확인 버튼 
const okBtn = document.getElementById('okBtn');
// 인증 번호 발송 버튼 
const sendCode = document.querySelector('.main-input-list:nth-child(3) button');
// 인증 버튼
const authenticate = document.querySelector('.main-input-list:nth-child(4) button');

// 입력 필수값(이름, 이메일, 핸드폰 번호)
const userName = document.getElementById("userName");
const email = document.getElementById("email");
const phoneNumber = document.getElementById("phoneNumber");
// 입력한 인증 번호
const inputCode = document.getElementById("code");

// 이름 오류 메시지 
const nameErrorMessage = document.querySelector('.main-input-list:nth-child(1) .main-error-message');
// 이메일 오류 메시지 
const emailErrorMessage = document.querySelector('.main-input-list:nth-child(2) .main-error-message');
// 핸드폰 번호 오류 메시지 
const phoneNumberErrorMessage = document.querySelector('.main-input-list:nth-child(3) .main-error-message');
// 인증번호 오류 메시지 
const codeMismatchMessage = document.querySelector('.main-input-list:nth-child(4) .main-error-message');
// 모든 오류 메시지 
const errorMessage = document.querySelectorAll('.main-error-message');


// 확인 버튼 누를 시 동작 
okBtn.addEventListener('click', function () {

  // 입력 오류 메시지 초기화
  for (const message of errorMessage) {
    message.textContent = "";
  }

  // 모든 입력값 유효 여부 초기화
  let isValidAll = true;

  // 필수값 누락 시 메시지 표시
  if (userName.value === "") {
    inputMissingMessage[0].style.display = 'inline';
  }
  if (email.value === "") {
    inputMissingMessage[1].style.display = 'inline';
  }
  if (phoneNumber.value === "") {
    inputMissingMessage[2].style.display = 'inline';
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

  // 인증번호가 일치하지 않을 경우 표시 
  if (isCodeSame === false) {
    codeMismatchMessage.style.display = 'inline';
  }

  // 인증번호가 확인되지 않을 경우 표시 
  if (isCodeSame === false) {
    codeMismatchMessage.style.display = 'inline';
  }

  // 하나라도 입력 오류 메시지가 있으면 모든 입력값 유효 여부를 false로 변경
  for (const message of errorMessage) {
    if (message.style.display === 'inline') {
      isValidAll = false;
    }
  }

  // 모든 입력값이 유효하면 아이디 찾기 결과 페이지로 이동
  if (isValidAll === true) {
    location.href = "./findIdResultId.html";
  }
});

// ===== SMS 발송 (임시 인증번호 생성) =====
code.disabled = true; // 처음엔 비활성화
const phoneRegex = /^01[016789]-?\d{3,4}-?\d{4}$/;
sendCode.addEventListener("click", function() {
	const phoneNumberChecker = phoneNumber.value.trim();
	if (phoneNumber == null || !phoneRegex.test(phoneNumberChecker)) {
		alert("핸드폰 번호를 입력해주세요.");
		return;
	}

	fetch(`${base}/member/sendSMS.me?memberPhoneNumber=${encodeURIComponent(phoneNumberChecker)}`, {
		method: "GET",
		headers: {
			"Accept": "text/plain",
			"X-Requested-With": "XMLHttpRequest" // 이걸 추가해야 서버를 다시로드 하지 않고 인증번호를 받을 수 있음
		}
	})
		.then(res => {
			if (!res.ok) throw new Error("발송 실패: " + res.status);
			return res.text(); // text 형식으로 받음
		})
		.then(msg => {
			// 서버가 성공적으로 처리했을 때만 실행
			alert(msg);               // 발송 메시지
			code.disabled = false;     // 인증번호 입력 활성화
			authenticate.disabled = false; // 인증 버튼 활성화
			sendCode.disabled = true;  // 재발송 방지
		})
		.catch(err => {
			// 실패했을 때
			alert("SMS 발송 중 오류가 발생했습니다.\n" + err);
			code.disabled = true;      // 입력 비활성화 유지
			authenticate.disabled = true; // 인증 버튼 비활성화
			sendCode.disabled = false; // 다시 시도 가능
		});
});

// ===== 인증번호 확인 (서버 대신 로컬 비교) =====
authenticate.addEventListener("click", function() {
	const codeChecker = code.value.trim();
	codeMismatchMessage.style.display = 'inline';
	if (!codeChecker) {
		codeMismatchMessage.textContent = "인증번호를 입력해주세요.";
		codeMismatchMessage.style.color = "red";
		return;
	}

	fetch(`${base}/member/checkSMS.me?verificationCode=${encodeURIComponent(codeChecker)}`, {
		headers: { "Accept": "text/plain", "X-Requested-With": "XMLHttpRequest"} 
		}).then(res => {
			    if (!res.ok) throw new Error("발송 실패: " + res.status);
			    return res.text(); // text 형식으로 받음
		})
		.then(msg => {
			if (msg.includes("성공")) {
				codeMismatchMessage.textContent = "인증에 성공했습니다.";
				codeMismatchMessage.style.color = "green";
				code.dataset.verified = "true";
				code.readonly = true;
				authenticate.style.display = "none";
				sendCode.style.display = "none";
				phoneCheck = true;
			} else {
				codeMismatchMessage.textContent = "인증번호가 일치하지 않습니다.";
				codeMismatchMessage.style.color = "red";
				code.dataset.verified = "false";
				phoneCheck = false;
			}
		})
		.catch(() => {
			duplicateMessage.textContent = "요청 중 오류가 발생했습니다.";
			duplicateMessage.style.color = "red";
		});
});