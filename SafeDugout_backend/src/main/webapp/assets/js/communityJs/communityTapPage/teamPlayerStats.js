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
    // pageContext 변수가 정의되지 않았을 경우를 대비한 안전한 접근
    const contextPath = typeof pageContext !== 'undefined' ? pageContext.request.contextPath : '';
    const url = `${contextPath}/kbo/stats?tab=${statsType}`;
    
    fetch(url)
      .then(response => {
        // HTTP 응답이 성공적인지 확인
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        // 서버에서 받은 JSON 데이터를 콘솔에 출력하여 구조 확인
        console.log(`서버에서 받은 ${statsType} 데이터:`, data);
        
        // 데이터가 배열이 아닐 경우 배열로 감싸줌
        const statsArray = Array.isArray(data) ? data : [data];
        
        if (statsType === "pitcher") {
          renderPitcherStats(statsArray);
        } else {
          renderBatterStats(statsArray);
        }
      })
      .catch(error => {
        console.error("데이터를 가져오는 중 오류 발생:", error);
      });
  }

  // 투수 데이터를 테이블에 렌더링하는 함수
  function renderPitcherStats(stats) {
    const dataContainer = pitcherTable.querySelector(".team-stats-data");
    dataContainer.innerHTML = ''; // 기존 데이터 지우기
    
    if (stats.length === 0) {
      dataContainer.innerHTML = '<div>데이터가 없습니다.</div>';
      return;
    }

    stats.forEach(player => {
      const row = document.createElement("div");
      row.className = "player-row";
      // JSON 데이터의 키에 맞게 변경
      row.innerHTML = `
        <div>${player.playerNumber}</div>
        <div>${player.playerName}</div>
        <div>${player.teamName}</div>
        <div>${player.era}</div>
        <div>${player.game}</div>
        <div>${player.w}</div>
        <div>${player.l}</div>
        <div>${player.sv}</div>
        <div>${player.hld}</div>
        <div>${player.wpct}</div>
        <div>${player.ip}</div>
        <div>${player.h}</div>
        <div>${player.hr}</div>
        <div>${player.bb}</div>
        <div>${player.hbp}</div>
        <div>${player.so}</div>
        <div>${player.r}</div>
        <div>${player.er}</div>
        <div>${player.whip}</div>
      `;
      dataContainer.appendChild(row);
    });
  }

  // 타자 데이터를 테이블에 렌더링하는 함수
  function renderBatterStats(stats) {
    const dataContainer = batterTable.querySelector(".team-stats-data");
    dataContainer.innerHTML = ''; // 기존 데이터 지우기

    if (stats.length === 0) {
      dataContainer.innerHTML = '<div>데이터가 없습니다.</div>';
      return;
    }

    stats.forEach(player => {
      const single = parseInt(player.h) - (parseInt(player.doublehit) + parseInt(player.triplehit) + parseInt(player.hr));
      
      const row = document.createElement("div");
      row.className = "player-row";
      row.innerHTML = `
        <div>${player.playerNumber}</div>
        <div>${player.playerName}</div>
        <div>${player.teamName}</div>
        <div>${player.avg}</div>
        <div>${player.game}</div>
        <div>${player.pa}</div>
        <div>${player.ab}</div>
        <div>${player.r}</div>
        <div>${player.h}</div>
        <div>${single}</div>
        <div>${player.doublehit}</div>
        <div>${player.triplehit}</div>
        <div>${player.hr}</div>
        <div>${player.tb}</div>
        <div>${player.rbi}</div>
        <div>${player.sac}</div>
        <div>${player.sf}</div>
      `;
      dataContainer.appendChild(row);
    });
  }
});
