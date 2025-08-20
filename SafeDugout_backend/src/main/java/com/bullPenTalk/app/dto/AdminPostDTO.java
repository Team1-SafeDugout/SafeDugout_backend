package com.bullPenTalk.app.dto;

public class AdminPostDTO {
//	CREATE TABLE tbl_admin_post(
//	admin_number number,
//	post_number NUMBER,
//	CONSTRAINT PK_ADMIN_POST PRIMARY KEY(ADMIN_NUMBER, POST_NUMBER),
//	CONSTRAINT FK_POST_ADMIN_NUMBER FOREIGN KEY (ADMIN_NUMBER) REFERENCES TBL_ADMIN (ADMIN_NUMBER),
//	CONSTRAINT FK_ADMIN_POST_NUMBER FOREIGN KEY (POST_NUMBER) REFERENCES TBL_POST (POST_NUMBER) ON DELETE CASCADE
//	);

	
	private int adminNumber;
	private int postNumber;
	
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	
	@Override
	public String toString() {
		return "AdminPostDTO [adminNumber=" + adminNumber + ", postNumber=" + postNumber + "]";
	}
	

}
