package com.bullPenTalk.app.dto;

public class MyPageTradeListDTO {
	
	private int sellPostNumber;
	private String sellPostTitle; 
	private int dealtypeId;
	private String memberId; 
	private int statusId;
	private int statusNumber; 
	private int pricePoint; 
	private String paymentDate; 
	private String completeDate;
	
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
