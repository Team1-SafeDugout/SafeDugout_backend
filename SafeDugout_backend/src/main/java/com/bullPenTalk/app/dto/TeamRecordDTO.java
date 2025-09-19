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
	private double teamEra; // double 수정
	private int teamScore;
	private int teamConcede;
	private String teamName;
	private double teamAvgBat;


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


	public double getTeamEra() {
		return teamEra;
	}


	public void setTeamEra(double teamEra) {
		this.teamEra = teamEra;
	}


	public int getTeamScore() {
		return teamScore;
	}


	public void setTeamScore(int score) {
		this.teamScore = score;
	}


	public int getTeamConcede() {
		return teamConcede;
	}


	public void setTeamConcede(int teamConcede) {
		this.teamConcede = teamConcede;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public double getTeamAvgBat() {
		return teamAvgBat;
	}


	public void setTeamAvgBat(double teamAvgBat) {
		this.teamAvgBat = teamAvgBat;
	}
	
	// toString
	@Override
	public String toString() {
		return "TeamRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", teamRank=" + teamRank
				+ ", gameCount=" + gameCount + ", teamWin=" + teamWin + ", teamDraw=" + teamDraw + ", teamLose="
				+ teamLose + ", teamWinRate=" + teamWinRate + ", teamEra=" + teamEra + ", teamScore=" + teamScore + ", teamConcede="
				+ teamConcede + ", teamName=" + teamName + ", teamAvgBat=" + teamAvgBat + "]";
	}
	
}




