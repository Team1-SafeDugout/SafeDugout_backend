const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기
const chargList = document.getElementById("ul-li");

const currentTab = document.getElementById('currentTab');

const urlParams = new URLSearchParams(window.location.search);

document.addEventListener('DOMContentLoaded', function(){
	if (typeof pays !== 'undefined') {
		var num = 1;
		pays.forEach(pay => {
			console.log("test");
			addPost(num, pay.Amonut, pay.date);
			num += 1;
		});
	}
});

/*<li class="post-list-row">
  <div class="post-list-number">10000 포인트</div>
  <div class="post-list-title">10000 포인트</div>
  <div class="post-list-date">2025.09.06</div>
</li>*/
function addPost(chargeNumberParam, chareAmountParam, chargeDateParam){
	const charge = document.createElement('li');
	charge.classList.add("post-list-row");
	charge.innerHTML = 
	`<div class="post-list-number">${chargeNumberParam}</div>
	<div class="post-list-title"> ${chareAmountParam} </div>
	<div class="post-list-date">${chargeDateParam}</div>`;

	chargList.appendChild(charge);
}