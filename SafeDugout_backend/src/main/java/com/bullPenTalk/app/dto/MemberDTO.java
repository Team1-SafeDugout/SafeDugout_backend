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
	private int memberNumber; //회원 번호
	private String memberName; //회원 이름
	private String memberPhone; //회원 전화번호
	private String memberId; //회원 ID
	private String memberPw; //회원 비밀번호
	private String memberEmail; //회원 이메일
	private int memberMyTeam; // 회원 마이팀
	private int memberPoint; //회원 포인트
	private String memberJoinDate; // 회원 가입 날짜
	private int memberPostalCode; // 회원 우편번호
	
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
	
	
	
	
	@Override
	public String toString() {
		return "MemberDTO [memberNumber=" + memberNumber + ", memberName=" + memberName + ", memberPhone=" + memberPhone
				+ ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberEmail=" + memberEmail
				+ ", memberMyTeam=" + memberMyTeam + ", memberPoint=" + memberPoint + ", memberJoinDate="
				+ memberJoinDate + ", memberPostalCode=" + memberPostalCode + "]";
	}
}
