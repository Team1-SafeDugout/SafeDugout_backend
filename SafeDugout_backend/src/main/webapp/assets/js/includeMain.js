// const logOutButton = window.getElementById();
const isLogin = true;

window.addEventListener('DOMContentLoaded', () => {

  const headerFileSelection = isLogin ? "${pageContext.request.contextPath}/headerLoginMain.jsps" : "${pageContext.request.contextPath}/headerNoLoginMain.jsp";

  // 헤더 불러오기
  fetch(headerFileSelection)
    .then(response => response.text())
    .then(data => {
      document.getElementById('header').innerHTML = data;
    });

  // 푸터 불러오기
  fetch('${pageContext.request.contextPath}/footer.jsp')
    .then(response => response.text())
    .then(data => {
      document.getElementById('footer').innerHTML = data;
    });
});
