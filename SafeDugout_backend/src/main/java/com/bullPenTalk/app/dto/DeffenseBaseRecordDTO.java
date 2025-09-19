package com.bullPenTalk.app.dto;

public class DeffenseBaseRecordDTO {
	// TEAM_NUMBER            NUMBER,
	// SEASON_YEAR            NUMBER,
	// GAME_COUNT             NUMBER,
	// ERROR                  NUMBER, -- 에러
	// DP 		               NUMBER, -- 병살
	// SB                     NUMBER, -- 도루허용
	// CB	                   NUMBER, -- 도루 저지
	// SB_SUCCESS             NUMBER, -- 도루 성공
	// PICK_OFF               NUMBER, -- 견제사(수비)
	// PICK_OFF_SUCCESS       NUMBER, -- 견제사(주루)

	private int teamNumber;
	private int seasonYear;
	private int gameCount;
	private int error;
	private int dp;
	private int sb;
	private int cb;
	private int sbSuccess;
	private int pickOff;
	private int pickOffSuccess;
	
	// get, set
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
	public int getDp() {
		return dp;
	}
	public void setDp(int dp) {
		this.dp = dp;
	}
	public int getSb() {
		return sb;
	}
	public void setSb(int sb) {
		this.sb = sb;
	}
	public int getCb() {
		return cb;
	}
	public void setCb(int cb) {
		this.cb = cb;
	}
	public int getSbSuccess() {
		return sbSuccess;
	}
	public void setSbSuccess(int sbSuccess) {
		this.sbSuccess = sbSuccess;
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
	
	// toString
	@Override
	public String toString() {
		return "DeffenseBaseRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", gameCount="
				+ gameCount + ", error=" + error + ", dp=" + dp + ", sb=" + sb + ", cb=" + cb + ", sbSuccess="
				+ sbSuccess + ", pickOff=" + pickOff + ", pickOffSuccess=" + pickOffSuccess + "]";
	}
	
	
}
