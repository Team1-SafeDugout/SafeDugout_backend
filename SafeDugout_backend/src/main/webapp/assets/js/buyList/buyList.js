const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기

const postList = document.getElementById("ul-li");
const buyModal = document.getElementById("buy-modal");
const modalBack = document.getElementById("buy-overlay");

let closeModalButton = document.getElementById("close-modal-button");
let confirmTradeButton = document.getElementById("confirm-trade-button");

let currentPost = -1;

document.addEventListener('DOMContentLoaded', function(){
	if (typeof posts !== 'undefined') {
		posts.forEach(post => {
			let statusName = "";
			switch (post.tradeStatus) {
				case "selling":
					statusName = "판매 중";
					break;
				case "Sold":
					statusName = "거래 중";
					break;
					
				case "Orderconfirmed":
					statusName = "구매 확정"
					break;
				default:
					statusName = "이건 오류임";
					break;
			}
			
			let dealTypeName = "";
			switch(post.dealType){
				case "Delivery":
					dealTypeName = "배송";
				break;
				
				case "Directdeal":
					dealTypeName = "직거래";
				break;
				
				default :
					dealTypeName = "이건 오류임";
				break;
			}
			
			addPost(
				post.imgSource, 
				post.title, dealTypeName, 
				statusName, post.addDate, 
				post.pointChange, 
				post.pointLeft, 
				post.buyDate, 
				post.confirmDate, 
				post.postNumber,
				post.seller
			);
		});
	}
});

function addPost
(imgSourceParam, titleParam, dealTypeParam, tradeStatusParam, addDateParam, pointChangeParam, pointLeftParam, buyDateParam, confirmDateParam, postNumber, sellMember){
	const newPost = document.createElement('li');
	newPost.classList.add("post-list-row");

	if(tradeStatusParam === '거래 중'){
		newPost.innerHTML = `
		  <div class="product-list-img">
		    <a href="/post/detail?postNumber=${postNumber}">
		      <img src="${imgSourceParam}" alt="">
		    </a>
		  </div>
		  <div class="product-list-info-middle">
		    <div class="product-list-title">
		      글 제목 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			  <a href="/trade/sellPostFrontController2.tr?category=allproduct&action=detail&sellPostNumber=${postNumber}">${titleParam}</a>
		    </div>
		    <div class="product-list-deal-type">
		      <span>거래 방식 :</span> <span>${dealTypeParam}</span>
		    </div>
		    <div class="product-list-seller">
		      <span>판매자 ID :</span> <span>${sellMember}</span>
		    </div>
		  </div>
		  <div class="product-list-info-right">
		    <div class="product-list-minus-point">${pointChangeParam} 포인트</div>
		    <div class="product-list-remain-point">
		      <span>잔여 포인트 :</span> <span>${pointLeftParam}</span>
		    </div>
		    <div class="product-list-buy-date">
		      <span>구매 일자 :</span> ${buyDateParam}<span>2025-09-04</span>
		    </div>
		    <div class="product-list-button-container">
		      <!-- 구매 확정 버튼 -->
		      <a>
		        <div class="product-list-button-complete" id = "add-button-${postNumber}">구매 확정 </div>
		      </a>
		      <!-- 구매 취소 버튼 -->
		      <a>
		        <div class="product-list-button-cancel" id = "cancle-button-${postNumber}">구매 취소 </div>
		      </a>
		    </div>
		  </div>
		`;
		
		postList.appendChild(newPost);
		const addButton = document.getElementById("add-button-" + postNumber);
		const cancleButton = document.getElementById("cancle-button-" + postNumber);

		addButton.addEventListener("click", function(){
			currentPost = postNumber;
			openModal();
		});

		cancleButton.addEventListener("click", function () {
			if (confirm("삭제하시겠습니까?")) {
				alert("삭제되었습니다.");
				window.location.href =  
				contextPath + 
				"/myPage/cancleTrade.mp?" + 
				"postNumber=" + postNumber;
			}
		});			
	}
	
	else if(tradeStatusParam === '구매 확정'){
		newPost.innerHTML = `
		  <div class="product-list-img">
		    <a href="/post/detail?postNumber=${postNumber}">
		      <img src="${imgSourceParam}" alt="">
		    </a>
		  </div>
		  
		  <div class="product-list-info-middle">
		    <div class="product-list-title">
		      글 제목 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <a href="/trade/sellPostFrontController2.tr?category=allproduct&action=detail&sellPostNumber=${postNumber}">${titleParam}</a>
		    </div>
		    <div class="product-list-deal-type">
		      <span>거래 방식 :</span> <span>${dealTypeParam}</span>
		    </div>
		    <div class="product-list-deal-status">
		      <span>거래 상태 :</span> <span>${tradeStatusParam}</span>
		    </div>
		    <div class="product-list-creation-date">
		      <span>등록 일자 :</span> <span>${addDateParam}</span>
		    </div>
		  </div>
		  
		  <div class="product-list-info-right">
		    <div class="product-list-plus-point">
		      <span>&nbsp</span> <span>&nbsp</span>
		    </div>
		    <div class="product-list-remain-point">
		      <span>가격 :</span> <span>${pointLeftParam} 포인트</span>
		    </div>
		    <div class="product-list-buy-date">
		      <span>구매 일자 :</span> <span>${buyDateParam}</span>
		    </div>
		    <div class="product-list-complete-date">
		      <span>확정 일자 :</span> <span>${confirmDateParam}</span>
		    </div>
		  </div>
		`;
		postList.appendChild(newPost);
	}
}

