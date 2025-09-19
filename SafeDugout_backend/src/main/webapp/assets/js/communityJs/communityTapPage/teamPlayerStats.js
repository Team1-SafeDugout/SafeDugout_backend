// let memberNumber = "${sessionScope.memberNumber}";

document.addEventListener("DOMContentLoaded", function() {
  const pitcherBtn = document.querySelector('[data-tab="pitcher"]');
  const batterBtn = document.querySelector('[data-tab="batter"]');
  const pitcherTable = document.getElementById("team-pitcher-table");
  const batterTable = document.getElementById("team-batter-table");

  // 페이지가 로드되면 투수 데이터 불러오기 (초기 상태)
  fetchAndDisplayStats("pitcher");

  // 버튼 클릭 이벤트 리스너
  pitcherBtn.addEventListener("click", () => {
    if (!pitcherBtn.classList.contains("active")) {
      pitcherBtn.classList.add("active");
      batterBtn.classList.remove("active");
      pitcherTable.style.display = "block";
      batterTable.style.display = "none";
      fetchAndDisplayStats("pitcher");
    }
  });

  batterBtn.addEventListener("click", () => {
    if (!batterBtn.classList.contains("active")) {
      batterBtn.classList.add("active");
      pitcherBtn.classList.remove("active");
      batterTable.style.display = "block";
      pitcherTable.style.display = "none";
      fetchAndDisplayStats("batter");
    }
  });

  // 서버에서 JSON 데이터를 가져오는 함수
  function fetchAndDisplayStats(statsType) {
    const url = `${pageContext.request.contextPath}/kbo/stats?tab=${statsType}`;
    
    fetch(url)
      .then(response => response.json())
      .then(data => {
        if (statsType === "pitcher") {
          renderPitcherStats(data);
        } else {
          renderBatterStats(data);
        }
      })
      .catch(error => console.error("데이터를 가져오는 중 오류 발생:", error));
  }

  // 투수 데이터를 테이블에 렌더링하는 함수
  function renderPitcherStats(stats) {
    const dataContainer = pitcherTable.querySelector(".team-stats-data");
    dataContainer.innerHTML = ''; // 기존 데이터 지우기
    
    stats.forEach(player => {
      const row = document.createElement("div");
      row.className = "player-row";
      row.innerHTML = `
        <div>${player.순위}</div>
        <div>${player.선수명}</div>
        <div>${player.팀명}</div>
        <div>${player.ERA}</div>
        <div>${player.경기}</div>
        <div>${player.승}</div>
        <div>${player.패}</div>
        <div>${player.세이브}</div>
        <div>${player.홀드}</div>
        <div>${player.승률}</div>
        <div>${player.이닝}</div>
        <div>${player.피안타}</div>
        <div>${player.피홈런}</div>
        <div>${player.볼넷}</div>
        <div>${player.사구}</div>
        <div>${player.삼진}</div>
        <div>${player.실점}</div>
        <div>${player.자책점}</div>
        <div>${player.WHIP}</div>
      `;
      dataContainer.appendChild(row);
    });
  }

  // 타자 데이터를 테이블에 렌더링하는 함수
  function renderBatterStats(stats) {
    const dataContainer = batterTable.querySelector(".team-stats-data");
    dataContainer.innerHTML = ''; // 기존 데이터 지우기

    stats.forEach(player => {
      const row = document.createElement("div");
      row.className = "player-row";
      row.innerHTML = `
        <div>${player.순위}</div>
        <div>${player.선수명}</div>
        <div>${player.팀명}</div>
        <div>${player.AVG}</div>
        <div>${player.G}</div>
        <div>${player.PA}</div>
        <div>${player.AB}</div>
        <div>${player.R}</div>
        <div>${player.H}</div>
        <div>${player._1B}</div>
        <div>${player._2B}</div>
        <div>${player._3B}</div>
        <div>${player.HR}</div>
        <div>${player.TB}</div>
        <div>${player.RBI}</div>
        <div>${player.SAC}</div>
        <div>${player.SF}</div>
      `;
      dataContainer.appendChild(row);
    });
  }
});