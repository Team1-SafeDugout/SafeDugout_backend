package com.bullPenTalk.app.dto;

public class SongPostDTO {
//	  POST_NUMBER,
//    POST_TITLE,
//    POST_DATE,
//    TEAM_NUMBER,
//    BOARD_TYPE_ID,
//    ADMIN_ID
	
	private int postNumber;
	private String postTitle;
	private String postDate;
	private int teamNumber;
	private int boardTypeId;
	private int adminId;
	
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
	public int getBoardTypeId() {
		return boardTypeId;
	}
	public void setBoardTypeId(int boardTypeId) {
		this.boardTypeId = boardTypeId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	// toString
	@Override
	public String toString() {
		return "SongPostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postDate=" + postDate
				+ ", teamNumber=" + teamNumber + ", boardTypeId=" + boardTypeId + ", adminId=" + adminId + "]";
	}
	
	
	
}
