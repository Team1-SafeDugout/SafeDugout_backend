package com.bullPenTalk.app.dto;

import java.util.Date;
import java.util.List;

public class TeamNoticeDetailDTO {
	
	
//     NP.NOTICE_POST_NUMBER,
//     NP.NOTICE_TYPE_ID,
//     NP.ADMIN_NUMBER,
//     NP.TEAM_NUMBER,
//     NP.NOTICE_POST_TITLE,
//     NP.NOTICE_POST_DATE,
//     NP.NOTICE_POST_UPDATE,
//     NP.NOTICE_POST_CONTENT,
//     AT.ATTACHMENT_NUMBER,
//     AT.ATTACHMENT_PATH,
//     AT.ATTACHMENT_NAME
// FROM TBL_NOTICE_POST NP
// LEFT JOIN TBL_ATTACHMENT AT
//     ON NP.NOTICE_POST_NUMBER = AT.NOTICE_POST_NUMBER
// WHERE NP.NOTICE_POST_NUMBER = #{noticePostNumber}
	
	private int noticePostNumber;
	private int noticeTypeId;
	private int adminNumber;
	private int teamNumber;
	private String noticePostTitle;
	private Date noticePostDate;
	private Date noticePostUpdate;
	private String noticePostContent;
	private List<AttachmentDTO> attachment;
	
	// get, set
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
	public Date getNoticePostDate() {
		return noticePostDate;
	}
	public void setNoticePostDate(Date noticePostDate) {
		this.noticePostDate = noticePostDate;
	}
	public Date getNoticePostUpdate() {
		return noticePostUpdate;
	}
	public void setNoticePostUpdate(Date noticePostUpdate) {
		this.noticePostUpdate = noticePostUpdate;
	}
	public String getNoticePostContent() {
		return noticePostContent;
	}
	public void setNoticePostContent(String noticePostContent) {
		this.noticePostContent = noticePostContent;
	}
	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}
	
	// toString
	@Override
	public String toString() {
		return "TeamNoticeDetailDTO [noticePostNumber=" + noticePostNumber + ", noticeTypeId=" + noticeTypeId
				+ ", adminNumber=" + adminNumber + ", teamNumber=" + teamNumber + ", noticePostTitle=" + noticePostTitle
				+ ", noticePostDate=" + noticePostDate + ", noticePostUpdate=" + noticePostUpdate
				+ ", noticePostContent=" + noticePostContent + ", attachment=" + attachment + "]";
	}
		
}
