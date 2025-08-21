package com.bullPenTalk.app.dto;

public class NoticeTypeDTO { // 공지사항 타입 
//	CREATE TABLE TBL_NOTICE_TYPE(
//	NOTICE_TYPE_ID NUMBER,
//	NOTICE_TYPE VARCHAR2(50) NOT NULL,
//	CONSTRAINT PK_NOTICE_TYPE PRIMARY KEY(NOTICE_TYPE_ID)
//	);

	private int noticeTypeId; // 공지사항 id
	private String noticeType; // 공지사항 타입
	
	// get, set
	public int getNoticeTypeId() 
	
	{
		return noticeTypeId;
	}
	public void setNoticeTypeId(int noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "NoticeTypeDTO [noticeTypeId=" + noticeTypeId + ", noticeType=" + noticeType + "]";
	}


}
