// 자유 게시판 데이터 (각 글에 이동할 URL 포함)
const freeBoardData = [
  { no: 1, title: "응원은 한화로", writer: "hanwha", date: "2025-08-12", link: "./freeCommunityDetail.html" },
  { no: 2, title: "응원은 lg로", writer: "lg", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 3, title: "응원은 nc로", writer: "nc", date: "2025-08-10", link: "./freeCommunityDetail.html" },
  { no: 4, title: "응원은 롯데로", writer: "lotte", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 5, title: "응원은 kt로", writer: "kt", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 6, title: "응원은 삼성으로", writer: "samsung", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 7, title: "응원은 두산으로", writer: "doosan", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 8, title: "응원은 kia로", writer: "kia", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 9, title: "응원은 키움으로", writer: "kiwoom", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { no: 10, title: "응원은 ssg로", writer: "ssg", date: "2025-08-11", link: "./freeCommunityDetail.html" },
];

// 입문자 가이드 데이터
const guideData = [
  { no: 1, title: "게시판 이용 안내", link: "/guide/1" },
  { no: 2, title: "야구 초보 가이드", link: "/guide/2" },
  { no: 3, title: "응원가 따라 부르기", link: "/guide/3" }
];

// 자유 게시판 ul 선택
const freeBoardUl = document.getElementById("free-board-content");

// 자유 게시판 리스트 추가 함수
function addFreeBoardItems(data) {
  data.forEach(item => {
    const li = document.createElement("li");
    li.className = "free-board-list";

    const divId = document.createElement("div");
    divId.textContent = item.no;
    li.appendChild(divId);

    const divTitle = document.createElement("div");
    const aTitle = document.createElement("a");
    aTitle.textContent = item.title;
    aTitle.href = "./freeCommunityDetail.html"; 
    divTitle.appendChild(aTitle);
    li.appendChild(divTitle);

    const divAuthor = document.createElement("div");
    divAuthor.textContent = item.author;
    li.appendChild(divAuthor);

    const divDate = document.createElement("div");
    divDate.textContent = item.date;
    li.appendChild(divDate);

    freeBoardUl.appendChild(li);
  });
}

// 입문자 가이드 ul 선택
const freeGuideUl = document.getElementById("free-guide-content");

// 입문자 가이드 리스트 추가 함수
function addFreeGuideItems(data) {
  data.forEach(item => {
    const li = document.createElement("li");
    li.className = "free-guide-list";

    const divId = document.createElement("div");
    divId.textContent = item.no;
    li.appendChild(divId);

    const divTitle = document.createElement("div");
    const aTitle = document.createElement("a");
    aTitle.textContent = item.title;
    aTitle.href = "./freeGuideDetail.html"; 
    divTitle.appendChild(aTitle);
    li.appendChild(divTitle);

    freeGuideUl.appendChild(li);
  });
}

// DOMContentLoaded 이벤트에서 실행
document.addEventListener("DOMContentLoaded", () => {
  addFreeBoardItems(freeBoardData);
  addFreeGuideItems(guideData);
});