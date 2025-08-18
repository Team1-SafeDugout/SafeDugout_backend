const deleteUserBtn = document.getElementById("delete-user-button");
const userSellList = document.getElementById("sell-post-list");
const userTradeList = document.getElementById("trade-post-list");
const userCommunityList = document.getElementById("community-post-list");

const sellistBtn = document.getElementsByClassName("list-names").item(0);
const tradeListBtn = document.getElementsByClassName("list-names").item(1);
const communityListBtn = document.getElementsByClassName("list-names").item(2);

deleteUserBtn.addEventListener('click', function () {
  if (confirm("정말 탈퇴 시키시겠습니까")) {
    if (userTradeList.children > 0) {
      alert("거래중인 글이 있습니다.");
    }
    else {
      alert("탈퇴 되었습니다.");
      location.href = "./../adminMenu/adminManageMember.html";
    }
  }
});

sellistBtn.addEventListener('click', function () {

  const userListNum = userSellList.children;
  if (userListNum.length >= 10) return;

  const newPost = document.createElement('li');

  const postNum = document.createElement('div');
  const postTitle = document.createElement('div');
  const postDate = document.createElement('div');

  const postURL = document.createElement('a');
  postURL.href = "./../adminDetailMenu/adminProductDetail.html";

  const numText = document.createTextNode("1");
  const titleText = document.createTextNode("제목입니다");
  const dateText = document.createTextNode("2025.08.06");

  postNum.appendChild(numText);
  postTitle.appendChild(postURL);
  postURL.appendChild(titleText);
  postDate.appendChild(dateText);

  newPost.appendChild(postNum);
  newPost.appendChild(postTitle);
  newPost.appendChild(postDate);

  userSellList.appendChild(newPost)

});

tradeListBtn.addEventListener('click', function () {
  const userListNum = userTradeList.children;
  if (userListNum.length >= 10) return;

  const newPost = document.createElement('li');

  const postNum = document.createElement('div');
  const postTitle = document.createElement('div');
  const postDate = document.createElement('div');
  const buyId = document.createElement('div');

  const postURL = document.createElement('a');
  postURL.href = "./../adminDetailMenu/adminProductTradingDetail.html";

  const numText = document.createTextNode("1");
  const titleText = document.createTextNode("제목입니다");
  const dateText = document.createTextNode("2025.08.06");
  const idText = document.createTextNode("th3179");

  postNum.appendChild(numText);
  postTitle.appendChild(postURL);
  postURL.appendChild(titleText);
  postDate.appendChild(dateText);
  buyId.appendChild(idText);

  newPost.appendChild(postNum);
  newPost.appendChild(postTitle);
  newPost.appendChild(postDate);
  newPost.appendChild(buyId);

  userTradeList.appendChild(newPost);
});

communityListBtn.addEventListener('click', function () {
  const userListNum = userCommunityList.children;
  if (userListNum.length >= 10) return;

  const newPost = document.createElement('li');

  const postNum = document.createElement('div');
  const postTitle = document.createElement('div');
  const postDate = document.createElement('div');

  const postURL = document.createElement('a');
  postURL.href = "./../adminDetailMenu/adminUserPost.html";

  const numText = document.createTextNode("1");
  const titleText = document.createTextNode("제목입니다");
  const dateText = document.createTextNode("2025.08.06");

  postNum.appendChild(numText);
  postTitle.appendChild(postURL);
  postURL.appendChild(titleText);
  postDate.appendChild(dateText);

  newPost.appendChild(postNum);
  newPost.appendChild(postTitle);
  newPost.appendChild(postDate);

  userCommunityList.appendChild(newPost);
});