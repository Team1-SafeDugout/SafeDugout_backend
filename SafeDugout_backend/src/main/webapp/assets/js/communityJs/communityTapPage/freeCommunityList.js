// 자유 게시판 데이터 (각 글에 이동할 URL 포함)
const freeBoardData = [
  { id: 1, title: "응원은 한화로", writer: "hanwha", date: "2025-08-12", link: "./freeCommunityDetail.html" },
  { id: 2, title: "응원은 lg로", writer: "lg", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 3, title: "응원은 nc로", writer: "nc", date: "2025-08-10", link: "./freeCommunityDetail.html" },
  { id: 4, title: "응원은 롯데로", writer: "lotte", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 5, title: "응원은 kt로", writer: "kt", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 6, title: "응원은 삼성으로", writer: "samsung", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 7, title: "응원은 두산으로", writer: "doosan", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 8, title: "응원은 kia로", writer: "kia", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 9, title: "응원은 키움으로", writer: "kiwoom", date: "2025-08-11", link: "./freeCommunityDetail.html" },
  { id: 10, title: "응원은 ssg로", writer: "ssg", date: "2025-08-11", link: "./freeCommunityDetail.html" },
];

// ul 요소 선택
const ul = document.getElementById("free-board-content");

// boardData 배열을 순회하며 li 요소 추가
freeBoardData.forEach(item => {
  const li = document.createElement("li");
  li.className = "free-board-list";

  // 각각 div 요소 4개 생성
  const divId = document.createElement("div");
  divId.textContent = item.id;
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

  ul.appendChild(li);
});
