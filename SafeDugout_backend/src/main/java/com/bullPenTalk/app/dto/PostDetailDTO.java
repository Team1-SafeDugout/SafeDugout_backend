package com.bullPenTalk.app.dto;

import java.util.List;

public class PostDetailDTO {

//	<!-- 팀 게시글 상세 조회 -->
//	<select id="detailSelect" parameterType="TeamPostDTO">
//		<![CDATA[
//		SELECT P.POST_NUMBER,
//	    P.POST_TITLE,
//	    P.POST_CONTENT,
//	    P.POST_DATE,
//	    M.MEMBER_ID AS POST_WRITER,
//	    C.COMMENT_NUMBER,
//	    C.COMMENT_CONTENT,
//	    NVL(C.COMMENT_UPDATE, C.COMMENT_DATE) AS COMMENT_LAST_UPDATE,
//	    CM.MEMBER_ID AS COMMENT_WRITER,
//	    A.ATTACHMENT_NUMBER,
//	    A.ATTACHMENT_NAME,
//	    A.ATTACHMENT_PATH
//	  	FROM TBL_POST P
//		JOIN TBL_MEMBER M ON P.MEMBER_NUMBER = M.MEMBER_NUMBER                
//		LEFT JOIN TBL_COMMENT C ON P.POST_NUMBER = C.POST_NUMBER              
//		LEFT JOIN TBL_MEMBER CM ON C.MEMBER_NUMBER = CM.MEMBER_NUMBER         
//		LEFT JOIN TBL_POST_ATTACHMENT PA ON P.POST_NUMBER = PA.POST_NUMBER    
//		LEFT JOIN TBL_ATTACHMENT A ON PA.ATTACHMENT_NUMBER = A.ATTACHMENT_NUMBER
//		WHERE P.POST_NUMBER = #{postNumber}                                  
//	  	AND P.TEAM_NUMBER = #{teamNumber}                                 
//		ORDER BY C.COMMENT_DATE ASC, A.ATTACHMENT_NUMBER ASC
//		]]>
//	</select>
	
	private int postNumber;
	private String postTitle;
	private String postContent;
	private String postDate;
	private int memberNumber;
	private int commentNumber;
	private String commentContent;
	private String update;
	private String commentMemberNumber;
	private List<AttachmentDTO> attachment;
	
	// get,set
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
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
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
				+ ", postDate=" + postDate + ", memberNumber=" + memberNumber + ", commentNumber=" + commentNumber
				+ ", commentContent=" + commentContent + ", update=" + update + ", commentMemberNumber="
				+ commentMemberNumber + ", attachment=" + attachment + "]";
	}
	
}
