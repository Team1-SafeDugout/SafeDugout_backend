package com.bullPenTalk.app.dto;

public class MemberAddressDTO {
//	CREATE TABLE TBL_MEMBER_ADDRESS(
//	MEMBER_NUMBER NUMBER,
//	POSTAL_CODE NUMBER,
//	CONSTRAINT PK_MEMBER_ADDRESS PRIMARY KEY(POSTAL_CODE, MEMBER_NUMBER),
//	CONSTRAINT FK_MEMBER_ADDRESS_CODE FOREIGN KEY(POSTAL_CODE) REFERENCES TBL_ADDRESS (POSTAL_CODE)ON DELETE CASCADE,
//	CONSTRAINT FK_ADDRESS_MEMBER_NUMBER FOREIGN KEY(MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER)ON DELETE CASCADE
//	);

	
	private int memberNumber;
	private int postalCode;
	
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public String toString() {
		return "MemberAddressDTO [memberNumber=" + memberNumber + ", postalCode=" + postalCode + "]";
	} 
	
	

}
