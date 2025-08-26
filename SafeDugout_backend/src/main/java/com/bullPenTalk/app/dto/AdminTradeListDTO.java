package com.bullPenTalk.app.dto;

public class AdminTradeListDTO {
	int tradeNumber;
	String sellPostTitle;
	String sellPostContent;
	String sellPostUpdate;
	String seller;
	String buyer;
	String categoryName;
	String teamName;
	String dealTypeName;
	String attachmentPath;
	String statusName;
	int pricePoint;
	
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
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
	public String getSellPostUpdate() {
		return sellPostUpdate;
	}
	public void setSellPostUpdate(String sellPostUpdate) {
		this.sellPostUpdate = sellPostUpdate;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getDealTypeName() {
		return dealTypeName;
	}
	public void setDealTypeName(String dealTypeName) {
		this.dealTypeName = dealTypeName;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getPricePoint() {
		return pricePoint;
	}
	public void setPricePoint(int pricePoint) {
		this.pricePoint = pricePoint;
	}
	@Override
	public String toString() {
		return "AdminTradeListDTO [tradeNumber=" + tradeNumber + ", sellPostTitle=" + sellPostTitle
				+ ", sellPostContent=" + sellPostContent + ", sellPostUpdate=" + sellPostUpdate + ", seller=" + seller
				+ ", buyer=" + buyer + ", categoryName=" + categoryName + ", teamName=" + teamName + ", dealTypeName="
				+ dealTypeName + ", attachmentPath=" + attachmentPath + ", statusName=" + statusName + ", pricePoint="
				+ pricePoint + "]";
	}
	
	
	
	
}
