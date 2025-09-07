package com.bullPenTalk.app.dto;

import java.util.List;

public class NewsDetailDTO {
	
	private int postNumber;
	private String postTitle;
	private String postContent;
	private String postDate;
	private String journalist;
	private String postLink;
	private int boardId;
	private int adminNumber;
	private int teamNumber;
	private List<AttachmentDTO> attachment;
	
	
	
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
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}
	
	// toString
	@Override
	public String toString() {
		return "NewsDetailDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", journalist=" + journalist + ", postLink=" + postLink + ", boardId="
				+ boardId + ", adminNumber=" + adminNumber + ", teamNumber=" + teamNumber + ", attachment=" + attachment
				+ "]";
	}
	
	
}         
