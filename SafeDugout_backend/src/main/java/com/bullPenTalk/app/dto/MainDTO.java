package com.bullPenTalk.app.dto;

public class MainDTO {

	// 경기 일정
	private int gameId; // 게임번호
	private String homeTeamName; // 홈팀 이름
	private String stadiumName; // 경기장 이름
	private String awayTeamName; // 원정팀 이름
	private String scheduleDate; // 경기 날짜
	// 판매글 목록
	private int sellPostNumber; // 판매 게시글 번호
	private String sellPostTitle; // 판매 게시글 제목
	private String sellPostCreationDate; // 판매 게시글 작성 일자
	private int pricePoint; // 상품 가격 포인트
	private String attachmentPath; // 첨부파일 경로
	// 팀 순위 목록
	private int teamRank; // 팀 순위
	private String teamName; // 팀 이름
	private int gameCount; // 게임 수
	private int teamWin; // 이긴 횟수
	private int teamDraw; // 비긴 횟수
	private int teamLose; // 진 횟수
	private double teamWinRate; // 팀 승률
	private double teamWinLoss; // 팀 승차
	// 입문자 가이드 목록
	private int noticePostNumber; // 공지사항 게시글 번호
	private String noticePostTitle; // 공지사항 게시글 제목
	private String noticePostDate; // 공지사항 게시글 날짜

	

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

	public int getPricePoint() {
		return pricePoint;
	}

	public void setPricePoint(int pricePoint) {
		this.pricePoint = pricePoint;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
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

	public int getNoticePostNumber() {
		return noticePostNumber;
	}

	public void setNoticePostNumber(int noticePostNumber) {
		this.noticePostNumber = noticePostNumber;
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

	@Override
	public String toString() {
		return "MainDTO [gameId=" + gameId + ", homeTeamName=" + homeTeamName + ", stadiumName=" + stadiumName
				+ ", awayTeamName=" + awayTeamName + ", scheduleDate=" + scheduleDate + ", sellPostNumber="
				+ sellPostNumber + ", sellPostTitle=" + sellPostTitle + ", sellPostCreationDate=" + sellPostCreationDate
				+ ", pricePoint=" + pricePoint + ", attachmentPath=" + attachmentPath + ", teamRank=" + teamRank
				+ ", teamName=" + teamName + ", gameCount=" + gameCount + ", teamWin=" + teamWin + ", teamDraw="
				+ teamDraw + ", teamLose=" + teamLose + ", teamWinRate=" + teamWinRate + ", teamWinLoss=" + teamWinLoss
				+ ", noticePostNumber=" + noticePostNumber + ", noticePostTitle=" + noticePostTitle
				+ ", noticePostDate=" + noticePostDate + "]";
	}

}
