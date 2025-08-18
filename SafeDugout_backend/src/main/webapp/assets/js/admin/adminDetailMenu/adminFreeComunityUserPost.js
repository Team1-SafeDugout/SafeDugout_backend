const commentAddBtn = document.getElementsByClassName("comments-page").item(0);
const commentUl = document.getElementsByClassName("team-comment-list").item(0);
const deletePostBtn = document.getElementById("delete-button");


deletePostBtn.addEventListener('click', function (){
  if (confirm("삭제하시겠습니까?")){
    alert("삭제 되었습니다.");
    location.href = "./../adminMenu/adminManageFreeCommunity.html";
  }
});

commentAddBtn.addEventListener('click', function () {

  const curTextNum = document.getElementsByClassName("team-comment-list").item(0);
  if (curTextNum.children > 3) return;
  addComment("안녕하세요", "th3179", "2025.08.09");


});

function addComment(targetComment, authorId, date) {
  const newComment = document.createElement("li");
  newComment.className = "comment-item";

  const commentInfo = document.createElement("div");
  commentInfo.className = "team-comment-info";

  const commentAuthor = document.createElement('span');
  const authorText = document.createTextNode("작성자ID" + authorId);
  commentAuthor.appendChild(authorText);

  const commentDate = document.createElement('span');
  const dateText = document.createTextNode(date);
  commentDate.appendChild(dateText);

  commentInfo.appendChild(commentAuthor);
  commentInfo.appendChild(commentDate);

  const comment = document.createElement('p');
  const commentText = document.createTextNode(targetComment);
  comment.appendChild(commentText);

  comment.className = "team-comment-text";

  const commentBtns = document.createElement("div");
  commentBtns.className = "team-comment-button";

  const formCont = document.createElement('form');
  formCont.setAttribute("action", "");

  const deleteBtn = document.createElement("button");
  deleteBtn.setAttribute("type", "button");
  const btnText = document.createTextNode("삭제");
  deleteBtn.appendChild(btnText);
  deleteBtn.addEventListener('click', function () {
    if (confirm("삭제하시겠습니까?")) {
      alert("삭제 되었습니다.");
      newComment.remove();
    }
  });

  commentBtns.appendChild(formCont);
  formCont.appendChild(deleteBtn);

  newComment.appendChild(commentInfo);
  newComment.appendChild(comment);
  newComment.appendChild(commentBtns);
  commentUl.appendChild(newComment);

  newComment.style.border = "1px solid black";
}