/**
 * 
 */
package com.bullPenTalk.app.dto;

/**
 * 
 */
public class TeamPostDTO {
	
//    SELECT P.POST_NUMBER,
//    P.POST_TITLE,
//    P.POST_CONTENT,
//    P.POST_DATE,
//    M.MEMBER_ID,
//    M.MEMBER_NUMBER,
//    P.BOARD_ID
    
	private int postNumber; // 게시글 번호

	
	private String postTitle; // 게시글 제목
	private String postContent; // 게시글 내용
	private String postDate; // 작성날짜
	private String postUpdate; // 수정 날짜
	
	private String memberId; //회원 ID	
	private int memberNumber; // 게시글 작성자 회원 번호

	private int boardId = 2; // 게시판 종류
	private int teamNumber; // 팀 번호
	
	String attachmentPath; // 
	
	
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
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
	public String getPostUpdate() {
		return postUpdate;
	}
	public void setPostUpdate(String postUpdate) {
		this.postUpdate = postUpdate;
	}
	@Override
	public String toString() {
		return "TeamPostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", postUpdate=" + postUpdate + ", memberId=" + memberId + ", memberNumber="
				+ memberNumber + ", boardId=" + boardId + ", teamNumber=" + teamNumber + ", attachmentPath="
				+ attachmentPath + "]";
	}	
}
