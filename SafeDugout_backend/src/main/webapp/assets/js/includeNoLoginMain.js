// const logOutButton = window.getElementById();
const isLogin = false;

window.addEventListener('DOMContentLoaded', () => {

  const headerFileSelection = isLogin ? "./headerLoginMain.html" : "./headerNoLoginMain.html";

  // 헤더 불러오기
  fetch(headerFileSelection)
    .then(response => response.text())
    .then(data => {
      document.getElementById('header').innerHTML = data;
    });

  // 푸터 불러오기
  fetch('./footer.html')
    .then(response => response.text())
    .then(data => {
      document.getElementById('footer').innerHTML = data;
    });
});
