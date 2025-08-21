package com.bullPenTalk.app.dto;

public class SellPostDetailDTO {

//	SELECT SP.SELL_POST_NUMBER,
//    SP.SELL_POST_TITLE,
//    SP.SELL_POST_CONTENT,
//    SP.PRICE_POINT,
//    SP.TRADING_AREA,
//    SP.SELL_POST_CREATION_DATE,
//    SP.SELL_POST_UPDATE,
//    M.MEMBER_NUMBER,
//    M.MEMBER_NAME AS SELLER_NAME,
//    C.CATEGORY_NAME,
//    S.STATUS_NAME,
//    D.DEALTYPE_NAME,
//    A.ATTACHMENT_NUMBER,
//    A.ATTACHMENT_NAME,
//    A.ATTACHMENT_PATH

	private int sellPostNumber; // 판매 글 번호
	private String sellPostTitle; // 상품명
	private String sellPostContent; // 상품 설명
	private int pricePoint; // 가격
	private String tradingArea; // 거래지역
	private String sellPostCreationDate; // 작성일자
	private String sellPostUpdate; // 수정일자
	private int memberNumber; // 회원번호
	private String memberId; // 판매자Id
	private int categoryName; // 카테고리 이름
	private String StatusName; // 거래상태 
	private String dealtypeName; // 거래 방식
	private int attachmentNumber; // 첨부파일 번호
	private String attachmentName; // 첨부파일 이름
	private String attachmentPath; // 첨부파일 경로
	
	
	// get, set
	public int getSellPostNumber() {
		return sellPostNumber;
	}
	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
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
	public int getPricePoint() {
		return pricePoint;
	}
	public void setPricePoint(int pricePoint) {
		this.pricePoint = pricePoint;
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
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(int categoryName) {
		this.categoryName = categoryName;
	}
	public String getStatusName() {
		return StatusName;
	}
	public void setStatusName(String statusName) {
		StatusName = statusName;
	}
	public String getDealtypeName() {
		return dealtypeName;
	}
	public void setDealtypeName(String dealtypeName) {
		this.dealtypeName = dealtypeName;
	}
	public int getAttachmentNumber() {
		return attachmentNumber;
	}
	public void setAttachmentNumber(int attachmentNumber) {
		this.attachmentNumber = attachmentNumber;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	// toString
	@Override
	public String toString() {
		return "SellPostDetailDTO [sellPostNumber=" + sellPostNumber + ", sellPostTitle=" + sellPostTitle
				+ ", sellPostContent=" + sellPostContent + ", pricePoint=" + pricePoint + ", tradingArea=" + tradingArea
				+ ", sellPostCreationDate=" + sellPostCreationDate + ", sellPostUpdate=" + sellPostUpdate
				+ ", memberNumber=" + memberNumber + ", memberId=" + memberId + ", categoryName=" + categoryName
				+ ", StatusName=" + StatusName + ", dealtypeName=" + dealtypeName + ", attachmentNumber="
				+ attachmentNumber + ", attachmentName=" + attachmentName + ", attachmentPath=" + attachmentPath + "]";
	}
	
	
}
