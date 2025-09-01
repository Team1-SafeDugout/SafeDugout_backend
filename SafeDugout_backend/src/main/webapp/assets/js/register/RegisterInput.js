const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기

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
const postalButton = document.getElementById("searchPostcodeBtn");
const address = document.getElementById("address");
const detailAddress = document.getElementById("detailAddress")
const myTeam = document.getElementById("myTeam");

// 입력 오류 메시지
const errorMessage = document.querySelectorAll('.main-input-error-message span');
const inputMissingMessage = document.getElementsByClassName('requiredValue');

const invalidIdMessage = document.querySelector('li:nth-child(2) span:nth-child(2)');
const codeMismatchMessage = document.querySelector('li:nth-child(6) span');

const requiredMessage = document.querySelector('li:nth-child(6) span:last-child');
const invalidEmail = document.querySelector('li:nth-child(7) span:last-child');


let idCheck = false;
let pwCheck = false;
let phoneCheck = false;
let emailCheck = false;


// 회원 가입 버튼 누를떄 요효성 검사
onsubmit = "return validateForm()"

function validateForm() {

	if (userName.value === "") {
		inputMissingMessage[0].style.display = 'inline';
		return false;
	}

	if (email.value === "") {
		inputMissingMessage[4].style.display = 'inline';
		return false;
	}

	if (idCheck == false) {
		inputMissingMessage[1].style.display = 'inline';
		id.scrollIntoView({ behavior: "smooth", block: "center" });
		return false;
	}

	else if (pwCheck == false) {
		inputMissingMessage[2].style.display = 'inline';
		pw.scrollIntoView({ behavior: "smooth", block: "center" });
		return false;
	}

	else if (phoneCheck == false) {
		inputMissingMessage[3].style.display = 'inline';
		phoneNumber.scrollIntoView({ behavior: "smooth", block: "center" });
		return false;
	}

	else if (emailCheck == false) {
		return false;
	}

	else {
		if (!postalCode.value.trim()) {
			postalCode.value = "0";
		}
		return true
	}
}

userName.addEventListener("blur", function() {

	if (userName.value !== "")
		inputMissingMessage[0].style.display = "none";
});

email.addEventListener("blur", function() {

	if (email.value !== "")
		inputMissingMessage[4].style.display = "none";
});

id.addEventListener("blur", function() {

	if (id.value !== "")
		inputMissingMessage[1].style.display = "none";
});

pw.addEventListener("blur", function() {

	if (pw.value !== "")
		inputMissingMessage[2].style.display = "none";
});

phoneNumber.addEventListener("blur", function() {

	if (phoneNumber.value !== "")
		inputMissingMessage[3].style.display = "none";
});

const duplicateMessage = document.querySelector('li:nth-child(2) span:nth-child(3)');
// 중복 확인 버튼 누를 시 아이디 중복 검사
checkDuplicate.addEventListener("click", function() {
	const memberId = id.value.trim();
	duplicateMessage.style.display = 'inline';
	if (!memberId) {
		duplicateMessage.textContent = "아이디를 입력해주세요.";
		duplicateMessage.style.color = "red";
		return;
	}
	fetch(`${base}/member/checkIdOk.me?memberId=${encodeURIComponent(memberId)}`, {
		headers: { "Accept": "application/json" }
	})
		.then(r => { if (!r.ok) throw new Error(r.status); return r.json(); })
		.then(data => {
			if (data.available) {
				duplicateMessage.textContent = "사용 가능한 아이디입니다.";
				duplicateMessage.style.color = "green";
				idCheck = true;
			} else {
				duplicateMessage.textContent = "이미 사용 중인 아이디입니다.";
				duplicateMessage.style.color = "red";
				idCheck = false;
			}
		})
		.catch(() => {
			duplicateMessage.textContent = "아이디 중복 검사 중 오류가 발생했습니다.";
			duplicateMessage.style.color = "red";
			idCheck = false;
		});
});

const invalidPwMessage = document.querySelector('li:nth-child(3) span:last-child');
const pwMismatchMessage = document.querySelector('li:nth-child(4) span');

// ===== 비밀번호 유효성/일치 =====
const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;

pw.addEventListener("blur", function() {
	invalidPwMessage.style.display = 'inline';
	const pwChecker = pw.value.trim();
	if (passwordRegex.test(pwChecker)) {
		invalidPwMessage.textContent = "사용 가능한 비밀번호입니다.";
		invalidPwMessage.style.color = "green";
	} else {
		invalidPwMessage.textContent = "비밀번호는 영문, 숫자, 특수문자를 포함하여 8자 이상 입력해야 합니다.";
		invalidPwMessage.style.color = "red";
	}
});

rePw.addEventListener("blur", function() {
	pwMismatchMessage.style.display = 'inline';
	const pwChecker = pw.value.trim();
	const pwChecker2 = rePw.value.trim();
	if (pwChecker && pwChecker === pwChecker2) {
		pwMismatchMessage.textContent = "비밀번호가 일치합니다.";
		pwMismatchMessage.style.color = "green";
		pwCheck = true;
	} else {
		pwMismatchMessage.textContent = "비밀번호가 일치하지 않습니다.";
		pwMismatchMessage.style.color = "red";
		pwCheck = false;
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

// 이메일 유효성 검사
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
email.addEventListener('blur', function() {

	const value = email.value.trim();

	if (value === "") {
		inputMissingMessage[4].style.display = "inline";
		return;
	}

	if (emailRegex.test(value)) {
		invalidEmail.style.display = "inline";
		invalidEmail.textContent = "사용 가능한 이메일입니다.";
		invalidEmail.style.color = "green";
		emailCheck = true;
	} else {
		invalidEmail.style.display = "inline";
		invalidEmail.textContent = "유효한 이메일 주소를 입력해주세요.";
		invalidEmail.style.color = "red";
		emailCheck = false;
	}


});

// 우편번호 버튼 누를 시 우편번호 검색
postalButton.addEventListener('click', function() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 1) 우편번호
			postalCode.value = data.zonecode || "";

			// 2) 메인 주소(도로명 또는 지번 한 칸만)
			//    - 참고항목(동/건물명)은 괄호로 덧붙임
			var isRoad = data.userSelectedType === "R";
			var base = isRoad ? (data.roadAddress || "") : (data.jibunAddress || "");
			var extra = "";

			if (isRoad) {
				if (data.bname && /[동|로|가]$/.test(data.bname)) extra += data.bname;
				if (data.buildingName && data.apartment === "Y") {
					extra += (extra ? ", " : "") + data.buildingName;
				}
			}
		}
	}).open({ popupTitle: "우편번호 검색" });
});

