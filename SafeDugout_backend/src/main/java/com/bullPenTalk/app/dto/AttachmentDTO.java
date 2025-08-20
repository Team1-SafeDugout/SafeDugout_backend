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

	
	private int attachmentNumber;
	private int attachmentTypeId; 
	private String attachmentName;
	private int attachmentSize; 
	private String attachmentPath;
	
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
	public int getAttachmentSize() {
		return attachmentSize;
	}
	public void setAttachmentSize(int attachmentSize) {
		this.attachmentSize = attachmentSize;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	@Override
	public String toString() {
		return "AttachmentDTO [attachmentNumber=" + attachmentNumber + ", attachmentTypeId=" + attachmentTypeId
				+ ", attachmentName=" + attachmentName + ", attachmentSize=" + attachmentSize + ", attachmentPath="
				+ attachmentPath + "]";
	} 
	
	

}
