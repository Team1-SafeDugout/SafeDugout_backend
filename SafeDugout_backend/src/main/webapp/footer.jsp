<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 배경 어둡게 만드는 div -->
  <div id="overlay"></div>
<!-- 모달창 1 -->
  <div class="modal-useterm-footer">
    <!-- 모달창 닫는 버튼 -->
    <!-- <div class="modal-close-button-footer">
      <span>✕</span>
    </div> -->
    <!-- 모달창 박스 부분 -->
    <div class="modal-window-footer">
      <!-- 모달창 상단 -->
      <div class="term-top-footer">
        <!-- 이용약관 텍스트 -->
        <span>이용약관</span>
      </div>
      <!-- 약관 텍스트 박스 -->
      <div class="term-text-box-footer">
        <section id="terms">
      <br>
      <h2>서비스 이용약관</h2>
      <br>
      <p class="meta">(이 문서에서 '운영팀'은 <strong>불펜토크 운영팀</strong>을 의미합니다.)</p>
		<br>
      <h3>제1조 (목적)</h3>
      <p>본 약관은 불펜토크 운영팀('운영팀')이 제공하는 야구 커뮤니티 및 중고거래 서비스를 포함한 모든 서비스(이하 '서비스')의 이용과 관련하여 운영팀과 회원 간의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.</p>
		<br>
      <h3>제2조 (용어의 정의)</h3>
      <ol>
        <li>"서비스"라 함은 운영팀이 제공하는 웹사이트 및 모바일 서비스를 통해 제공되는 모든 기능(커뮤니티, 팀/선수기록, 일정/순위, 중고거래 등)을 의미합니다.</li>
        <li>"회원"이라 함은 본 약관에 동의하고 이용계약을 체결한 개인을 의미합니다.</li>
        <li>"포인트"라 함은 회원이 카카오페이 QR코드 결제를 통해 충전하여 사이트 내 결제수단으로 사용할 수 있는 가상의 지급수단을 의미합니다.</li>
        <li>"중고거래 서비스"라 함은 회원 상호 간 물품 거래를 지원하는 플랫폼 기능을 의미합니다.</li>
      </ol>
		<br>
      <h3>제3조 (약관의 효력 및 변경)</h3>
      <ol>
        <li>본 약관은 회원가입, 서비스 초기화면의 공지 또는 링크를 통해 게시함으로써 효력을 발생합니다.</li>
        <li>운영팀은 합리적 사유가 발생할 경우 관련 법령에 따라 본 약관을 변경할 수 있으며, 변경 시 적용일자 및 변경사유를 명시하여 최소 7일 전에 공지합니다. 이용자 권리에 중대한 영향을 미치는 변경은 최소 30일 전에 공지합니다.</li>
        <li>변경된 약관은 공지한 시행일 이후 사이트 접속 또는 서비스 이용을 통해 효력이 발생하며, 시행일 이후 서비스를 계속 이용하면 변경에 동의한 것으로 간주됩니다.</li>
      </ol>
		<br>
      <h3>제4조 (이용계약의 성립)</h3>
      <ol>
        <li>이용계약은 회원이 본 약관에 동의하고 가입 신청을 완료한 뒤, 운영팀이 이를 승인함으로써 체결됩니다.</li>
        <li>운영팀은 다음 각 호에 해당하는 신청에 대하여는 승낙을 보류하거나 거절할 수 있습니다: 허위정보 기재, 타인정보 도용, 기타 가입을 부적절하다고 판단되는 경우.</li>
      </ol>
		<br>
      <h3>제5조 (회원의 의무)</h3>
      <ol>
        <li>회원은 관계 법령, 본 약관, 운영정책 및 서비스 안내를 준수해야 합니다.</li>
        <li>회원은 타인의 권리를 침해하거나 서비스 운영을 방해하는 행위를 하여서는 안 됩니다.</li>
        <li>회원은 계정정보 보호의무가 있으며 비밀번호 관리 소홀로 발생한 손해에 대해 책임을 집니다.</li>
      </ol>
		<br>
      <h3>제6조 (운영팀의 의무)</h3>
      <ol>
        <li>운영팀은 안정적인 서비스 제공을 위해 노력합니다.</li>
        <li>운영팀은 개인정보 처리 관련 국내 법령을 준수하여 회원의 개인정보를 적절히 보호합니다. 자세한 내용은 개인정보처리방침을 따릅니다.</li>
        <li>신고 접수 시 사실 확인을 위해 필요한 경우 판매자·구매자 양측에 자료 제출을 요청할 수 있습니다.</li>
      </ol>
		<br>
      <h3>제7조 (포인트 및 결제)</h3>
  <ol>
    <li>포인트 충전은 카카오페이 QR코드 결제 등 운영팀이 제공하는 방법으로 이루어집니다. 포인트 충전 및 사용에 관한 구체적 절차는 별도 안내합니다.</li>
    <li>포인트 환불은 관련 법령과 운영팀의 환불정책에 따릅니다. (예: 결제 취소, 미사용 포인트 환불 등)</li>
    <li>포인트를 이용한 결제 과정에서 발생한 오류 및 이슈는 운영팀이 조사 후 필요한 보정 조치를 취합니다. 단, 회원 간 거래 자체의 법적 책임은 거래 당사자에게 있습니다.</li>
  </ol>
		<br>
      <h4>제7조2 (카카오페이 결제 관련 규정)</h3> 
  <p>운영팀은 카카오페이㈜가 제공하는 전자결제 서비스를 연동하여 포인트 충전 및 결제 서비스를 제공합니다. 카카오페이 결제 이용과 관련하여 다음의 규정이 적용됩니다.</p>
  <ul> 
    <li><strong>카카오페이 약관 준수</strong>: 회원은 카카오페이㈜가 정한 이용약관 및 관련 규정을 준수해야 하며, 카카오페이 이용 중 발생하는 분쟁은 해당 약관에 따릅니다.</li>
    <li><strong>결제 및 환불</strong>: 카카오페이를 통한 결제 취소·환불 절차는 운영팀 환불정책과 카카오페이 약관에 따라 처리됩니다.</li>
    <li><strong>결제 오류 처리</strong>: 시스템 오류로 인해 결제가 잘못 처리된 경우, 운영팀은 카카오페이와 협력하여 신속히 원상 복구 또는 환불을 진행합니다.</li>
    <li><strong>회원 의무</strong>: 회원은 타인의 개인정보 및 결제수단을 도용하여서는 안 되며, 불법 결제 행위 적발 시 서비스 이용이 제한될 수 있습니다.</li>
    <li><strong>운영팀 면책</strong>: 카카오페이 자체 시스템 장애, 통신망 문제, 불가항력적 사유로 인한 결제 지연 또는 실패에 대해서는 운영팀의 책임이 제한됩니다.</li>
  </ul>
		<br>
      <h3>제8조 (중고거래의 기본원칙)</h3>
      <ol>
        <li>운영팀은 중고거래 플랫폼을 제공할 뿐, 거래의 당사자가 아니며 거래에 따른 책임은 판매자 및 구매자 당사자에게 있습니다.</li>
        <li>거래 완료 기준은 구매자의 '거래 확정' 동작으로 하며, 확정 시 보류되어 있던 포인트가 판매자에게 이전됩니다.</li>
      </ol>
		<br>
      <h3>제9조 (거래 분쟁 및 신고 처리)</h3>
      <ol>
        <li>구매확정 지연, 환불 요청, 물품 미수령 등 분쟁이 발생한 경우, 양측은 운영팀에 신고할 수 있으며 증빙자료(사진, 영수증, 운송장 등)를 제출해야 합니다.</li>
        <li>운영팀은 접수된 신고에 대해 중립적 입장에서 사실관계 확인을 진행하고 필요 시 포인트 이전을 보류하거나 임시조치를 취할 수 있습니다.</li>
        <li>허위신고·악의적 거래방해가 확인될 경우 운영팀은 해당 회원에 대해 경고, 게시물 삭제, 서비스 이용 제한 등 제재를 할 수 있습니다.</li>
      </ol>
		<br>
      <h3>제10조 (서비스의 중단 및 책임 제한)</h3>
      <ol>
        <li>운영팀은 설비의 정기점검, 긴급 장애, 불가항력적 사유 등으로 서비스 제공을 일시 중단할 수 있습니다.</li>
        <li>운영팀은 회원 간 정보 교환·거래로 인한 분쟁에 대해 중개자 입장에서 지원할 수 있으나, 직접적인 손해배상 책임은 부담하지 않습니다. 다만 포인트 시스템의 기술적 오류로 인한 손해는 운영팀이 조사·보상 범위 내에서 대응합니다.</li>
      </ol>
		<br>
      <h3>제11조 (이용계약의 해지 및 이용제한)</h3>
      <ol>
        <li>회원은 언제든지 회원탈퇴를 요청할 수 있습니다. 운영팀은 요청 접수 후 관련 처리절차를 진행합니다.</li>
        <li>운영팀은 회원이 본 약관 또는 운영정책을 위반한 경우 사전 통지 후 이용 제한, 일시정지 또는 계약 해지 등의 조치를 취할 수 있습니다.</li>
      </ol>
		<br>
      <h3>제12조 (손해배상 및 면책)</h3>
      <ol>
        <li>운영팀은 고의·중대한 과실이 없는 한 회원 간 거래로 인한 손해에 대해 책임을 지지 않습니다.</li>
        <li>회원은 본인의 불법행위 또는 약관·정책 위반으로 운영팀 또는 제3자에게 손해를 끼친 경우 법적 책임을 부담합니다.</li>
      </ol>
		<br>
      <h3>제13조 (준거법 및 관할)</h3>
      <p>본 약관은 대한민국 법령에 따라 해석되며, 운영팀과 회원 간에 분쟁이 발생할 경우 운영팀의 소재지를 관할하는 법원을 제1심 관할법원으로 합니다.</p>
		<br>
      <h3>시행일</h3>
      <p>본 약관은 2025년 9월 18일부터 시행합니다.</p>
      <br>
    </section>
      </div>
    </div>
    <!-- 모달창 버튼 컨테이너 -->
    <div class="modal-button-container-footer">
      <!-- 닫기버튼 a 태그 -->
      <a>
        <div class="modal-button-close-footer">닫기
        </div>
      </a>
    </div>
  </div>
 <!-- 모달창 2 -->
  <div class="modal-pipolicy-footer">
    <!-- 모달창 닫는 버튼 -->
    <!-- <div class="modal-close-button-footer">
      <span>✕</span>
    </div> -->
    <!-- 모달창 박스 부분 -->
    <div class="modal-window-footer">
      <!-- 모달창 상단 -->
      <div class="term-top-footer">
        <!-- 이용약관 텍스트 -->
        <span>개인정보처리방침</span>
      </div>
      <!-- 약관 텍스트 박스 -->
      <div class="term-text-box-footer">
      	<br>
        <h2>개인정보처리방침</h2>
        <br>
        <section>
            <h3>제1조 (목적)</h3>
            <p>불펜토크 운영팀(이하 "운영팀"이라고 함)는 운영팀이 제공하고자 하는 서비스(이하 '운영팀 서비스')를 이용하는 이용자(이하 '이용자' 또는 '개인정보')를 보호하기 위해, 개인정보보호법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률(이하 '정보통신망법') 등 관련 법령을 준수하고, 서비스 이용자의 개인정보 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보처리방침(이하 '본 방침')을 수립합니다.</p>
            <br>
        </section>

        <section>
            <h3>제2조 (개인정보 처리의 원칙)</h3>
            <p>개인정보 관련 법령 및 본 방침에 따라 운영팀은 이용자의 개인정보를 수집할 수 있으며 수집된 개인정보는 개인의 동의가 있는 경우에 한해 제3자에게 제공될 수 있습니다. 단, 법령의 규정 등에 의해 적법하게 강제되는 경우에는 운영팀은 수집한 이용자의 개인정보를 사전에 개인의 동의 없이 제3자에게 제공할 수도 있습니다.</p>
            <br>
        </section>

        <section>
            <h3>제3조 (본 방침의 공개)</h3>
            <ol>
                <li>운영팀은 이용자가 언제든지 쉽게 방침을 확인할 수 있도록 운영팀 홈페이지 첫 화면 또는 첫 화면과의 연결 화면을 통해 본 방침을 공개하고 있습니다.</li>
                <li>운영팀은 제1항에 따라 방침을 공개하는 경우 글자 크기, 색상 등을 활용하여 이용자가 본 방침을 쉽게 확인할 수 있도록 합니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제4조 (본 방침의 변경)</h3>
            <ol>
                <li>본 방침은 개인정보 관련 법령, 지침, 고시 또는 정부나 운영팀 서비스의 정책이나 내용의 변경에 따라 개정될 수 있습니다.</li>
                <li>운영팀은 제1항에 따라 본 방침을 개정하는 경우 다음 각 호 하나 이상의 방법으로 공지합니다.
                    <ol type="a">
                        <li>운영팀이 운영하는 인터넷 홈페이지의 첫 화면의 공지사항란 또는 별도의 창을 통하여 공지하는 방법</li>
                        <li>서면·모사전송·전자우편 또는 이와 비슷한 방법으로 이용자에게 공지하는 방법</li>
                    </ol>
                </li>
                <li>운영팀은 제2항의 공지는 본 방침 개정의 시행일로부터 최소 7일 이전에 공지합니다. 다만, 이용자 권리의 중요한 변경이 있을 경우에는 최소 30일 전에 공지합니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제5조 (회원 가입을 위한 정보)</h3>
            <p>운영팀은 이용자의 운영팀 서비스에 대한 회원가입을 위하여 다음과 같은 정보를 수집합니다.</p>
            <ul>
                <li>필수 수집 정보: 이메일 주소, 비밀번호, 이름, 닉네임 및 휴대폰 번호</li>
                <li>선택 수집 정보: 우편번호, 응원 팀</li>
            </ul>
            <br>
        </section>

        <section>
            <h3>제6조 (본인 인증을 위한 정보)</h3>
            <p>운영팀은 이용자의 본인 인증을 위하여 다음과 같은 정보를 수집합니다.</p>
            <ul>
                <li>필수 수집 정보: 휴대폰 번호</li>
            </ul>
            <br>
        </section>

        <section>
            <h3>제7조 (개인정보 수집 방법)</h3>
            <p>운영팀은 다음과 같은 방법으로 이용자의 개인정보를 수집합니다.</p>
            <ol>
                <li>이용자가 운영팀의 홈페이지에 자신의 개인정보를 입력하는 방식</li>
                <li>애플리케이션 등 운영팀이 제공하는 홈페이지 외의 서비스를 통해 이용자가 자신의 개인정보를 입력하는 방식</li>
                <li>이용자가 고객센터의 상담, 게시판에서의 활동 등 운영팀의 서비스를 이용하는 과정에서 이용자가 입력하는 방식</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제8조 (개인정보의 이용)</h3>
            <p>운영팀은 개인정보를 다음 각 호의 경우에 이용합니다.</p>
            <ol>
                <li>공지사항의 전달 등 운영팀 운영에 필요한 경우</li>
                <li>이용문의에 대한 회신, 불만의 처리 등 이용자에 대한 서비스 개선을 위한 경우</li>
                <li>운영팀의 서비스를 제공하기 위한 경우</li>
                <li>법령 및 운영팀 약관을 위반하는 회원을 위한 이용 제한 조치, 부정 이용 행위를 포함하여 서비스의 원활한 운영에 지장을 주는 행위에 대한 방지 및 제재를 위한 경우</li>
                <li>개인정보 및 관심에 기반한 이용자 간 관계의 형성을 위한 경우</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제9조 (사전동의 등에 따른 개인정보의 제공)</h3>
            <ol>
                <li>운영팀은 개인정보 제3자 제공 금지에도 불구하고, 이용자가 사전에 공개하거나 다음 각 호 사항에 대하여 동의한 경우에는 제3자에게 개인정보를 제공할 수 있습니다. 다만 이 경우에도 운영팀은 관련 법령 내에서 최소한으로 개인정보를 제공합니다.
                    <ol type="a">
                        <li>카카오페이 서비스 이용 시 결제 대행사를 통한 결제를 위하여 제공을 제공</li>
                    </ol>
                </li>
                <li>운영팀은 전항의 제3자 제공 관계에 변화가 있거나 제3자 제공 관계가 종료될 때도 같은 절차에 의해 이용자에게 고지 및 동의를 구합니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제10조 (개인정보의 보유 및 이용기간)</h3>
            <ol>
                <li>운영팀은 이용자의 개인정보에 대해 개인정보의 수집·이용 목적을 위한 기간 동안 개인정보를 보유 및 이용합니다.</li>
                <li>전항에도 불구하고 운영팀은 내부 방침에 의해 서비스 부정 이용기록은 부정 가입 및 이용 방지를 위하여 회원 탈퇴 시점으로부터 최대 1년간 보관합니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제11조 (법령에 따른 개인정보의 보유 및 이용기간)</h3>
            <p>운영팀은 관계 법령에 따라 다음과 같이 개인정보를 보유 및 이용합니다.</p>
            <ol>
                <li>전자상거래 등에서의 소비자 보호에 관한 법률에 따른 보유 정보 및 보유기간
                    <ol type="a">
                        <li>계약 또는 청약철회 등에 관한 기록: 5년</li>
                        <li>대금결제 및 재화 등의 공급에 관한 기록: 5년</li>
                        <li>소비자의 불만 또는 분쟁처리에 관한 기록: 3년</li>
                        <li>표시·광고에 관한 기록: 6개월</li>
                    </ol>
                </li>
                <li>통신비밀보호법에 따른 보유 정보 및 보유기간
                    <ol type="a">
                        <li>웹사이트 로그 자료: 3개월</li>
                    </ol>
                </li>
                <li>전자금융거래법에 따른 보유 정보 및 보유기간
                    <ol type="a">
                        <li>전자금융거래에 관한 기록: 5년</li>
                    </ol>
                </li>
                <li>위치정보의 보호 및 이용 등에 관한 법률
                    <ol type="a">
                        <li>개인위치정보에 관한 기록: 6개월</li>
                    </ol>
                </li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제12조 (개인정보의 파기 원칙)</h3>
            <p>운영팀은 원칙적으로 이용자의 개인정보 처리 목적의 달성, 보유이용기간의 경과 등 개인정보가 필요하지 않을 경우에는 해당 개인정보를 지체 없이 파기합니다.</p>
            <br>
        </section>

        <section>
            <h3>제13조 (개인정보파기절차)</h3>
            <ol>
                <li>이용자가 회원가입 등을 위해 입력한 정보는 개인정보 처리 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함) 내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참고) 일정 기간 저장된 후 파기됩니다.</li>
                <li>운영팀은 파기 사유가 발생한 개인정보를 개인정보 보호책임자의 승인절차를 거쳐 파기합니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제14조 (개인정보파기방법)</h3>
            <p>운영팀은 전자적 파일 형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제하며, 종이로 출력된 개인정보는 분쇄기로 분쇄하거나 소각 등을 통하여 파기합니다.</p>
            <br>
        </section>

        <section>
            <h3>제15조 (광고성 정보의 전송 조치)</h3>
            <ol>
                <li>운영팀은 전자적 전송매체를 이용하여 영리목적의 광고성 정보를 전송하는 경우 이용자의 명시적인 사전동의를 받습니다. 다만, 다음 각 호 어느 하나에 해당하는 경우에는 사전 동의를 받지 않습니다.
                    <ol type="a">
                        <li>운영팀이 재화 등의 거래관계를 통하여 수신자로부터 직접 연락처를 수집한 경우, 거래가 종료된 날로부터 6개월 이내에 운영팀이 처리하고 수신자와 거래한 것과 동종의 재화 등에 대한 영리목적의 광고성 정보를 전송하려는 경우</li>
                        <li>「방문판매 등에 관한 법률」에 따른 전화권유판매자가 육성으로 수신자에게 개인정보의 수집출처를 고지하고 전화 권유를 하는 경우</li>
                    </ol>
                </li>
                <li>운영팀은 전항에도 불구하고 수신자가 수신거부의사를 표시하거나 사전 동의를 철회한 경우에는 영리목적의 광고성 정보를 전송하지 않으며 수신거부 및 수신동의의 철회에 대한 처리 결과를 알립니다.</li>
                <li>운영팀은 오후 9시부터 다음 날 오전 8시까지의 시간에 전자적 전송매체를 이용하여 영리목적의 광고성 정보를 전송하는 경우에는 제1항에도 불구하고 그 수신자로터 별도의 사전 동의를 받습니다.</li>
                <li>운영팀은 전자적 전송매체를 이용하여 영리목적의 광고성 정보를 전송하는 경우 다음의 사항 등을 광고성 정보에 구체적으로 밝힙니다.
                    <ol type="a">
                        <li>운영팀명 및 연락처</li>
                        <li>수신 거부 또는 수신 동의의 철회 의사표시에 관한 사항의 표시</li>
                    </ol>
                </li>
                <li>운영팀은 전자적 전송매체를 이용하여 영리목적의 광고성 정보를 전송하는 경우 다음 각 호의 어느 하나에 해당하는 조치를 하지 않습니다.
                    <ol type="a">
                        <li>광고성 정보 수신자의 수신거부 또는 수신 동의의 철회를 회피·방해하는 조치</li>
                        <li>숫자·부호 또는 문자를 조합하여 전화번호·전자우편주소 등 수신자의 연락처를 자동으로 만들어 내는 조치</li>
                        <li>영리목적의 광고성 정보를 전송할 목적으로 전화번호 또는 전자우편주소를 자동으로 등록하는 조치</li>
                        <li>광고성 정보 전송자의 신원이나 광고 전송 출처를 감추기 위한 각종 조치</li>
                        <li>영리목적의 광고성 정보를 전송할 목적으로 수신자를 기망하여 회신을 유도하는 각종 조치</li>
                    </ol>
                </li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제16조 (이용자의 의무)</h3>
            <ol>
                <li>이용자는 자신의 개인정보를 최신의 상태로 유지해야 하며, 이용자의 부정확한 정보 입력으로 발생하는 문제의 책임은 이용자 자신에게 있습니다.</li>
                <li>타인의 개인정보를 도용한 회원가입의 경우 이용자 자격을 상실하거나 관련 개인정보보호 법령에 의해 처벌을 받을 수 있습니다.</li>
                <li>이용자는 전자우편주소, 비밀번호 등에 대한 보안을 유지할 책임이 있으며 제3자에게 이를 양도하거나 대여할 수 없습니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제17조 (개인정보 자동 수집 장치의 설치·운영 및 거부에 관한 사항)</h3>
            <ol>
                <li>운영팀은 이용자에게 개별적인 맞춤서비스를 제공하기 위해 이용 정보를 저장하고 수시로 불러오는 개인정보 자동 수집장치(이하 '쿠키')를 사용합니다. 쿠키는 웹사이트를 운영하는 데 이용되는 서버(http)가 이용자의 웹브라우저(PC 및 모바일을 포함)에게 보내는 소량의 정보이며 이용자의 웹 저장공간에 저장되기도 합니다.</li>
                <li>이용자는 쿠키 설치에 대한 선택권이 있습니다. 따라서 이용자는 웹브라우저에서 옵션을 설정함으로써 모든 쿠키를 허용하거나, 쿠키가 저장될 때마다 확인을 거치거나, 아니면 모든 쿠키의 저장을 거부할 수도 있습니다.</li>
                <li>다만, 쿠키의 저장을 거부할 경우에는 로그인이 필요한 운영팀의 일부 서비스는 이용에 어려움이 있을 수 있습니다.</li>
            </ol>
            <br>
        </section>

        <section>
            <h3>제18조 (쿠키 설치 허용 지정 방법)</h3>
            <p>웹브라우저 옵션 설정을 통해 쿠키 허용, 쿠키 차단 등의 설정을 할 수 있습니다.</p>
            <ul class="no-list-style">
                <li>1. Edge: 웹브라우저 우측 상단의 설정 메뉴 > 쿠키 및 사이트 권한 > 쿠키 및 사이트 데이터 관리 및 삭제</li>
                <li>2. Chrome: 웹브라우저 우측 상단의 설정 메뉴 > 개인정보 및 보안 > 쿠키 및 기타 사이트 데이터</li>
                <li>3. Whale: 웹브라우저 우측 상단의 설정 메뉴 > 개인정보 보호 > 쿠키 및 기타 사이트 데이터</li>
            </ul>
            <br>
        </section>

        <section>
            <h3>제19조 (개인정보 보호 책임자 지정)</h3>
            <ol>
                <li>운영팀은 이용자의 개인정보를 보호하고 개인정보와 관련한 불만을 처리하기 위하여 아래와 같이 관련 부서 및 개인정보 보호 책임자를 지정하고 있습니다.</li>
            </ol>
            <ul class="no-list-style">
                <li>가. 개인정보 보호 책임자
                    <ul>
                        <li>1) 성명: 박건아, 이태호, 백정이</li>
                        <li>2) 직책: 관리자</li>
                        <li>3) 전화번호: 010-8563-9121</li>
                        <li>4) 이메일: th3179@naver.com</li>
                    </ul>
                </li>
            </ul>
            <br>
        </section>

        <section>
            <h3>제20조 (권익 침해에 대한 구제방법)</h3>
            <ol>
                <li>정보주체는 개인정보침해로 인한 구제를 받기 위하여 개인정보분쟁조정위원회, 한국인터넷진흥원 개인정보침해신고센터 등에 분쟁해결이나 상담 등을 신청할 수 있습니다. 이 밖에 기타 개인정보침해의 신고, 상담에 대하여는 아래의 기관에 문의하시기 바랍니다.
                    <ul class="no-list-style">
                        <li>가. 개인정보분쟁조정위원회: (국번없이) 1833-6972 (www.kopico.go.kr)</li>
                        <li>나. 개인정보침해신고센터: (국번없이) 118 (privacy.kisa.or.kr)</li>
                        <li>다. 대검찰청: (국번없이) 1301 (www.spo.go.kr)</li>
                        <li>라. 경찰청: (국번없이) 182 (ecrm.cyber.go.kr)</li>
                    </ul>
                </li>
                <li>운영팀은 정보주체의 개인정보자기결정권을 보장하고, 개인정보침해로 인한 상담 및 피해 구제를 위해 노력하고 있으며, 신고나 상담이 필요한 경우 제1항의 담당부서로 연락해주시기 바랍니다.</li>
                <li>개인정보 보호법 제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.
                    <ul class="no-list-style">
                        <li>가. 중앙행정심판위원회: (국번없이) 110 (www.simpan.go.kr)</li>
                    </ul>
                </li>
            </ol>
            <br>
        </section>
        
        <section>
            <h3>제21조 (카카오페이 결제 관련 개인정보 처리방침)</h3>
			<br>
            <h4>1. 총칙</h4>
            <p>
              운영팀은 카카오페이㈜와의 결제 서비스 제공을 위하여 아래와 같이 개인정보를 처리하며,
              관련 법령을 준수합니다.
            </p>
			<br>
            <h4>2. 수집하는 개인정보 항목</h4>
            <ul>
              <li>결제 시: 카카오페이 결제 식별자(결제 ID), 거래 내역, 결제 금액, 결제 수단 정보(카카오페이와 연동된 계좌/카드)</li>
              <li>자동 수집 항목: 접속 IP, 쿠키, 기기 정보 등</li>
            </ul>
            <br>
            <h4>3. 개인정보의 수집 및 이용 목적</h4>
            <ul>
              <li>서비스 제공 및 회원 관리</li>
              <li>카카오페이를 통한 결제 처리 및 환불, 정산</li>
              <li>고객 문의 응대 및 분쟁 해결</li>
              <li>관련 법령 준수 (세법 등)</li>
            </ul>
            <br>
            <h4>4. 개인정보의 보유 및 이용기간</h4>
            <ul>
              <li>회원 탈퇴 시 즉시 파기</li>
              <li>단, 결제/정산 관련 기록은 전자상거래법에 따라 5년간 보관</li>
            </ul>
            <br>
            <h4>5. 개인정보의 제3자 제공</h4>
            <p>
              운영팀은 결제 서비스 제공을 위하여 필요한 범위 내에서 카카오페이에 개인정보를 제공합니다.
            </p>
            <br>
            <h4>6. 개인정보의 위탁</h4>
            <p>
              운영팀은 결제 대행(카카오페이㈜), 서버 운영 등 원활한 서비스 제공을 위해 개인정보 처리를 위탁할 수 있으며,
              이 경우 관련 법령에 따라 안전하게 관리되도록 감독합니다.
            </p>
            <br>
            <h4>7. 정보주체의 권리</h4>
            <p>
              이용자는 개인정보 열람, 정정, 삭제, 처리정지 요구 등 개인정보 보호 관련 권리를 행사할 수 있습니다.
            </p>
            <br>
        </section>
        
        <section>
            <h3>부칙</h3>
            <p>본 방침은 2025.09.18. 부터 시행됩니다.</p>
            <br>
        </section>
      </div>
    </div>
    <!-- 모달창 버튼 컨테이너 -->
    <div class="modal-button-container-footer">
      <!-- 닫기버튼 a 태그 -->
      <a>
        <div class="modal-button-close-footer">닫기
        </div>
      </a>
    </div>
  </div>
 <!-- 모달창 3 -->
  <div class="modal-tradepolicy-footer">
    <!-- 모달창 닫는 버튼 -->
    <!-- <div class="modal-close-button-footer">
      <span>✕</span>
    </div> -->
    <!-- 모달창 박스 부분 -->
    <div class="modal-window-footer">
      <!-- 모달창 상단 -->
      <div class="term-top-footer">
        <!-- 이용약관 텍스트 -->
        <span>중고거래 운영 방침</span>
      </div>
      <!-- 약관 텍스트 박스 -->
      <div class="term-text-box-footer">
        <section id="market">
        <br>
      <h2>중고거래 운영정책</h2>
      <br>

      <h3>제1조 (목적)</h3>
      <p>본 운영정책은 불펜토크 운영팀(이하 '운영팀')이 제공하는 중고거래 서비스의 안전한 이용과 분쟁 예방을 위하여 필요한 사항을 규정합니다.</p>
		<br>
      <h3>제2조 (거래 방식)</h3>
      <ol>
        <li>회원은 직거래 또는 택배(배송)거래 중 선택하여 거래할 수 있습니다.</li>
        <li>구매 확정 전까지 거래대금(포인트)은 사이트에서 보류 처리되며, 구매확정 시 판매자에게 포인트가 이전됩니다.</li>
      </ol>
		<br>
      <h3>제3조 (게시물 등록 및 금지 물품)</h3>
      <ol>
        <li>판매자는 물품명, 상태, 사진, 가격, 거래방법(직거래/택배), 배송비 부담 주체 등을 정확히 기재해야 합니다.</li>
        <li>다음 물품은 게시할 수 없습니다: 불법물품, 위조품, 도난품, 위험물, 법령에서 금지된 물품, 기타 타인의 권리를 침해하는 물품.</li>
      </ol>
		<br>
      <h3>제4조 (신고 및 증빙자료)</h3>
      <ol>
        <li>거래 관련 분쟁이 발생한 경우, 당사자는 운영팀에 신고할 수 있으며, 신고자는 가능한 증빙자료(사진, 거래내역, 운송장, 메시지 내역 등)를 제출해야 합니다.</li>
        <li>운영팀은 분쟁 해결을 위해 판매자·구매자 양측에 추가 자료 제출을 요청할 수 있습니다. 자료 제출을 거부하거나 허위자료 제출이 확인될 경우 불리한 결과가 발생할 수 있습니다.</li>
        <li>신고 접수 방법: 사이트 푸터에 기재된 이메일(<a href="mailto:privacy@bullpen.co.kr">privacy@bullpen.co.kr</a>)로 접수합니다. 접수 시 거래정보(주문번호/게시물ID/거래일시 등)를 함께 제출해 주세요.</li>
      </ol>
		<br>
      <h3>제5조 (구매확정 지연 및 임시조치)</h3>
      <ol>
        <li>구매자가 물품을 수령하고도 거래 확정을 하지 않는 경우 판매자는 운영팀에 신고할 수 있습니다.</li>
        <li>운영팀은 신고 접수 후 제출된 증빙을 검토하여 필요 시 포인트 이전 보류, 임시 환불 등 조치를 취할 수 있습니다.</li>
      </ol>
		<br>
      <h3>제6조 (허위신고 및 악의적 행위에 대한 제재)</h3>
      <ol>
        <li>허위신고나 악의적 거래 방해 행위가 확인될 경우 운영팀은 해당 회원에 대해 경고, 게시물 삭제, 거래 기능 제한, 계정 정지 등 제재를 취할 수 있습니다.</li>
        <li>중대한 피해를 야기한 경우 운영팀은 관련 기관(경찰, 수사기관)에 고발할 수 있습니다.</li>
      </ol>
		<br>
      <h3>제7조 (판매자·구매자의 책임 범위)</h3>
      <ol>
        <li>판매자는 물품의 하자, 설명과 다른 부분에 대해 성실히 고지할 의무가 있습니다.</li>
        <li>구매자는 물품 수령 시 상태를 확인하고, 이상이 있을 경우 즉시 사진 등 증빙을 남겨 신고해야 합니다.</li>
        <li>운영팀은 거래의 중개자이며, 기본적으로 거래 당사자의 직접적인 법적 책임을 대체하지 않습니다.</li>
      </ol>
		<br>
      <h3>제8조 (포인트 환불 및 취소)</h3>
      <ol>
        <li>취소, 환불 절차는 거래의 성격(직거래/배송) 및 사유(변심/미수령/물품불량)에 따라 상이하며 관련 법령과 운영팀의 환불정책을 따릅니다.</li>
        <li>거래 취소 또는 환불 요청 시 운영팀이 개입하는 경우, 보류된 포인트는 운영팀의 조사 완료 전까지 잠정 보류됩니다.</li>
      </ol>
		<br>
      <h3>제9조 (개인정보 및 자료 제공 동의)</h3>
      <p>신고 조사 과정에서 운영팀은 사실 확인을 위해 당사자에게서 관련 자료(사진, 메시지, 운송장 등)를 요청할 수 있으며, 회원은 이에 성실히 응해야 합니다. 단, 개인정보의 수집·이용·제공은 개인정보처리방침 및 관련 법령에 따라 처리됩니다.</p>
		<br>
      <h3>제10조 (정책 변경)</h3>
      <p>본 운영정책은 서비스 개선 및 법령 변경 등에 따라 변경될 수 있으며, 변경 시 운영팀은 사전 공지합니다.</p>
		<br>
      <h3>시행일</h3>
      <p>본 운영정책은 2025년 9월 18일부터 시행합니다.</p>
      <br>
    </section>
      </div>
    </div>
    <!-- 모달창 버튼 컨테이너 -->
    <div class="modal-button-container-footer">
      <!-- 닫기버튼 a 태그 -->
      <a>
        <div class="modal-button-close-footer">닫기
        </div>
      </a>
    </div>
  </div>
