package com.bullPenTalk.app.dto;

import java.util.Date;

public class TeamNoticePostDTO {
	private int noticePostNumber; // 공지글 번호
	private int noticeTypeId; // 팀 공지글 번호 =  2
	private int adminNumber; // 관리자 번호
	private int teamNumber; // 팀 번호
	private String noticePostTitle; // 팀공지글 제목
	private String noticePostContent; // 팀공지글 내용
	private Date noticePostDate; // 작성날짜
	private String noticePostUpdate; // 수정 날짜
	private int attachmentNumber; // 
    private String attachmentName;
    private String attachmentPath;
	
	public int getAttachmentNumber() {
		return attachmentNumber;
	}

	public void setAttachmentNumber(int attachmentNumber) {
		this.attachmentNumber = attachmentNumber;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public int getNoticeTypeId() {
		return noticeTypeId;
	}

	public void setNoticeTypeId(int noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
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
	public Date getNoticePostDate() {
		return noticePostDate;
	}
	public void setNoticePostDate(Date noticePostDate) {
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
		return "TeamNoticePostDTO [noticePostNumber=" + noticePostNumber + ", noticeTypeId=" + noticeTypeId
				+ ", adminNumber=" + adminNumber + ", teamNumber=" + teamNumber + ", noticePostTitle=" + noticePostTitle
				+ ", noticePostContent=" + noticePostContent + ", noticePostDate=" + noticePostDate
				+ ", noticePostUpdate=" + noticePostUpdate + ", attachmentNumber=" + attachmentNumber
				+ ", attachmentName=" + attachmentName + ", attachmentPath=" + attachmentPath + "]";
	}
}
