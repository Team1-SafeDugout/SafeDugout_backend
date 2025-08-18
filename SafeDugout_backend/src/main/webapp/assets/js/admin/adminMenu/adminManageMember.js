const userList = document.getElementById("list-ul");
const addbutton = document.getElementsByClassName("list-names").item(0);

const leftButton = document.getElementById("left-button");
const rightButton = document.getElementById("right-button");
const numberList = document.querySelectorAll("#numberlist-ul>li");

const userNums = 12;
var curPage = 0;

// 숫자 버튼들 세팅
function setNumber() {
  for (var i = 0; i < numberList.length; i++) {
    var curNum = i + (Math.floor((curPage / 5)) * 5);
    numberList.item(i).firstChild.firstChild.nodeValue = curNum + 1;

    if (curPage == curNum) {
      numberList.item(i).style.backgroundColor = "#4D5061";
      numberList.item(i).style.color = "white";
    }

    else {
      numberList.item(i).style.backgroundColor = "white";
      numberList.item(i).style.color = "black";
    }

    if (curNum > userNums) {
      numberList.item(i).style.display = "none";
    }
    else {
      numberList.item(i).style.display = "block";
    }
  }
}


// leftright button 보이기 말기
function setButton() {
  if (curPage == 0) {
    leftButton.style.display = "none";
  } else {
    leftButton.style.display = "block";
  }

  if (curPage >= userNums) {
    rightButton.style.display = "none";
  } else {
    rightButton.style.display = "block";
  }
}

// 왼쪽 오른쪽 버튼 보이기 말기
leftButton.addEventListener('click', function () {
  if (curPage > 0) {
    curPage--;
    setNumber();
  }
  setButton();
});

// 테스트용 왼쪽 오른쪽 버튼
rightButton.addEventListener('click', function () {
  if (curPage < userNums) {
    curPage++;
    setNumber();
  }
  setButton();
});

// 테스트용 추가 버튼
addbutton.addEventListener('click', function () {

  setNumber();
  const userListNum = document.querySelectorAll("#list-ul>li");
  if (userListNum.length >= 10) return;

  const newMember = document.createElement('li');

  const userNumber = document.createElement('div');
  const userID = document.createElement('div');
  const addDate = document.createElement('div');

  const userIdURL = document.createElement('a');
  userID.appendChild(userIdURL);

  const userNumberText = document.createTextNode("userNumber");
  const userIDText = document.createTextNode("userID");
  const addDateText = document.createTextNode("addDate");

  userIdURL.setAttribute('href', "./../adminDetailMenu/adminUserDetail.html");

  userNumber.appendChild(userNumberText);
  userID.appendChild(userIdURL);
  userIdURL.appendChild(userIDText);
  addDate.appendChild(addDateText);

  newMember.appendChild(userNumber);
  newMember.appendChild(userID);
  newMember.appendChild(addDate);

  userList.appendChild(newMember);
});



window.onload = function () {
  setNumber();
  setButton();
};