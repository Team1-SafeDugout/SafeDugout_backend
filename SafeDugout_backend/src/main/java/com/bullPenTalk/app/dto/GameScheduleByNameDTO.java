package com.bullPenTalk.app.dto;

public class GameScheduleByNameDTO {
	private int gameId; //게임 번호
	private String homeTeamName; //홈팀 이름
	private String stadiumName; //경기장 이름
	private String awayTeamName; //어웨이 팀 이름
	private String scheduleDate; //경기 날짜
	
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
