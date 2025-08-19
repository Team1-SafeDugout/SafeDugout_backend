package com.bullPenTalk.app.dto;

public class GameScheduleDTO {
//	CREATE TABLE TBL_GAME_SCHEDULE (
//	GAME_ID            NUMBER PRIMARY KEY,
//	HOME_TEAM_NUMBER   NUMBER NOT NULL,
//	AWAY_TEAM_NUMBER   NUMBER NOT NULL,
//	SCHEDULE_DATE      DATE NOT NULL,
//	STADIUM_NUMBER     NUMBER NOT NULL,
//	CONSTRAINT FK_HOME_TEAM FOREIGN KEY (HOME_TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER),
//	CONSTRAINT FK_AWAY_TEAM FOREIGN KEY (AWAY_TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER),
//	CONSTRAINT FK_STADIUM FOREIGN KEY (STADIUM_NUMBER) REFERENCES TBL_STADIUM(STADIUM_NUMBER)
//	);
	
	private int gameId;
	private int homeTeamNumber;
	private int awayTeamNumber;
	private String ScheduleDate;
	private int StadiumNumber;
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getHomeTeamNumber() {
		return homeTeamNumber;
	}
	public void setHomeTeamNumber(int homeTeamNumber) {
		this.homeTeamNumber = homeTeamNumber;
	}
	public int getAwayTeamNumber() {
		return awayTeamNumber;
	}
	public void setAwayTeamNumber(int awayTeamNumber) {
		this.awayTeamNumber = awayTeamNumber;
	}
	public String getScheduleDate() {
		return ScheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		ScheduleDate = scheduleDate;
	}
	public int getStadiumNumber() {
		return StadiumNumber;
	}
	public void setStadiumNumber(int stadiumNumber) {
		StadiumNumber = stadiumNumber;
	}
	
	@Override
	public String toString() {
		return "GameScheduleDTO [gameId=" + gameId + ", homeTeamNumber=" + homeTeamNumber + ", awayTeamNumber="
				+ awayTeamNumber + ", ScheduleDate=" + ScheduleDate + ", StadiumNumber=" + StadiumNumber + "]";
	}
	
	
}
