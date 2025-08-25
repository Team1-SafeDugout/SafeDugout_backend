// assets/js/trade/tradeMain.js
document.addEventListener("DOMContentLoaded", () => {
  //  검색창 관련
  const searchForm = document.querySelector("form");
  const searchInput = document.querySelector("input[name='searchWord']");
  const searchBtn = document.getElementById("searchBtn");

  document.addEventListener("DOMContentLoaded", function () {
      // 전체 상품 div 선택
      const productLinks = document.querySelectorAll(".product a");
      productLinks.forEach(link => {
          link.addEventListener("click", function (e) {
              e.preventDefault(); // 기본 링크 이동 방지

              const url = this.href; // href 가져오기
              console.log("상품 상세 페이지 이동 URL:", url);

              // 실제 페이지 이동
              window.location.href = url;
          });
      });
	  

  
  //  세션 사용자 확인 
  if (memberNumber && memberNumber !== "null") {
    console.log("로그인된 사용자 번호:", memberNumber);
  } else {
    console.log("비로그인 상태");
  }
});
});