<!-- 푸터 -->
  <footer>
  <div class="footer-left">
  	<p><span class="service-name">불펜토크 BULLPENTALK</span></p>
    <p><span class="useTerm-footer">이용약관</span>&nbsp•&nbsp<span class="piPolicy-footer">개인정보처리방침</span></p>
    <p>대표 관리자 이메일 주소 : admin1234@gmail.com</p>
    <p><span class="tradePolicy-footer">중고거래 운영 방침</span></p>
  </div>
  <div class="footer-right">
  	<p><span class="footer-page-title">팀 커뮤니티</span></p>
  	<p class="footer-team-link">
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=3">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/hanwha.png" alt="">한화
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=2">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/lg.png" alt="">LG
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=8">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/lotte.png" alt="">롯데
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=5">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/ssg.png" alt="">SSG
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=9">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/kia.png" alt="">KIA
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=6">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/kt.png" alt="">KT
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=7">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/nc.png" alt="">NC
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=4">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/samsung.png" alt="">삼성
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=1">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/doosan.png" alt="">두산
  		</a>
  		<a href="${pageContext.request.contextPath}/main/mainTeam.ma?teamNumber=10">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/kiwoom.png" alt="">키움
  		</a>
  	</p>
  	<div class="footer-right-bottom">
  		<div class="footer-page-title-container">
  		<div>
  			<span class="footer-page-title">전체 커뮤니티</span>
  		</div>
  		<div>
  			<a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr">
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeMainLogo.png" alt="중고거래 로고">
			<span class="footer-page-title">중고거래</span>
			</a>
		</div>
  		<div>
  			<c:choose>
  			<c:when test="${not empty sessionScope.memberNumber}">
  				<a href="${pageContext.request.contextPath}/trade/SellPostFrontController2.tr?category=tradewirte&action=write">
  			</c:when>
  			<c:otherwise>
  				<a class="footer-trade-write-nologin">
  			</c:otherwise>
  			</c:choose>
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/tradeLogo.png" alt="상품 등록 로고">
			<span class="footer-page-title">상품 등록</span>
			</a>
		</div>
  		<div>
  			<c:choose>
  			<c:when test="${not empty sessionScope.memberNumber}">
  				<a href="${pageContext.request.contextPath}/myPage/postList.mp">
  			</c:when>
  			<c:otherwise>
  				<a class="footer-mypage-nologin">
  			</c:otherwise>
  			</c:choose>
  			<img src="${pageContext.request.contextPath}/assets/img/communityImg/icoMypage.png" alt="마이페이지 로고">
			<span class="footer-page-title">마이페이지</span>
			</a>
		</div>
		</div>
		<p><a href="${pageContext.request.contextPath}/freeCommunity/freeCommunitymain.fc"><span class="free-community-main">• 전체 커뮤니티 메인</span></a></p>
  		<p><a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityList.fc"><span class="free-community-board">• 자유 게시판</span></a></p>
  		<p><a href="${pageContext.request.contextPath}/freeCommunity/freeCommunityNoticeList.fc"><span class="free-community-guide">• 입문자 가이드</span></a></p>
  	</div>
  </div>
  </footer>
<!-- js 파일 -->
<script src="${pageContext.request.contextPath}/assets/js/footer.js"></script>