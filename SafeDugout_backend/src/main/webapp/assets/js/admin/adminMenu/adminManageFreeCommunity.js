const postList = document.getElementById('list-ul');


document.addEventListener("DOMContentLoaded", function() {
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			let typeName = "";
			switch (post.type) {
				case "1":
					typeName = "메인공지";
					break;
				case "2":
					typeName = "팀공지";
					break;
				case "3":
					typeName = "입문자가이드";
					break;
				default:
					typeName = "기타";
					break;
			}
			addPost(post.number, post.title, post.date, typeName, post.type);
		});
	}
});

// 테스트용 추가 버튼
function addPost(postNumberParam, postTitleParam, postDateParam, postTypeParam, postTypeNum) {

	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postDate = document.createElement('div');
	const postType = document.createElement('div');
	const deleteBtn = document.createElement('div');

	const postNumText = document.createTextNode(postNumberParam);
	const postTitleText = document.createTextNode(postTitleParam);
	const postDateText = document.createTextNode(postDateParam);
	const postTypeText = document.createTextNode(postTypeParam);
	const deleteBtnText = document.createTextNode("삭제하기");

	postTitle.style.overflow = "hidden";
	postTitle.style.whiteSpace = "nowrap";
	postTitle.style.textOverflow = "eclipse";
	
	postDate.style.overflow = "hidden";
	postDate.style.whiteSpace = "nowrap";
	postDate.style.textOverflow = "eclipse";

	const postTitleLink = document.createElement('a');
	postTitleLink.setAttribute("href", "/admin/adminReadMainNoticeOk.ad?noticePostNumber=" + postNumberParam + "&noticeTypeId=" + postTypeNum);
	postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postDate.appendChild(postDateText);
	postType.appendChild(postTypeText);
	deleteBtn.appendChild(deleteBtnText);

	deleteBtn.addEventListener('click', function() {
		if (window.confirm("정말 삭제하시겠습니까")) {
			window.location.href = contextPath + "/admin/adminDeleteNoticeOk.ad?noticePostNumber=" + postNumberParam + "&noticeTypeId=" + postTypeNum;
		}
	});

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postDate);
	newPost.appendChild(postType);
	newPost.appendChild(deleteBtn);

	postList.appendChild(newPost);
}

/*// 테스트용 추가 버튼
addUserPostButton.addEventListener('click', function () {
	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postDate = document.createElement('div');
	const postType = document.createElement('div');
	const postID = document.createElement('div');
	const deleteBtn = document.createElement('div');

	postNumText = document.createTextNode("1");
	postTitleText = document.createTextNode("전체 커뮤니티 글 제목입니다.");
	postDateText = document.createTextNode("0000.00.00");
	postTypeText = document.createTextNode("게시글");
	postIDText = document.createTextNode("th3180");
	deleteBtnText = document.createTextNode("삭제하기");

  postTitle.style.overflow = "hidden";
  postTitle.style.whiteSpace = "nowrap";
  postTitle.style.textOverflow = "eclipse";

  const postTitleLink = document.createElement('a');
  postTitleLink.setAttribute("href", "./../adminDetailMenu/adminFreeComunityUserPost.html");
  postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postDate.appendChild(postDateText);
	postType.appendChild(postTypeText);
	postID.appendChild(postIDText);
	deleteBtn.appendChild(deleteBtnText);

	deleteBtn.addEventListener('click', function () {
		if (window.confirm("정말 삭제하시겠습니까")) {
			newPost.remove();
		}
	});

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postDate);
	newPost.appendChild(postType);
	newPost.appendChild(postID);
	newPost.appendChild(deleteBtn);

	userPostList.appendChild(newPost);
});*/