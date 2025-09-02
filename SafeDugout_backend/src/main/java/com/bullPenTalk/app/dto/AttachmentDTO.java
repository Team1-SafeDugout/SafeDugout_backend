package com.bullPenTalk.app.dto;

public class AttachmentDTO {
//	CREATE TABLE TBL_ATTACHMENT(
//	ATTACHMENT_NUMBER NUMBER,
//	ATTACHMENT_TYPE_ID NUMBER,
//	ATTACHMENT_NAME VARCHAR2(100),
//	ATTACHMENT_SIZE NUMBER,
//	ATTACHMENT_PATH VARCHAR2(200),
//	CONSTRAINT PK_ATTACHMENT PRIMARY KEY(ATTACHMENT_NUMBER),
//	CONSTRAINT FK_ATTACHMENT_TYPE FOREIGN KEY(ATTACHMENT_TYPE_ID) REFERENCES TBL_ATTACHMENT_TYPE(ATTACHMENT_TYPE_ID)
//	);

	
	private int attachmentNumber; // 첨부파일 번호
	private int attachmentTypeId; // 첨부파일 종류 번호 
	private String attachmentName; // 첨부파일 이름
	private String attachmentPath; // 첨부파일 경로
	private int sellPostNumber; 
	private int postNumber;
	private int noticePostNumber;
	
	// get, set
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
	}
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
	public int getAttachmentTypeId() {
		return attachmentTypeId;
	}
	public void setAttachmentTypeId(int attachmentTypeId) {
		this.attachmentTypeId = attachmentTypeId;
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
		return "AttachmentDTO [attachmentNumber=" + attachmentNumber + ", attachmentTypeId=" + attachmentTypeId
				+ ", attachmentName=" + attachmentName + ", attachmentPath=" + attachmentPath + ", sellPostNumber="
				+ sellPostNumber + ", postNumber=" + postNumber + ", noticePostNumber=" + noticePostNumber + "]";
	}
	

	
	

}
