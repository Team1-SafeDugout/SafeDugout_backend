const deleteBtn = document.getElementById("delete-button");


deleteBtn.addEventListener('click', function(){
    // 삭제 confirm 창
    if(confirm("삭제 하시겠습니까?")){
        alert("글 을 삭제하였습니다.");
        location.href = './../adminMenu/adminManagePosts.html';
    }
});