/*const closeModalButton = document.getElementById("close-modal-button");
const confirmTradeButton = document.getElementById("confirm-trade-button");*/
/* 모달창 */
function openModal(){
	
	modalBack.style.display = "block";
	getProductInfo(currentPost);


}

function closeModal(){
	modalBack.style.display = "none";
	buyModal.style.display = "none";
}

function confrirmTrade(sellPostNumber){
/*	window.location.href = contextPath +"/myPage/confirmTrade.mp?tradePost=" +  currentPost; */
	fetch(`${base}/myPage/confirmTrade.mp?sellPostNumber=${encodeURIComponent(sellPostNumber)}`, {
		headers: {
			"X-Requested-With": "XMLHttpRequest" 
			,"Accept": "text/plain" 
		}
	})
		.then(r => { if (!r.ok) throw new Error(r.status); return r.text(); })
		.then(data => {
			if(data){
				if (data === "성공") {
					/*이동용 모달*/
					alert("구매 확정하였습니다");
					window.location.href = contextPath +"/myPage/tradeList.mp";
				}

				else{
					alert("구매 확정에 실패하였습니다");
					closeModal();
				}				
			} 
		})
		.catch(() => {
			alert("거래페이지를 불러오기 실패했습니다");
			closeModal();
		});
}

function getProductInfo(sellPostNumber){
	
	fetch(`${base}/myPage/openModal.mp?sellPostNumber=${encodeURIComponent(sellPostNumber)}`, {
		headers: {
			"X-Requested-With": "XMLHttpRequest" 
			,"Accept": "application/json" 
		}
	})
		.then(r => { if (!r.ok) throw new Error(r.status); return r.json(); })
		.then(data => {
			if (data) {
				console.log("이거 나왔어! :: " + data);
				
				buyModal.style.display = "flex";
				buyModal.innerHTML = `
				<h3>구매 할 물품.</h3>
				<ul class="post-list-modal">
				  <li class="post-list-row-modal-product-title">
				    <span>상품 이름 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span>${data.title}</span>
				  </li>
				  <li class="post-list-row-modal-product-content">
				    <span>상품 설명 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span>${data.sellPostContent}</span>
				  </li>
				  <li class="post-list-row-modal">
				    <span>거래 방식 :</span> <span>배송</span>
				  </li>
				  <li class="post-list-row-modal">
				    <span>거래 희망 지역 :</span> <span>인천</span>
				  </li>
				  <li class="post-list-row-modal">
				    <span>판매자 ID :</span> <span>sfeq8474</span>
				  </li>
				  <li class="post-list-row-modal-product-price">
				    <div class="product-price">
				      <span>상품 가격 :</span> <span>1000000 포인트</span>
				    </div>
				  </li>
				</ul>
				<div class="product-list-button-container-modal">
				  <!-- 확인 버튼 -->
				  <a>
				    <div class="product-list-button-confirm-modal" id = "confirm-trade-button">확인
				    </div>
				  </a>
				  <!-- 취소 버튼 -->
				  <a>
				    <div class="product-list-button-cancel-modal" id = "close-modal-button">취소
				    </div>
				  </a>
				</div>	
				`;
				
				closeModalButton = document.getElementById("close-modal-button");
				confirmTradeButton = document.getElementById("confirm-trade-button");

				closeModalButton.addEventListener("click", function(){
					closeModal();
				});

				confirmTradeButton.addEventListener("click",function(){
					confrirmTrade(sellPostNumber);
				});
				
			} else {
				console.log("상품이 없어");
				console.log("이거 나왔어! :: " + data.title);
				closeModal();
			}
		})
		.catch(() => {
			alert("거래페이지를 불러오기 실패했습니다");
			closeModal();
		});
}

