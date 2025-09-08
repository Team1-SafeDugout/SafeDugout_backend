package com.bullPenTalk.app.dto;

import java.util.Date;
import java.util.List;

public class GuidePostDTO {
	private int noticePostNumber; // 공지사항 게시글 번호
	private String noticePostTitle; // 공지사항 게시글 제목
	private String noticePostContent; // 공지사항 게시글 내용
	private Date noticePostDate; // 공지사항 게시 날짜
	private String noticePostUpdate; // 공지사항 게시글 수정
	
	private int adminNumber; // 관리자 이름
	
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

	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "GuidePostDTO [noticePostNumber=" + noticePostNumber + ", adminNumber=" + adminNumber
				+ ", noticePostTitle=" + noticePostTitle + ", noticePostContent=" + noticePostContent
				+ ", noticePostDate=" + noticePostDate + ", noticePostUpdate=" + noticePostUpdate + ", attachment="
				+ attachment + "]";
	}
	
	
}
