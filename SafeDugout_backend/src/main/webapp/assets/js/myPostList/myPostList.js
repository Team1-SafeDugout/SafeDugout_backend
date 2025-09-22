const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기
const memberPostList = document.getElementById("ul-li");

const currentTab = document.getElementById('currentTab');

const urlParams = new URLSearchParams(window.location.search);

document.addEventListener('DOMContentLoaded', function(){
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			let typeName = "";
			switch (post.type) {
				case "1":
					typeName = "전체 게시판";
					break;
				case "2":
					typeName = "팀 게시판";
					break;
				default:
					typeName = "기타";
					break;
			}
			console.log("test");
			addPost(post.number, post.title, post.date, typeName, post.type, post.team);
		});
	}

	/*currentTab.value = urlParams.get("currentTab");*/
});

/*<li class="post-list-top">
	<div class="post-list-number">글 번호</div>
	<div class="post-list-title">제목</div>
	<div class="post-list-date">작성 일자</div>
	<button type="button" class="post-list-delete"></button>
</li>*/
function addPost(postNumberParam, postTitleParam, postDateParam,postTypeParam, postTypeNum, postTeamNumber){
	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postDate = document.createElement('div');
	const postType = document.createElement('div');
	const deleteBtn = document.createElement('div');
	
	newPost.classList.add("post-list-row");
	postNum.classList.add("post-list-number");
	postTitle.classList.add("post-list-title");
	postDate.classList.add("post-list-date");
	postType.classList.add("post-list-date");
	deleteBtn.classList.add("post-list-delete");

	const postNumText = document.createTextNode(postNumberParam);
	const postTitleText = document.createTextNode(postTitleParam);
	const postDateText = document.createTextNode(formatDate(postDateParam));
	const postTypeText = document.createTextNode(postTypeParam);
	const deleteBtnText = document.createTextNode("삭제하기");

	postTitle.style.overflow = "hidden";
	postTitle.style.whiteSpace = "nowrap";
	postTitle.style.textOverflow = "eclipse";

	postDate.style.overflow = "hidden";
	postDate.style.whiteSpace = "nowrap";
	postDate.style.textOverflow = "eclipse";

	const postTitleLink = document.createElement('a');
	if(postTypeNum === "1"){
		postTitleLink.setAttribute("href", "/freeCommunity/freeCommunityDetailOk.fc?postNumber=" + postNumberParam);
	}
	
	else if(postTypeNum === "2"){
		postTitleLink.setAttribute("href", "/community/teamCommunityFrontController.tc?category=board&action=detail&postNumber=" + postNumberParam + "&teamNumber=" + postTeamNumber);
	}
	
	postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postDate.appendChild(postDateText);
	postType.appendChild(postTypeText);
	deleteBtn.appendChild(deleteBtnText);

	deleteBtn.addEventListener('click', function() {
		if (window.confirm("정말 삭제하시겠습니까")) {
			window.location.href =  contextPath + "/myPage/deletePost.mp?postNumber=" + postNumberParam;
		}
	});

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postDate);
	newPost.appendChild(postType);
	newPost.appendChild(deleteBtn);

	memberPostList.appendChild(newPost);
}


function formatDate(dateString) {
  const date = new Date(dateString);

  const yyyy = date.getFullYear();
  const mm = String(date.getMonth() + 1).padStart(2, '0');
  const dd = String(date.getDate()).padStart(2, '0');

  return `${yyyy}-${mm}-${dd}`;
}