const confirmButton = document.getElementById("confirm-button");

confirmButton.addEventListener('click', function(){	
	
	confirmButton.disabled = true;
	confirmButton.textContent = "처리 중..."; // 선택: 사용자 안내용 메시지
	
	fetch(`/myPage/unsubcribeComplete.mp`, 
		{ headers: { "Accept": "application/json","X-Requested-With": "XMLHttpRequest" } })
		.then(response => {
		    if (!response.ok) throw new Error(response.status);
		    return response.text();
		})
		.then(data => {
			console.log(data);
		    if(data === "성공"){
				window.location.href =  "/myPage/unsubcribeSuccess.mp";
			} else{
				window.location.href =  "/myPage/unsubcribeFail.mp";
			}
		})
		.catch(error => {
		    console.error("에러 발생:", error);
			window.location.href =  "/myPage/unsubcribeFail.mp";
	});
});