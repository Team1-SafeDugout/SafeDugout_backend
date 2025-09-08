const deleteBtn = document.getElementById("delete-button");

const param = new URLSearchParams(window.location.search);

const postNumber = param.get("postNumber");
const boardId = param.get("postTypeId");

deleteBtn.addEventListener('click', function(){
    // 삭제 confirm 창
    if(confirm("삭제 하시겠습니까?")){
        alert("글 을 삭제하였습니다.");
		console.log(postNumber + ", " + boardId);
		window.location.href = "/admin/adminDeletePostOk.ad?postNumber=" + postNumber + "&postTypeId=" + boardId;
    }
});