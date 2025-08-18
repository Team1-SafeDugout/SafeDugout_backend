document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");
  const titleInput = document.querySelector(".team-input[placeholder='제목을 입력하세요']");
  const contentTextarea = document.querySelector(".team-textarea");
  const submitBtn = document.querySelector(".team-submit-btn");

  // 에러 메시지 생성
  function createErrorMessage(message) {
    const div = document.createElement("div");
    div.style.color = "red";
    div.style.fontSize = "10px";
    div.style.marginTop = "4px";
    div.textContent = message;
    return div;
  }

  let titleErrorDiv = null;
  let contentErrorDiv = null;

  submitBtn.addEventListener("click", (e) => {

    if (titleErrorDiv) titleErrorDiv.remove();
    if (contentErrorDiv) contentErrorDiv.remove();

    let valid = true;

    // 제목
    if (!titleInput.value.trim()) {
      titleErrorDiv = createErrorMessage("제목을 입력하세요");
      titleInput.classList.add("error");
      titleInput.parentNode.appendChild(titleErrorDiv);
      valid = false;
    } else {
      titleInput.classList.remove("error");
    }
    // 내용
    if (!contentTextarea.value.trim()) {
      contentErrorDiv = createErrorMessage("내용을 입력하세요");
      contentTextarea.classList.add("error");
      contentTextarea.parentNode.appendChild(contentErrorDiv);
      valid = false;
    } else {
      contentTextarea.classList.remove("error");
    }
    if (!valid) {
      return; 
    }
    if (confirm("등록하시겠습니까?")) {
      window.location.href = "/webapp/app/communityHtml/communityTapPage/teamPostComplete.html";
    }
  });
});
