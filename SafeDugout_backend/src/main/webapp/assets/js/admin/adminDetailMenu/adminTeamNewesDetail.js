const deleteButton = document.getElementById("delete-button");
const fixButton = document.getElementById("fix-button");

// 글삭제 버튼
deleteButton.addEventListener('click', function(){
  if(confirm("삭제하시겠습니까?")){
    alert("삭제 되었습니다");
    location.href = "./../adminMenu/adminManageTeamNews.html";
  }
})

fixButton.addEventListener('click', function(){
  if(confirm("수정하시겠습니까?")){
    location.href = "./../adminDetail/adminAddTeamNewsDetail.html";
  }
})