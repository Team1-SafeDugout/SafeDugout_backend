const postList = document.getElementById('list-ul');


document.addEventListener("DOMContentLoaded", function() {
    if (typeof posts !== 'undefined') {
        posts.forEach(post => {
            addPost(post.number, post.title, post.date, "전체 공지사항");
        });
    }
});

function addPost(postNumberParam, postTitleParam, postDateParam, postTypeParam){
	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postDate = document.createElement('div');
	const postType = document.createElement('div');
	const deleteBtn = document.createElement('div');

	const postNumText = document.createTextNode(postNumberParam);
	const postTitleText = document.createTextNode(postTitleParam);
	const postDateText = document.createTextNode(postDateParam);
	const postTypeText = document.createTextNode("전체공지사항");
	const deleteBtnText = document.createTextNode("삭제하기");

	postTitle.style.overflow = "hidden";
	postTitle.style.whiteSpace = "nowrap";
	postTitle.style.textOverflow = "eclipse";

	const postTitleLink = document.createElement('a');
	postTitleLink.setAttribute("href", "/admin/adminReadMainNoticeOk.ad?postNumber=" + postNumberParam);
	postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postDate.appendChild(postDateText);
	postType.appendChild(postTypeText);
	deleteBtn.appendChild(deleteBtnText);

	deleteBtn.addEventListener('click', function () {
		if (window.confirm("정말 삭제하시겠습니까")) {
			/*이부분은 다시 작성 필요*/
		}
	});

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postDate);
	newPost.appendChild(postType);
	newPost.appendChild(deleteBtn);

	postList.appendChild(newPost);
}