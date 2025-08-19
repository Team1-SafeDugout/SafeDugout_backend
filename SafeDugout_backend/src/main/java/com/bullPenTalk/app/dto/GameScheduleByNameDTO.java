package com.bullPenTalk.app.dto;

public class GameScheduleByNameDTO {
	int gameId;
	String homeTeamName;
	String stadiumName;
	String awayTeamName;
	String scheduleDate;
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getHomeTeamName() {
		return homeTeamName;
	}
	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getAwayTeamName() {
		return awayTeamName;
	}
	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	@Override
	public String toString() {
		return "GameScheduleByNameDTO [gameId=" + gameId + ", homeTeamName=" + homeTeamName + ", stadiumName="
				+ stadiumName + ", awayTeamName=" + awayTeamName + ", scheduleDate=" + scheduleDate + "]";
	}
	
}
