package com.bullPenTalk.app.dto;

public class SongPostDTO {
//	  POST_NUMBER,
//    POST_TITLE,
//    POST_DATE,
//    TEAM_NUMBER,
//    BOARD_TYPE_ID,
//    ADMIN_ID
	
	private int postNumber; // 게시글 번호
	private String postTitle; // 응원가 명
	private String postDate; // 등록일자
	private int teamNumber; // 대상 팀
	private int boardTypeId; // 어느 보드에 저장될 
	private int adminId; // 등록한 관리자 ID
	private String songUrl; // 응원가 URL
	private String postContent;
	
	// get, set
	
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public String getSongUrl() {
		return songUrl;
	}
	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
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
