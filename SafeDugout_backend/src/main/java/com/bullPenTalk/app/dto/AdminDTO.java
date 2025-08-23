package com.bullPenTalk.app.dto;

public class AdminDTO {
//	ADMIN_NUMBER NUMBER(3),
//	ADMIN_NAME VARCHAR2(30) NOT NULL,
//	ADMIN_ID VARCHAR2(15) NOT NULL,
//	ADMIN_PW VARCHAR2(15) NOT NULL,
//	ADMIN_EMAIL VARCHAR2(50) NOT NULL,
	
	private int adminNumber; // 관리자 번호
	private String adminName; // 관리자 이름
	private String adminId; // 관리자 ID
	private String adminPw; // 관리자 비밀번호
	private String adminEmail; // 관리자 이메일주소
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdmidPw(String admidPw) {
		this.adminPw = admidPw;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminNumber=" + adminNumber + ", adminName=" + adminName + ", adminId=" + adminId
				+ ", admidPw=" + adminPw + ", adminEmail=" + adminEmail + "]";
	}
	
	
}
