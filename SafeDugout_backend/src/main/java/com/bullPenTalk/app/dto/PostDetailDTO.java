package com.bullPenTalk.app.dto;

import java.util.Date;
import java.util.List;

public class PostDetailDTO {

	
	private int postNumber;
	private String postTitle;
	private String postContent;
	private Date postDate;
	private Date update;
	private int memberNumber;
	private String memberId;
	private int commentNumber;
	private String commentContent;
	private String commentMemberNumber;
	private int teamNumber;
	private List<AttachmentDTO> attachment;
	
	// get,set
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPostNumber() {
		return postNumber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
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
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
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
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public String getCommentMemberNumber() {
		return commentMemberNumber;
	}
	public void setCommentMemberNumber(String commentMemberNumber) {
		this.commentMemberNumber = commentMemberNumber;
	}
	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}

	// toString
	@Override
	public String toString() {
		return "PostDetailDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", update=" + update + ", memberNumber=" + memberNumber + ", memberId="
				+ memberId + ", commentNumber=" + commentNumber + ", commentContent=" + commentContent
				+ ", commentMemberNumber=" + commentMemberNumber + ", teamNumber=" + teamNumber + ", attachment="
				+ attachment + "]";
	}
	
	
}
