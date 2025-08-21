package com.bullPenTalk.app.dto;

public class MyPageCommentDTO {
	
	private int sellPostNumber; //판매 게시글 번호
	private int tradeNumber; //거래 번호
	private String postTitle; //게시글 제목
	private String memberId; //회원 ID
	private String commentContent; //댓글내용
	private String commentDate; //댓글 작성 날짜
	private String commentUpdate; //댓글 수정
	private int commentNumber; //댓글 번호
	
	public int getCommentNumber() {
		return commentNumber;
	}
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		return "MyPageCommentDTO [tradeNumber=" + tradeNumber + ", postTitle=" + postTitle + ", memberId=" + memberId
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", commentUpdate="
				+ commentUpdate + ", commentNumber=" + commentNumber + "]";
	}

	
	
}
