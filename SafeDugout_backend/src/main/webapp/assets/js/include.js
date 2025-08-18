// const logOutButton = window.getElementById();
const isLogin = true;

window.addEventListener('DOMContentLoaded', () => {

  const headerFileSelection = isLogin ? "./../../headerLogin.html" : "./../../headerNoLogin.html";

  // 헤더 불러오기
  fetch(headerFileSelection)
    .then(response => response.text())
    .then(data => {
      document.getElementById('header').innerHTML = data;
    });

  // 푸터 불러오기
  fetch('./../../footer.html')
    .then(response => response.text())
    .then(data => {
      document.getElementById('footer').innerHTML = data;
    });
});
