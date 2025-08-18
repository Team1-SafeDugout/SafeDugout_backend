const loginBtn = document.getElementById("login-button");
const loginErrorMessage = document.getElementsByClassName("main-input-fail-message").item(0);
const id = document.getElementById("id");
const pw = document.getElementById("pw");


loginBtn.addEventListener('click',function(){

    if(id.value === "" || pw.value === ""){
        loginErrorMessage.style.display = "block";
    }

    else{
        
        if(id.value === "admin" && pw.value === "1234"){
            loginErrorMessage.style.display = "none";
            location.href = "./../adminMenu/adminSiteStatistics.html";
        }

        else{
            loginErrorMessage.style.display = "block";
        }
    }
});
