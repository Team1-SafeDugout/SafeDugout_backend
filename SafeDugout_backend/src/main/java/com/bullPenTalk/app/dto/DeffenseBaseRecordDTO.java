package com.bullPenTalk.app.dto;

public class DeffenseBaseRecordDTO {
//	CREATE TABLE TBL_DEFENSE_BASE_RECORD (
//	TEAM_NUMBER            NUMBER,
//	SEASON_YEAR            NUMBER,
//	GAME_COUNT             NUMBER,
//	ERROR                  NUMBER,
//	GIDOUT                 NUMBER,
//	SB_ALLOW               NUMBER,
//	SB_BLOCK               NUMBER,
//	SB_SUCCESS             NUMBER,
//	PICK_OFF               NUMBER,
//	PICK_OFF_SUCCESS       NUMBER,
//	CONSTRAINT PK_DEFENSE_BASE_RECORD PRIMARY KEY (TEAM_NUMBER, SEASON_YEAR),
//	CONSTRAINT FK_DEFENSE_BASE_RECORD FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	
	private int teamNumber;
	private int seasonYear;
	private int gameCount; 
	private int error; 
	private int gidout;
	private int SBAllow;
	private int SBBlock;
	private int SBSuccess;
	private int pickOff;
	private int pickOffSuccess;
	
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public int getSeasonYear() {
		return seasonYear;
	}
	public void setSeasonYear(int seasonYear) {
		this.seasonYear = seasonYear;
	}
	public int getGameCount() {
		return gameCount;
	}
	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public int getGidout() {
		return gidout;
	}
	public void setGidout(int gidout) {
		this.gidout = gidout;
	}
	public int getSBAllow() {
		return SBAllow;
	}
	public void setSBAllow(int sBAllow) {
		SBAllow = sBAllow;
	}
	public int getSBBlock() {
		return SBBlock;
	}
	public void setSBBlock(int sBBlock) {
		SBBlock = sBBlock;
	}
	public int getSBSuccess() {
		return SBSuccess;
	}
	public void setSBSuccess(int sBSuccess) {
		SBSuccess = sBSuccess;
	}
	public int getPickOff() {
		return pickOff;
	}
	public void setPickOff(int pickOff) {
		this.pickOff = pickOff;
	}
	public int getPickOffSuccess() {
		return pickOffSuccess;
	}
	public void setPickOffSuccess(int pickOffSuccess) {
		this.pickOffSuccess = pickOffSuccess;
	}
	@Override
	public String toString() {
		return "DeffenseBaseRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", gameCount="
				+ gameCount + ", error=" + error + ", gidout=" + gidout + ", SBAllow=" + SBAllow + ", SBBlock="
				+ SBBlock + ", SBSuccess=" + SBSuccess + ", pickOff=" + pickOff + ", pickOffSuccess=" + pickOffSuccess
				+ "]";
	}
	

}
