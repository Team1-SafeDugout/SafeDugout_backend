package com.bullPenTalk.app.dto;

public class GuidePostDTO {
	private int noticePostNumber;
	private int noticeTypeId = 0;
	private int adminNumber;
	private String noticePostTitle;
	private String noticePostContent;
	
	@Override
	public String toString() {
		return "GuidePostDTO [noticePostNumber=" + noticePostNumber + ", noticeTypeId=" + noticeTypeId
				+ ", adminNumber=" + adminNumber + ", noticePostTitle=" + noticePostTitle + ", noticePostContent="
				+ noticePostContent + ", noticePostDate=" + noticePostDate + ", noticePostUpdate=" + noticePostUpdate
				+ "]";
	}
	
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
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
	private String noticePostDate;
	private String noticePostUpdate;
}
