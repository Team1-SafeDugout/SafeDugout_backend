// const logOutButton = window.getElementById();
const isLogin = true;

window.addEventListener('DOMContentLoaded', () => {

  const headerFileSelection = isLogin ? "/webapp/headerLogin.html" : "/webapp/headerNoLogin.html";

  // 헤더 불러오기
  fetch(headerFileSelection)
    .then(response => response.text())
    .then(data => {
      document.getElementById('header').innerHTML = data;
    });

  // 푸터 불러오기
  fetch('/webapp/footer.html')
    .then(response => response.text())
    .then(data => {
      document.getElementById('footer').innerHTML = data;
    });
});
