package com.bullPenTalk.app.dto;

public class AdminTradeListDTO {
	int tradeNumber;
	String sellPostTitle;
	String statusName;
	String memberId;
	String paymentDate;
	String completeDate;
	
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSellPostTitle() {
		return sellPostTitle;
	}
	public void setSellPostTitle(String sellPostTitle) {
		this.sellPostTitle = sellPostTitle;
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
		return "AdminTradeListDTO [tradeNumber=" + tradeNumber + ", sellPostTitle=" + sellPostTitle + ", statusName="
				+ statusName + ", memberId=" + memberId + ", paymentDate=" + paymentDate + ", completeDate="
				+ completeDate + "]";
	}

}
