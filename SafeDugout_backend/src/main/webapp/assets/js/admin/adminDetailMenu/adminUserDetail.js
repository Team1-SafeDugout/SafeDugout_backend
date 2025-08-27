const userSellList = document.getElementById("sell-post-list");
const userTradeList = document.getElementById("trade-post-list");
const userCommunityList = document.getElementById("community-post-list");

document.addEventListener("DOMContentLoaded", function() {
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			addPost(post.number, post.title, post.date, typeName, post.type);
		});
	}
});


function posts(targetList, postNumberParam, postTitleParam, postDateParam){
  const newPost = document.createElement('li');

  const postNum = document.createElement('div');
  const postTitle = document.createElement('div');
  const postDate = document.createElement('div');

  const postURL = document.createElement('a');
  postURL.setAttribute("href", "/admin/adminReadSellOk.ad?postNumber=" + postNumberParam);

  const numText = document.createTextNode(postNumberParam);
  const titleText = document.createTextNode(postTitleParam);
  const dateText = document.createTextNode(postDateParam);

  postNum.appendChild(numText);
  postTitle.appendChild(postURL);
  postURL.appendChild(titleText);
  postDate.appendChild(dateText);

  newPost.appendChild(postNum);
  newPost.appendChild(postTitle);
  newPost.appendChild(postDate);

  targetList.appendChild(newPost)
}