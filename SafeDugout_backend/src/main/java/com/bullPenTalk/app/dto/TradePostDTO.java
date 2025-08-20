package com.bullPenTalk.app.dto;

public class TradePostDTO {
//	CREATE TABLE TBL_TRADE_POST(
//	TRADE_NUMBER NUMBER,
//	SELL_POST_NUMBER NUMBER NOT NULL,
//	STATUS_NUMBER NUMBER NOT NULL,
//	BUY_MEMBER NUMBER NOT NULL,
//	PAYMENT_DATE DATE NOT NULL DEFAULT SYSDATE,
//	COMPLETE_DATE DATE ,
//	CONSTRAINT PK_TRADE_POST PRIMARY KEY(TRADE_NUMBER),
//	CONSTRAINT FK_TRADE_POST_SELL FOREIGN KEY(SELL_POST_NUMBER) REFERENCES TBL_SELL_POST (SELL_POST_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_TRADE_POST_BUYMEMBER FOREIGN KEY(BUY_MEMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER),
//	CONSTRAINT FK_TRADE_POST_STATUS FOREIGN KEY(STATUS_NUMBER) REFERENCES TBL_TRADE_STATUS (STATUS_ID)
//	);
	
	int tradeNumber;
	int sellPostNumber;
	int statusNumber; 
	int buyMember;
	String paymentDate;
	String completeDate;
	
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
	
	@Override
	public String toString() {
		return "FreePostDTO [tradeNumber=" + tradeNumber + ", sellPostNumber=" + sellPostNumber + ", statusNumber="
				+ statusNumber + ", buyMember=" + buyMember + ", paymentDate=" + paymentDate + ", completeDate="
				+ completeDate + "]";
	}
}
