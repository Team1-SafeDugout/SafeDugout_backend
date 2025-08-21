package com.bullPenTalk.app.dto;

public class NewsPostDTO { // 뉴스글
//	POST_NUMBER,
//    POST_TITLE,
//    POST_CONTENT,
//    POST_DATE,
//    TEAM_NUMBER,
//    JOURNALIST,
//	  POST_LINK	
//    ATTACHMENT_NUMBER,
//    ATTACHMENT_NAME,
//    ATTACHMENT_PATH,
	
	private int postNumber; // 게시글 번호
	private String postTitle; // 게시글 제목
	private String postContent; // 게시글 내용
	private String postDate; // 작성일자
	private int teamNumber; // 팀 번호
	private String journalist; // 기자명
	private String postLink; // 기사원문 링크
	private int attachmentNumber; // 첨부파일 번호
	private String attachmentName; // 첨부파일 이름
	private String attachmentPath; // 첨부파일 경로
	
	// get, set
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getJournalist() {
		return journalist;
	}
	public String getPostLink() {
		return postLink;
	}
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}
	public void setJournalist(String journalist) {
		this.journalist = journalist;
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
		return "NewsPostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", teamNumber=" + teamNumber + ", journalist=" + journalist + ", postLink="
				+ postLink + ", attachmentNumber=" + attachmentNumber + ", attachmentName=" + attachmentName
				+ ", attachmentPath=" + attachmentPath + "]";
	}
	

	
	
}
