package com.bullPenTalk.app.dto;

public class MatchResultDTO {
//	CREATE TABLE TBL_MATCH_RESULT (
//	GAME_ID          NUMBER PRIMARY KEY,
//	HOME_TEAM_SCORE  NUMBER,
//	AWAY_TEAM_SCORE  NUMBER,
//	MATCH_RESULT     VARCHAR2(10),
//	CONSTRAINT FK_MATCH_GAME FOREIGN KEY (GAME_ID) REFERENCES TBL_GAME_SCHEDULE(GAME_ID)
//	);

	private int gameId; // 게임번호
	private int homeTeamScore; //홈팀 점수
	private int awayTeamScore; //어웨이팀 점수
	private String matchResult; //결과
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	public String getMatchResult() {
		return matchResult;
	}
	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
	
	@Override
	public String toString() {
		return "MatchResultDTO [gameId=" + gameId + ", homeTeamScore=" + homeTeamScore + ", awayTeamScore="
				+ awayTeamScore + ", matchResult=" + matchResult + "]";
	} 
	

}
