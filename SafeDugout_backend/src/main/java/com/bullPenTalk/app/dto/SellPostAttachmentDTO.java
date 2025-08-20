package com.bullPenTalk.app.dto;

public class SellPostAttachmentDTO {
//	CREATE TABLE TBL_SELL_POST_ATTACHMENT(
//	SELL_POST_NUMBER NUMBER,
//	ATTACHMENT_NUMBER NUMBER,
//	CONSTRAINT PK_SELL_POST_ATTACHMENT PRIMARY KEY(SELL_POST_NUMBER, ATTACHMENT_NUMBER),
//	CONSTRAINT FK_ATTACHMENT_SELL_POST_NUMBER FOREIGN KEY(SELL_POST_NUMBER) REFERENCES TBL_SELL_POST (SELL_POST_NUMBER)ON DELETE CASCADE,
//	CONSTRAINT FK_SELL_POST_ATTACHMENT_NUMBER FOREIGN KEY(ATTACHMENT_NUMBER) REFERENCES TBL_ATTACHMENT (ATTACHMENT_NUMBER)ON DELETE CASCADE
//	);
	
	private int sellPostNumber;
	private int attachmentNumber;
	
	public int getSellPostNumber() {
		return sellPostNumber;
	}
	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}
	public int getAttachmentNumber() {
		return attachmentNumber;
	}
	public void setAttachmentNumber(int attachmentNumber) {
		this.attachmentNumber = attachmentNumber;
	}
	
	@Override
	public String toString() {
		return "SellPostAttachmentDTO [sellPostNumber=" + sellPostNumber + ", attachmentNumber=" + attachmentNumber
				+ "]";
	}
	
}
