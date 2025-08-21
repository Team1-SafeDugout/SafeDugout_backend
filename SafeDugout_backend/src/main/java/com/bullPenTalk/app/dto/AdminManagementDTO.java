package com.bullPenTalk.app.dto;

public class AdminManagementDTO {
//	CREATE TABLE TBL_ADMIN_MANAGEMENT (
//	ADMIN_NUMBER    NUMBER,
//	MEMBER_NUMBER   NUMBER,
//	CONSTRAINT PK_ADMIN_MANAGEMENT PRIMARY KEY (ADMIN_NUMBER, MEMBER_NUMBER),
//	CONSTRAINT FK_ADMIN_MANAGEMENT_ADMIN FOREIGN KEY (ADMIN_NUMBER) REFERENCES TBL_ADMIN(ADMIN_NUMBER),
//	CONSTRAINT FK_ADMIN_MANAGEMENT_MEMBER FOREIGN KEY (MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER)
//	);

	
	private int adminNumber; // 관리자 번호
	private int memberNumber; // 회원 번호
	
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	@Override
	public String toString() {
		return "AdminManagementDTO [adminNumber=" + adminNumber + ", memberNumber=" + memberNumber + "]";
	} 
	
	
	

}
