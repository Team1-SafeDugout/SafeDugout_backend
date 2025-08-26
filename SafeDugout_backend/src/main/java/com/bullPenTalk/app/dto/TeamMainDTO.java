package com.bullPenTalk.app.dto;

public class TeamMainDTO {

	//팀 뉴스 목록
	private String newsPostTitle; //팀 뉴스 제목
	
	//게시글 목록
	private int postNumber; //팀 게시글 번호
	private String postTitle; //팀 게시글 제목
	
	//팀 유튜브 
	private String attachmentPath; //썸네일 이미지 경로
	private String postLink; //유튜브 링크
	
	//경기 일정
	private int gameId; //게임 번호
	private int homeTeamNumber; //홈팀 번호
	private String stadiumName; //경기장 이름
	private int awayTeamNumber; //어웨이팀 번호
	private String scheduleDate; //경기 날짜
	
	//팀별 순위 목록
	private int teamRank; // 팀 순위
	private String teamName; // 팀 이름
	private int gameCount; // 게임 수
	private int teamWin;  // 이긴 횟수
	private int teamDraw; // 비긴 횟수
	private int teamLose;  // 진 횟수
	private double teamWinRate; // 팀 승률
	private double teamWinLoss; // 팀 승차
	
	public String getNewsPostTitle() {
		return newsPostTitle;
	}
	public void setNewsPostTitle(String newsPostTitle) {
		this.newsPostTitle = newsPostTitle;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getPostLink() {
		return postLink;
	}
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}
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
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public int getAwayTeamNumber() {
		return awayTeamNumber;
	}
	public void setAwayTeamNumber(int awayTeamNumber) {
		this.awayTeamNumber = awayTeamNumber;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
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
		return "TeamMainDTO [newsPostTitle=" + newsPostTitle + ", postNumber=" + postNumber + ", postTitle=" + postTitle
				+ ", attachmentPath=" + attachmentPath + ", postLink=" + postLink + ", gameId=" + gameId
				+ ", homeTeamNumber=" + homeTeamNumber + ", stadiumName=" + stadiumName + ", awayTeamNumber="
				+ awayTeamNumber + ", scheduleDate=" + scheduleDate + ", teamRank=" + teamRank + ", teamName="
				+ teamName + ", gameCount=" + gameCount + ", teamWin=" + teamWin + ", teamDraw=" + teamDraw
				+ ", teamLose=" + teamLose + ", teamWinLoss=" + teamWinLoss + ", teamWinRate=" + teamWinRate + "]";
	}
	
}
