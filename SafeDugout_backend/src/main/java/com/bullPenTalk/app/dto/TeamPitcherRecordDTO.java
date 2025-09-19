package com.bullPenTalk.app.dto;

public class TeamPitcherRecordDTO {
	// TEAM_NUMBER NUMBER NOT NULL,
	// SEASON_YEAR NUMBER NOT NULL,
	// TEAM_PITCHER_ERA NUMBER,
	// TEAM_PITCHER_GAME_COUNT NUMBER,
	// TEAM_PITCHER_WIN NUMBER,
	// TEAM_PITCHER_LOSE NUMBER,
	// TEAM_PITCHER_SAVE NUMBER,
	// TEAM_PITCHER_HOLD NUMBER,
	// TEAM_PITCHER_WPCT NUMBER,
	// TEAM_PITCHER_IP NUMBER,
	// TEAM_PITCHER_HITS NUMBER,
	// TEAM_PITCHER_HR NUMBER,
	// TEAM_PITCHER_BB NUMBER,
	// TEAM_PITCHER_HBP NUMBER,
	// TEAM_PITCHER_STRIKEOUT NUMBER,
	// TEAM_PITCHER_SCORE NUMBER,
	// TEAM_PITCHER_ER NUMBER,
	// TEAM_PITCHER_WHIP NUMBER,

	private int teamNumber;
	private int seasonYear;
	private double teamPitcherEra;
	private int teamPitcherGameCount;
	private int teamPitcherWin;
	private int teamPitcherLose;
	private int teamPitcherSave;
	private int teamPitcherHold;
	private double teamPitcherWpct;
	private double teamPitcherIp;
	private int teamPitcherHits;
	private int teamPitcherHr;
	private int teamPitcherBb;
	private int teamPitcherHbp;
	private int teamPitcherStrikeout;
	private int teamPitcherScore;
	private int teamPitcherEr;
	private double teamPitcherWhip;

	// get, set
	public int getTeamPitcherGameCount() {
		return teamPitcherGameCount;
	}

	public void setTeamPitcherGameCount(int teamPitcherGameCount) {
		this.teamPitcherGameCount = teamPitcherGameCount;
	}
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

	public double getTeamPitcherEra() {
		return teamPitcherEra;
	}

	public void setTeamPitcherEra(double teamPitcherEra) {
		this.teamPitcherEra = teamPitcherEra;
	}

	public int getTeamPitcherWin() {
		return teamPitcherWin;
	}

	public void setTeamPitcherWin(int teamPitcherWin) {
		this.teamPitcherWin = teamPitcherWin;
	}

	public int getTeamPitcherLose() {
		return teamPitcherLose;
	}

	public void setTeamPitcherLose(int teamPitcherLose) {
		this.teamPitcherLose = teamPitcherLose;
	}

	public int getTeamPitcherSave() {
		return teamPitcherSave;
	}

	public void setTeamPitcherSave(int teamPitcherSave) {
		this.teamPitcherSave = teamPitcherSave;
	}

	public int getTeamPitcherHold() {
		return teamPitcherHold;
	}

	public void setTeamPitcherHold(int teamPitcherHold) {
		this.teamPitcherHold = teamPitcherHold;
	}

	public double getTeamPitcherWpct() {
		return teamPitcherWpct;
	}

	public void setTeamPitcherWpct(double teamPitcherWpct) {
		this.teamPitcherWpct = teamPitcherWpct;
	}

	public double getTeamPitcherIp() {
		return teamPitcherIp;
	}

	public void setTeamPitcherIp(double teamPitcherIp) {
		this.teamPitcherIp = teamPitcherIp;
	}

	public int getTeamPitcherHits() {
		return teamPitcherHits;
	}

	public void setTeamPitcherHits(int teamPitcherHits) {
		this.teamPitcherHits = teamPitcherHits;
	}

	public int getTeamPitcherHr() {
		return teamPitcherHr;
	}

	public void setTeamPitcherHr(int teamPitcherHr) {
		this.teamPitcherHr = teamPitcherHr;
	}

	public int getTeamPitcherBb() {
		return teamPitcherBb;
	}

	public void setTeamPitcherBb(int teamPitcherBb) {
		this.teamPitcherBb = teamPitcherBb;
	}

	public int getTeamPitcherHbp() {
		return teamPitcherHbp;
	}

	public void setTeamPitcherHbp(int teamPitcherHbp) {
		this.teamPitcherHbp = teamPitcherHbp;
	}

	public int getTeamPitcherStrikeout() {
		return teamPitcherStrikeout;
	}

	public void setTeamPitcherStrikeout(int teamPitcherStrikeout) {
		this.teamPitcherStrikeout = teamPitcherStrikeout;
	}

	public int getTeamPitcherScore() {
		return teamPitcherScore;
	}

	public void setTeamPitcherScore(int teamPitcherScore) {
		this.teamPitcherScore = teamPitcherScore;
	}

	public int getTeamPitcherEr() {
		return teamPitcherEr;
	}

	public void setTeamPitcherEr(int teamPitcherEr) {
		this.teamPitcherEr = teamPitcherEr;
	}

	public double getTeamPitcherWhip() {
		return teamPitcherWhip;
	}

	public void setTeamPitcherWhip(double teamPitcherWhip) {
		this.teamPitcherWhip = teamPitcherWhip;
	}

	// toString
	@Override
	public String toString() {
		return "TeamPitcherRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", teamPitcherEra="
				+ teamPitcherEra + ", teamPitcherGameCount=" + teamPitcherGameCount + ", teamPitcherWin="
				+ teamPitcherWin + ", teamPitcherLose=" + teamPitcherLose + ", teamPitcherSave=" + teamPitcherSave
				+ ", teamPitcherHold=" + teamPitcherHold + ", teamPitcherWpct=" + teamPitcherWpct + ", teamPitcherIp="
				+ teamPitcherIp + ", teamPitcherHits=" + teamPitcherHits + ", teamPitcherHr=" + teamPitcherHr
				+ ", teamPitcherBb=" + teamPitcherBb + ", teamPitcherHbp=" + teamPitcherHbp + ", teamPitcherStrikeout="
				+ teamPitcherStrikeout + ", teamPitcherScore=" + teamPitcherScore + ", teamPitcherEr=" + teamPitcherEr
				+ ", teamPitcherWhip=" + teamPitcherWhip + "]";
	}

}
