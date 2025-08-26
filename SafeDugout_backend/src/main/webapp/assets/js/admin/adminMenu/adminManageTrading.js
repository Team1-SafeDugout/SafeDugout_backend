const postList = document.getElementById('list-ul');

function formatDate(dateString) {
	if (!dateString) return "-"; // 값이 없으면 대시 표시
	const date = new Date(dateString);
	if (isNaN(date.getTime())) return dateString; // 변환 실패 시 원본 반환
	return date.toLocaleDateString("ko-KR", {
		year: "numeric",
		month: "2-digit",
		day: "2-digit"
	});
}

document.addEventListener("DOMContentLoaded", function() {
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			addPost(post.tradeNumber, post.postTitle, formatDate(post.postUpdate), post.seller, post.buyer);
		});
	}
});

function addPost(postNumberParam, postTitleParam, postUpdateParam, sellerParam, buyerParam) {
	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postUpdate = document.createElement('div');
	const seller = document.createElement('div');
	const buyer = document.createElement('div');

	const postNumText = document.createTextNode(postNumberParam);
	const postTitleText = document.createTextNode(postTitleParam);
	const postUpdateText = document.createTextNode(postUpdateParam)
	const sellerText = document.createTextNode(sellerParam);
	const buyerText = document.createTextNode(buyerParam);

	postTitle.style.overflow = "hidden";
	postTitle.style.whiteSpace = "nowrap";
	postTitle.style.textOverflow = "eclipse";

	postUpdate.style.overflow = "hidden";
	postUpdate.style.whiteSpace = "nowrap";
	postUpdate.style.textOverflow = "eclipse";


	const postTitleLink = document.createElement('a');
	postTitleLink.setAttribute("href", "/admin/adminReadTradeOk.ad?postNumber=" + postNumberParam);
	postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postUpdate.appendChild(postUpdateText);
	seller.appendChild(sellerText);
	buyer.appendChild(buyerText);

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postUpdate);
	newPost.appendChild(seller);
	newPost.appendChild(buyer);

	postList.appendChild(newPost);
}