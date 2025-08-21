package com.bullPenTalk.app.dto;

public class TeamDTO {
//	CREATE TABLE TBL_TEAM(
//	TEAM_NUMBER NUMBER,
//	TEAM_NAME VARCHAR2(50) NOT NULL,
//	CONSTRAINT PK_TEAM PRIMARY KEY(TEAM_NUMBER)
//	);

	
	private int teamNumber; // 팀번호
	private String teamName; // // 팀이름
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "TeamDTO [teamNumber=" + teamNumber + ", teamName=" + teamName + "]";
	}

}
