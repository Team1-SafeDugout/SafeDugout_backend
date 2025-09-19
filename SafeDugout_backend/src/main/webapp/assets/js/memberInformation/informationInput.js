const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기

/*정보 저장 버튼*/
const saveButton = document.getElementById("save-button");

/* 핸드폰 인증번호 전송 버튼*/
const validateButton = document.getElementById("validate-button");
const phoneVeriButton = document.getElementById("phoneVeriButton");


/* 핸드폰 인증 완료*/
var phoneChecker = true;

/* 우편번호 수정 버튼*/
const changePostalCodeButton = document.getElementById("searchPostcodeBtn");

/*수정 버튼*/
const fixButton = document.getElementsByClassName("edit-button");
const cofirmButton = document.getElementsByClassName("confirm-button");
/*
0. 비밀번호
1. 핸드폰 번호
2. 이매일
3. 우편번호
4. 마이팀
*/

// 입력값
const pw = document.getElementById("pw");
const rePw = document.getElementById("rePw");
const phoneNumber = document.getElementById("phoneNumber");
const code = document.getElementById("code");
const email = document.getElementById("email");
const postalCode = document.getElementById("postalCode");
const postalButton = document.getElementById("searchPostcodeBtn");
const myTeam = document.getElementById("myTeam");


// 정보 입력 먼저 뜨면 안되는거
const rePwLi = document.getElementById("re-pw");
const validateLi = document.getElementById("validate-phone");

/*입력 오류 메시지*/

/* 비밀번호 미입력,형식 */
const pwError = document.getElementsByClassName("main-input-error-message")[0];

/* 비밀번호 미일치, 미입력 */
const rePwError = document.getElementsByClassName("main-input-error-message")[1];

/* 핸드폰 번호 미입력, 형식*/
const phoneNumError = document.getElementsByClassName("main-input-error-message")[2];

/* 인증번호 미입력, 미일치*/
const validateCodeError = document.getElementsByClassName("main-input-error-message")[3];

/* 이메일 미앱력, 형식*/
const EmailError = document.getElementsByClassName("main-input-error-message")[4];


/* 수정 버튼 클릭 이벤트*/
fixButton[0].addEventListener("click", function() {
	console.log("비밀번호 고치기 버튼 클릭됨");
	cofirmButton[0].style.display = "block";
	fixButton[0].style.display = "none";
	/*pwError.style.display = "block";*/
	rePwLi.style.display = "block";
	/*사용가능하도록 해제*/
	pw.removeAttribute("readonly");
	rePw.removeAttribute("readonly");
	pw.style.pointerEvents = "auto";
	rePw.style.pointerEvents = "auto";
});

fixButton[1].addEventListener("click", function() {
	console.log("핸드폰 번호 고치기 버튼 클릭됨");
	cofirmButton[1].style.display = "block";
	fixButton[1].style.display = "none";

	/*validateLi.style.display = "block";*/
	validateButton.style.display = "block";
	phoneNumber.removeAttribute("readonly");
	phoneNumber.style.pointerEvents = "auto";
	phoneChecker = false;
});

fixButton[2].addEventListener("click", function() {
	console.log("이매일 고치기 버튼 클릭됨");
	cofirmButton[2].style.display = "block";
	fixButton[2].style.display = "none";
/*	EmailError.style.display = "block";*/
	email.removeAttribute("readonly");
	email.style.pointerEvents = "auto";
});

fixButton[3].addEventListener("click", function() {
	console.log("우편번호 고치기 버튼 클릭됨");
	cofirmButton[3].style.display = "block";
	fixButton[3].style.display = "none";
	postalButton.style.display = "block";	
});

fixButton[4].addEventListener("click", function() {
	console.log("마이팀 고치기 버튼 클릭됨");
	cofirmButton[4].style.display = "block";
	fixButton[4].style.display = "none";
	myTeam.removeAttribute("readonly");
	myTeam.style.pointerEvents = "auto";
});

