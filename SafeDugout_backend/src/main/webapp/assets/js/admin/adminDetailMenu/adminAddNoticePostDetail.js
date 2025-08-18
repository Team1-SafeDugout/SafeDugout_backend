const deleteBtn = document.getElementById("cancle-button");

deleteBtn.addEventListener('click', function(){
    // 삭제 confirm 창
    if(confirm("정말 취소하시겠습니까?\n내용은 저장되지 않습니다.")){
        alert("글 작성을 취소 하셨습니다.");
        location.href = './../adminMenu/adminManagePosts.html';
    }
});