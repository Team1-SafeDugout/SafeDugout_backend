const addbutton = document.getElementsByClassName("list-names").item(0);
const addUserPostButton = document.getElementsByClassName("list-names").item(1);

const postList = document.getElementById('post-list');
const userPostList = document.getElementById('user-post-list');

// 테스트용 추가 버튼
addbutton.addEventListener('click', function () {

	const userListNum = document.querySelectorAll("#post-list>li");
	if (userListNum.length >= 10) return;

	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postDate = document.createElement('div');
	const postType = document.createElement('div');
	const deleteBtn = document.createElement('div');

	postNumText = document.createTextNode("1");
	postTitleText = document.createTextNode("응원은 두산으로");
	postDateText = document.createTextNode("admin");
	postTypeText = document.createTextNode("2025-08-12");
	deleteBtnText = document.createTextNode("삭제하기");

  postTitle.style.overflow = "hidden";
  postTitle.style.whiteSpace = "nowrap";
  postTitle.style.textOverflow = "eclipse";

  const postTitleLink = document.createElement('a');
  postTitleLink.setAttribute("href", "./../adminDetailMenu/adminFreeCommunityGuideDetail.html");
  postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postDate.appendChild(postDateText);
	postType.appendChild(postTypeText);
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
	newPost.appendChild(deleteBtn);

	postList.appendChild(newPost);
});

// 테스트용 추가 버튼
addUserPostButton.addEventListener('click', function () {

	const userListNum = document.querySelectorAll("#user-post-list>li");
	if (userListNum.length >= 10) return;

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
});