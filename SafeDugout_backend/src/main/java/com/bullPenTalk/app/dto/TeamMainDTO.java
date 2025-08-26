package com.bullPenTalk.app.dto;

public class TeamMainDTO {

	//경기 일정
	private int gameId; // 게임번호
	private String homeTeamName; // 홈팀 이름
	private String stadiumName; // 경기장 이름
	private String awayTeamName; // 원정팀 이름
	private String scheduleDate; // 경기 날짜
	//팀 뉴스 목록
	private String newsPostTitle; //팀 뉴스 제목	
	//팀 게시글 목록
	private int postNumber; //팀 게시글 번호
	private String postTitle; //팀 게시글 제목	
	private String memberId; //작성자 ID
	private String postDate; //작성일자
	//팀 유튜브 
	private String attachmentPath; //썸네일 이미지 경로
	private String postLink; //유튜브 링크	
	//팀별 순위 목록
	private int teamRank; // 팀 순위
	private String teamName; // 팀 이름
	private int gameCount; // 게임 수
	private int teamWin;  // 이긴 횟수
	private int teamDraw; // 비긴 횟수
	private int teamLose;  // 진 횟수
	private double teamWinRate; // 팀 승률
	private double teamWinLoss; // 팀 승차
	
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
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

	public double getTeamWinRate() {
		return teamWinRate;
	}

	public void setTeamWinRate(double teamWinRate) {
		this.teamWinRate = teamWinRate;
	}

	public double getTeamWinLoss() {
		return teamWinLoss;
	}

	public void setTeamWinLoss(double teamWinLoss) {
		this.teamWinLoss = teamWinLoss;
	}

	@Override
	public String toString() {
		return "TeamMainDTO [gameId=" + gameId + ", homeTeamName=" + homeTeamName + ", stadiumName=" + stadiumName
				+ ", awayTeamName=" + awayTeamName + ", scheduleDate=" + scheduleDate + ", newsPostTitle="
				+ newsPostTitle + ", postNumber=" + postNumber + ", postTitle=" + postTitle + ", memberId=" + memberId
				+ ", postDate=" + postDate + ", attachmentPath=" + attachmentPath + ", postLink=" + postLink
				+ ", teamRank=" + teamRank + ", teamName=" + teamName + ", gameCount=" + gameCount + ", teamWin="
				+ teamWin + ", teamDraw=" + teamDraw + ", teamLose=" + teamLose + ", teamWinRate=" + teamWinRate
				+ ", teamWinLoss=" + teamWinLoss + "]";
	}
	
}
