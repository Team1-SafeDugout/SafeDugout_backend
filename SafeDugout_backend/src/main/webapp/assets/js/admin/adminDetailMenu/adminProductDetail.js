const deleteButton = document.getElementById("delete-button");

// 글삭제 버튼
deleteButton.addEventListener('click', function(){
  if(confirm("삭제하시겠습니까?")){
    alert("삭제 되었습니다");
    location.href = "./../adminMenu/adminManageSell.html";
  }
})