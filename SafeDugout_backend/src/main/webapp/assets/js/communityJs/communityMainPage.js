// 예시 데이터
const newsData = [
  { id: 1, title: "후반기 기세싸움",  link: "#" },
  { id: 2, title: "뉴스 제목 2",  link: "#" },
  { id: 3, title: "뉴스 제목 3",  link: "#" },
];


const videoIds = ['QpIiH_18Cf4', 'sFEzzqbpmM4', 'zC7ZwHBJ3jw'];

const boardData = [
  { id: 101, title: "아싸 1등", writer: "user01", date: "2025-08-10", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },
  { id: 102, title: "우린언제 쯤 이길까?...", writer: "user002", date: "2025-08-09", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },
  { id: 103, title: "연봉 반납해라...", writer: "user003", date: "2025-08-09", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },
  { id: 104, title: "야구장 맛집 추천좀요", writer: "user001", date: "2025-08-09", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },
  { id: 105, title: "000열애설 났어요", writer: "user005", date: "2025-08-09", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },
  { id: 106, title: "우리팀 해체해라!!!", writer: "user004", date: "2025-08-09", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },
  { id: 107, title: "또 역전패 그만좀 해라", writer: "user009", date: "2025-08-09", link: "./../../../../webapp/app/communityHtml/communityTapPage/teamPostDetail.html" },

];

// 뉴스 영역 렌더링
function renderNews() {
  const mainNewsDiv = document.querySelector(".main-news");
  mainNewsDiv.innerHTML = ""; // 초기화

  newsData.forEach(news => {
    const newsDiv = document.createElement("div");
    newsDiv.style.backgroundImage = `url(${news.imgSrc})`;
    newsDiv.title = news.title;

    // 클릭 시 뉴스 링크로 이동
    newsDiv.addEventListener("click", () => {
      window.location.href = news.link;
    });

    mainNewsDiv.appendChild(newsDiv);
  });

  // 뉴스 리스트
  const newsListUl = document.querySelector(".news-list");
  newsListUl.innerHTML = "";
  newsData.forEach(news => {
    const li = document.createElement("li");
    li.textContent = news.title;
    newsListUl.appendChild(li);
  });
}



// 썸네일 리스트 ul 요소 선택
function renderYoutube() {
  const thumbList = document.querySelector('.thumb-list');
  thumbList.innerHTML = ''; 

  videoIds.forEach(id => {
    const li = document.createElement('li');
    const div = document.createElement('div');
    div.className = 'thumb';

    const a = document.createElement('a');
    a.href = `https://www.youtube.com/watch?v=${id}`;
    a.target = '_blank';
    a.rel = 'noopener noreferrer';

    const img = document.createElement('img');
    img.src = `https://img.youtube.com/vi/${id}/hqdefault.jpg`;
    img.alt = `유튜브 영상 썸네일 ${id}`;

    a.appendChild(img);
    div.appendChild(a);
    li.appendChild(div);
    thumbList.appendChild(li);
  });
}



// 게시판 영역
function renderBoard() {
  const boardUl = document.querySelector(".team-board-list");
  boardUl.innerHTML = "";
  boardData.forEach(post => {
    const li = document.createElement("li");
    const a = document.createElement("a");
    a.href = post.link;
    a.textContent = `${post.id} | ${post.title} | ${post.writer} | ${post.date}`;
    li.appendChild(a);
    boardUl.appendChild(li);
    
  });
}

document.addEventListener("DOMContentLoaded", () => {
  renderNews();
  renderBoard();
  renderYoutube();  
});

