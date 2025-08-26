// productRegister.js

document.addEventListener("DOMContentLoaded", () => {

    // ----------------------------
    // 이미지 업로드 & 미리보기
    // ----------------------------
    const uploadImg = document.getElementById("uploadImg");
    const previewImg = document.getElementById("previewImg");
    const deleteImg = document.getElementById("deleteImg");

    uploadImg.addEventListener("change", () => {
        const file = uploadImg.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = e => {
                previewImg.src = e.target.result;
            };
            reader.readAsDataURL(file);
        }
    });

    deleteImg.addEventListener("click", () => {
        uploadImg.value = ""; // 파일 선택 초기화
        previewImg.src = "/assets/img/communityImg/tradeLogo.png"; // 기본 이미지
    });

    // ----------------------------
    // 팀 선택
    // ----------------------------
    const logos = document.querySelectorAll(".logo img");
    const teamInput = document.getElementById("team");

    logos.forEach(logo => {
        logo.addEventListener("click", () => {
            teamInput.value = logo.dataset.teamId; // 클릭한 팀 ID 세팅
            logos.forEach(l => l.classList.remove("selected"));
            logo.classList.add("selected"); // 선택 강조
        });
    });

    // ----------------------------
    // 상품 등록 폼 검증
    // ----------------------------
    const form = document.querySelector("form");
    const productName = document.getElementById("productName");
    const productContent = document.getElementById("productContent");
    const pricePoint = document.getElementById("productPoint");
    
    form.addEventListener("submit", (e) => {
        let valid = true;

        // 상품명 확인
        if (!productName.value.trim()) {
            alert("상품명을 입력해주세요.");
            valid = false;
        }

        // 굿즈 종류 확인
        const categoryChecked = form.querySelector("input[name='categoryId']:checked");
        if (!categoryChecked) {
            alert("굿즈 종류를 선택해주세요.");
            valid = false;
        }

        // 거래 방식 확인
        const dealChecked = form.querySelector("input[name='dealTypeId']:checked");
        if (!dealChecked) {
            alert("거래 방식을 선택해주세요.");
            valid = false;
        }

        // 가격 확인
        if (!pricePoint.value || isNaN(pricePoint.value) || pricePoint.value <= 0) {
            alert("가격을 올바르게 입력해주세요.");
            valid = false;
        }

        if (!valid) e.preventDefault(); // 검증 실패 시 제출 막기
    });

});
