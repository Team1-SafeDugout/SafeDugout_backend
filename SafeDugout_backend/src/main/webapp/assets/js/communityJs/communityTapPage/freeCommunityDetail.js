let comments = [
  { id: 1, author: "user01", date: "2025-08-08", text: "첫 번째 댓글" },
  { id: 2, author: "user02", date: "2025-08-09", text: "두 번째 댓글" }
];

// 댓글 목록 
function renderComments() {
  const commentList = document.querySelector(".free-community-comment-list");
  commentList.innerHTML = ""; 
  comments.forEach(comment => {
    const li = document.createElement("li");
    li.className = "free-community-comment-item";
    li.innerHTML = `
      <div class="free-community-comment-info">
        <span class="free-community-comment-author">작성자 ID: ${comment.author}</span>
        <span class="free-community-comment-date">${comment.date}</span>
      </div>
      <p class="free-community--comment-text">${comment.text}</p>
      <div class="free-community--comment-button">
        <button type="button" onclick="editComment(${comment.id})">수정</button>
        <button type="button" onclick="deleteComment(${comment.id})">삭제</button>
      </div>
    `;
    commentList.appendChild(li);
  });
}

// 댓글 등록 처리
document.querySelector(".team-btn-button").addEventListener("click", () => {
  const textarea = document.querySelector(".free-community--comment-area textarea");
  const text = textarea.value.trim();
  if (!text) {
    alert("댓글 내용을 입력해주세요.");
    return;
  }

  // 로그인 유저 아이디 넣어야 함
  const newComment = {
    id: Date.now(),
    author: "user",
    date: new Date().toISOString().slice(0, 10), 
    text
  };

  comments.push(newComment);
  textarea.value = ""; // 입력창 초기화
  renderComments();
});

// 댓글 삭제 함수
function deleteComment(id) {
  if (!confirm("댓글을 삭제하시겠습니까?")) return;
  comments = comments.filter(c => c.id !== id);
  renderComments();
}

// 댓글 수정 함수
function editComment(id) {
  const comment = comments.find(c => c.id === id);
  if (!comment) return;
  const newText = prompt("댓글을 수정하세요:", comment.text);
  if (newText === null) return;
  comment.text = newText.trim();
  renderComments();
}

// 게시물 수정
document.addEventListener("DOMContentLoaded", () => {
  const editBtn = document.querySelector(".free-community-header button a");

  // 수정 버튼 클릭
  editBtn.addEventListener("click", (e) => {
    e.preventDefault();

    // 기존 첨부파일 여부 확인 (로컬스토리지 사용)
    const attachedFile = localStorage.getItem("attachedFile");

    if (attachedFile) {
      if (confirm("수정 시 첨부된 파일이 삭제됩니다. 계속하시겠습니까?")) {
        // 파일 삭제
        localStorage.removeItem("attachedFile");
        console.log("첨부파일 삭제 완료");
      } else {
        return; // 취소하면 글쓰기 페이지로 이동 안 함
      }
    }

    // 글쓰기 페이지로 이동
    window.location.href = "./freeCommunityWriting.html";
  });
});
