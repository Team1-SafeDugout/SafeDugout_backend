package com.bullPenTalk.app.dto;

public class NoticeTypeDTO {
//	CREATE TABLE TBL_NOTICE_TYPE(
//	NOTICE_TYPE_ID NUMBER,
//	NOTICE_TYPE VARCHAR2(50) NOT NULL,
//	CONSTRAINT PK_NOTICE_TYPE PRIMARY KEY(NOTICE_TYPE_ID)
//	);

	private int noticeTypeId;
	private String noticeType;
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
	
	@Override
	public String toString() {
		return "NoticeTypeDTO [noticeTypeId=" + noticeTypeId + ", noticeType=" + noticeType + "]";
	}


}
