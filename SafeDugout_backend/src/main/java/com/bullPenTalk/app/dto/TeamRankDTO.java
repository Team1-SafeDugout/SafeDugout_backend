package com.bullPenTalk.app.dto;

public class TeamRankDTO {
	private int teamRank; 
	private String teamName;
	private int gameCount;
	private int teamWin; 
	private int teamDraw;
	private int teamLose; 
	private double teamWinLoss;
	private double teamWinRate;
	
	public int getTeamRank() {
		return teamRank;
	}
	public void setTeamRank(int teamRank) {
		this.teamRank = teamRank;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	public double getTeamWinLoss() {
		return teamWinLoss;
	}
	public void setTeamWinLoss(double teamWinLoss) {
		this.teamWinLoss = teamWinLoss;
	}
	public double getTeamWinRate() {
		return teamWinRate;
	}
	public void setTeamWinRate(double teamWinRate) {
		this.teamWinRate = teamWinRate;
	}
	
	@Override
	public String toString() {
		return "TeamRankDTO [teamRank=" + teamRank + ", teamName=" + teamName + ", gameCount=" + gameCount
				+ ", teamWin=" + teamWin + ", teamDraw=" + teamDraw + ", teamLose=" + teamLose + ", teamWinLoss="
				+ teamWinLoss + ", teamWinRate=" + teamWinRate + "]";
	} 
	
	
}
