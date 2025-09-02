package com.bullPenTalk.app.dto;

public class MainNoticePostDTO {
	private int noticePostNumber; //공지사항 게시글 번호
	private int noticeTypeId = 1; //공지사항 종류 번호	
	private int adminNumber; //관리자 번호
	private String noticePostTitle; //공지사항 게시글 제목
	private String noticePostContent; //공지사항 게시글 내용
	private String noticePostDate; // 공지사항 게시 날짜
	private String noticePostUpdate; //공지사항 게시글 수정
	private int attachmentNumber;
    private String attachmentName;
    private String attachmentPath;
	
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
	public String getNoticePostUpdate() {
		return noticePostUpdate;
	}
	public void setNoticePostUpdate(String noticePostUpdate) {
		this.noticePostUpdate = noticePostUpdate;
	}
	
	@Override
	public String toString() {
		return "MainNoticePostDTO [noticePostNumber=" + noticePostNumber + ", noticeTypeId=" + noticeTypeId
				+ ", adminNumber=" + adminNumber + ", noticePostTitle=" + noticePostTitle + ", noticePostContent="
				+ noticePostContent + ", noticePostDate=" + noticePostDate + ", noticePostUpdate=" + noticePostUpdate
				+ ", attachmentNumber=" + attachmentNumber + ", attachmentName=" + attachmentName + ", attachmentPath="
				+ attachmentPath + "]";
	}
}
