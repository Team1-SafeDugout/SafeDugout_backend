// teamSongTeamList.js

// 데이터 (글번호, 제목, 링크)
const teamSongs = [
  { num: 1, title: "승리를 위하여", link: "https://www.youtube.com/watch?v=dqW2DaOjOho" },
  { num: 2, title: "엘도라도", link: "https://www.youtube.com/watch?v=g4tl-r76JEs" },
  { num: 3, title: "서울의아리아 ", link: "https://www.youtube.com/watch?v=xr6wPZxyhxI" },
  { num: 4, title: "영광의 순간", link: "https://www.youtube.com/watch?v=_hWa_T6Ku8U" },
  { num: 5, title: "외쳐라 최강기아", link: "https://www.youtube.com/watch?v=yirww4738cs" },
];

document.addEventListener("DOMContentLoaded", () => {
  const listContainer = document.querySelector(".team-song-list");

  teamSongs.forEach(song => {
    const li = document.createElement("li");
    li.classList.add("team-song-list-row");

    li.innerHTML = `
      <span class="team-song-num">${song.num}</span>
      <span class="team-song-title">
        <a href="${song.link}">${song.title}</a>
      </span>
    `;

    listContainer.appendChild(li);
  });
});
