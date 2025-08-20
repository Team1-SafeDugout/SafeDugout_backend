package com.bullPenTalk.app.dto;

public class StadiumDTO {
//	CREATE TABLE TBL_STADIUM (
//	STADIUM_NUMBER   NUMBER PRIMARY KEY,
//	STADIUM_ADDRESS  VARCHAR2(100) NOT NULL,
//	STADIUM_NAME     VARCHAR2(50) NOT NULL,
//	TEAM_NUMBER      NUMBER NOT NULL,
//	CONSTRAINT FK_STADIUM_TEAM FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	private int stadiumNUmber;
	private String stadiumAddress;
	private String stadiumName;
	private int stadiumteamNumber;
	public int getStadiumNUmber() {
		return stadiumNUmber;
	}
	public void setStadiumNUmber(int stadiumNUmber) {
		this.stadiumNUmber = stadiumNUmber;
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
	
	@Override
	public String toString() {
		return "StadiumDTO [stadiumNUmber=" + stadiumNUmber + ", stadiumAddress=" + stadiumAddress + ", stadiumName="
				+ stadiumName + ", stadiumteamNumber=" + stadiumteamNumber + "]";
	}
}
