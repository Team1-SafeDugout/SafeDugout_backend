package com.bullPenTalk.app.dto;

public class SellPostListDTO {
	int sellPostNumber;
	String attachmentPath;
	String sellPostTitle;
	String sellPostCreationDate;
	
	public int getSellPostNumber() {
		return sellPostNumber;
	}
	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getSellPostTitle() {
		return sellPostTitle;
	}
	public void setSellPostTitle(String sellPostTitle) {
		this.sellPostTitle = sellPostTitle;
	}
	public String getSellPostCreationDate() {
		return sellPostCreationDate;
	}
	public void setSellPostCreationDate(String sellPostCreationDate) {
		this.sellPostCreationDate = sellPostCreationDate;
	}
	
	@Override
	public String toString() {
		return "SellPostListDTO [sellPostNumber=" + sellPostNumber + ", attachmentPath=" + attachmentPath
				+ ", sellPostTitle=" + sellPostTitle + ", sellPostCreationDate=" + sellPostCreationDate + "]";
	}
	
}
