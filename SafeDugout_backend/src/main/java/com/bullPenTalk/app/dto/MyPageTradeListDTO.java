package com.bullPenTalk.app.dto;

public class MyPageTradeListDTO {
	
	private int sellPostNumber; // 판매 게시글 번호
	private String sellPostTitle; //판매 게시글 제목
	private int dealtypeId; //거래 방식ID
	private String memberId; //회원 ID
	private int statusId; //거래 상태 ID
	private int statusNumber; //거래 상태 번호
	private int pricePoint; // 포인트 값 
	private String paymentDate; //구매 날짜
	private String completeDate; // 구매 확정 날짜
	
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
	public int getStatusNumber() {
		return statusNumber;
	}
	public void setStatusNumber(int statusNumber) {
		this.statusNumber = statusNumber;
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
	
	@Override
	public String toString() {
		return "MyPageTradeListDTO [sellPostTitle=" + sellPostTitle + ", dealtypeId=" + dealtypeId + ", memberId="
				+ memberId + ", statusNumber=" + statusNumber + ", pricePoint=" + pricePoint + ", paymentDate="
				+ paymentDate + ", completeDate=" + completeDate + "]";
	} 
	
}
