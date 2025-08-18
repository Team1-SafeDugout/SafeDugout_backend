// 뉴스 데이터 예시
const newsData = [
  {
    imgSrc: "./../../../assets/img/communityImg/lg.png",
    title: "타격 기계도 4번 타자도 아니다, LG 후반기 타격 1위는 '슈퍼 백업'",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/doosan.png",
    title: "두산 베어스, 시즌 후반기 반격 시작",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/kia.png",
    title: "기아 타이거즈, 새로운 전력 보강 효과 기대",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/HH.png",
    title: "한화 이글스, 젊은 선수들 중심으로 팀 리빌딩",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/kt.png",
    title: "KT 위즈, 새 외국인 선수 영입 완료",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/lg.png",
    title: "LG 트윈스, 홈 경기장 리모델링 계획 발표",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/WO.png",
    title: "키움 히어로즈, 신인 선수들의 눈부신 활약",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/doosan.png",
    title: "두산 베어스, 투수진 보강으로 후반기 상승세 기대",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/HH.png",
    title: "한화 이글스, 팬들과 함께하는 다양한 이벤트 개최",
    link: "./teamNewsDetail.html"
  },
  {
    imgSrc: "./../../../assets/img/communityImg/kt.png",
    title: "KT 위즈, 새로운 응원가 공개",
    link: "./teamNewsDetail.html"
  }
];


// 뉴스 리스트를 추가하는 함수
function addNewsItems(newsArray) {
  const newsBox = document.getElementById("team-news-box");

  // 기존 뉴스 목록 초기화
  newsBox.innerHTML = "";

  newsArray.forEach(news => {
    const li = document.createElement("li");
    li.classList.add("team-news-list");

    const a = document.createElement("a");
    a.href = news.link;

    const imgSpan = document.createElement("span");
    const img = document.createElement("img");
    img.src = news.imgSrc;
    img.alt = news.title;
    imgSpan.appendChild(img);

    const textSpan = document.createElement("span");
    textSpan.textContent = news.title;

    a.appendChild(imgSpan);
    a.appendChild(textSpan);
    li.appendChild(a);
    newsBox.appendChild(li);
  });
}

// 페이지 로드 후 실행
window.addEventListener("DOMContentLoaded", () => {
  addNewsItems(newsData);
});
