package com.bullPenTalk.app.dto;

public class CommentDTO {
//	C.COMMENT_NUMBER,
//	C.COMMENT_CONTENT,
//	C.COMMENT_DATE,
//	C.COMMENT_UPDATE,
//	M.MEMBER_ID

	
	private int commentNumber; // 댓글 번호 
	private String commentContent; // 댓글 내용 
	private String commentDate; // 작성 일자
	private String commentUpdate; // 수정 일자
	private String memberID; // 작성자 ID
	private int postNumber; // 작성한 글 번호
	private int memberNumber; // 작성자 번호
	private String postTitle;	// 댓글 작성한 글 제목
	private String postAuthor;  // 댓글 작성한 글 작가
	
	
	
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostAuthor() {
		return postAuthor;
	}
	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentUpdate() {
		return commentUpdate;
	}
	public void setCommentUpdate(String commentUpdate) {
		this.commentUpdate = commentUpdate;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentNumber=" + commentNumber + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", commentUpdate=" + commentUpdate + ", memberID=" + memberID + ", postNumber="
				+ postNumber + ", memberNumber=" + memberNumber + ", postTitle=" + postTitle + ", postAuthor="
				+ postAuthor + "]";
	}
	
	 

	
}
