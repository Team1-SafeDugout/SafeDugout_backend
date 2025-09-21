<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원정보 수정 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/memberUpdate/inputInformation.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/memberInformation/informationInput.js"></script>

</head>

<body>
  <jsp:include page="${pageContext.request.contextPath}/header.jsp" />
  <main>
    <div class="main-full">
      <section class="sidebar">
        <h2>MY페이지</h2>
        <div>
          <ul>
            <li class="sidebar-button post"> <a href="${pageContext.request.contextPath}/myPage/postList.mp"> 내가 쓴 게시글</a> </li>
            <li class="sidebar-button commet"> <a href="${pageContext.request.contextPath}/myPage/commentList.mp"> 내가 쓴 댓글</a> </li>
            <li class="sidebar-button buy"> <a href="${pageContext.request.contextPath}/myPage/tradeList.mp"> 구매 내역</a> </li>
            <li class="sidebar-button sell"> <a href="${pageContext.request.contextPath}/myPage/sellList.mp"> 판매 내역</a> </li>
            <li class="sidebar-button member-update"> <a href="${pageContext.request.contextPath}/myPage/changeInfo.mp"> 회원 정보 수정</a></li>
            <li class="sidebar-button member-quit"> <a href="${pageContext.request.contextPath}/myPage/unSubscribe.mp"> 회원 탈퇴</a></li>
          </ul>
        </div>
      </section>

      <section class="main-content">
        <h3>회원 정보 입력</h3>
        <form action="/myPage/CompleteEdit.mp" method="post" novalidate onsubmit="return validateForm()">
          <div class="main-form-box">
            <ul>
            <!-- 1번쨰 : 이름 -->
              <li>
                <div class="main-input-list">
                  <div class="main-input-list-text">이름</div>
                  <input type="text" placeholder="${memberInfo.memberName}" readonly style="pointer-events: none" value = "${memberInfo.memberName}">
                </div>
              </li>

              <li>
                <div class="main-input-list">
                  <div class="main-input-list-text">아이디</div>
                  <input type="text" placeholder="${memberInfo.memberId}" readonly style="pointer-events: none" value = "${memberInfo.memberId}">
                </div>
              </li>
			<!-- 3번쨰 : 비밀번호 -->
              <li>
                <div class="main-input-error-message"> <span>* 비밀번호가 유효하지 않습니다.</span></div>
                <div class="main-input-list">
                  <div class="main-input-list-text">비밀번호</div>
                  <input name = "pw" id = "pw" type="password" placeholder="영문, 숫자, 특수문자 조합 8자 이상" readonly style="pointer-events: none" value = "${memberInfo.memberPw}">
                  <div class="change-btn">
                    <a class = "edit-button" href="#">수정하기</a>
                    <a class = "confirm-button" href="#">완료</a>
                  </div>
                </div>
              </li>
              
              <!-- 4번쨰 : 비밀번호 일치 -->
              <li id = "re-pw">
                <div class="main-input-error-message"> <span>* 비밀번호가 일치하지 않습니다.</span></div>
                <div class="main-input-list">
                  <div class="main-input-list-text">비밀번호 확인</div>
                  <input id = "rePw" type="password" placeholder="비밀번호를 재입력하세요">
                </div>
              </li>
              
              
			<!-- 5번쨰 : 핸드폰 번호 -->
              <li>
                <div class="main-input-error-message"> <span>* 필수 입력 값입니다.</span></div>
                <div class="main-input-list">
                  <div class="main-input-list-text">핸드폰 번호</div>
                  <input id  = "phoneNumber" name = "phone" type="text" placeholder="핸드폰 번호를 입력하세요" readonly style="pointer-events: none" value ="${memberInfo.memberPhone}">
                  <button id = "validate-button" type="button">인증번호 발송</button>
                  <div class="change-btn">
                    <a class = "edit-button" href="#">수정하기</a>
                    <a class = "confirm-button" href="#">완료</a>
                  </div>
                </div>
              </li>
              
              <!-- 6번쨰 : 인증번호 -->
              <li id = "validate-phone">
                <div class="main-input-error-message"> <span>* 인증번호가 불일치합니다.</span></div>
                <div class="main-input-list">
                  <div class="main-input-list-text">인증 번호 입력</div>
                  <input id = "code" type="text" placeholder="인증 번호 입력">
                  <button type="button" id = "phoneVeriButton">인증</button>
                </div>
              </li>

				<!-- 7번쨰 : 이메일 -->
              <li>
                <div class="main-input-error-message"> <span>* 필수 입력 값입니다.</span></div>
                <div class="main-input-list">
                  <div class="main-input-list-text">이메일</div>
                  <input name = "email" id = "email" type="email" placeholder="이메일을 입력하세요" readonly style="pointer-events: none" value="${memberInfo.memberEmail}">
                  <div class="main-input-email-at"></div>
                  <div class="change-btn">
                    <a class = "edit-button" href="#">수정하기</a>
                    <a class = "confirm-button" href="#">완료</a>
                  </div>
                </div>
              </li>
              
              <!-- 8번쨰 : 우편번호 -->
              <li>
                <div class="main-input-list-optional">
                  <div class="main-input-list-text">주소</div>
                  <input name = "postal" id = "postalCode" type="text" readonly style="pointer-events: none" value="${memberInfo.memberPostalCode}">
                  <button id = "searchPostcodeBtn" type="button">우편번호</button>
                  <div class="change-btn">
                    <a class = "edit-button" href="#">수정하기</a>
                    <a class = "confirm-button" href="#">완료</a>
                  </div>
                </div>
              </li>
              
              <!-- 9번쨰 : 마이팀 -->
              <li>
                <div class="main-input-list-optional">
                  <div class="main-input-list-text">MY팀</div>
                  <select name="myTeam" id="myTeam" style="pointer-events: none">
                    <option value="0">MY팀을 선택하세요(미정)</option>
                    <option value="삼성 라이온즈">삼성 라이온즈</option>
                    <option value="LG 트윈스">LG 트윈스</option>
                    <option value="두산 베어스">두산 베어스</option>
                    <option value="NC 다이노스">NC 다이노스</option>
                    <option value="키움 히어로즈">키움 히어로즈</option>
                    <option value="KT 위즈">KT 위즈</option>
                    <option value="KIA 타이거즈">KIA 타이거즈</option>
                    <option value="SSG 랜더스">SSG 랜더스</option>
                    <option value="롯데 자이언츠">롯데 자이언츠</option>
                    <option value="한화 이글스">한화 이글스</option>
                  </select>
                  <div class="change-btn">
                    <a class = "edit-button" href="#">수정하기</a>
                    <a class = "confirm-button" href="#">완료</a>
                  </div>
                </div>
                 	<script>
					  const teamParam = "${memberInfo.memberMyTeam}";
					  console.log(teamParam);
					  let teamName = "";
					  switch (teamParam) {
							case "1":
								teamName = "두산 베어스";
								break;
							case "2":
								teamName = "LG 트윈스";
								break;
							case "3":	
								teamName = "한화 이글스";
								break;
							case "4":
								teamName = "삼성 라이온즈";
								break;
							case "5":
								teamName = "SSG 랜더스";		
								break;
							case "6":
								teamName = "KT 위즈";
								break;
							case "7":			
								teamName = "NC 다이노스";
								break;
							case "8":
								teamName = "롯데 자이언츠";			
								break;
							case "9":
								teamName = "KIA 타이거즈";
								break;
							case "10":
								teamName = "키움 히어로즈";
								break;
							default:
								teamName = "0";
								break;
						}
					  console.log(teamName);
					  document.getElementById("myTeam").value = teamName;
					</script> 
              </li>
            </ul>
            <div class="main-button-container">
              <button type="submit" id = "save-button">
                <div class="main-button-next">수정 완료 </div>
              </button>
            </div>
          </div>
        </form>
      </section>

      <section class="point-box">
        <div class="my-point-text">내 포인트</div>
        <div class="my-point-value">
          <span>${myPoint}</span><span>P</span>
        </div>
        <a href="${pageContext.request.contextPath}/myPage/pointCharge.mp" class="charge-list-btn">포인트 충전 내역 보기</a>
        <a href="${pageContext.request.contextPath}/trade/sellPostFrontController2.tr?category=buy&action=charging" class="charge-btn">충전</a>
      </section>
    </div>
  </main>
  <jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>

</html>