const deleteBtn = document.getElementById("cancle-button");
const radios = document.querySelectorAll('input[name="post-categories"]');
const selectTeam = document.getElementById('select-team');
const fileInput = document.getElementById('file-area');
const fileList = document.querySelector('.file-list');
const cntElement = document.querySelector('.cnt');

document.addEventListener("DOMContentLoaded", function() {
  radios.forEach(radio => {
    radio.addEventListener('change', function() {
      if (this.value === 'team') {
        selectTeam.style.display = 'inline-block'; // 보이기
      } else {
        selectTeam.style.display = 'none'; // 숨기기
      }
    });
  });
});

fileInput.addEventListener('change', (event) => {
    const files = event.target.files;

    // 기존 미리보기 초기화
    fileList.innerHTML = '';

    // 파일이 1개 초과인 경우 초기화하고 경고창 띄우기
    if (files.length > 1) {
        const dataTransfer = new DataTransfer();
        fileInput.files = dataTransfer.files;
        alert("파일은 최대 1개까지만 첨부 가능합니다.");
        cntElement.textContent = 0;
        return;
    }

    // 선택된 파일들을 순회하며 미리보기 생성
    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        const src = URL.createObjectURL(file);

        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <div class="show-img-box">
                <img width = 300px height = 300px src="${src}" alt="${file.name}">
            </div>
            <div class="btn-box">
                <button type='button' class='img-cancel-btn' data-name='${file.name}'>삭제</button>
            </div>
        `;
        fileList.appendChild(listItem);
    }

    // 파일 개수 업데이트
    cntElement.textContent = files.length;
    
    // 새로 생성된 삭제 버튼에 클릭 이벤트 리스너 추가
    const cancelButtons = document.querySelectorAll('.img-cancel-btn');
    cancelButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            const fileName = e.target.dataset.name;
            const currentFiles = fileInput.files;
            const dataTransfer = new DataTransfer();

            // 삭제할 파일을 제외하고 새로운 FileList 생성
            for (let i = 0; i < currentFiles.length; i++) {
                if (currentFiles[i].name !== fileName) {
                    dataTransfer.items.add(currentFiles[i]);
                }
            }

            // 파일 입력(input)의 files 속성을 업데이트
            fileInput.files = dataTransfer.files;

            // DOM에서 미리보기 요소 제거
            e.target.closest('li').remove();

            // 파일 개수 업데이트
            cntElement.textContent = fileInput.files.length;
        });
    });
});

deleteBtn.addEventListener('click', function() {
	// 삭제 confirm 창
	if (confirm("정말 취소하시겠습니까?\n내용은 저장되지 않습니다.")) {
		alert("글 작성을 취소 하셨습니다.");
		location.href = './../adminMenu/adminManagePosts.html';
	}
});