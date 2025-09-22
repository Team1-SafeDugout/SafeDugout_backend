const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기
const commentPostList = document.getElementById("ul-li");

const currentTab = document.getElementById('currentTab');

const urlParams = new URLSearchParams(window.location.search);

document.addEventListener('DOMContentLoaded', function(){
	if (typeof comments !== 'undefined') {
		comments.forEach(comment => {
			console.log("test");
			addPost(comment.number, comment.title, comment.author, comment.content, comment.date, comment.commentNumber, comment.postType, comment.teamNumber);
		});
	}

	/*currentTab.value = urlParams.get("currentTab");*/
});

/*<li class="comment-list-row">
  <div class="post-title">제목예시1</div>
  <div class="post-writer">1</div>
  <div class="comment-list-title"><a href="">작성 내용 예시1</a></div>
  <div class="comment-list-date">2025.01.01</div>
  <button type="button" class="comment-list-delete">삭제하기</button>
</li>*/
function addPost(commentPostNumber, commentTitleParam, commentAuthorParam, commentContentParam, commentDateParam, commentNumber, postType, teamNumber){
	const newComment = document.createElement('li');

	const commentTitle = document.createElement('div');
	const commentAuthor = document.createElement('div');
	const commentContent = document.createElement('div');
	const commentDate = document.createElement('div');
	const deleteBtn = document.createElement('div');
	
	newComment.classList.add("comment-list-row");
	commentTitle.classList.add("post-title");
	commentAuthor.classList.add("post-writer");
	commentContent.classList.add("comment-list-title");
	commentDate.classList.add("comment-list-date");
	deleteBtn.classList.add("comment-list-delete");

	const commentTitleText = document.createTextNode(commentTitleParam);
	const commentAuthorText = document.createTextNode(commentAuthorParam);
	const commentContentText = document.createTextNode(commentContentParam);
	const commentDateText = document.createTextNode(formatDate(commentDateParam));
	const deleteBtnText = document.createTextNode("삭제하기");

	commentTitle.style.overflow = "hidden";
	commentTitle.style.whiteSpace = "nowrap";
	commentTitle.style.textOverflow = "eclipse";

	commentAuthor.style.overflow = "hidden";
	commentAuthor.style.whiteSpace = "nowrap";
	commentAuthor.style.textOverflow = "eclipse";
	
	commentContent.style.overflow = "hidden";
	commentContent.style.whiteSpace = "nowrap";
	commentContent.style.textOverflow = "eclipse";
	
	commentDate.style.overflow = "hidden";
	commentDate.style.whiteSpace = "nowrap";
	commentDate.style.textOverflow = "eclipse";

	const commentTitleLink = document.createElement('a');
	
	console.log(postType);
	console.log(commentPostNumber);
	
	if(postType === "1"){
		commentTitleLink.setAttribute("href", "/freeCommunity/freeCommunityDetailOk.fc?postNumber=" + commentPostNumber);
	}
	
	else if(postType === "2"){
		console.log(teamNumber);
		commentTitleLink.setAttribute("href", "/community/teamCommunityFrontController.tc?category=board&action=detail&postNumber=" + commentPostNumber + "&teamNumber=" + teamNumber);
	}
	
	commentTitleLink.appendChild(commentTitleText);

	commentTitle.appendChild(commentTitleLink);
	commentAuthor.appendChild(commentAuthorText);
	commentContent.appendChild(commentContentText);
	commentDate.appendChild(commentDateText);
	deleteBtn.appendChild(deleteBtnText);

	deleteBtn.addEventListener('click', function() {
		if (window.confirm("정말 삭제하시겠습니까")) {
			window.location.href =  contextPath + "/myPage/deleteComment.mp?commentNumber=" + commentNumber;
		}
	});

	newComment.appendChild(commentTitle);
	newComment.appendChild(commentAuthor);
	newComment.appendChild(commentContent);
	newComment.appendChild(commentDate);
	newComment.appendChild(deleteBtn);

	commentPostList.appendChild(newComment);
}

function formatDate(dateString) {
  const date = new Date(dateString);

  const yyyy = date.getFullYear();
  const mm = String(date.getMonth() + 1).padStart(2, '0');
  const dd = String(date.getDate()).padStart(2, '0');

  return `${yyyy}-${mm}-${dd}`;
}