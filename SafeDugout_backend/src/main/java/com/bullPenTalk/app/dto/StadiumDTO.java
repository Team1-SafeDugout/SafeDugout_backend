package com.bullPenTalk.app.dto;

public class StadiumDTO {
//	CREATE TABLE TBL_STADIUM (
//	STADIUM_NUMBER   NUMBER PRIMARY KEY,
//	STADIUM_ADDRESS  VARCHAR2(100) NOT NULL,
//	STADIUM_NAME     VARCHAR2(50) NOT NULL,
//	TEAM_NUMBER      NUMBER NOT NULL,
//	CONSTRAINT FK_STADIUM_TEAM FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	private int stadiumNumber; // 경기장 번호
	private String stadiumAddress; // 경기장 주소
	private String stadiumName; // 경기장 이름
	private int stadiumteamNumber; // 경기장 홈 팀
	
	//get, set
	public int getStadiumNumber() {
		return stadiumNumber;
	}
	public void setStadiumNumber(int stadiumNUmber) {
		this.stadiumNumber = stadiumNUmber;
	}
	public String getStadiumAddress() {
		return stadiumAddress;
	}
	public void setStadiumAddress(String stadiumAddress) {
		this.stadiumAddress = stadiumAddress;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public int getStadiumteamNumber() {
		return stadiumteamNumber;
	}
	public void setStadiumteamNumber(int stadiumteamNumber) {
		this.stadiumteamNumber = stadiumteamNumber;
	}
	
	// toString
	@Override
	public String toString() {
		return "StadiumDTO [stadiumNumber=" + stadiumNumber + ", stadiumAddress=" + stadiumAddress + ", stadiumName="
				+ stadiumName + ", stadiumteamNumber=" + stadiumteamNumber + "]";
	}
}
