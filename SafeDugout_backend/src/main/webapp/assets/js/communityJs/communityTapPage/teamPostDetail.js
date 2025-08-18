document.addEventListener("DOMContentLoaded", () => {
  const commentList = document.querySelector(".team-comment-list");
  const deleteButtons = commentList.querySelectorAll("button[type='submit']:nth-child(2)");
  // 삭제 버튼에 이벤트 추가
  deleteButtons.forEach(btn => {
    btn.addEventListener("click", (e) => {
      if (confirm("댓글을 삭제하시겠습니까?")) {
        const commentItem = btn.closest(".comment-item");
        if (commentItem) {
          commentItem.remove();
        }
      }
    });
  });
});

// 비로그인 시 작성 제한
document.addEventListener("DOMContentLoaded", () => {
  const userId = localStorage.getItem("userId"); 
  const commentForm = document.querySelector(".team-comment-area form");
  const textarea = commentForm.querySelector("textarea");
  const submitBtn = commentForm.querySelector(".team-btn-submit");
  if (!userId) {
    textarea.disabled = true;
    textarea.placeholder = "로그인 후 댓글을 작성할 수 있습니다.";
    submitBtn.disabled = true;
    commentForm.addEventListener("submit", (e) => {
      e.preventDefault();
      alert("댓글을 작성하려면 로그인해야 합니다.");
    });
  } else {
  }
});

// 로그인 유저가 작성자가 아니면 수정/삭제 버튼 숨기기
document.addEventListener("DOMContentLoaded", () => {
  const loginUserId = localStorage.getItem("userId"); 
  const postWriterElem = document.querySelector(".team-post-writer p");
  const postWriterId = postWriterElem ? postWriterElem.textContent.trim() : null;
  if (loginUserId !== postWriterId) {
    const buttons = document.querySelectorAll(".team-post-header button");
    buttons.forEach(btn => btn.style.display = "none");
  }
});

document.addEventListener("DOMContentLoaded", () => {
  const loginUserId = localStorage.getItem("userId"); // 로그인한 사용자 ID 가져오기
  const commentItems = document.querySelectorAll(".comment-item");

  commentItems.forEach(comment => {
    const authorSpan = comment.querySelector(".comment-author");
    const authorId = authorSpan ? authorSpan.textContent.replace("작성자 ID:", "").trim() : null;

    if (loginUserId !== authorId) {
      // 작성자가 아니면 수정/삭제 버튼 숨기기
      const buttons = comment.querySelectorAll(".team-comment-button button");
      buttons.forEach(btn => btn.style.display = "none");
    }
  });
});
