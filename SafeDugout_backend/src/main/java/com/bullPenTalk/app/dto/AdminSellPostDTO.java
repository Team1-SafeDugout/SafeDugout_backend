package com.bullPenTalk.app.dto;

public class AdminSellPostDTO {	
	int sellPostNumber;
	String memberId;
	String statusName;
	String categoryName;
	String dealTypeName;
	int pricePoint;
	String sellPostTitle;
	String tradingArea;
	String sellPostCreationDate;
	String sellPostUpdate;
	String teamName;
	String attachmentPath;	
	
	
	public int getSellPostNumber() {
		return sellPostNumber;
	}




	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}




	public String getMemberId() {
		return memberId;
	}




	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}




	public String getStatusName() {
		return statusName;
	}




	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}




	public String getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	public String getDealTypeName() {
		return dealTypeName;
	}




	public void setDealTypeName(String dealTypeName) {
		this.dealTypeName = dealTypeName;
	}




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




	public String getTeamName() {
		return teamName;
	}




	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}




	public String getAttachmentPath() {
		return attachmentPath;
	}




	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}




	@Override
	public String toString() {
		return "AdminSellPostDTO [sellPostNumber=" + sellPostNumber + ", memberId=" + memberId + ", statusName="
				+ statusName + ", categoryName=" + categoryName + ", dealTypeName=" + dealTypeName + ", pricePoint="
				+ pricePoint + ", sellPostTitle=" + sellPostTitle + ", tradingArea=" + tradingArea
				+ ", sellPostCreationDate=" + sellPostCreationDate + ", sellPostUpdate=" + sellPostUpdate
				+ ", teamName=" + teamName + ", attachmentPath=" + attachmentPath + "]";
	}
	
	
}
