package com.bullPenTalk.app.dto;

public class MemberDTO {
//	CREATE TABLE TBL_MEMBER(
//			MEMBER_NUMBER NUMBER,
//			MEMBER_NAME VARCHAR2(30) NOT NULL,
//			MEMBER_PHONE VARCHAR2(14) NOT NULL,
//			MEMBER_ID VARCHAR2(15) NOT NULL,
//			MEMBER_PW VARCHAR2(15) NOT NULL,
//			MEMBER_EMAIL VARCHAR2(50) NOT NULL,
//			MEMBER_MY_TEAM NUMBER,
//			MEMBER_POINT NUMBER,
//			MEMBER_JOIN_DATE DATE NOT NULL,
//			MEMBER_postal_code NUMBER,
//			CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NUMBER),
//			CONSTRAINT UK_MEMBER UNIQUE(MEMBER_ID)
//			);
	
	private int memberNumber;
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getMemberMyTeam() {
		return memberMyTeam;
	}
	public void setMemberMyTeam(int memberMyTeam) {
		this.memberMyTeam = memberMyTeam;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberJoinDate() {
		return memberJoinDate;
	}
	public void setMemberJoinDate(String memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	public int getMemberPostalCode() {
		return memberPostalCode;
	}
	public void setMemberPostalCode(int memberPostalCode) {
		this.memberPostalCode = memberPostalCode;
	}
	
	
	
	private String memberName;
	private String memberPhone;
	private String memberId;
	private String memberPw;
	private String memberEmail;
	private int memberMyTeam;
	private int memberPoint;
	private String memberJoinDate;
	private int memberPostalCode;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
