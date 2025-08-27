const userList = document.getElementById("list-ul");

document.addEventListener("DOMContentLoaded", function() {
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			addPost(post.number, post.id, post.date);
		});
	}
});
// 테스트용 추가 버튼
function addPost(userNumberParam, userIdParam, addDateParam){
  const newMember = document.createElement('li');

  const userNumber = document.createElement('div');
  const userID = document.createElement('div');
  const addDate = document.createElement('div');

  const userIdURL = document.createElement('a');
  userID.appendChild(userIdURL);

  const userNumberText = document.createTextNode(userNumberParam);
  const userIDText = document.createTextNode(userIdParam);
  const addDateText = document.createTextNode(addDateParam);

  userIdURL.setAttribute('href', "/admin/adminReadMemberOk.ad?memberNumber="+userNumberParam);

  userNumber.appendChild(userNumberText);
  userID.appendChild(userIdURL);
  userIdURL.appendChild(userIDText);
  addDate.appendChild(addDateText);

  newMember.appendChild(userNumber);
  newMember.appendChild(userID);
  newMember.appendChild(addDate);

  userList.appendChild(newMember);
}