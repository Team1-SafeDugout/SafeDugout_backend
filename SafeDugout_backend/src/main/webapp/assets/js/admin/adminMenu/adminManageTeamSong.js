const openModal = document.getElementById("add-song-button");
const closeModal = document.getElementById("cancle-button");

const modal = document.getElementById("section-modal");
const modalForm = document.getElementById("modal-form");

const postList = document.getElementById('list-ul');

var addOn = false;

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
			addPost(post.number, teamName, post.title, post.link, post.date);
		});
	}
});

openModal.addEventListener('click', function() {
	modal.style.display = "flex";
	modalForm.reset();
	addOn = true;
});

closeModal.addEventListener('click', function() {
	modal.style.display = "none";
});

// 테스트용 추가 버튼
function addPost(postNumberParam, postTeamNameParam, postTitleParam, postLinkParam, postDateParam) {
	const newMember = document.createElement('li');

	const number = document.createElement('div');
	const teamName = document.createElement('div');
	const songName = document.createElement('div');
	const fixDate = document.createElement('div');
	const linkURL = document.createElement('div');
	const buttons = document.createElement('div');

	const deleteButton = document.createElement('button');

	deleteButton.setAttribute('type', 'button');
	deleteButton.appendChild(document.createTextNode("삭제"));
	deleteButton.addEventListener('click', function () {
		if (confirm("삭제하시겠습니까?")) {
			alert("삭제되었습니다.");
			window.location.href =  
			contextPath + 
			"/admin/adminDeletePostOk.ad?" + 
			"postNumber=" + postNumberParam + "&postTypeId=5";
		}
	});


	const NumberText = document.createTextNode(postNumberParam);
	const teamNameText = document.createTextNode(postTeamNameParam);
	const songNameText = document.createTextNode(postTitleParam);
	const linkURLText = document.createTextNode(postLinkParam);
	const fixDateText = document.createTextNode(postDateParam);

	buttons.appendChild(deleteButton);

	number.appendChild(NumberText);
	teamName.appendChild(teamNameText);
	songName.appendChild(songNameText);
	linkURL.appendChild(linkURLText);
	fixDate.appendChild(fixDateText);
	
	songName.style.overflow = "hidden";
	songName.style.whiteSpace = "nowrap";
	songName.style.textOverflow = "eclipse";
		
	fixDate.style.overflow = "hidden";
	fixDate.style.whiteSpace = "nowrap";
	fixDate.style.textOverflow = "eclipse";
	
	linkURL.style.overflow = "hidden";
	linkURL.style.whiteSpace = "nowrap";
	linkURL.style.textOverflow = "eclipse";

	linkURL.setAttribute('href', postLinkParam);

	newMember.appendChild(number);
	newMember.appendChild(teamName);
	newMember.appendChild(songName);
	newMember.appendChild(linkURL);
	newMember.appendChild(fixDate);
	newMember.appendChild(buttons);

	postList.appendChild(newMember);
};