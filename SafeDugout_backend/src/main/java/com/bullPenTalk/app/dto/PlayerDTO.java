package com.bullPenTalk.app.dto;

public class PlayerDTO { // 선수
//	CREATE TABLE TBL_PLAYER(
//	PLAYER_NUMBER NUMBER,
//	TEAM_NUMBER NUMBER NOT NULL,
//	PLAYER_POSITION VARCHAR2(15) NOT NULL,
//	PLAYER_NAME VARCHAR2(30) NOT NULL,
//	CONSTRAINT PK_PLAYER PRIMARY KEY(PLAYER_NUMBER),
//	CONSTRAINT FK_PLAYER_TEAM FOREIGN KEY(TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	private int playerNumber; // 선수 번호
	private int teamNumber; // 팀 번호
	private String playerPosition; // 포지션(투수,타자)
	private String playerName; // 선수 이름
	
	// get, set
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	// toString
	@Override
	public String toString() {
		return "PlayerDTO [playerNumber=" + playerNumber + ", teamNumber=" + teamNumber + ", playerPosition="
				+ playerPosition + ", playerName=" + playerName + "]";
	}
	
	

}
