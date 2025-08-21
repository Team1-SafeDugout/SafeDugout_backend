package com.bullPenTalk.app.dto;

public class MyPageCommentDTO {
	
	private int sellPostNumber;
	private int tradeNumber;
	private String postTitle;
	private String memberId;
	private String commentContent;
	private String commentDate;
	private String commentUpdate;
	private int commentNumber;
	
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
