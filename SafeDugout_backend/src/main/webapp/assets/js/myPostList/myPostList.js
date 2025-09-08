/*<li class="post-list-top">
	<div class="post-list-number">글 번호</div>
	<div class="post-list-title">제목</div>
	<div class="post-list-date">작성 일자</div>
	<button type="button" class="post-list-delete"></button>
</li>*/
const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기
const memberPostList = document.getElementById("ul-li");

const currentTab = document.getElementById('currentTab');

const urlParams = new URLSearchParams(window.location.search);
var posts = [];

document.addEventListener('DOMContentLoaded', function(){
	memberPostList.innerHTML = '';
	posts = "${boardList}";
});