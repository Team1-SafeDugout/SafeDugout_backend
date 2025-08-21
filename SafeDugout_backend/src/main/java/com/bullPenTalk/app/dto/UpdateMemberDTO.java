package com.bullPenTalk.app.dto;

public class UpdateMemberDTO {
	
	private int memberNumber;
	private String memberPhone;
	private String memberEmail; 
	private int memberPostalCode;
	private String detailAddress;
	private int myTeam;
	
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getMemberPostalCode() {
		return memberPostalCode;
	}
	public void setMemberPostalCode(int memberPostalCode) {
		this.memberPostalCode = memberPostalCode;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public int getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(int myTeam) {
		this.myTeam = myTeam;
	}
	
	@Override
	public String toString() {
		return "UpdateMemberDTO [memberNumber=" + memberNumber + ", memberPhone=" + memberPhone + ", memberEmail="
				+ memberEmail + ", memberPostalCode=" + memberPostalCode + ", detailAddress=" + detailAddress
				+ ", myTeam=" + myTeam + "]";
	}
	
	
}
