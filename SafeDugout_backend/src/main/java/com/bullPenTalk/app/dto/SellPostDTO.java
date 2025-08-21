package com.bullPenTalk.app.dto;

public class SellPostDTO { // 판매글
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
	
	private int sellPostNumber; // 판매글 번호
	private int memberNumber; // 회원번호 (판매자)
	private int statusId; // 거래상태 id(판매중, 판매완료, 구매확정)
	private int categoryId; // 카테고리 id
	private int dealtypeId; // 거래방식 id(직거래, 택배)
	private int pricePoint;  // 가격
	private String sellPostTitle; // 판매글 제목
	private String tradingArea; // 거래지역
	private String sellPostCreationDate; // 판매글 작성일자
	private String sellPostUpdate; // 수정일자
	private String sellPostContent; // 상품 설명
	
	// get, set
	public int getPricePoint() {
		return pricePoint;
	}
	public void setPricePoint(int pricePoint) {
		this.pricePoint = pricePoint;
	}
	public String getSellPostTitle() {
		return sellPostTitle;
	}
	public void setSellPostTitle(String sellPostTitle) {
		this.sellPostTitle = sellPostTitle;
	}
	public String getSellPostContent() {
		return sellPostContent;
	}
	public void setSellPostContent(String sellPostContent) {
		this.sellPostContent = sellPostContent;
	}
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
	
	
	// toSTring
	@Override
	public String toString() {
		return "SellPostDTO [sellPostNumber=" + sellPostNumber + ", memberNumber=" + memberNumber + ", statusId="
				+ statusId + ", categoryId=" + categoryId + ", dealtypeId=" + dealtypeId + ", pricePoint=" + pricePoint
				+ ", sellPostTitle=" + sellPostTitle + ", tradingArea=" + tradingArea + ", sellPostCreationDate="
				+ sellPostCreationDate + ", sellPostUpdate=" + sellPostUpdate + ", sellPostContent=" + sellPostContent
				+ "]";
	}

}
