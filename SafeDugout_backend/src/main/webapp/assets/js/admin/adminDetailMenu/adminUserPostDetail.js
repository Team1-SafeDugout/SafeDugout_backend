const deletePostBtn = document.getElementById("delete-button");
const commentList = document.getElementById("ul-li");

const param = new URLSearchParams(window.location.search);

const postNumber = param.get("postNumber");
const boardId = param.get("boardId");

deletePostBtn.addEventListener('click', function (){
  if (confirm("삭제하시겠습니까?")){
    alert("삭제 되었습니다.");
    window.location.href =  "/admin/adminDeletePostOk.ad?postNumber=" + postNumber + "&postTypeId=" + boardId + "&currentTab=all";
  }
});

document.addEventListener("DOMContentLoaded", function() {
  addComment("안녕하세요", "th3179", "2025.08.09");
});

function addComment(targetComment, authorId, date) {
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
  
  deleteBtn.addEventListener('click', function () {
    if (confirm("삭제하시겠습니까?")) {
      alert("삭제 되었습니다.");
	  
	  window.location.href =  contextPath + "/admin/adminDeletePostOk.ad?postNumber=" + postNumber + "&postTypeId=" + boardId;
      
    }
  });

  commentBtns.appendChild(deleteBtn);

  newComment.appendChild(commentInfo);
  newComment.appendChild(comment);
  newComment.appendChild(commentBtns);
  commentList.appendChild(newComment);
}