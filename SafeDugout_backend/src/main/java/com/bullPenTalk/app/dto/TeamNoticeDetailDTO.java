package com.bullPenTalk.app.dto;

import java.util.List;

public class TeamNoticeDetailDTO {
	
	private int noticePostNumber;
	private int adminNumber; // 관리자 이름
	
	private String noticePostTitle;
	private String noticePostContent;
	private String noticePostDate;
	private String noticePostUpdate;

	private List<AttachmentDTO> attachment;

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

	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "TeamNoticeDetailDTO [noticePostNumber=" + noticePostNumber + ", adminNumber=" + adminNumber
				+ ", noticePostTitle=" + noticePostTitle + ", noticePostContent=" + noticePostContent
				+ ", noticePostDate=" + noticePostDate + ", noticePostUpdate=" + noticePostUpdate + ", attachment="
				+ attachment + "]";
	}	
}
