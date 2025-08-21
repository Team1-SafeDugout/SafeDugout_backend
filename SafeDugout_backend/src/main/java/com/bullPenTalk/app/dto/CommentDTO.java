package com.bullPenTalk.app.dto;

public class CommentDTO {
//	CREATE TABLE TBL_COMMENT(
//	COMMENT_NUMBER NUMBER,
//	MEMBER_NUMBER NUMBER NOT NULL,
//	POST_NUMBER NUMBER NOT NULL,
//	COMMENT_CONTENT VARCHAR2(2000) NOT NULL,
//	COMMENT_DATE DATE NOT NULL DEFAULT SYSDATE ,
//	COMMENT_UPDATE DATE NOT NULL,
//	CONSTRAINT PK_COMMENT PRIMARY KEY(COMMENT_NUMBER),
//	CONSTRAINT FK_COMMENT_MEMBER FOREIGN KEY(MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_COMMENT_POST FOREIGN KEY(POST_NUMBER) REFERENCES TBL_POST(POST_NUMBER) ON DELETE CASCADE
//	);

	
	private int commentNumber; // 댓글 번호
	private int memberNumber; // 회원 번호
	private int postNumber; // 게시글 번호 
	private String commentContent; // 댓글 내용 
	private String commentDate; // 작성 일자
	private String commentUpdate; // 수정 일자
	
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
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
	
	@Override
	public String toString() {
		return "CommentDTO [commentNumber=" + commentNumber + ", memberNumber=" + memberNumber + ", postNumber="
				+ postNumber + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", commentUpdate=" + commentUpdate + "]";
	}
	

}
