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
            reader.onload = e => previewImg.src = e.target.result;
            reader.readAsDataURL(file);
        }
    });

    deleteImg.addEventListener("click", () => {
        uploadImg.value = "";
        previewImg.src = "/assets/img/communityImg/tradeLogo.png";
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

        if (!productName.value.trim()) {
            alert("상품명을 입력해주세요.");
            valid = false;
        }

        if (!form.querySelector("input[name='categoryId']:checked")) {
            alert("굿즈 종류를 선택해주세요.");
            valid = false;
        }

        if (!form.querySelector("input[name='dealTypeId']:checked")) {
            alert("거래 방식을 선택해주세요.");
            valid = false;
        }

        if (!pricePoint.value || isNaN(pricePoint.value) || pricePoint.value <= 0) {
            alert("가격을 올바르게 입력해주세요.");
            valid = false;
        }

        if (!valid) e.preventDefault();
    });

    // ----------------------------
    // 팀 로고 선택 기능
    // ----------------------------
    const logos = document.querySelectorAll(".logo img");
    const teamInput = document.getElementById("team");

    logos.forEach(logo => {
        logo.addEventListener("click", () => {
            logos.forEach(l => l.parentElement.classList.remove("selected"));
            logo.parentElement.classList.add("selected");
            teamInput.value = logo.dataset.teamId;
        });
    });

});
