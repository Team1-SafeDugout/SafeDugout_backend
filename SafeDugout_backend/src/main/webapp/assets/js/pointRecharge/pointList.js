document.addEventListener('DOMContentLoaded', () => {
  const listContainer = document.querySelector('.point-list');
  const numberListUl = document.getElementById('numberlist-ul');
  const leftButton = document.getElementById('left-button');
  const rightButton = document.getElementById('right-button');

  const rowCount = 10; // 한 페이지당 10개
  let currentPage = 1;
  let totalPage = 1;

  // 날짜 포맷 변경 함수 (YYYY-MM-DD -> YYYY.MM.DD)
  function formatDate(dateStr) {
    return dateStr.replace(/-/g, '.');
  }

  // 데이터 렌더링 함수
  function renderList(records) {
    listContainer.innerHTML = ''; // 기존 데이터 삭제

    records.forEach(record => {
      const div = document.createElement('div');
      div.classList.add('point-listnumber');

      const chargeAmountLi = document.createElement('li');
      chargeAmountLi.textContent = `${record.chargeAmount}포인트`;

      const afterPointLi = document.createElement('li');
      afterPointLi.textContent = `${record.afterPoint}포인트`;

      const chargeDateLi = document.createElement('li');
      chargeDateLi.textContent = formatDate(record.chargeDate);

      div.appendChild(chargeAmountLi);
      div.appendChild(afterPointLi);
      div.appendChild(chargeDateLi);

      listContainer.appendChild(div);
    });
  }

  // 페이지 번호 버튼 렌더링
  function renderPagination(totalPages, currentPage) {
    numberListUl.innerHTML = '';

    // 최대 10개 페이지 버튼 생성
    const maxPageButtons = 10;
    let startPage = Math.floor((currentPage - 1) / maxPageButtons) * maxPageButtons + 1;
    let endPage = Math.min(startPage + maxPageButtons - 1, totalPages);

    for (let i = startPage; i <= endPage; i++) {
      const li = document.createElement('li');
      const a = document.createElement('a');
      a.href = "#";
      a.textContent = i;
      if (i === currentPage) {
        a.style.fontWeight = 'bold';
      }
      a.addEventListener('click', (e) => {
        e.preventDefault();
        fetchData(i);
      });
      li.appendChild(a);
      numberListUl.appendChild(li);
    }

    leftButton.disabled = currentPage === 1;
    rightButton.disabled = currentPage === totalPages;
  }

  // 데이터 불러오기
  function fetchData(page) {
    fetch(`/app/pointChargeRecordOkController?page=${page}`)
      .then(res => res.json())
      .then(data => {
        currentPage = data.page;
        totalPage = Math.ceil(data.total / rowCount);
        renderList(data.records);
        renderPagination(totalPage, currentPage);
        // 필요하면 내 포인트 등 다른 UI 업데이트도 여기에 추가 가능
      })
      .catch(err => {
        console.error('데이터 로드 실패:', err);
      });
  }

  leftButton.addEventListener('click', () => {
    if (currentPage > 1) {
      fetchData(currentPage - 1);
    }
  });

  rightButton.addEventListener('click', () => {
    if (currentPage < totalPage) {
      fetchData(currentPage + 1);
    }
  });

  // 초기 데이터 로드
  fetchData(1);
});
