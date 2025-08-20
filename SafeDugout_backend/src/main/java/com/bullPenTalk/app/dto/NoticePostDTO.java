package com.bullPenTalk.app.dto;

public class NoticePostDTO {
//	CREATE TABLE TBL_NOTICE_POST(
//	NOTICE_POST_NUMBER NUMBER,
//	NOTICE_TYPE_ID NUMBER,
//	ADMIN_NUMBER NUMBER,
//	TEAM_NUMBER NUMBER,
//	NOTICE_POST_TITLE VARCHAR2(100) NOT NULL,
//	NOTICE_POST_CONTENT CLOB NOT NULL,
//	NOTICE_POST_DATE DATE NOT NULL,
//	NOTICE_POST_UPDATE DATE ,
//	CONSTRAINT PK_NOTICE_POST PRIMARY KEY(NOTICE_POST_NUMBER),
//	CONSTRAINT FK_NOTICE_POST_ADMIN FOREIGN KEY(ADMIN_NUMBER) REFERENCES TBL_ADMIN(ADMIN_NUMBER),
//	CONSTRAINT FK_NOTICE_POST_TYPE FOREIGN KEY(NOTICE_TYPE_ID) REFERENCES TBL_NOTICE_TYPE(NOTICE_TYPE_ID),
//	CONSTRAINT FK_NOTICE_POST_TEAM FOREIGN KEY(TEAM_NUMBER) REFERENCES TBL_TEAM (TEAM_NUMBER)
//	);
	private int noticePostNumber;
	private int noticeTypeId;
	private int adminNumber;
	private int teamNumber;
	private String noticePostTitle;
	private String noticePostContent;
	private String noticePostDate;
	private String noticePostUpdate;
	
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
	}
	public int getNoticeTypeId() {
		return noticeTypeId;
	}
	public void setNoticeTypeId(int noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getNoticePostTitle() {
		return noticePostTitle;
	}
	public void setNoticePostTitle(String noticePostTitle) {
		this.noticePostTitle = noticePostTitle;
	}
	public String getNoticePostContent() {
		return noticePostContent;
	}
	public void setNoticePostContent(String noticePostContent) {
		this.noticePostContent = noticePostContent;
	}
	public String getNoticePostDate() {
		return noticePostDate;
	}
	public void setNoticePostDate(String noticePostDate) {
		this.noticePostDate = noticePostDate;
	}
	public String getNoticePostUpdate() {
		return noticePostUpdate;
	}
	public void setNoticePostUpdate(String noticePostUpdate) {
		this.noticePostUpdate = noticePostUpdate;
	}
	
	@Override
	public String toString() {
		return "NoticePostDTO [noticePostNumber=" + noticePostNumber + ", noticeTypeId=" + noticeTypeId
				+ ", adminNumber=" + adminNumber + ", teamNumber=" + teamNumber + ", noticePostTitle=" + noticePostTitle
				+ ", noticePostContent=" + noticePostContent + ", noticePostDate=" + noticePostDate
				+ ", noticePostUpdate=" + noticePostUpdate + "]";
	}
	
	
	
}
