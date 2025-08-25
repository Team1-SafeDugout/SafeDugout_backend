const addbutton = document.getElementById("save-button");
const openModal = document.getElementById("add-youtube-button");
const closeModal = document.getElementById("cancle-button");


// 테스트용 추가 버튼
function addButton(postNumberParam, teamNameParam, linkParam, dateParam) {

  const newMember = document.createElement('li');

  const number = document.createElement('div');
  const teamName = document.createElement('div');
  const fixDate = document.createElement('div');
  const linkURL = document.createElement('div');
  const buttons = document.createElement('div');

  const deleteButton = document.createElement('button');

  deleteButton.setAttribute('type', 'button');
  deleteButton.appendChild(document.createTextNode("삭제"));
  deleteButton.addEventListener('click', function(){
    if(confirm("삭제하시겠습니까?")){
      alert("삭제되었습니다.");
	  
    }
  })

  const NumberText = document.createTextNode(postNumberParam);
  const teamNameText = document.createTextNode(teamNameParam);
  const linkURLText = document.createTextNode(linkParam);
  const fixDateText = document.createTextNode(dateParam);

  buttons.appendChild(deleteButton);

  number.appendChild(NumberText);
  teamName.appendChild(teamNameText);
  linkURL.appendChild(linkURLText);
  fixDate.appendChild(fixDateText);

  linkURL.setAttribute('href',linkParam);

  newMember.appendChild(number);
  newMember.appendChild(teamName);
  newMember.appendChild(linkURL);
  newMember.appendChild(fixDate);
  newMember.appendChild(buttons);

  if(addOn){
    userList.appendChild(newMember);
  }
  modal.style.display = "none";
}