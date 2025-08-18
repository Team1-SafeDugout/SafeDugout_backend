// 삭제하기 버튼 
const deleteBtn = document.getElementsByClassName('post-button-delete')[0];

// 이벤트리스너 
deleteBtn.addEventListener('click', function () {
  if (confirm("삭제하시겠습니까?")) {
    alert("삭제 되었습니다.");
    location.href = "./tradeMain.html";
  } else {

  }
});