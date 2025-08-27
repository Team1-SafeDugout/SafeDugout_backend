const userPosts = document.getElementById("list-ul");

document.addEventListener("DOMContentLoaded", function() {
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			let typeName = "";
			switch (post.type) {
				case "1":
					typeName = "전체 커뮤";
					break;
				case "2":
					typeName = "팀 커뮤";
					break;
				default:
					typeName = "기타";
					break;
			}
			addposts(post.number, post.title, typeName, post.type);
		});
	}
});


function addposts(postNumberParam, postTitleParam, postTypeParam, postTypeInt){
  const newPost = document.createElement('li');

  const postNum = document.createElement('div');
  const postTitle = document.createElement('div');
  const postType = document.createElement('div');

  const postURL = document.createElement('a');
  postURL.setAttribute("href", "/admin/adminReadPostOk.ad?postNumber=" + postNumberParam + "&boardId=" + postTypeInt);

  const numText = document.createTextNode(postNumberParam);
  const titleText = document.createTextNode(postTitleParam);
  const typeText = document.createTextNode(postTypeParam);

  postNum.appendChild(numText);
  postTitle.appendChild(postURL);
  postURL.appendChild(titleText);
  postType.appendChild(typeText);

  newPost.appendChild(postNum);
  newPost.appendChild(postTitle);
  newPost.appendChild(postType);

  userPosts.appendChild(newPost);
}