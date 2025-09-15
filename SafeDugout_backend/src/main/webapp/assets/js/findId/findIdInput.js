// 루트 경로 
const contextPath = "${pageContext.request.contextPath}";

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
// 찾은 회원번호 
let memberNumber = null;

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
// 아이디 찾기 실패 메시지 
const findFailMessage = document.querySelector('.find-fail-message');

// 이름 유효 여부 
let nameCheck = true;
// 이메일 유효 여부 
let emailCheck = true;
// 전화번호 유효 여부
let phoneNumberCheck = true;
// 인증번호 확인 여부 
let codeCheck = false;
// 이메일 정규표현식, 이메일 입력값(좌우 공백 제외)
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

// ===== SMS 발송 (임시 인증번호 생성) =====
code.disabled = true; // 처음엔 비활성화
const phoneRegex = /^01[016789]-?\d{3,4}-?\d{4}$/;
sendCode.addEventListener("click", function() {
	const phoneNumberChecker = phoneNumber.value.trim();
	if (phoneNumber == null || !phoneRegex.test(phoneNumberChecker)) {
		alert("핸드폰 번호를 입력해주세요.");
		return;
	}

	fetch(`/member/sendSMS.me?memberPhoneNumber=${encodeURIComponent(phoneNumberChecker)}`, {
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

	fetch(`/member/checkSMS.me?verificationCode=${encodeURIComponent(codeChecker)}`, {
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
				codeCheck = true;
			} else {
				codeMismatchMessage.textContent = "인증번호가 일치하지 않습니다.";
				codeMismatchMessage.style.color = "red";
				code.dataset.verified = "false";
				codeCheck = false;
			}
		})
		.catch(() => {
			duplicateMessage.textContent = "요청 중 오류가 발생했습니다.";
			duplicateMessage.style.color = "red";
		});
});

// 확인 버튼 누를 시 동작 
okBtn.addEventListener('click', function () {

  // 입력 오류 메시지 초기화
  for (const message of errorMessage) {
    message.textContent = "";
  }
	findFailMessage.style.visibility = 'hidden';

  // 모든 입력값 유효 여부(오류메시지) 초기화
  nameCheck = true;
  emailCheck = true;
  phoneNumberCheck = true;

  // 필수값 누락 시 메시지 표시
  if (userName.value === "") {
    nameErrorMessage.textContent = '필수 입력 값입니다.';
		nameCheck = false;
  }
  if (email.value === "") {
    emailErrorMessage.textContent = '필수 입력 값입니다.';
		emailCheck = false;
  }
  if (phoneNumber.value === "") {
    phoneNumberErrorMessage.textContent = '필수 입력 값입니다.';
		phoneNumberCheck = false;
  }

	const value = email.value.trim();
	console.log(value);
	console.log(emailRegex.test(value));

	// 이메일 입력값 유효하지 않으면 표시 
	if (email.value !== "" && !(emailRegex.test(value))){
		emailErrorMessage.textContent = "유효한 이메일 주소를 입력해주세요.";
		emailErrorMessage.style.color = "red";
		emailCheck = false;
	}

	// 인증번호가 확인되지 않을 경우 표시 
  if (codeCheck === false) {
    codeMismatchMessage.textContent = '인증번호 확인이 되지 않았습니다.';
  }

	// 누락값 없고, 인증 확인 되면 서버에 전송 
	// && codeCheck
	console.log(nameCheck && emailCheck && phoneNumberCheck);
	if (nameCheck && emailCheck && phoneNumberCheck) {
		fetch(`/member/findIdOk.me`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({
				name: userName.value,
				email: email.value,
				phoneNumber: phoneNumber.value
			}),
		})
		.then(res => res.json())
		.then(result => {
			memberNumber = result.memberNumber;
			nameCheck = result.nameRegistered;
			emailCheck = result.emailRegistered;
			phoneNumberCheck = result.phoneRegistered;

			// 등록되지 않았을 시 메시지 표시
		if(!nameCheck) {
			nameErrorMessage.textContent = '등록되지 않은 이름입니다.';
		}
		if(!emailCheck) {
			emailErrorMessage.textContent = '등록되지 않은 이메일입니다.';
		}
		if(!phoneNumberCheck) {
			phoneNumberErrorMessage.textContent = '등록되지 않은 핸드폰 번호입니다.';
		}
		// 응답받은 id가 있으면 페이지 이동, 그렇지 않으면 메시지 표시 
		if(memberNumber !== -1) {
			location.href = `/member/findIdResultOk.me?memberNumber=${encodeURIComponent(memberNumber)}`;
		}else{
			findFailMessage.style.visibility = 'visible';
		}
		});
	}
});
