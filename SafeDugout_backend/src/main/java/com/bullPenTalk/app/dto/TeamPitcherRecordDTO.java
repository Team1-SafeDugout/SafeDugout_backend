package com.bullPenTalk.app.dto;

public class TeamPitcherRecordDTO {
//	CREATE TABLE TBL_TEAM_PITCHER_RECORD (
//	TEAM_NUMBER                  NUMBER NOT NULL,
//	SEASON_YEAR                  NUMBER NOT NULL,
//	TEAM_PITCHER_ERA             NUMBER,
//	TEAM_PITCHER_START_ERA       NUMBER,
//	TEAM_PITCHER_RELIEF_ERA      NUMBER,
//	TEAM_PITCHER_GAME_COUNT      NUMBER,
//	TEAM_PITCHER_WIN             NUMBER,
//	TEAM_PITCHER_LOSE            NUMBER,
//	TEAM_PITCHER_SAVE            NUMBER,
//	TEAM_PITCHER_HOLD            NUMBER,
//	TEAM_PITCHER_STRIKEOUT       NUMBER,
//	TEAM_PITCHER_HITS            NUMBER,
//	TEAM_PITCHER_HR              NUMBER,
//	TEAM_PITCHER_BB              NUMBER,
//	TEAM_PITCHER_HBP             NUMBER,
//	TEAM_PITCHER_SCORE           NUMBER,
//	TEAM_PITCHER_SELF_SCORE      NUMBER,
//	CONSTRAINT PK_TEAM_PITCHER_RECORD PRIMARY KEY (TEAM_NUMBER, SEASON_YEAR),
//	CONSTRAINT FK_TEAM_PITCHER_RECORD FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	
	private int teamNumber; // 팀 번호
	private int seasonYear; // 시즌 년도
	private double teamPitcherEra; // 팀 전체 투수의 평균자책점
	private double teamPitcherStartEra; // 선발 투수진의 평균자책점
	private double teamPitcherReliefEra; // 불펜(계투) 투수진의 평균자책점
	private int teamPitcherGameCount; // 팀 투수가 출전한 경기 수
	private int teamPitcherWin; // 팀 투수가 기록한 승리 횟수
	private int teamPitcherLose; // 팀 투수가 기록한 패배 횟수
	private int teamPitcherSave; // 구원 투수가 기록한 세이브(SV) 횟수
	private int teamPitcherHold; // 불펜 투수가 기록한 홀드(Hold) 횟수
	private int teamPitcherStrikeout; // 팀 투수가 기록한 탈삼진 개수
	
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
	public void setTeamPitcherEra(int teamPitcherEra) {
		this.teamPitcherEra = teamPitcherEra;
	}
	public double getTeamPitcherStartEra() {
		return teamPitcherStartEra;
	}
	public void setTeamPitcherStartEra(int teamPitcherStartEra) {
		this.teamPitcherStartEra = teamPitcherStartEra;
	}
	public double getTeamPitcherReliefEra() {
		return teamPitcherReliefEra;
	}
	public void setTeamPitcherReliefEra(int teamPitcherReliefEra) {
		this.teamPitcherReliefEra = teamPitcherReliefEra;
	}
	public int getTeamPitcherGameCount() {
		return teamPitcherGameCount;
	}
	public void setTeamPitcherGameCount(int teamPitcherGameCount) {
		this.teamPitcherGameCount = teamPitcherGameCount;
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
	public int getTeamPitcherStrikeout() {
		return teamPitcherStrikeout;
	}
	public void setTeamPitcherStrikeout(int teamPitcherStrikeout) {
		this.teamPitcherStrikeout = teamPitcherStrikeout;
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
	public int getTeamPitcherScore() {
		return teamPitcherScore;
	}
	public void setTeamPitcherScore(int teamPitcherScore) {
		this.teamPitcherScore = teamPitcherScore;
	}
	public int getTeamPitcherSelfScore() {
		return teamPitcherSelfScore;
	}
	public void setTeamPitcherSelfScore(int teamPitcherSelfScore) {
		this.teamPitcherSelfScore = teamPitcherSelfScore;
	}
	private int teamPitcherHits;
	private int teamPitcherHr;
	private int teamPitcherBb;
	private int teamPitcherHbp;
	private int teamPitcherScore;
	private int teamPitcherSelfScore;
	@Override
	public String toString() {
		return "TeamPitcherRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", teamPitcherEra="
				+ teamPitcherEra + ", teamPitcherStartEra=" + teamPitcherStartEra + ", teamPitcherReliefEra="
				+ teamPitcherReliefEra + ", teamPitcherGameCount=" + teamPitcherGameCount + ", teamPitcherWin="
				+ teamPitcherWin + ", teamPitcherLose=" + teamPitcherLose + ", teamPitcherSave=" + teamPitcherSave
				+ ", teamPitcherHold=" + teamPitcherHold + ", teamPitcherStrikeout=" + teamPitcherStrikeout
				+ ", teamPitcherHits=" + teamPitcherHits + ", teamPitcherHr=" + teamPitcherHr + ", teamPitcherBb="
				+ teamPitcherBb + ", teamPitcherHbp=" + teamPitcherHbp + ", teamPitcherScore=" + teamPitcherScore
				+ ", teamPitcherSelfScore=" + teamPitcherSelfScore + "]";
	}
	
	

}
