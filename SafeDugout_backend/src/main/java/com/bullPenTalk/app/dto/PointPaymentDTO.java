package com.bullPenTalk.app.dto;

public class PointPaymentDTO {

	private String paymentId;       // IMP 결제번호
    private String merchantUid;     // 가맹점 주문번호
    private int memberNumber;       // 결제한 회원 번호
    private int amount;             // 결제 금액
    private String status;          // 결제 상태
    private String payMethod;       // 결제 방식
    private String paidAt;            // 결제 완료 시간
    private String createdAt;         // 레코드 생성 시간
    
    // get, set
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getMerchantUid() {
		return merchantUid;
	}
	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(String paidAt) {
		this.paidAt = paidAt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	// toString
	@Override
	public String toString() {
		return "PointPaymentDTO [paymentId=" + paymentId + ", merchantUid=" + merchantUid + ", memberNumber="
				+ memberNumber + ", amount=" + amount + ", status=" + status + ", payMethod=" + payMethod + ", paidAt="
				+ paidAt + ", createdAt=" + createdAt + "]";
	}
    
	
    
}
