// 공지사항 제목 출력 부분 선택 
const recentMainTitle = document.querySelector('.main-notice');

fetch('/header.ma')
.then(res => res.text())
.then(result => {
  recentMainTitle.textContent = result;
});

