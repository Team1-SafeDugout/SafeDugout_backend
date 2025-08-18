// 각 썸네일 리스트에 들어갈 유튜브 비디오 ID 배열
const teamSongVideoIds = ['dqW2DaOjOho', 'g4tl-r76JEs', 'xr6wPZxyhxI', '_hWa_T6Ku8U', 'yirww4738cs'];
const playerSongVideoIds = ['u3qiN8-UxeY', 'UDCWbW96deg', 'xs0Lfqs2C2I', '3MxdMmF4eGM', 'LIpJjxAe2V8'];

const thumbLists = document.querySelectorAll('.cheer-song .thumb-list');
const videoIdsList = [teamSongVideoIds, playerSongVideoIds];

thumbLists.forEach((ul, idx) => {
  ul.innerHTML = '';

  videoIdsList[idx].forEach(id => {
    const li = document.createElement('li');
    const div = document.createElement('div');
    div.className = 'thumb';

    const a = document.createElement('a');
    a.href = `https://www.youtube.com/watch?v=${id}`;
    a.target = '_blank';
    a.rel = 'noopener noreferrer';

    const img = document.createElement('img');
    img.src = `https://img.youtube.com/vi/${id}/hqdefault.jpg`;
    img.alt = '유튜브 썸네일';

    a.appendChild(img);
    div.appendChild(a);
    li.appendChild(div);
    ul.appendChild(li);
  });
});


