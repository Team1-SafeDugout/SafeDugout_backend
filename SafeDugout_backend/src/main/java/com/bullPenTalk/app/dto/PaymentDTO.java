package com.bullPenTalk.app.dto;

public class PaymentDTO {

	private int tradeNumber;      // 거래 번호
    private int sellPostNumber;   // 판매글 번호
    private int statusNumber;     // 거래 상태 
    private int buyMember;        // 구매자 번호
    private String paymentDate;   // 결제일
    private String completeDate;  // 구매확정일
    
    //get, set
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public int getSellPostNumber() {
		return sellPostNumber;
	}
	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}
	public int getStatusNumber() {
		return statusNumber;
	}
	public void setStatusNumber(int statusNumber) {
		this.statusNumber = statusNumber;
	}
	public int getBuyMember() {
		return buyMember;
	}
	public void setBuyMember(int buyMember) {
		this.buyMember = buyMember;
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
		return "PaymentDTO [tradeNumber=" + tradeNumber + ", sellPostNumber=" + sellPostNumber + ", statusNumber="
				+ statusNumber + ", buyMember=" + buyMember + ", paymentDate=" + paymentDate + ", completeDate="
				+ completeDate + "]";
	}
    
	
    
}
