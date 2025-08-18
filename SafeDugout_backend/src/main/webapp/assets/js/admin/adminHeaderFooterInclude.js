// const logOutButton = window.getElementById();
const isLogin = true;

window.addEventListener('DOMContentLoaded', () => {
  if(window.location.pathname == ""){
    
  }

  const headerFileSelection = isLogin ? "../adminHeader.html" : "../adminHeaderBeforeLogin.html";

  // 헤더 불러오기
  fetch(headerFileSelection)
    .then(response => response.text())
    .then(data => {
      document.getElementById('header').innerHTML = data;
    });

  // 푸터 불러오기
  fetch('../adminFooter.html')
    .then(response => response.text())
    .then(data => {
      document.getElementById('footer').innerHTML = data;
    });
});


