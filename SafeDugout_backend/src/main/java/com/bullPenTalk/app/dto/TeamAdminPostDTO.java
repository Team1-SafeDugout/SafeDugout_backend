package com.bullPenTalk.app.dto;

public class TeamAdminPostDTO {

	private int postNumber; // 게시글 번호
	private String postTitle; // 게시글 제목
	private String postDate; // 작성 날짜
	private String postUpdate; // 수정 날짜
	private int boardId; // 어떤 게시판에 적힌 글인지
	private int memberNumber; // 해당글을 작성자 회원 번호
	private String memberId; // 해당글을 작성한 회원 아이디
	private String postContent; // 작성된 글
	private int teamNumber; // 팀 게시판이므로 어떤 팀 글 인지 팀 번호로 확인
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
