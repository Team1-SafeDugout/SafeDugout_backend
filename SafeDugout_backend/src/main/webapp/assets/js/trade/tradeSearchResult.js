document.querySelector("form").addEventListener("submit", function(e) {
    let keyword = document.querySelector("input[name='keyword']").value.trim();
    if (!keyword) {
        e.preventDefault();
        alert("검색어를 입력해주세요.");
    }
});