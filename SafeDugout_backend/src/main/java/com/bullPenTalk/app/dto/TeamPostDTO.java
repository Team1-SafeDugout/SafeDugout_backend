package com.bullPenTalk.app.dto;

import java.util.List;

public class TeamPostDTO {
	
   
	private int postNumber; // 게시글 번호
	private String postTitle; // 게시글 제목
	private String postContent; // 게시글 내용
	private String postDate; // 작성날짜
	private String postUpdate; // 수정 날짜	
	private String memberId; //회원 ID	
	private int memberNumber; // 게시글 작성자 회원 번호
	private int teamNumber; // 팀 번호
	private int postType; // 포스트 타입	
	private List<AttachmentDTO> attachment; // 첨부파일
	
	//get, set
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public int getPostType() {
		return postType;
	}
	public void setPostType(int postType) {
		this.postType = postType;
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
		return "TeamPostDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", postUpdate=" + postUpdate + ", memberId=" + memberId + ", memberNumber="
				+ memberNumber + ", teamNumber=" + teamNumber + ", postType=" + postType + ", attachment=" + attachment
				+ "]";
	}
	
	

}
