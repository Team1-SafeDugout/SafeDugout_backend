const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기

const postList = document.getElementById('list-ul');
const currentTab = document.getElementById('currentTab');

const urlParams = new URLSearchParams(window.location.search); // url 변수 읽기용


document.addEventListener("DOMContentLoaded", function() {
	posts.forEach(post => {
	let typeName = "";
	switch (post.type) {
		case "1":
			typeName = "자유게시판";
			break;
		case "2":
			typeName = "팀게시판";
			break;
		default:
			typeName = "기타";
			break;
			}
	addPost(post.number, post.title, post.date, typeName, post.type);
	});
	console.log(urlParams.get("currentTab"));
	currentTab.value = urlParams.get("currentTab");
	// 비동기 백업
/*	fetch(`/admin/adminManageUserPostListOk.ad?currentTab=all`, 
		{ headers: { "Accept": "application/json" } })
		.then(response => {
		    if (!response.ok) throw new Error(response.status);
		    return response.json();
		})
		.then(data => {
		    console.log("서버 응답:", data);
			postList.innerHTML = '';
		    if (data.posts && data.posts.length > 0) {
				data.posts.forEach(post => {
					let typeName = "";
					switch (post.boardId) {
						case 1:
							typeName = "자유게시판";
							break;
						case 2:
							typeName = "팀게시판";
							break;
						default:
							typeName = "기타";
							break;
					}
					addPost(post.postNumber, post.postTitle, post.postDate, typeName, post.boardId);
				});
		    } else {
		        postList.innerHTML = `<div>등록된 게시물이 없습니다.</div>`;
		    }
		})
		.catch(error => {
		    console.error("에러 발생:", error);
	});*/
});

currentTab.addEventListener('change', function(){
	const selectedValue = currentTab.value;
	console.log("▶ 선택된 카테고리:", selectedValue);
	window.location.href =  contextPath + "/admin/adminManageUserPostListOk.ad?currentTab=" + currentTab.value;
	
	// 비동기 백업
	/*fetch(`/admin/adminManageUserPostListOk.ad?currentTab=${selectedValue}`, 
	{ headers: { "Accept": "application/json" } })
	.then(response => {
	    if (!response.ok) throw new Error(response.status);
	    return response.json();
	})
	.then(data => {
	    console.log("서버 응답:", data);
		postList.innerHTML = '';
	    if (data.posts && data.posts.length > 0) {
			data.posts.forEach(post => {
				let typeName = "";
				switch (post.boardId) {
					case 1:
						typeName = "자유게시판";
						break;
					case 2:
						typeName = "팀게시판";
						break;
					default:
						typeName = "기타";
						break;
				}
				addPost(post.postNumber, post.postTitle, post.postDate, typeName, post.boardId);
			});
	    } else {
	        postList.innerHTML = `<div>등록된 게시물이 없습니다.</div>`;
	    }
	})
	.catch(error => {
	    console.error("에러 발생:", error);
	});*/
});

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
			window.location.href =  contextPath + "/admin/adminDeleteNoticeOk.ad?noticePostNumber=" + postNumberParam + "&noticeTypeId=" + postTypeNum;
		}
	});

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postDate);
	newPost.appendChild(postType);
	newPost.appendChild(deleteBtn);

	postList.appendChild(newPost);
}