package com.bullPenTalk.app.dto;

public class YoutubePostDTO {
	
//   POST_NUMBER,
//   POST_TITLE,
//   POST_DATE,
//   POST_CONTENT,
//   POST_LINK,
//   TEAM_NUMBER,
//   ADMIN_NUMBER
//	 BOARD_ID
	
	// 유튜브 게시글에 필요한 정보
	private int postNumber;
	private String postTitle;
	private String postDate;
	private String postContent;
	private String postLink;	
	private int teamNumber;
	private int adminNumber;
	private int boardId;
	
	// get, set
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostLink() {
		return postLink;
	}
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostlink() {
		return postlink;
	}
	public void setPostlink(String postlink) {
		this.postlink = postlink;
	}
	private String postlink;

	// toString
	@Override
	public String toString() {
		return "YoutubePostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postDate=" + postDate
				+ ", postContent=" + postContent + ", postLink=" + postLink + ", teamNumber=" + teamNumber
				+ ", adminNumber=" + adminNumber + ", boardId=" + boardId + ", postlink=" + postlink + "]";
	}

	
	
	
}


