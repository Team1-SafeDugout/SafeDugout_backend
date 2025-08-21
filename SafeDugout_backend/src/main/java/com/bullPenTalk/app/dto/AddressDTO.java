package com.bullPenTalk.app.dto;

public class AddressDTO {
//	CREATE TABLE TBL_ADDRESS(
//	POSTAL_CODE NUMBER,
//	DETAILED_ADDRESS VARCHAR2(100),
//	CONSTRAINT PK_ADDRESS PRIMARY KEY(POSTAL_CODE)
//	);

	
	private int postalCode; // 우편번호 
	private String detailedAddress; // 상세주소
	
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	
	@Override
	public String toString() {
		return "AddressDTO [postalCode=" + postalCode + ", detailedAddress=" + detailedAddress + "]";
	} 
	

}
