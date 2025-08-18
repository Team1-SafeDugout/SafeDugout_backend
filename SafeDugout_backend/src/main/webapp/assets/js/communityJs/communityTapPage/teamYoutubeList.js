// teamYoutubeList.js
document.addEventListener("DOMContentLoaded", () => {
  const youtubeListEl = document.querySelector(".team-youtube-list");

  // 유튜브 데이터
  const youtubeData = [
    {
      num: 3,
      title: "괴물 투수의 완벽한 경기 하이라이트",
      link: "https://www.youtube.com/watch?v=xxxxxx"
    },
    {
      num: 4,
      title: "역대급 끝내기 홈런 모음",
      link: "https://www.youtube.com/watch?v=yyyyyy"
    },
    {
      num: 5,
      title: "팬들이 뽑은 명장면 베스트 10",
      link: "https://www.youtube.com/watch?v=zzzzzz"
    }
  ];
  // 기존 header 다음에 추가
  youtubeData.forEach(video => {
    const li = document.createElement("li");
    li.classList.add("team-youtube-list-row");
    li.innerHTML = `
      <span>${video.num}</span>
      <span>${video.title}</span>
    `;
    li.addEventListener("click", () => {
      window.location.href = video.link;
    });
    youtubeListEl.appendChild(li);
  });
});
