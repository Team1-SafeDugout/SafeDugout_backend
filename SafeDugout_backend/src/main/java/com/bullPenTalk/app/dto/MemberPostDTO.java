package com.bullPenTalk.app.dto;

public class MemberPostDTO {
//	CREATE TABLE TBL_MEMBER_POST(
//	MEMBER_NUMBER NUMBER,
//	POST_NUMBER NUMBER,
//	CONSTRAINT PK_MEMBER_POST PRIMARY KEY(MEMBER_NUMBER, POST_NUMBER),
//	CONSTRAINT FK_MEMBER_POST_NUMBER FOREIGN KEY(POST_NUMBER) REFERENCES TBL_POST (POST_NUMBER)ON DELETE CASCADE,
//	CONSTRAINT FK_POST_MEMBER_NUMBER FOREIGN KEY(MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER)ON DELETE CASCADE
//	);

	
	private int memberNumber;
	private int postNumber;
	
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
	
	@Override
	public String toString() {
		return "MemberPostDTO [memberNumber=" + memberNumber + ", postNumber=" + postNumber + "]";
	}
	

}
