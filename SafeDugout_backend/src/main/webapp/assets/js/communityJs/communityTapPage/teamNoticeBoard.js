// 공지 목록 예시 데이터
const noticeData = [
  { id: 1, title: "메인 공지 불펜토크 사이트 이용안내", date: "2025-08-10" },
  { id: 2, title: "팀 커뮤니티 이용 안내", date: "2025-07-30" },
  { id: 3, title: "단체관람 안내", date: "2025-07-15" },
];

// ul 요소 선택
const noticeList = document.getElementById("team-notice-list");

// 공지 리스트 추가 함수
function addNoticeItems(data) {
  data.forEach(item => {
    const li = document.createElement("li");
    li.className = "team-notice-list-item";

    // 공지 제목과 날짜를 담을 div 생성
    const titleDiv = document.createElement("div");
    titleDiv.className = "notice-title";

    const a = document.createElement("a");
    a.textContent = item.title;
    a.href = "./teamNoticeBoardDetail.html";  // 실제 공지 상세 페이지 링크로 변경 필요
    titleDiv.appendChild(a);

    const dateDiv = document.createElement("div");
    dateDiv.className = "notice-date";
    dateDiv.textContent = item.date;

    // li에 추가
    li.appendChild(titleDiv);
    li.appendChild(dateDiv);

    noticeList.appendChild(li);
  });
}

// DOMContentLoaded 이벤트에서 실행
document.addEventListener("DOMContentLoaded", () => {
  addNoticeItems(noticeData);
});
