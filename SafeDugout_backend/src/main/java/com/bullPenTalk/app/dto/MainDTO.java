package com.bullPenTalk.app.dto;

public class MainDTO {
	
	private int gameId;
	private int homeTeamNumber;
	private String stadiumName;
	private int awayTeamNumber;
	private String scheduleDate;
	
	private int sellPostNumber;
	private String sellPostTitle; 
	private String sellPostCreationDate;
	private String attachmentPath;
	
	private int noticePostNumber; 
	private String noticePostTitle;
	private String noticePostDate;
	
	private int teamRank; 
	private String teamName;
	private int gameCount;
	private int teamWin; 
	private int teamDraw;
	private int teamLose; 
	private double teamWinLoss;
	private double teamWinRate;
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public int getSellPostNumber() {
		return sellPostNumber;
	}
	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}
	public String getSellPostTitle() {
		return sellPostTitle;
	}
	public void setSellPostTitle(String sellPostTitle) {
		this.sellPostTitle = sellPostTitle;
	}
	public String getSellPostCreationDate() {
		return sellPostCreationDate;
	}
	public void setSellPostCreationDate(String sellPostCreationDate) {
		this.sellPostCreationDate = sellPostCreationDate;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public int getNoticePostNumber() {
		return noticePostNumber;
	}
	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
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
	public String getNoticePostTitle() {
		return noticePostTitle;
	}
	public void setNoticePostTitle(String noticePostTitle) {
		this.noticePostTitle = noticePostTitle;
	}
	public String getNoticePostDate() {
		return noticePostDate;
	}
	public void setNoticePostDate(String noticePostDate) {
		this.noticePostDate = noticePostDate;
	}
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
		return "MainDTO [gameId=" + gameId + ", homeTeamName=" + homeTeamNumber + ", stadiumName=" + stadiumName
				+ ", awayTeamName=" + awayTeamNumber + ", scheduleDate=" + scheduleDate + ", sellPostNumber="
				+ sellPostNumber + ", sellPostTitle=" + sellPostTitle + ", sellPostCreationDate=" + sellPostCreationDate
				+ ", attachmentPath=" + attachmentPath + ", noticePostNumber=" + noticePostNumber + ", noticePostTitle="
				+ noticePostTitle + ", noticePostDate=" + noticePostDate + ", teamRank=" + teamRank + ", teamName="
				+ teamName + ", gameCount=" + gameCount + ", teamWin=" + teamWin + ", teamDraw=" + teamDraw
				+ ", teamLose=" + teamLose + ", teamWinLoss=" + teamWinLoss + ", teamWinRate=" + teamWinRate + "]";
	}
}
