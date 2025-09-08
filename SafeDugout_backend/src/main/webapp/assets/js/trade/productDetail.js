document.addEventListener("DOMContentLoaded", function() {
    const deleteButton = document.getElementById("deleteButton");
    const deleteForm = document.getElementById("deleteForm");

    if (deleteButton && deleteForm) {
        // 버튼 타입을 명시적으로 button으로 설정
        deleteButton.type = "button";

        deleteButton.addEventListener("click", function() {
            // 확인창 띄우기
            if (confirm("정말 삭제하시겠습니까?")) {
                deleteForm.submit(); // 확인 시에만 폼 전송
            }
            // 취소 시에는 아무 동작도 없음 → 서버 전송 안 됨
        });
    }
});
