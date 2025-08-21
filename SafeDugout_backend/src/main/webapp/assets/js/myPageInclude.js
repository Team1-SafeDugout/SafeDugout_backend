// const logOutButton = window.getElementById();
const isLogin = false;

window.addEventListener('DOMContentLoaded', () => {

  const headerFileSelection = isLogin ? "${pageContext.request.contextPath}/myPageHeaderLogin.jsp" : "${pageContext.request.contextPath}/headerNoLogin.jsp";

  // 헤더 불러오기
  fetch("${pageContext.request.contextPath}/myPageHeader.jsp")
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
