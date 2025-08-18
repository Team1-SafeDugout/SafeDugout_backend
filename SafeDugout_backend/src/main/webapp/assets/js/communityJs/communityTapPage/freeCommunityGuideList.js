// 예시 데이터
const guideData = [
  { id: 1, title: "입문자 가이드 1", date: "2025-08-12", link: "./freeCommunityGuideDetail.html" },
  { id: 2, title: "입문자 가이드 2", date: "2025-08-11", link: "./freeCommunityGuideDetail.html" },
  { id: 3, title: "입문자 가이드 3", date: "2025-08-10", link: "./freeCommunityGuideDetail.html" },
];

// ul 선택
const guideUl = document.getElementById("free-guide-list");

// 리스트 추가 함수
function addGuideItems(data) {
  data.forEach(item => {
    const li = document.createElement("li");
    li.className = "free-guide-list-item";

    const divTitle = document.createElement("div");
    divTitle.className = "free-guide-title";

    const a = document.createElement("a");
    a.textContent = item.title;
    a.href = item.link;
    divTitle.appendChild(a);

    li.appendChild(divTitle);


    const divDate = document.createElement("div");
    divDate.className = "free-guide-date";
    divDate.textContent = item.date;
    li.appendChild(divDate);
    

    guideUl.appendChild(li);
  });
}

document.addEventListener("DOMContentLoaded", () => {
  addGuideItems(guideData);
});
