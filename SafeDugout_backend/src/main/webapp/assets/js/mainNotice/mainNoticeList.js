// 페이지 버튼 
const pageNum = document.querySelectorAll('.page-num');
// 페이지 버튼 a 태그 
const pageNumA = document.querySelectorAll('.page-num a');
// 오른쪽 화살표 버튼
const rightArrow = document.querySelector('.arrow-button:last-child');
// 왼쪽 화살표 버튼 
const leftArrow = document.querySelector('.arrow-button:first-child');

// 현재 페이지 시작 번호
let startNum = 1;

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