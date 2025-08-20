package com.bullPenTalk.app.dto;

public class AdminDTO {
//	ADMIN_NUMBER NUMBER(3),
//	ADMIN_NAME VARCHAR2(30) NOT NULL,
//	ADMIN_ID VARCHAR2(15) NOT NULL,
//	ADMIN_PW VARCHAR2(15) NOT NULL,
//	ADMIN_EMAIL VARCHAR2(50) NOT NULL,
	
	private int adminNumber;
	private String adminName;
	private String adminId;
	private String admidPw;
	private String adminEmail;
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
	public String getAdmidPw() {
		return admidPw;
	}
	public void setAdmidPw(String admidPw) {
		this.admidPw = admidPw;
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
				+ ", admidPw=" + admidPw + ", adminEmail=" + adminEmail + "]";
	}
	
	
}
