const deletePostBtn = document.getElementById("delete-button");
const commentList = document.getElementById("ul-li");

const param = new URLSearchParams(window.location.search);

const postNumber = param.get("postNumber");
const boardId = param.get("boardId");


deletePostBtn.addEventListener('click', function (){
  if (confirm("삭제하시겠습니까?")){
    alert("삭제 되었습니다.");
    window.location.href =  "/admin/adminDeletePostOk.ad?postNumber=" + postNumber + "&postTypeId=" + postType + "&currentTab=all";
  }
});

document.addEventListener("DOMContentLoaded", function() {
	if (!postNumber) return;
	async function loadReplies() {
		try {
		      const res = await fetch(`/reply/replyListOk.re?postNumber=${encodeURIComponent(postNumber)}`, {
		        headers: { "Accept": "application/json", "X-Requested-With": "XMLHttpRequest" },
		      });
		      if (!res.ok) throw new Error("댓글 목록을 불러오는 데 실패했습니다.");
		      const replies = await safeJson(res);
			  commentList.innerHTML = '';
			  replies.forEach(comment => {
				addComment(comment.commentContent, comment.memberID, comment.commentDate, comment.commentNumber);
			  });	
			  
		    } catch (error) {
		      console.error("댓글 목록 불러오기 실패:", error);
		      alert("댓글 목록을 불러오는데 실패했습니다.");
		  }
	}
	
	function addComment(targetComment, authorId, date, commentNumber) {
	  const newComment = document.createElement("li");

	  const commentInfo = document.createElement("div");

	  const commentAuthor = document.createElement('span');
	  const authorText = document.createTextNode("작성자ID :" + authorId);
	  commentAuthor.appendChild(authorText);

	  const commentDate = document.createElement('span');
	  const dateText = document.createTextNode(date);
	  commentDate.appendChild(dateText);

	  commentInfo.appendChild(commentAuthor);
	  commentInfo.appendChild(commentDate);

	  const comment = document.createElement('p');
	  const commentText = document.createTextNode(targetComment);
	  comment.appendChild(commentText);

	  const commentBtns = document.createElement("div");
	  commentBtns.className = "team-comment-button";

	  const deleteBtn = document.createElement("button");
	  deleteBtn.setAttribute("type", "button");
	  
	  const btnText = document.createTextNode("삭제");
	  deleteBtn.appendChild(btnText);
	  
	  deleteBtn.addEventListener('click', async function () {
	    if (confirm("삭제하시겠습니까?")) {		  
		  try {
		    const response = await fetch(
		      `/reply/replyDeleteOk.re?commentNumber=${encodeURIComponent(commentNumber)}`,
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
	  });

	  commentBtns.appendChild(deleteBtn);

	  newComment.appendChild(commentInfo);
	  newComment.appendChild(comment);
	  newComment.appendChild(commentBtns);
	  commentList.appendChild(newComment);
	}
	
	async function safeJson(res) {
	  const text = await res.text();
	  try { return text ? JSON.parse(text) : null; } catch { return null; }
	}
	
	loadReplies();
});


