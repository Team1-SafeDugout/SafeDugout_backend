package com.bullPenTalk.app.dto;

public class TeamRecordDTO {
//	CREATE TABLE TBL_TEAM_RECORD (
//	TEAM_NUMBER       NUMBER ,
//	SEASON_YEAR       NUMBER,
//	TEAM_RANK         NUMBER,
//	GAME_COUNT        NUMBER,
//	TEAM_WIN          NUMBER,
//	TEAM_DRAW         NUMBER,
//	TEAM_LOSE         NUMBER,
//	TEAM_WIN_RATE     NUMBER,
//	TEAM_AVG_BAT      NUMBER,
//	TEAM_ERA          NUMBER,
//	TEAM_SCORE        NUMBER,
//	TEAM_CONCEDE      NUMBER,
//	CONSTRAINT PK_TEAM_RECORD PRIMARY KEY (TEAM_NUMBER, SEASON_YEAR),
//	CONSTRAINT FK_TEAM_RECORD FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	
	private int teamNumber; 
	private int seasonYear;
	private int teamRank;
	private int gameCount;
	private int teamWin;
	private int teamDraw;
	private int teamLose;
	private double teamWinRate; // double 수정
	private double avgBat; // double 수정
	private double era; // double 수정
	private int score;
	private int concede;
	
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

	public int getTeamRank() {
		return teamRank;
	}

	public void setTeamRank(int teamRank) {
		this.teamRank = teamRank;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}

	public int getTeamWin() {
		return teamWin;
	}

	public void setTeamWin(int teamWin) {
		this.teamWin = teamWin;
	}

	public int getTeamDraw() {
		return teamDraw;
	}

	public void setTeamDraw(int teamDraw) {
		this.teamDraw = teamDraw;
	}

	public int getTeamLose() {
		return teamLose;
	}

	public void setTeamLose(int teamLose) {
		this.teamLose = teamLose;
	}

	public double getTeamWinRate() {
		return teamWinRate;
	}

	public void setTeamWinRate(double teamWinRate) {
		this.teamWinRate = teamWinRate;
	}

	public double getAvgBat() {
		return avgBat;
	}

	public void setAvgBat(double avgBat) {
		this.avgBat = avgBat;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getConcede() {
		return concede;
	}

	public void setConcede(int concede) {
		this.concede = concede;
	}

	// toString
	@Override
	public String toString() {
		return "TeamRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", teamRank=" + teamRank
				+ ", gameCount=" + gameCount + ", teamWin=" + teamWin + ", teamDraw=" + teamDraw + ", teamLose="
				+ teamLose + ", teamWinRate=" + teamWinRate + ", avgBat=" + avgBat + ", era=" + era + ", score=" + score
				+ ", concede=" + concede + "]";
	}
	
}




