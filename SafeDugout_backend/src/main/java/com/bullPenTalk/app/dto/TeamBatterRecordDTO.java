package com.bullPenTalk.app.dto;

public class TeamBatterRecordDTO {
//	CREATE TABLE TBL_TEAM_BATTER_RECORD (
//	TEAM_ID                   NUMBER NOT NULL,
//	SEASON_YEAR               NUMBER NOT NULL,
//	TEAM_BATTER_AVG_BAT       NUMBER,
//	TEAM_BATTER_GAME_COUNT    NUMBER,
//	TEAM_BATTER_AT_BAT        NUMBER,
//	TEAM_BATTER_RBI           NUMBER,
//	TEAM_BATTER_SCORE         NUMBER,
//	TEAM_BATTER_HITS          NUMBER,
//	TEAM_BATTER_DOUBLE_HIT    NUMBER,
//	TEAM_BATTER_TRIPLE_HIT    NUMBER,
//	TEAM_BATTER_HR            NUMBER,
//	TEAM_BATTER_BB            NUMBER,
//	TEAM_BATTER_GIDOUT        NUMBER,
//	TEAM_BATTER_HBP           NUMBER,
//	TEAM_BATTER_STRIKEOUT     NUMBER,
//	TEAM_BATTER_OPS           NUMBER,
//	TEAM_BATTER_STOLEN_BASE   NUMBER,
//	CONSTRAINT PK_TEAM_BATTER_RECORD PRIMARY KEY (TEAM_ID, SEASON_YEAR),
//	CONSTRAINT FK_TEAM_BATTER_RECORD FOREIGN KEY (TEAM_ID) REFERENCES TBL_TEAM(TEAM_NUMBER) ON DELETE CASCADE
//	);
	
	private int teamId;
	private int seasonYear;
	private int teamBatterAvgBat;
	private int teamBatterGameCount;
	private int teamBatterAtBat;
	private int teamBatterRbi;
	private int teamBatterScore;
	private int teamBatterHits;
	private int teamBatterDoubleHit;
	private int teamBatterTripleHit;
	private int teamBatterHr;
	private int teamBatterBb;
	private int teamBatterGidout;
	private int teamBatterHbp;
	private int teamBatterStrikeout;
	private int teamBatterOps;
	private int teamBatterStolenBase;
	
	
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getSeasonYear() {
		return seasonYear;
	}
	public void setSeasonYear(int seasonYear) {
		this.seasonYear = seasonYear;
	}
	public int getTeamBatterAvgBat() {
		return teamBatterAvgBat;
	}
	public void setTeamBatterAvgBat(int teamBatterAvgBat) {
		this.teamBatterAvgBat = teamBatterAvgBat;
	}
	public int getTeamBatterGameCount() {
		return teamBatterGameCount;
	}
	public void setTeamBatterGameCount(int teamBatterGameCount) {
		this.teamBatterGameCount = teamBatterGameCount;
	}
	public int getTeamBatterAtBat() {
		return teamBatterAtBat;
	}
	public void setTeamBatterAtBat(int teamBatterAtBat) {
		this.teamBatterAtBat = teamBatterAtBat;
	}
	public int getTeamBatterRbi() {
		return teamBatterRbi;
	}
	public void setTeamBatterRbi(int teamBatterRbi) {
		this.teamBatterRbi = teamBatterRbi;
	}
	public int getTeamBatterScore() {
		return teamBatterScore;
	}
	public void setTeamBatterScore(int teamBatterScore) {
		this.teamBatterScore = teamBatterScore;
	}
	public int getTeamBatterHits() {
		return teamBatterHits;
	}
	public void setTeamBatterHits(int teamBatterHits) {
		this.teamBatterHits = teamBatterHits;
	}
	public int getTeamBatterDoubleHit() {
		return teamBatterDoubleHit;
	}
	public void setTeamBatterDoubleHit(int teamBatterDoubleHit) {
		this.teamBatterDoubleHit = teamBatterDoubleHit;
	}
	public int getTeamBatterTripleHit() {
		return teamBatterTripleHit;
	}
	public void setTeamBatterTripleHit(int teamBatterTripleHit) {
		this.teamBatterTripleHit = teamBatterTripleHit;
	}
	public int getTeamBatterHr() {
		return teamBatterHr;
	}
	public void setTeamBatterHr(int teamBatterHr) {
		this.teamBatterHr = teamBatterHr;
	}
	public int getTeamBatterBb() {
		return teamBatterBb;
	}
	public void setTeamBatterBb(int teamBatterBb) {
		this.teamBatterBb = teamBatterBb;
	}
	public int getTeamBatterGidout() {
		return teamBatterGidout;
	}
	public void setTeamBatterGidout(int teamBatterGidout) {
		this.teamBatterGidout = teamBatterGidout;
	}
	public int getTeamBatterHbp() {
		return teamBatterHbp;
	}
	public void setTeamBatterHbp(int teamBatterHbp) {
		this.teamBatterHbp = teamBatterHbp;
	}
	public int getTeamBatterStrikeout() {
		return teamBatterStrikeout;
	}
	public void setTeamBatterStrikeout(int teamBatterStrikeout) {
		this.teamBatterStrikeout = teamBatterStrikeout;
	}
	public int getTeamBatterOps() {
		return teamBatterOps;
	}
	public void setTeamBatterOps(int teamBatterOps) {
		this.teamBatterOps = teamBatterOps;
	}
	public int getTeamBatterStolenBase() {
		return teamBatterStolenBase;
	}
	public void setTeamBatterStolenBase(int teamBatterStolenBase) {
		this.teamBatterStolenBase = teamBatterStolenBase;
	}
	
	
	@Override
	public String toString() {
		return "TeamBatterRecordDTO [teamId=" + teamId + ", seasonYear=" + seasonYear + ", teamBatterAvgBat="
				+ teamBatterAvgBat + ", teamBatterGameCount=" + teamBatterGameCount + ", teamBatterAtBat="
				+ teamBatterAtBat + ", teamBatterRbi=" + teamBatterRbi + ", teamBatterScore=" + teamBatterScore
				+ ", teamBatterHits=" + teamBatterHits + ", teamBatterDoubleHit=" + teamBatterDoubleHit
				+ ", teamBatterTripleHit=" + teamBatterTripleHit + ", teamBatterHr=" + teamBatterHr + ", teamBatterBb="
				+ teamBatterBb + ", teamBatterGidout=" + teamBatterGidout + ", teamBatterHbp=" + teamBatterHbp
				+ ", teamBatterStrikeout=" + teamBatterStrikeout + ", teamBatterOps=" + teamBatterOps
				+ ", teamBatterStolenBase=" + teamBatterStolenBase + "]";
	
}

}