// 구매확정 전
//<li class="post-list-row">
//  <div class="product-list-img">
//    <a href="">
//      <img src="/webapp/assets/img/communityImg/tradeLogo.png" alt="">
//    </a>
//  </div>
//  <div class="product-list-info-middle">
//    <div class="product-list-title">
//      글 제목 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="">따끈따끈한 글로브 입니다</a>
//    </div>
//    <div class="product-list-deal-type">
//      <span>거래 방식 :</span> <span>배송</span>
//    </div>
//    <div class="product-list-seller">
//      <span>판매자 ID :</span> <span>sfeq8474</span>
//    </div>
//  </div>
//  <div class="product-list-info-right">
//    <div class="product-list-minus-point">- 1000000 포인트</div>
//    <div class="product-list-remain-point">
//      <span>잔여 포인트 :</span> <span>1000000 포인트</span>
//    </div>
//    <div class="product-list-buy-date">
//      <span>구매 일자 :</span> <span>2025-09-04</span>
//    </div>
//    <div class="product-list-button-container">
//      <!-- 구매 확정 버튼 -->
//      <a>
//        <div class="product-list-button-complete">구매 확정
//        </div>
//      </a>
//      <!-- 구매 취소 버튼 -->
//      <a>
//        <div class="product-list-button-cancel">구매 취소
//        </div>
//      </a>
//    </div>
//  </div>
//</li>

// 구매확정 이후
/*<li class="post-list-row">
  <div class="product-list-img">
    <a href="">
      <img src="/webapp/assets/img/communityImg/tradeLogo.png" alt="">
    </a>
  </div>
  <div class="product-list-info-middle">
    <div class="product-list-title">
      글 제목 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="">따끈따끈한 글로브 입니다!!</a>
    </div>
    <div class="product-list-deal-type">
      <span>거래 방식 :</span> <span>배송</span>
    </div>
    <div class="product-list-seller">
      <span>판매자 ID :</span> <span>sen2584</span>
    </div>
  </div>
  <div class="product-list-info-right">
    <div class="product-list-minus-point">- 1000000 포인트</div>
    <div class="product-list-remain-point">
      <span>잔여 포인트 :</span> <span>1000000 포인트</span>
    </div>
    <div class="product-list-buy-date">
      <span>구매 일자 :</span> <span>2025-09-03</span>
    </div>
    <div class="product-list-complete-date">
      <span>확정 일자 :</span> <span>2025-09-05</span>
    </div>
  </div>
</li>*/

// 구매 확정 모달
/*<h3>구매 확정 되었습니다.</h3>
<ul class="post-list-modal">
  <li class="post-list-row-modal-product-title">
    <span>상품 이름 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span>따끈따끈한 글로브 입니다</span>
  </li>
  <li class="post-list-row-modal-product-content">
    <span>상품 설명 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <span>따근따근한 글로브, 상태 양호, 착용감 좋음</span>
  </li>
  <li class="post-list-row-modal">
    <span>거래 방식 :</span> <span>배송</span>
  </li>
  <li class="post-list-row-modal">
    <span>거래 희망 지역 :</span> <span>인천</span>
  </li>
  <li class="post-list-row-modal">
    <span>판매자 ID :</span> <span>sfeq8474</span>
  </li>
  <li class="post-list-row-modal-product-price">
    <div class="product-price">
      <span>상품 가격 :</span> <span>1000000 포인트</span>
    </div>
  </li>
</ul>
<div class="product-list-button-container-modal">
  <!-- 확인 버튼 -->
  <a>
    <div class="product-list-button-confirm-modal" id = "confirm-trade-button">확인
    </div>
  </a>
  <!-- 취소 버튼 -->
  <a>
    <div class="product-list-button-cancel-modal" id = "close-modal-button">취소
    </div>
  </a>
</div>*/