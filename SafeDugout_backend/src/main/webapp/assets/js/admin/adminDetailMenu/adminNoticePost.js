const deleteBtn = document.getElementById("delete-button");

const param = new URLSearchParams(window.location.search);

const noticePostNumber = param.get("noticePostNumber");
const noticeTypeId = param.get("noticeTypeId");

deleteBtn.addEventListener('click', function(){
    // 삭제 confirm 창
    if(confirm("삭제 하시겠습니까?")){
        alert("글 을 삭제하였습니다.");
		console.log(noticePostNumber + ", " + noticeTypeId);
		window.location.href = "/admin/adminDeleteNoticeOk.ad?noticePostNumber=" + noticePostNumber + "&noticeTypeId=" + noticeTypeId;
    }
});