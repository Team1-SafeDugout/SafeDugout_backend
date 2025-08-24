const addbutton = document.getElementById("save-button");
const openModal = document.getElementById("add-song-button");
const closeModal = document.getElementById("cancle-button");

const modal = document.getElementById("section-modal");
const modalForm = document.getElementById("modal-form");

var addOn = false;

openModal.addEventListener('click', function(){
  modal.style.display = "flex";
  modalForm.reset();
  addOn = true;
});

closeModal.addEventListener('click', function(){
  modal.style.display = "none";
});

// 테스트용 추가 버튼
addbutton.addEventListener('click', function () {
  const newMember = document.createElement('li');

  const number = document.createElement('div');
  const teamName = document.createElement('div');
  const songName = document.createElement('div');
  const fixDate = document.createElement('div');
  const linkURL = document.createElement('div');
  const buttons = document.createElement('div');

  const changeButton = document.createElement('button');
  const deleteButton = document.createElement('button');

  changeButton.setAttribute('type', 'button');
  changeButton.appendChild(document.createTextNode("수정"));
  changeButton.addEventListener('click', function(){
    modal.style.display = "flex";
    modalForm.reset();
    addOn = false;
  })

  deleteButton.setAttribute('type', 'button');
  deleteButton.appendChild(document.createTextNode("삭제"));
  deleteButton.addEventListener('click', function(){
    if(confirm("삭제하시겠습니까?")){
      alert("삭제되었습니다.");
      newMember.remove();
    }
  })

  const NumberText = document.createTextNode("number");
  const teamNameText = document.createTextNode("team");
  const songNameText = document.createTextNode("YAHO");
  const linkURLText = document.createTextNode("naver.com");
  const fixDateText = document.createTextNode("0000.00.00");

  buttons.appendChild(changeButton);
  buttons.appendChild(deleteButton);

  number.appendChild(NumberText);
  teamName.appendChild(teamNameText);
  songName.appendChild(songNameText);
  linkURL.appendChild(linkURLText);
  fixDate.appendChild(fixDateText);

  linkURL.setAttribute('href',"https://www.youtube.com/");

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
});