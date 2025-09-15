
// 탭 전환
function setupTabSwitch() {
  const buttons = document.querySelectorAll(".team-stats-switch button");
  const pitcherTable = document.getElementById("team-pitcher-table");
  const batterTable = document.getElementById("team-batter-table");

  buttons.forEach(button => {
    button.addEventListener("click", () => {
      buttons.forEach(btn => btn.classList.remove("active"));
      button.classList.add("active");

      pitcherTable.style.display = button.dataset.tab === "pitcher" ? "block" : "none";
      batterTable.style.display = button.dataset.tab === "batter" ? "block" : "none";
    });
  });
}

window.addEventListener("DOMContentLoaded", () => {
  setupTabSwitch();
});
