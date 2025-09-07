package com.bullPenTalk.app.dto;

public class PostDTO { // 게시글 번호
//	CREATE TABLE TBL_POST(
//	POST_NUMBER NUMBER,
//	MEMBER_NUMBER NUMBER,
//	TEAM_NUMBER NUMBER,
//	ADMIN_NUMBER NUMBER,
//	BOARD_ID NUMBER,
//	POST_TITLE VARCHAR2(100) NOT NULL,
//	POST_CONTENT CLOB NOT NULL,
//	POST_DATE DATE NOT NULL DEFAULT SYSDATE,
//	POST_UPDATE DATE,
//	POST_LINK VARCHAR2(200),
//	CONSTRAINT PK_POST PRIMARY KEY(POST_NUMBER),
//	CONSTRAINT FK_POST_MEMBER FOREIGN KEY(MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_POST_TEAM FOREIGN KEY(TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER),
//	CONSTRAINT FK_POST_ADMIN FOREIGN KEY(ADMIN_NUMBER) REFERENCES TBL_ADMIN(ADMIN_NUMBER),
//	CONSTRAINT fk_post_board FOREIGN key(board_id) REFERENCES TBL_BOARD (BOARD_NUMBER)
//	);

	
	private int postNumber; //게시글 번호
	private int memberNumber; // 회원 번호(게시글 작성자)
	private int teamNumber; // 팀번호
	private int adminNumber; // 관리자 번호
	private int boardId; // 게시판 종류 id
	private String postTitle; // 게시글 제목
	private String postContent; // 게시글 내용
	private String postDate; // 작성일자
	private String postUpdate; // 수정일자
	private String postLink; // 게시글 링크
	private String journalist; // 기자이름
	private int postType;
	
	public int getPostType() {
		return postType;
	}
	public void setPostType(int postType) {
		this.postType = postType;
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
	public String getPostLink() {
		return postLink;
	}
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}
	public String getJournalist() {
		return journalist;
	}
	public void setJournalist(String journalist) {
		this.journalist = journalist;
	}
	@Override
	public String toString() {
		return "PostDTO [postNumber=" + postNumber + ", memberNumber=" + memberNumber + ", teamNumber=" + teamNumber
				+ ", adminNumber=" + adminNumber + ", boardId=" + boardId + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + ", postDate=" + postDate + ", postUpdate=" + postUpdate
				+ ", postLink=" + postLink + ", journalist=" + journalist + ", postType=" + postType + "]";
	}
	
	

}
