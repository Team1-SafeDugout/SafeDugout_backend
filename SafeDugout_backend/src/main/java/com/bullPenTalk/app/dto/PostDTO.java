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

	
	private int postNUmber; //게시글 번호
	private int memberNUmber; // 회원 번호(게시글 작성자)
	private int teamNumber; // 팀번호
	private int adminNUmber; // 관리자 번호
	private int boardId; // 게시판 종류 id
	private String postTitle; // 게시글 제목
	private String postContent; // 게시글 내용
	private String postDate; // 작성일자
	private String postUpdate; // 수정일자
	private String postLink; // 게시글 링크
	private String journalist; // 기자이름

	
	public String getJournalist() {
		return journalist;
	}
	public void setJournalist(String journalist) {
		this.journalist = journalist;
	}
	public int getPostNUmber() {
		return postNUmber;
	}
	public void setPostNUmber(int postNUmber) {
		this.postNUmber = postNUmber;
	}
	public int getMemberNUmber() {
		return memberNUmber;
	}
	public void setMemberNUmber(int memberNUmber) {
		this.memberNUmber = memberNUmber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public int getAdminNUmber() {
		return adminNUmber;
	}
	public void setAdminNUmber(int adminNUmber) {
		this.adminNUmber = adminNUmber;
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
	
	@Override
	public String toString() {
		return "PostDTO [postNUmber=" + postNUmber + ", memberNUmber=" + memberNUmber + ", teamNumber=" + teamNumber
				+ ", adminNUmber=" + adminNUmber + ", boardId=" + boardId + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + ", postDate=" + postDate + ", postUpdate=" + postUpdate
				+ ", postLink=" + postLink + ", journalist=" + journalist + "]";
	}
	
	

}
