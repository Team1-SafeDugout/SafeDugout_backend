package com.bullPenTalk.app.dto;

public class PointChargeRecordDTO { // 충전 내역

//	CREATE TABLE TBL_POINT_CHARGE_RECORD(
//	RECORD_ID NUMBER,
//	CHARGE_POINT NUMBER NOT NULL, 
//	AFTER_CHARGE_POINT NUMBER NOT NULL, 
//	CHARGE_DATE DATE NOT NULL, 
//	MEMBER_NUMBER NUMBER(3),
//	CONSTRAINT PK_RECORD PRIMARY KEY(RECORD_ID),
//	CONSTRAINT FK_RECORD FOREIGN KEY(MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER)
//	);
	
	private int recordId; // 충전 id
	private int chargePoint; // 충전 포인트
	private int afterChargePoint; // 충전 뒤 포인트
	private String chargeDate; // 충전 일자
	private int memberNumber; // 회원 번호
	
	// get, set
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getChargePoint() {
		return chargePoint;
	}
	public void setChargePoint(int chargePoint) {
		this.chargePoint = chargePoint;
	}
	public int getAfterChargePoint() {
		return afterChargePoint;
	}
	public void setAfterChargePoint(int afterChargePoint) {
		this.afterChargePoint = afterChargePoint;
	}
	public String getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(String chargeDate) {
		this.chargeDate = chargeDate;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	// toString
	@Override
	public String toString() {
		return "PointChargeRecordDTO [recordId=" + recordId + ", chargePoint=" + chargePoint + ", afterChargePoint="
				+ afterChargePoint + ", chargeDate=" + chargeDate + ", memberNumber=" + memberNumber + "]";
	} 
	
}
