package com.bullPenTalk.app.dto;

public class MyPageTradeListDTO { // 마이페이지 판매글 리스트
	
	private int sellPostNumber; // 판매글 번호
	private String sellPostTitle; // 판매글 제목
	private int dealtypeId; // 판매글 거래방식 id(택배, 직거래)
	private String memberId;  // 판매자 id
	private int statusId; // 거래상태 id (판매전 , 판매후, 구매확정)
	private int pricePoint; // 가격
	private String paymentDate; // 결제일자
	private String completeDate; // 구매 확정일자
	
	// get, set
	public String getSellPostTitle() {
		return sellPostTitle;
	}
	public void setSellPostTitle(String sellPostTitle) {
		this.sellPostTitle = sellPostTitle;
	}
	public int getDealtypeId() {
		return dealtypeId;
	}
	public void setDealtypeId(int dealtypeId) {
		this.dealtypeId = dealtypeId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getPricePoint() {
		return pricePoint;
	}
	public void setPricePoint(int pricePoint) {
		this.pricePoint = pricePoint;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MyPageTradeListDTO [sellPostTitle=" + sellPostTitle + ", dealtypeId=" + dealtypeId + ", memberId="
				+ memberId + ", statusNumber=" + ", pricePoint=" + pricePoint + ", paymentDate="
				+ paymentDate + ", completeDate=" + completeDate + "]";
	} 
	
}
