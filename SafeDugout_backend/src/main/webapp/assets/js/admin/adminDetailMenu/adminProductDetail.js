const deleteButton = document.getElementById("delete-button");
const param = new URLSearchParams(window.location.search);

const postNumber = param.get("postNumber");

// 글삭제 버튼
deleteButton.addEventListener('click', function() {
	if (confirm("삭제하시겠습니까?")) {
		alert("삭제 되었습니다");
		window.location.href = "/admin/adminDelteSellOk.ad?postNumber=" + postNumber;
	}
});