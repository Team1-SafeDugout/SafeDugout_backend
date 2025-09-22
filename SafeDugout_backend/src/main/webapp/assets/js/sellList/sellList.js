const form = document.getElementById("joinForm") || document.querySelector("form");
const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : ""; // ★ 전역 없이 읽기
const sellPostList = document.getElementById("ul-li");

const urlParams = new URLSearchParams(window.location.search);

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
				post.postNumber
			);
		});
	}
});
// 거래중인상태
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
    <div class="product-list-deal-status">
      <span>거래 상태 :</span> <span>확정</span>
    </div>
    <div class="product-list-creation-date">
      <span>등록 일자 :</span> <span>2025-08-29</span>
    </div>
  </div>
  <div class="product-list-info-right">
    <div class="product-list-plus-point">
      <span></span> <span>+ 1000000 포인트</span>
    </div>
    <div class="product-list-remain-point">
      <span>잔여 포인트 :</span> <span>1000000 포인트</span>
    </div>
    <div class="product-list-buy-date">
      <span>구매 일자 :</span> <span>2025-09-02</span>
    </div>
    <div class="product-list-complete-date">
      <span>확정 일자 :</span> <span>2025-09-05</span>
    </div>
  </div>
</li>*/

// 거래 전 상태
			/*<li class="post-list-row">
              <div class="product-list-img">
                <a href="">
                  <img src="/webapp/assets/img/communityImg/tradeLogo.png" alt="">
                </a>
              </div>
              <div class="product-list-info-middle">
                <div class="product-list-title">
                  글 제목 :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="">따끈따끈한 글로브 입니다</a>
                </div>
                <div class="product-list-deal-type">
                  <span>거래 방식 :</span> <span>배송</span>
                </div>
                <div class="product-list-deal-status">
                  <span>거래 상태 :</span> <span>거래 이전</span>
                </div>
                <div class="product-list-creation-date">
                  <span>등록 일자 :</span> <span>2025-08-31</span>
                </div>
              </div>
              <div class="product-list-info-right">
                <div class="product-list-plus-point">
                  <span>&nbsp</span> <span>&nbsp</span>
                </div>
                <div class="product-list-price">
                  <span>가격 :</span> <span>1000000 포인트</span>
                </div>
                <div class="product-list-buy-date">
                  <span>&nbsp</span> <span>&nbsp</span>
                </div>
                <div class="product-list-button-container">
                  <!-- 삭제 버튼 -->
                  <a>
                    <div class="product-list-button-delete">삭제하기
                    </div>
                  </a>
                </div>
              </div>
            </li>*/

function addPost
(imgSourceParam, titleParam, dealTypeParam, tradeStatusParam, addDateParam, pointChangeParam, pointLeftParam, buyDateParam, confirmDateParam, postNumber){
	const newPost = document.createElement('li');
	newPost.classList.add("post-list-row");

	if(tradeStatusParam === '판매 중'){
		newPost.innerHTML = `
		  <div class="product-list-img">
		    <a href="/post/detail?postNumber=${postNumber}">
		      
		    </a>
		  </div>
		  <div class="product-list-info-middle">
		    <div class="product-list-title">
		      글 제목 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
		    <div class="product-list-price">
		      <span>가격 :</span> <span>${pointLeftParam} 포인트</span>
		    </div>
		    <div class="product-list-buy-date">
		      <span>&nbsp</span>
		    </div>
		    <div class="product-list-button-container">
		      <!-- 삭제 버튼 -->
		      <a href="/myPage/deleteSell.mp?sellPostNumber=${postNumber}" class="product-list-button-delete">삭제하기</a>
		    </div>
		  </div>
		`;
	}
	
	else if(tradeStatusParam === '거래 중'){
		newPost.innerHTML = `
		  <div class="product-list-img">
		    <a href="/post/detail?postNumber=${postNumber}">
		      
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
		      <span>&nbsp;</span> <span>&nbsp;</span>
		    </div>
		  </div>
		`;			
	}
	
	else if(tradeStatusParam === '구매 확정'){
		newPost.innerHTML = `
		  <div class="product-list-img">
		    <a href="/post/detail?postNumber=${postNumber}">
		      
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
	}
	
	sellPostList.appendChild(newPost);
}