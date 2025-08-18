// 상품 종류 카테고리 
const category = document.querySelectorAll('.category');
// 팀 로고 
const teamLogo = document.querySelectorAll('.team-bar-logo');
// 검색 버튼 
const searchBtn = document.getElementById('searchBtn');
// 상품 항목
const productList = document.querySelectorAll('.product-list');
// 결과 없음 텍스트 
const noResulttext = document.getElementsByClassName('no-result-text')[0];
// 상품 개수 
const productCount = document.getElementById('productCount');
// 페이지 버튼 
const pageNum = document.querySelectorAll('.page-num');
// 페이지 버튼 a 태그 
const pageNumA = document.querySelectorAll('.page-num a');
// 오른쪽 화살표 버튼
const rightArrow = document.querySelector('.arrow-button:last-child');
// 왼쪽 화살표 버튼 
const leftArrow = document.querySelector('.arrow-button:first-child');

// 팀에 따른 value 값 배열 
const teamValue = ['allTeam', 'doosan', 'HH', 'kia', 'kt', 'lg', 'LT', 'nc', 'SS', 'ssg', 'WO'];
// 카테고리에 따른 value 값 배열 
const categoryValue = ['allType', 'uniform', 'hat', 'cloths', 'etc', 'cheeringTool', 'baseballEqu'];

// 검색어 일치 항목 여부 
let searchResult = true;
// 현재 페이지 시작 번호
let startNum = 1;

// 검색어 
const searchWord = document.getElementById('searchWord');
// 검색어 텍스트, 카테고리 텍스트
const resultText = document.getElementsByClassName('big-text')[0];
// 검색어 텍스트 
const searchWordText = document.getElementById('searchWordText');

// 이벤트리스너
// 팀 로고 누를 시 빨간 네모 표시, input 태그 value 설정 
teamLogo.forEach((logo, index) => {
  logo.addEventListener('click', function (e) {
    // 기존 빨간 네모 없애기 
    for (let targetLogo of teamLogo) {
      targetLogo.style.border = 'none';
    }

    // 빨간 네모 표시 
    e.currentTarget.style.border = '1px solid red';

  });
});
// 상품 종류 카테고리를 누를 시 포인터색으로 변경 
category.forEach((menu, index) => {
  menu.addEventListener('click', function (e) {
    // 기존 포인터색 배경 없애기 
    for (let targetmenu of category) {
      targetmenu.style.backgroundColor = 'transparent';
    }

    // 포인터색 배경 입히기 
    e.currentTarget.style.backgroundColor = '#DCD6D0';

  });
});
// 검색 버튼 누를 시 동작 
searchBtn.addEventListener('click', function () {
  // 검색 결과 없을 경우 
  if (searchResult === false) {
    for (list of productList) {
      list.style.display = 'none';
    }
    noResulttext.style.display = 'block';
    productCount.innerText = '0000';
  }

  // 검색어 표시 
  if (searchWord.value !== "") {
    resultText.style.display = 'inline';
    searchWordText.innerText = searchWord.value;
  }

  // 검색어가 없을 경우 표시 x
  if (searchWord.value === "") {
    resultText.style.display = 'none';
    searchWordText.innerText = searchWord.value;
  }
});
// 팀 로고 누를 시 빨간 네모 표시, input 태그 value 설정 
teamLogo.forEach((logo, index) => {
  logo.addEventListener('click', function (e) {
    // 기존 빨간 네모 없애기 
    for (let targetLogo of teamLogo) {
      targetLogo.style.border = 'none';
    }

    // 빨간 네모 표시 
    e.currentTarget.style.border = '1px solid red';

  });
});
// 페이지 버튼 누를 시 동작 
pageNum.forEach((btn, index) => {
  btn.addEventListener('click', function (e) {
    // 기존 버튼색 초기화
    for (let targetBtn of pageNum) {
      targetBtn.style.backgroundColor = '#f5f5f5';
    }
    for (let targetBtnA of pageNumA) {
      targetBtnA.style.color = 'black';
    }

    // 클릭된 버튼 색 변경 
    e.currentTarget.style.backgroundColor = '#DCD6D0';
    if (e.currentTarget === btn) {
      pageNumA[index].style.color = 'white';
    }
  });
});
// 오른쪽 화살표 버튼 누를 시 동작
rightArrow.addEventListener('click', function () {
  startNum += 5;
  let plusNum = 0;
  for (let targetPageNumA of pageNumA) {
    targetPageNumA.innerText = startNum + plusNum + '';
    plusNum++;
  }
});
// 왼쪽 화살표 버튼 누를 시 동작
leftArrow.addEventListener('click', function () {
  if (startNum > 1) {
    startNum -= 5;
    let plusNum = 0;
    for (let targetPageNumA of pageNumA) {
      targetPageNumA.innerText = startNum + plusNum + '';
      plusNum++;
    }
  }
});