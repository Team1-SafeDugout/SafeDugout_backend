const loginBtn = document.querySelector('.main-login-button');
const loginErrorMessage = document.getElementsByClassName("main-input-fail-message").item(0);
const id = document.getElementById("id");
const pw = document.getElementById("pw");
// 이전 페이지 URL 저장할 input 선택
const originPageInput = document.getElementById("originPage");

loginBtn.addEventListener('click', function () {

 /* if (id.value === "" || pw.value === "") {
    loginErrorMessage.style.visibility = "visible";
  }

  else {

    if (id.value === "user1234" && pw.value === "1234") {
      loginErrorMessage.style.visibility = "hidden";
      location.href = "./../../mainLogin.html";
    }

    else {
      loginErrorMessage.style.visibility = "visible";
    }
  }*/
});

// hidden type input에 이전 페이지 URL 저장
originPageInput.value = document.referrer;
