// 예시 공지글 데이터 (실제 서버 API 호출로 교체 가능)
const noticeData = [
  { id: 1, title: "불펜토크 사이트 이용안내", writer: "관리자", date: "2025-08-12" },
  { id: 2, title: "단체관람 안내", writer: "운영팀", date: "2025-08-11" },
  { id: 3, title: "팀 커뮤니티 이용 안내", writer: "운영팀", date: "2025-08-11" }
];

// 예시 게시글 데이터
const boardData = [
    { id: 1, title: '게시글 제목 1', author: '작성자1', date: '2025-08-12', link: './teamPostDetail.html' },
    { id: 2, title: '게시글 제목 2', author: '작성자2', date: '2025-08-11', link: './teamPostDetail.html' },
    { id: 3, title: '게시글 제목 3', author: '작성자3', date: '2025-08-10', link: './teamPostDetail.html' },
    { id: 4, title: '게시글 제목 4', author: '작성자4', date: '2025-08-09', link: './teamPostDetail.html' },
    { id: 5, title: '게시글 제목 5', author: '작성자5', date: '2025-08-08', link: './teamPostDetail.html' },
    { id: 6, title: '게시글 제목 6', author: '작성자6', date: '2025-08-07', link: './teamPostDetail.html' },
    { id: 7, title: '게시글 제목 7', author: '작성자7', date: '2025-08-06', link: './teamPostDetail.html' },
    { id: 8, title: '게시글 제목 8', author: '작성자8', date: '2025-08-05', link: './teamPostDetail.html' },
    { id: 9, title: '게시글 제목 9', author: '작성자9', date: '2025-08-04', link: './teamPostDetail.html' },
    { id: 10, title: '게시글 제목 10', author: '작성자10', date: '2025-08-03', link: './teamPostDetail.html' },
];

// 공지글 리스트 렌더링
function renderNoticeList() {
  const noticeContent = document.getElementById("team-notice-content");

  // 헤더(li 첫번째)는 그대로 두고 나머지 초기화
  while (noticeContent.children.length > 1) {
    noticeContent.removeChild(noticeContent.lastChild);
  }

  noticeData.forEach(notice => {
    const li = document.createElement("li");
    li.classList.add("team-notice-list");

    const a = document.createElement("a");
    a.href = "#"; // 상세 페이지 링크 적용 가능

    const divId = document.createElement("div");
    divId.textContent = notice.id;
    a.appendChild(divId);

    const divTitle = document.createElement("div");
    divTitle.textContent = notice.title;
    a.appendChild(divTitle);

    const divWriter = document.createElement("div");
    divWriter.textContent = notice.writer;
    a.appendChild(divWriter);

    const divDate = document.createElement("div");
    divDate.textContent = notice.date;
    a.appendChild(divDate);

    li.appendChild(a);
    noticeContent.appendChild(li);
  });
}

// 게시글 리스트 렌더링
function renderBoardList() {
  const boardContent = document.querySelector(".team-board-content");

  // 헤더(li 첫번째)는 그대로 두고 나머지 초기화
  while (boardContent.children.length > 1) {
    boardContent.removeChild(boardContent.lastChild);
  }

  boardData.forEach(post => {
    const li = document.createElement("li");
    li.classList.add("team-board-list");

    const a = document.createElement("a");
    a.href = "./teamPostDetail.html"; 

    const divId = document.createElement("div");
    divId.textContent = post.id;
    a.appendChild(divId);

    const divTitle = document.createElement("div");
    divTitle.textContent = post.title;
    a.appendChild(divTitle);

    const divWriter = document.createElement("div");
    divWriter.textContent = post.author;
    a.appendChild(divWriter);

    const divDate = document.createElement("div");
    divDate.textContent = post.date;
    a.appendChild(divDate);

    li.appendChild(a);
    boardContent.appendChild(li);
  });
}

// 초기화 함수 - DOM 로드 후 호출
document.addEventListener("DOMContentLoaded", () => {
  renderNoticeList();
  renderBoardList();
});
