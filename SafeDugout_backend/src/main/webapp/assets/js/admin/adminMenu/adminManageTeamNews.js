const postList = document.getElementById('list-ul');


document.addEventListener("DOMContentLoaded", function() {
    if (typeof posts !== 'undefined') {
        posts.forEach(post => {
			let teamName = "";
			    switch (post.teamtype) {
			        case "1":
			            teamName = "두산 베어스";
			            break;
			        case "2":
						teamName = "LG 트윈스";
			            break;
			        case "3":			            
						teamName = "한화 이글스";
			            break;
			        case "4":
						teamName = "삼성 라이온즈";
			            break;
			        case "5":
						teamName = "SSG 랜더스";
			            break;
			        case "6":
			            teamName = "KT 위즈";
			            break;
			        case "7":   
						teamName = "NC 다이노스";
			            break;
			        case "8": 
						teamName = "롯데 자이언츠";
			            break;
			        case "9":
						teamName = "KIA 타이거즈";
			            break;
			        case "10":
			            teamName = "키움 히어로즈";
			            break;
			        default:
			            teamName = "기타";
			            break;
			    }
            addPost(post.number, post.title, post.date, teamName);
        });
    }
});

function addPost(postNumberParam, postTitleParam, postDateParam, postTeamName){
	const newPost = document.createElement('li');

	const postNum = document.createElement('div');
	const postTitle = document.createElement('div');
	const postDate = document.createElement('div');
	const teamType = document.createElement('div');
	const deleteBtn = document.createElement('div');

	const postNumText = document.createTextNode(postNumberParam);
	const postTitleText = document.createTextNode(postTitleParam);
	const postDateText = document.createTextNode(postDateParam);
	const postTeamText = document.createTextNode(postTeamName);
	const deleteBtnText = document.createTextNode("삭제하기");

	postTitle.style.overflow = "hidden";
	postTitle.style.whiteSpace = "nowrap";
	postTitle.style.textOverflow = "eclipse";
	
	postDate.style.overflow = "hidden";
	postDate.style.whiteSpace = "nowrap";
	postDate.style.textOverflow = "eclipse";

	const postTitleLink = document.createElement('a');
	postTitleLink.setAttribute("href", "/admin/adminReadPostOk.ad?postNumber=" + postNumberParam + "&postTypeId=3");
	postTitleLink.appendChild(postTitleText);

	postNum.appendChild(postNumText);
	postTitle.appendChild(postTitleLink);
	postDate.appendChild(postDateText);
	teamType.appendChild(postTeamText);
	deleteBtn.appendChild(deleteBtnText);

	deleteBtn.addEventListener('click', function () {
		if (confirm("삭제하시겠습니까?")) {
			alert("삭제되었습니다.");
			window.location.href =  
			contextPath + 
			"/admin/adminDeletePostOk.ad?" + 
			"postNumber=" + postNumberParam + "&postTypeId=3";
		}
	});

	newPost.appendChild(postNum);
	newPost.appendChild(postTitle);
	newPost.appendChild(postDate);
	newPost.appendChild(teamType);
	newPost.appendChild(deleteBtn);

	postList.appendChild(newPost);
}