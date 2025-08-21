package com.bullPenTalk.app.dto;

public class AdminNoticeDTO {
//	CREATE TABLE TBL_ADMIN_NOTICE (
//	ADMIN_NUMBER        NUMBER,
//	NOTICE_POST_NUMBER  NUMBER,
//	CONSTRAINT PK_ADMIN_NOTICE PRIMARY KEY (ADMIN_NUMBER, NOTICE_POST_NUMBER),
//	CONSTRAINT FK_NOTICE_ADMIN_NUMBER FOREIGN KEY (ADMIN_NUMBER) REFERENCES TBL_ADMIN(ADMIN_NUMBER),
//	CONSTRAINT FK_ADMIN_NOTICE_NUMBER FOREIGN KEY (NOTICE_POST_NUMBER) REFERENCES TBL_NOTICE_POST(NOTICE_POST_NUMBER) ON DELETE CASCADE
//	});



	private int adminNumber; // 관리자 번호
	private int noticePostNumber; // 공지사항 번호
	
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
	}
	
	@Override
	public String toString() {
		return "AdminNoticeDTO [adminNumber=" + adminNumber + ", noticePostNumber=" + noticePostNumber + "]";
	} 
}

	

