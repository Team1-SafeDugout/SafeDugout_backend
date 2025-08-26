document.addEventListener("DOMContentLoaded", () => {
  // 엘리먼트 선택
  const listBtn = document.querySelector(".list-btn");
  const modifyBtn = document.querySelector(".modify-btn");
  const deleteBtn = document.querySelector(".delete-btn");
  const submitBtn = document.querySelector(".submit-btn");
  const commentListEl = document.querySelector("#comment-list");

  // 데이터
  const boardNumber  = listBtn?.dataset.boardNumber  ?? window.boardNumber;
  const memberNumber = listBtn?.dataset.memberNumber ?? window.memberNumber;
  const contextPath = '${pageContext.request.contextPath}';

  console.log("확인 boardNumber :", boardNumber);
  console.log("확인 memberNumber :", memberNumber);

  // 이동 버튼
  // 목록 버튼 클릭 시
  listBtn?.addEventListener("click", () => {
      window.location.href = `${contextPath}/community/teamCommunityFrontController.tc?category=board&action=list`;
  });

  // 수정 버튼 클릭 시
  modifyBtn?.addEventListener("click", () => {
      if (!postNumber) return alert("postNumber가 없습니다");
      window.location.href = `${contextPath}/community/teamCommunityFrontController.tc?category=board&action=updatePage&postNumber=${encodeURIComponent(postNumber)}`;
  });


  // ====== 게시글 삭제 ======
  deleteBtn?.addEventListener("click", async () => {
      if (!postNumber) return alert("postNumber가 없습니다");
      if (!confirm("정말 삭제하시겠습니까?")) return;

      try {
          const res = await fetch(`${contextPath}/community/teamCommunityFrontController.tc?category=board&action=delete&postNumber=${encodeURIComponent(postNumber)}`, {
              method: "GET",
              headers: { "X-Requested-With": "XMLHttpRequest" },
          });
          if (!res.ok) throw new Error("삭제 요청 실패");

          alert("게시글이 삭제되었습니다.");
          window.location.href = `${contextPath}/community/teamCommunityFrontController.tc?category=board&action=list`;
      } catch (err) {
          console.error("게시글 삭제 실패 :", err);
          alert("게시글 삭제에 실패했습니다.");
      }
  });


  // ====== 댓글 작성 ======
  submitBtn?.addEventListener("click", async () => {
    const contentEl = document.querySelector("#content");
    const content = contentEl?.value.trim();

    if (!content) return alert("댓글 내용을 입력해주세요.");
    if (!boardNumber || !memberNumber) return alert("boardNumber 또는 memberNumber가 없습니다.");

    try {
      const response = await fetch("/reply/replyWriteOk.re", {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=utf-8",
          "X-Requested-With": "XMLHttpRequest",
        },
        body: JSON.stringify({ boardNumber, memberNumber, replyContent: content }),
      });

      const result = await safeJson(response);
      if (result?.status === "success") {
        alert("댓글이 작성되었습니다.");
        if (contentEl) contentEl.value = "";
        await loadReplies();
      } else {
        alert("댓글 작성에 실패했습니다.");
      }
    } catch (error) {
      console.error("댓글 작성 실패:", error);
      alert("댓글 작성 중 오류가 발생했습니다.");
    }
  });

  // ====== 댓글 영역 이벤트 위임 ======
  if (commentListEl) {
    commentListEl.addEventListener("click", async (event) => {
      const target = event.target;

      // 삭제
      if (target.matches(".comment-delete")) {
        const replyNumber = target.dataset.number;
        if (!replyNumber) return;

        if (confirm("댓글을 삭제하시겠습니까?")) {
          try {
            const response = await fetch(
              `/reply/replyDeleteOk.re?replyNumber=${encodeURIComponent(replyNumber)}`,
              { method: "GET", headers: { "X-Requested-With": "XMLHttpRequest" } }
            );
            const result = await safeJson(response);
            if (result?.status === "success") {
              alert("댓글이 삭제되었습니다.");
              await loadReplies();
            } else {
              alert("댓글 삭제에 실패했습니다.");
            }
          } catch (error) {
            console.error("댓글 삭제 실패:", error);
            alert("댓글 삭제 중 오류가 발생했습니다.");
          }
        }
      }

      // 수정 준비
      if (target.matches(".comment-modify-ready")) {
        const li = target.closest("li");
        if (!li) return;

        const contentDiv = li.querySelector(".comment-content");
        const originalContent = contentDiv?.textContent?.trim() ?? "";

        if (contentDiv) {
          // 취약하게 원문 그대로 (escapeHtml 제거)
          contentDiv.outerHTML = `<textarea class="modify-content">${originalContent}</textarea>`;
        }

        const btnGroup = target.closest(".comment-btn-group");
        if (btnGroup) {
          btnGroup.innerHTML =
            `<button type="button" class="comment-modify" data-number="${target.dataset.number || ""}">수정 완료</button>`;
        }
      }

      // 수정 완료
      if (target.matches(".comment-modify")) {
        const replyNumber = target.dataset.number;
        if (!replyNumber) return;

        const li = target.closest("li");
        const newContent = li?.querySelector(".modify-content")?.value.trim();
        if (!newContent) return alert("댓글 내용을 입력해주세요.");

        try {
          const response = await fetch("/reply/replyUpdateOk.re", {
            method: "POST",
            headers: {
              "Content-Type": "application/json; charset=utf-8",
              "X-Requested-With": "XMLHttpRequest",
            },
            body: JSON.stringify({ replyNumber, replyContent: newContent }),
          });

          const result = await safeJson(response);
          if (result?.status === "success") {
            alert("댓글이 수정되었습니다.");
            await loadReplies();
          } else {
            alert("댓글 수정에 실패했습니다.");
          }
        } catch (error) {
          console.error("댓글 수정 실패:", error);
          alert("댓글 수정 중 오류가 발생했습니다.");
        }
      }
    });
  }

  // ====== 댓글 목록 로드 ======
  async function loadReplies() {
    if (!boardNumber) return;
    try {
      const res = await fetch(`/reply/replyListOk.re?boardNumber=${encodeURIComponent(boardNumber)}`, {
        headers: { "Accept": "application/json", "X-Requested-With": "XMLHttpRequest" },
      });
      if (!res.ok) throw new Error("댓글 목록을 불러오는 데 실패했습니다.");
      const replies = await safeJson(res);
      renderReplies(Array.isArray(replies) ? replies : []);
    } catch (error) {
      console.error("댓글 목록 불러오기 실패:", error);
      alert("댓글 목록을 불러오는데 실패했습니다.");
    }
  }

  // ====== 댓글 렌더링 ======
  function renderReplies(replies) {
    if (!commentListEl) return;

    commentListEl.innerHTML = "";

    if (!replies.length) {
      commentListEl.innerHTML = "<li>댓글이 없습니다.</li>";
      return;
    }

    const frag = document.createDocumentFragment();

    replies.forEach((reply) => {
      const isMyComment = String(reply.memberNumber) === String(memberNumber);
      const li = document.createElement("li");

      // 템플릿 리터럴 유지 (JSP EL 충돌 없음: 클라이언트 템플릿이라 안전)
      li.innerHTML = `
        <div class="comment-info">
          <span class="writer">${reply.memberId ?? ""}</span>
          <span class="date">${(reply.replyUpdateDate || reply.replyDate) ?? ""}</span>
        </div>
        <div class="comment-content-wrap">
          <div class="comment-content">${reply.replyContent ?? ""}</div>
          ${isMyComment ? `
            <div class="comment-btn-group">
              <button type="button" class="comment-modify-ready" data-number="${reply.replyNumber}">수정</button>
              <button type="button" class="comment-delete" data-number="${reply.replyNumber}">삭제</button>
            </div>` : ""}
        </div>
      `;
      frag.appendChild(li);
    });

    commentListEl.appendChild(frag);
  }

  // ====== 유틸 ======
  async function safeJson(res) {
    const text = await res.text();
    try { return text ? JSON.parse(text) : null; } catch { return null; }
  }

  // 초기 로드
  loadReplies();
});
