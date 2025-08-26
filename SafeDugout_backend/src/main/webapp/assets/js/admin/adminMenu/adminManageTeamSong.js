const addbutton = document.getElementById("save-button");
const openModal = document.getElementById("add-song-button");
const closeModal = document.getElementById("cancle-button");

const modal = document.getElementById("section-modal");
const modalForm = document.getElementById("modal-form");

var addOn = false;

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
					typeName = "응원가";
					break;
			}
			addPost(post.number, post.title, post.date, post.type, post.type);
		});
	}
});

openModal.addEventListener('click', function(){
  modal.style.display = "flex";
  modalForm.reset();
  addOn = true;
});

closeModal.addEventListener('click', function(){
  modal.style.display = "none";
});

// 테스트용 추가 버튼
function addbutton(postNumberParam, postTitleParam, postDateParam, postTypeParam, postURLParam) {
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
  deleteButton.addEventListener('click', function(){
    if(confirm("삭제하시겠습니까?")){
      alert("삭제되었습니다.");
      newMember.remove();
    }
  })

  const NumberText = document.createTextNode(postNumberParam);
  const teamNameText = document.createTextNode(postTypeParam);
  const songNameText = document.createTextNode(postTitleParam);
  const linkURLText = document.createTextNode(postURLParam);
  const fixDateText = document.createTextNode(postDateParam);

  buttons.appendChild(deleteButton);

  number.appendChild(NumberText);
  teamName.appendChild(teamNameText);
  songName.appendChild(songNameText);
  linkURL.appendChild(linkURLText);
  fixDate.appendChild(fixDateText);

  linkURL.setAttribute('href',postURLParam);

  newMember.appendChild(number);
  newMember.appendChild(teamName);
  newMember.appendChild(songName);
  newMember.appendChild(linkURL);
  newMember.appendChild(fixDate);
  newMember.appendChild(buttons);

  if(addOn){
    userList.appendChild(newMember);
  }
  modal.style.display = "none";
};