/*-----------------------------------------------------------------*/
/*pwError,rePwError*/
/* 완료 버튼 클릭 이벤트 */
const reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()])[A-Za-z\d!@#$%^&*()]{8,}$/
cofirmButton[0].addEventListener("click", function() {
	const pwChecker = pw.value.trim();
	const rePwChecker = rePw.value.trim();
	if(reg.test(pwChecker)){
		pwError.style.display = "block";
		pwError.value = "사용 가능합니다.";
	} else{
		pwError.style.display = "block";
		pwError.value = "사용 불가능 합니다";
		return;
	}
	
	if(pwChecker === rePwChecker){
		console.log("비밀번호 완료 버튼 클릭됨");
		fixButton[0].style.display = "block";
		cofirmButton[0].style.display = "none";
		pwError.style.display = "none";
		rePwLi.style.display = "none";
		pw.style.pointerEvents = "none";
	} else{
		rePwError.style.display = "block";
		rePwError.value = "일치하지 않습니다.";
		return;
	}
	
});

validateButton.addEventListener('click',function(){
	checkPhone();
});


cofirmButton[1].addEventListener("click", function() {
	console.log("핸드폰 번호 완료 버튼 클릭됨");
	if(phoneChecker){
		fixButton[1].style.display = "block";
		cofirmButton[1].style.display = "none";
		phoneNumError.style.display = "none";
		validateLi.style.display = "none";
		validateButton.style.display = "none";
	}
});


cofirmButton[2].addEventListener("click", function() {
	if(checkEmail()){
		console.log("이매일 완료 버튼 클릭됨");
		fixButton[2].style.display = "block";
		cofirmButton[2].style.display = "none";
		EmailError.style.display = "none";
		email.style.pointerEvents = "none";
	} else{		
		EmailError.style.display = "block";
	}
});

cofirmButton[3].addEventListener("click", function() {
	console.log("우편번호 완료 버튼 클릭됨");
	fixButton[3].style.display = "block";
	cofirmButton[3].style.display = "none";
	postalButton.style.display = "none";
});

cofirmButton[4].addEventListener("click", function() {
	console.log("마이팀 완료 버튼 클릭됨");
	fixButton[4].style.display = "block";
	cofirmButton[4].style.display = "none";
	myTeam.style.pointerEvents = "none";
});

function validateForm() {
	/*모든 완료 버튼의 display 가 히든이면 저장 가능*/
	
	if(	Array.from(cofirmButton).filter(btn => btn.offsetParent === null)){
		alert("정보가 저장 되었습니다");
		return true;
	} else{
		alert("정보 수정을 완료해 주세요");
		return false;
	}
}

// ===== 비밀번호 유효성/일치 =====
const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;

function checkPw() {
	invalidPwMessage.style.display = 'inline';
	const pwChecker = pw.value.trim();
	if (passwordRegex.test(pwChecker)) {
		return true;
	} else {
		return false;
	}
}

function checkRePw() {
	pwMismatchMessage.style.display = 'inline';
	const pwChecker = pw.value.trim();
	const pwChecker2 = rePw.value.trim();
	if (pwChecker && pwChecker === pwChecker2) {
		return true;
	} else {
		return false;
	}
}

// ===== SMS 발송 (임시 인증번호 생성) =====
const phoneRegex = /^01[016789]-?\d{3,4}-?\d{4}$/;
function checkPhone() {
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
			// 인증 버튼 활성화
			validateLi.style.display = "block";

			code.removeAttribute("readonly");
			code.style.pointerEvents = "auto";
			// 재발송 방지
			validateButton.style.display = "none"
			
		})
		.catch(err => {
			// 실패했을 때
			alert("SMS 발송 중 오류가 발생했습니다.\n" + err);
			// 입력 비활성화 유지
			// 인증 버튼 비활성화
			// 다시 시도 가능
		});
}
// ===== 인증번호 확인 (서버 대신 로컬 비교) =====
function checkValidateCode() {
	const codeChecker = code.value.trim();
	if (!codeChecker) {
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
				alert("인증 완료");
				validateLi.style.display = "none";
				phoneChecker = true;
			} else {
				alert("인증 번호를 확인해 주세요");
				phoneChecker = false;
			}
		})
		.catch(() => {
			alert("요청 중 오류가 발생했습니다.");
		});
}

phoneVeriButton.addEventListener("click", function(){
	checkValidateCode();
});

// 이메일 유효성 검사
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
function checkEmail () {
	const value = email.value.trim();

	if (value === "") {
		EmailError.value = "필수 입력 값입니다";
		return false;
	}

	if (emailRegex.test(value)) {
		return true;
	} else {
		EmailError.value = "유효하지 않은 이메일입니다";
		return false;
	}
}

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

