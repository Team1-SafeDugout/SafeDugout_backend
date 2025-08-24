package com.bullPenTalk.app.dto;

public class TeamNoticeDetailDTO {

//	<select id="detailSelect" resultType="TeamNoticePostDTO" parameterType="int">
//	<![CDATA[ 
//	SELECT NP.NOTICE_POST_NUMBER,
//		       NP.NOTICE_POST_TITLE,
//		       NP.NOTICE_POST_CONTENT,
//		       NP.NOTICE_POST_DATE,
//		       NVL(NP.NOTICE_POST_UPDATE, NP.NOTICE_POST_DATE) AS LAST_UPDATE,
//		       A.ADMIN_NAME,
//		       AT.ATTACHMENT_NUMBER,
//		       AT.ATTACHMENT_NAME,
//		       AT.ATTACHMENT_PATH
//		FROM TBL_NOTICE_POST NP
//		JOIN TBL_NOTICE_TYPE NT ON NP.NOTICE_TYPE_ID = NT.NOTICE_TYPE_ID
//		JOIN TBL_ADMIN A ON NP.ADMIN_NUMBER = A.ADMIN_NUMBER
//		LEFT JOIN TBL_NOTICE_ATTACHMENT NA ON NP.NOTICE_POST_NUMBER = NA.NOTICE_POST_NUMBER
//		LEFT JOIN TBL_ATTACHMENT AT ON NA.ATTACHMENT_NUMBER = AT.ATTACHMENT_NUMBER
//		WHERE NP.NOTICE_POST_NUMBER = #{noticePostNumber}
//		AND NT.NOTICE_TYPE = 'teamcommunitynotice'
//	]]>
//	</select>
	
	private int noticePostNumber;
	private String noticePostTitle;
	private String noticePostContent;
	private String noticePostDate;
	private String noticePostUpdate;
	private String adminName;
	private int attachmentNumber;
	private String attachmentName;
	private String attachmentPath;
	
	// get, set
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
	
	// toString
	@Override
	public String toString() {
		return "TeamNoticeDetailDTO [noticePostNumber=" + noticePostNumber + ", noticePostTitle=" + noticePostTitle
				+ ", noticePostContent=" + noticePostContent + ", noticePostDate=" + noticePostDate
				+ ", noticePostUpdate=" + noticePostUpdate + ", adminName=" + adminName + ", attachmentNumber="
				+ attachmentNumber + ", attachmentName=" + attachmentName + ", attachmentPath=" + attachmentPath + "]";
	}
	
	
	
	
}
