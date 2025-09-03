package com.bullPenTalk.app.dto;

public class FreePostDTO {
	
	private int postNumber; //게시글 번호
	
	private int memberNumber; //회원 번호
	private String memberId; //회원 ID
	
	private String postTitle; //게시글 제목
	private String postDate; //게시글 작성 날짜
	private String postUpdate; //게시글 수정
	private String postContent; //게시글 내용
	
	private int boardId = 2; // 보드아이디
	String attachmentPath;
	
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
		return "FreePostDTO [postNumber=" + postNumber + ", memberNumber=" + memberNumber + ", memberId=" + memberId
				+ ", postTitle=" + postTitle + ", postDate=" + postDate + ", postUpdate=" + postUpdate
				+ ", postContent=" + postContent + ", boardId=" + boardId + ", attachmentPath=" + attachmentPath + "]";
	}
	
	
}
