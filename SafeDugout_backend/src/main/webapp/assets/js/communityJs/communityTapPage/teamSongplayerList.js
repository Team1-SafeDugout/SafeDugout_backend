const songListData = [
  { num: 1, title: '홍창기 응원가', url: 'https://www.youtube.com/watch?v=u3qiN8-UxeY' },
  { num: 2, title: '이재현 응원가', url: 'https://www.youtube.com/watch?v=UDCWbW96deg' },
  { num: 3, title: '정수빈 응원가', url: 'https://www.youtube.com/watch?v=xs0Lfqs2C2I' },
  { num: 4, title: '구자욱 응원가', url: 'https://www.youtube.com/watch?v=3MxdMmF4eGM' },
  { num: 5, title: '양의지 응원가', url: 'https://www.youtube.com/watch?v=LIpJjxAe2V8' },
  { num: 6, title: '류현진 응원가', url: 'https://www.youtube.com/results?search_query=류현진+응원가' },
  { num: 7, title: '손아섭 응원가', url: 'https://www.youtube.com/results?search_query=손아섭+응원가' },
  { num: 8, title: '김광현 응원가', url: 'https://www.youtube.com/results?search_query=김광현+응원가' },
  { num: 9, title: '오승환 응원가', url: 'https://www.youtube.com/results?search_query=오승환+응원가' },
  { num: 10, title: '강백호 응원가', url: 'https://www.youtube.com/results?search_query=강백호+응원가' }
];

const ul = document.querySelector('.team-song-list');

songListData.forEach(item => {
  const a = document.createElement('a');
  a.href = item.url;
  a.target = '_blank'; // 새 탭 열기 옵션

  const li = document.createElement('li');
  li.classList.add('team-song-list-header'); // 기존 스타일 유지용 클래스 (필요에 따라 조절)

  const spanNum = document.createElement('span');
  spanNum.classList.add('team-song-num');
  spanNum.textContent = item.num;

  const spanTitle = document.createElement('span');
  spanTitle.classList.add('team-song-title');
  spanTitle.textContent = item.title;

  li.appendChild(spanNum);
  li.appendChild(spanTitle);
  a.appendChild(li);

  ul.appendChild(a);
});
