package com.bullPenTalk.app.dto;

public class TeamNoticePostDTO {
	private int noticePostNumber;
	private int noticeTypeId = 0;
	private int adminNumber;
	private int teamNumber;
	private String noticePostTitle;
	private String noticePostContent;
	private String noticePostDate;
	private String noticePostUpdate;
	
	@Override
	public String toString() {
		return "TeamNoticePostDTO [noticePostNumber=" + noticePostNumber + ", noticeTypeId=" + noticeTypeId
				+ ", adminNumber=" + adminNumber + ", teamNumber=" + teamNumber + ", noticePostTitle=" + noticePostTitle
				+ ", noticePostContent=" + noticePostContent + ", noticePostDate=" + noticePostDate
				+ ", noticePostUpdate=" + noticePostUpdate + "]";
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
}
