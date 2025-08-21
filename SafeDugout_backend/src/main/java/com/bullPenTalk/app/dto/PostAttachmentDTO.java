package com.bullPenTalk.app.dto;

public class PostAttachmentDTO { // 게시글 첨부파일 
//	CREATE TABLE TBL_POST_ATTACHMENT(
//	POST_NUMBER NUMBER,
//	ATTACHMENT_NUMBER NUMBER,
//	CONSTRAINT PK_POST_ATTACHMENT PRIMARY KEY(POST_NUMBER, ATTACHMENT_NUMBER),
//	CONSTRAINT FK_ATTACHMENT_POST_NUMBER FOREIGN KEY(POST_NUMBER) REFERENCES TBL_POST(POST_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_POST_ATTACHMENT_NUMBER FOREIGN KEY(ATTACHMENT_NUMBER) REFERENCES TBL_ATTACHMENT(ATTACHMENT_NUMBER) ON DELETE CASCADE
//	);

	
	private int postNumber; // 게시글 번호
	private int attachmentNumber; // 첨부파일 번호
	
	// get, set
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
	
	// toString
	@Override
	public String toString() {
		return "PostAttachmentDTO [postNumber=" + postNumber + ", attachmentNumber=" + attachmentNumber + "]";
	}

}
