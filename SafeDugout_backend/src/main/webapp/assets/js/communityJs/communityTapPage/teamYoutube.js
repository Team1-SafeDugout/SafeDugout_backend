// 유튜브 비디오 아이디
const videoIds = ['QpIiH_18Cf4', 'sFEzzqbpmM4', 'zC7ZwHBJ3jw', 'MMrAe8gjXH4', '_seFRe7N8bI'];

// 썸네일 리스트 ul 요소 선택
const thumbList = document.querySelector('.thumb-list');

videoIds.forEach(id => {
  const li = document.createElement('li');
  const div = document.createElement('div');
  div.className = 'thumb';

  const a = document.createElement('a');
  a.href = `https://www.youtube.com/watch?v=${id}`;
  a.target = '_blank';
  a.rel = 'noopener noreferrer';

  const img = document.createElement('img');
  img.src = `https://img.youtube.com/vi/${id}/hqdefault.jpg`;
  img.alt = `유튜브 영상 썸네일 ${id}`;

  a.appendChild(img);
  div.appendChild(a);
  li.appendChild(div);
  thumbList.appendChild(li);
});
