package com.bullPenTalk.app.dto;

public class TeamAdminPostDTO {

	private int postNumber;
	private String postTitle;
	private String postDate;
	private String postUpdate;
	private int boardId;
	private int memberNumber;
	private String memberId;
	private String postContent;
	private int teamNumber;
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
	public String getPostUpdate() {
		return postUpdate;
	}
	public void setPostUpdate(String postUpdate) {
		this.postUpdate = postUpdate;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	
	@Override
	public String toString() {
		return "TeamAdminPost [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postDate=" + postDate
				+ ", postUpdate=" + postUpdate + ", boardId=" + boardId + ", memberNumber=" + memberNumber
				+ ", memberId=" + memberId + ", postContent=" + postContent + ", teamNumber=" + teamNumber + "]";
	}
	
	
}
