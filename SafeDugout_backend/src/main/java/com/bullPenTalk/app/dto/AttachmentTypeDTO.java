package com.bullPenTalk.app.dto;

public class AttachmentTypeDTO {
//	CREATE TABLE TBL_ATTACHMENT_TYPE(
//	ATTACHMENT_TYPE_ID NUMBER,
//	ATTACHMENT_TYPE VARCHAR2(50),
//	CONSTRAINT PK_ATTACHMENT_TYPE PRIMARY KEY(ATTACHMENT_TYPE_ID)
//	);
	
	private int attachmentTypeId;
	private String attachmentType;
	
	public int getAttachmentTypeId() {
		return attachmentTypeId;
	}
	public void setAttachmentTypeId(int attachmentTypeId) {
		this.attachmentTypeId = attachmentTypeId;
	}
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	
	@Override
	public String toString() {
		return "AttachmentTypeDTO [attachmentTypeId=" + attachmentTypeId + ", attachmentType=" + attachmentType + "]";
	}
	
	
	
}
