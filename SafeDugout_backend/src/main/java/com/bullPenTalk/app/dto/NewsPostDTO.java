package com.bullPenTalk.app.dto;

import java.util.List;

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
	private int adminNumber; // 어드민 번호
	private int postType; // 보드 번호
	private List<AttachmentDTO> attachment; 
	private String imgPath;
	private String teamName;
	

	// get, set
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
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
	public void setJournalist(String journalist) {
		this.journalist = journalist;
	}
	public String getPostLink() {
		return postLink;
	}
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}
	
	public int getPostType() {
		return postType;
	}
	public void setPostType(int postType) {
		this.postType = postType;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	//toString
	@Override
	public String toString() {
		return "NewsPostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", teamNumber=" + teamNumber + ", journalist=" + journalist + ", postLink="
				+ postLink + ", adminNumber=" + adminNumber + ", postType=" + postType + ", attachment=" + attachment
				+ ", imgPath=" + imgPath + ", teamName=" + teamName + "]";
	}
	
}
