package com.bullPenTalk.app.dto;

public class TeamBatterRecordDTO {
    // TEAM_ID                   NUMBER NOT NULL,
    // SEASON_YEAR               NUMBER NOT NULL,
    // TEAM_BATTER_GAME_COUNT    NUMBER,
    // TEAM_BATTER_AVG_BAT       NUMBER,
    // TEAM_BATTER_PA_BAT        NUMBER,
    // TEAM_BATTER_AB            NUMBER,
    // TEAM_BATTER_R             NUMBER,
    // TEAM_BATTER_HITS          NUMBER,
    // TEAM_BATTER_DOUBLE_HIT    NUMBER,
    // TEAM_BATTER_TRIPLE_HIT    NUMBER,
    // TEAM_BATTER_HR            NUMBER,
    // TEAM_BATTER_TB            NUMBER,
    // TEAM_BATTER_RBI           NUMBER,
    // TEAM_BATTER_SAC           NUMBER,
    // TEAM_BATTER_SF            NUMBER,

	private int teamId;
	private int seasonYear;
	private int teamBatterGameCount;
	private double teamBatterAvgBat;
	private int teamBatterPaBat;
	private int teamBatterAb;
	private int teamBatterR;
	private int teamBatterHits;
	private int teamBatterDoubleHit;
	private int teamBatterTripleHit;
	private int teamBatterHr;
	private int teamBatterTb;
	private int teamBatterRbi;
	private int teamBatterSac;
	private int teamBatterSf;
	
	// get, set
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
	public int getTeamBatterGameCount() {
		return teamBatterGameCount;
	}
	public void setTeamBatterGameCount(int teamBatterGameCount) {
		this.teamBatterGameCount = teamBatterGameCount;
	}
	public double getTeamBatterAvgBat() {
		return teamBatterAvgBat;
	}
	public void setTeamBatterAvgBat(double teamBatterAvgBat) {
		this.teamBatterAvgBat = teamBatterAvgBat;
	}
	public int getTeamBatterPaBat() {
		return teamBatterPaBat;
	}
	public void setTeamBatterPaBat(int teamBatterPaBat) {
		this.teamBatterPaBat = teamBatterPaBat;
	}
	public int getTeamBatterAb() {
		return teamBatterAb;
	}
	public void setTeamBatterAb(int teamBatterAb) {
		this.teamBatterAb = teamBatterAb;
	}
	public int getTeamBatterR() {
		return teamBatterR;
	}
	public void setTeamBatterR(int teamBatterR) {
		this.teamBatterR = teamBatterR;
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
	public int getTeamBatterTb() {
		return teamBatterTb;
	}
	public void setTeamBatterTb(int teamBatterTb) {
		this.teamBatterTb = teamBatterTb;
	}
	public int getTeamBatterRbi() {
		return teamBatterRbi;
	}
	public void setTeamBatterRbi(int teamBatterRbi) {
		this.teamBatterRbi = teamBatterRbi;
	}
	public int getTeamBatterSac() {
		return teamBatterSac;
	}
	public void setTeamBatterSac(int teamBatterSac) {
		this.teamBatterSac = teamBatterSac;
	}
	public int getTeamBatterSf() {
		return teamBatterSf;
	}
	public void setTeamBatterSf(int teamBatterSf) {
		this.teamBatterSf = teamBatterSf;
	}
	
	// toString
	@Override
	public String toString() {
		return "TeamBatterRecordDTO [teamId=" + teamId + ", seasonYear=" + seasonYear + ", teamBatterGameCount="
				+ teamBatterGameCount + ", teamBatterAvgBat=" + teamBatterAvgBat + ", teamBatterPaBat="
				+ teamBatterPaBat + ", teamBatterAb=" + teamBatterAb + ", teamBatterR=" + teamBatterR
				+ ", teamBatterHits=" + teamBatterHits + ", teamBatterDoubleHit=" + teamBatterDoubleHit
				+ ", teamBatterTripleHit=" + teamBatterTripleHit + ", teamBatterHr=" + teamBatterHr + ", teamBatterTb="
				+ teamBatterTb + ", teamBatterRbi=" + teamBatterRbi + ", teamBatterSac=" + teamBatterSac
				+ ", teamBatterSf=" + teamBatterSf + "]";
	}
	
	
}

