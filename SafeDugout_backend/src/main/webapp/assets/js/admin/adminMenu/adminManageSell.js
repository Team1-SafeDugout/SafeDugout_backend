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
		addPost(post.tradeNumber, post.postTitle, post.statusName, post.memberId, formatDate(post.paymentDay), formatDate(post.completeDay));
		});
	}
});

function addPost(postNumberParam, postTitleParam, postStatusParam, postMemberId, postPaymentDate, postCompleteDate) {
	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postStatus = document.createElement('div');
	const memberId = document.createElement('div');
	const payMentDate = document.createElement('div');
	const completeDate = document.createElement('div');

	const postNumText = document.createTextNode(postNumberParam);
	const postTitleText = document.createTextNode(postTitleParam);
	const postStatusText = document.createTextNode(postStatusParam)
	const memberIdText = document.createTextNode(postMemberId);
	const paymentDateText = document.createTextNode(postPaymentDate);
	const completeDateText = document.createTextNode(postCompleteDate);

	postTitle.style.overflow = "hidden";
	postTitle.style.whiteSpace = "nowrap";
	postTitle.style.textOverflow = "eclipse";	
	
	payMentDate.style.overflow = "hidden";
	payMentDate.style.whiteSpace = "nowrap";
	payMentDate.style.textOverflow = "eclipse";

	completeDate.style.overflow = "hidden";
	completeDate.style.whiteSpace = "nowrap";
	completeDate.style.textOverflow = "eclipse";


	const postTitleLink = document.createElement('a');
	/*postTitleLink.setAttribute("href", "/admin/adminReadMainNoticeOk.ad?noticePostNumber=" + postNumberParam);*/
	postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postStatus.appendChild(postStatusText);
	memberId.appendChild(memberIdText);
	payMentDate.appendChild(paymentDateText);
	completeDate.appendChild(completeDateText);



	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postStatus);
	newPost.appendChild(memberId);
	newPost.appendChild(payMentDate);
	newPost.appendChild(completeDate);

	postList.appendChild(newPost);
}