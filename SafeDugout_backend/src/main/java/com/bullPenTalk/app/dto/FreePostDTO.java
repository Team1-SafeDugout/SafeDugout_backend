package com.bullPenTalk.app.dto;

public class FreePostDTO {
	private int postNumber; //게시글 번호
	private String postTitle; //게시글 제목
	private String postDate; //게시글 작성 날짜
	private String postUpdate; //게시글 수정
	private int boardId; //게시판 ID
	private int memberNumber; //회원 번호
	private String memberId; //회원 ID
	private String postContent; //게시글 내용
	
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
	
	@Override
	public String toString() {
		return "FreePostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postDate=" + postDate
				+ ", postUpdate=" + postUpdate + ", boardId=" + boardId + ", memberNumber=" + memberNumber
				+ ", memberId=" + memberId + ", postContent=" + postContent + "]";
	}
	
}
