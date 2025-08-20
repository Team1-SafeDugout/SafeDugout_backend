package com.bullPenTalk.app.dto;

public class PostAttachmentDTO {
//	CREATE TABLE TBL_POST_ATTACHMENT(
//	POST_NUMBER NUMBER,
//	ATTACHMENT_NUMBER NUMBER,
//	CONSTRAINT PK_POST_ATTACHMENT PRIMARY KEY(POST_NUMBER, ATTACHMENT_NUMBER),
//	CONSTRAINT FK_ATTACHMENT_POST_NUMBER FOREIGN KEY(POST_NUMBER) REFERENCES TBL_POST(POST_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_POST_ATTACHMENT_NUMBER FOREIGN KEY(ATTACHMENT_NUMBER) REFERENCES TBL_ATTACHMENT(ATTACHMENT_NUMBER) ON DELETE CASCADE
//	);

	
	private int postNumber;
	private int attachmentNumber;
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getAttachmentNumber() {
		return attachmentNumber;
	}
	public void setAttachmentNumber(int attachmentNumber) {
		this.attachmentNumber = attachmentNumber;
	}
	
	@Override
	public String toString() {
		return "PostAttachmentDTO [postNumber=" + postNumber + ", attachmentNumber=" + attachmentNumber + "]";
	}

}
