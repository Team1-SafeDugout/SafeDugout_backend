package com.bullPenTalk.app.dto;

public class SellPostDTO {
//	CREATE TABLE TBL_SELL_POST(
//	SELL_POST_NUMBER NUMBER,
//	MEMBER_NUMBER NUMBER NOT NULL,
//	STATUS_ID NUMBER NOT NULL,
//	CATEGORY_ID NUMBER NOT NULL,
//	DEALTYPE_ID NUMBER NOT NULL,
//	PRICE_POINT NUMBER NOT NULL,
//	SELL_POST_TITLE VARCHAR2(100) NOT NULL,
//	SELL_POST_CONTENT CLOB NOT NULL,
//	TRADING_AREA VARCHAR2(100) NOT NULL,
//	SELL_POST_CREATION_DATE TIMESTAMP NOT NULL DEFAULT SYSTIMESTAMP ,
//	SELL_POST_UPDATE DATE ,
//	CONSTRAINT PK_SELL_POST PRIMARY KEY(SELL_POST_NUMBER),
//	CONSTRAINT FK_SELL_POST_MEMEBER FOREIGN KEY(MEMBER_NUMBER)   REFERENCES TBL_MEMBER(MEMBER_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_SELL_POST_CATEGORY FOREIGN KEY(CATEGORY_ID) REFERENCES TBL_CATEGORY(CATEGORY_ID),
//	CONSTRAINT FK_SELL_POST_STATUS FOREIGN KEY(STATUS_ID) REFERENCES TBL_TRADE_STATUS(STATUS_ID),
//	CONSTRAINT FK_SELL_POST_DEALTYPE FOREIGN KEY(DEALTYPE_ID) REFERENCES TBL_DEALTYPE (DEALTYPE_ID)
//	);
	
	int sellPostNumber; 
	int memberNumber;
	int statusId;
	int categoryId;
	int dealtypeId;
	int pricePointNumber; 
	String sellPostTitile; 
	String tradingArea;
	String sellPostCreationDate;
	String sellPostUpdate;
	
	public int getSellPostNumber() {
		return sellPostNumber;
	}
	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDealtypeId() {
		return dealtypeId;
	}
	public void setDealtypeId(int dealtypeId) {
		this.dealtypeId = dealtypeId;
	}
	public int getPricePointNumber() {
		return pricePointNumber;
	}
	public void setPricePointNumber(int pricePointNumber) {
		this.pricePointNumber = pricePointNumber;
	}
	public String getSellPostTitile() {
		return sellPostTitile;
	}
	public void setSellPostTitile(String sellPostTitile) {
		this.sellPostTitile = sellPostTitile;
	}
	public String getTradingArea() {
		return tradingArea;
	}
	public void setTradingArea(String tradingArea) {
		this.tradingArea = tradingArea;
	}
	public String getSellPostCreationDate() {
		return sellPostCreationDate;
	}
	public void setSellPostCreationDate(String sellPostCreationDate) {
		this.sellPostCreationDate = sellPostCreationDate;
	}
	public String getSellPostUpdate() {
		return sellPostUpdate;
	}
	public void setSellPostUpdate(String sellPostUpdate) {
		this.sellPostUpdate = sellPostUpdate;
	}
	
	@Override
	public String toString() {
		return "SellPostDTO [sellPostNumber=" + sellPostNumber + ", memberNumber=" + memberNumber + ", statusId="
				+ statusId + ", categoryId=" + categoryId + ", dealtypeId=" + dealtypeId + ", pricePointNumber="
				+ pricePointNumber + ", sellPostTitile=" + sellPostTitile + ", tradingArea=" + tradingArea
				+ ", sellPostCreationDate=" + sellPostCreationDate + ", sellPostUpdate=" + sellPostUpdate + "]";
	}
	
	
	
	
}
