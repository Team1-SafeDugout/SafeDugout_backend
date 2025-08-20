package com.bullPenTalk.app.dto;

public class NoticeAttachmentDTO {
//	CREATE TABLE TBL_NOTICE_ATTACHMENT(
//	NOTICE_POST_NUMBER NUMBER,
//	ATTACHMENT_NUMBER NUMBER,
//	CONSTRAINT PK_NOTICE_ATTACHMENT PRIMARY KEY(NOTICE_POST_NUMBER, ATTACHMENT_NUMBER),
//	CONSTRAINT FK_ATTACHMENT_NOTICE_NUMBER FOREIGN KEY(NOTICE_POST_NUMBER) REFERENCES TBL_NOTICE_POST(NOTICE_POST_NUMBER)ON DELETE CASCADE,
//	CONSTRAINT FK_NOTICE_ATTACHMENT_NUMBER FOREIGN KEY(ATTACHMENT_NUMBER) REFERENCES TBL_ATTACHMENT (ATTACHMENT_NUMBER)ON DELETE CASCADE
//	);
	private int noticePostNumber;
	private int attachmentNumber;
	
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
	}
	public int getAttachmentNumber() {
		return attachmentNumber;
	}
	public void setAttachmentNumber(int attachmentNumber) {
		this.attachmentNumber = attachmentNumber;
	}
	
	@Override
	public String toString() {
		return "NoticeAttachmentDTO [noticePostNumber=" + noticePostNumber + ", attachmentNumber=" + attachmentNumber
				+ "]";
	}
	
	
}
