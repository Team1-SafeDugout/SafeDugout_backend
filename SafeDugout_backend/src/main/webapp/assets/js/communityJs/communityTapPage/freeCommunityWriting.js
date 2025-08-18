document.addEventListener("DOMContentLoaded", () => {
  const submitBtn = document.querySelector(".free-community-submit-btn");
  const cancelBtn = document.querySelector(".free-community-cancel-btn");
  const fileBtn = document.querySelector(".free-community-file-btn");
  const deleteBtn = document.querySelector(".free-community-delete-btn");
  const fileInfo = document.querySelector(".free-community-file-info");

  let selectedFile = null;

  // 등록 버튼 클릭 시 컨펌
  submitBtn.addEventListener("click", () => {
    const title = document.querySelector(".free-community-writer-input").value.trim();
    const author = document.querySelector(".team-input").value.trim();
    const content = document.querySelector(".free-community-writer-textarea").value.trim();

    if (!title || !author || !content) {
      alert("제목, 작성자, 내용은 모두 입력해야 합니다.");
      return;
    }

    if (confirm("이 게시물을 등록하시겠습니까?")) {
      alert("게시물이 등록되었습니다.");
      // 디테일 페이지로 이동
      window.location.href = "./freeCommunityDetail.html";
    }
  });

  // 취소 버튼 클릭
  cancelBtn.addEventListener("click", () => {
    if (confirm("작성 중인 내용을 취소하시겠습니까?")) {
      window.history.back();
    }
  });

  // 파일 업로드
  fileBtn.addEventListener("click", () => {
    const input = document.createElement("input");
    input.type = "file";
    input.accept = "image/*";

    input.addEventListener("change", (e) => {
      const file = e.target.files[0];
      if (!file) return;

      // 용량 체크 (10MB 제한)
      if (file.size > 10 * 1024 * 1024) {
        alert("이미지 파일은 10MB 이하만 업로드 가능합니다.");
        return;
      }

      // 1개만 업로드 가능
      if (selectedFile) {
        alert("이미 파일이 첨부되어 있습니다. 먼저 삭제 후 다시 시도하세요.");
        return;
      }

      selectedFile = file;
      fileInfo.textContent = `첨부된 파일: ${file.name} (${(file.size / 1024 / 1024).toFixed(2)}MB)`;
    });

    input.click();
  });

  // 파일 삭제
  deleteBtn.addEventListener("click", () => {
    if (!selectedFile) {
      alert("삭제할 파일이 없습니다.");
      return;
    }

    if (confirm("첨부된 파일을 삭제하시겠습니까?")) {
      selectedFile = null;
      fileInfo.textContent = "* 파일은 1개만 업로드 가능합니다\n* 이미지파일 10MB 이상 불가\n* 수정 시 첨부된 파일이 삭제됩니다";
    }
  });
});
