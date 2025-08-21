package com.bullPenTalk.app.dto;

public class ChampionshipRecordDTO {
//	CREATE TABLE TBL_CHAMPIONSHIP_RECORD (
//	TEAM_NUMBER       NUMBER NOT NULL,
//	SEASON_YEAR       NUMBER NOT NULL,
//	IS_CHAMPIONSHIP   CHAR(1) CHECK (IS_CHAMPIONSHIP IN ('Y', 'N')),
//	CONSTRAINT PK_CHAMPIONSHIP PRIMARY KEY (TEAM_NUMBER, SEASON_YEAR),
//	CONSTRAINT FK_CHAMPIONSHIP_TEAM FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)
//	);

	
	private int teamNumber; // 팀 번호
	private int seasonYear; // 시즌(년도)
	private boolean isChampionship; // 우승 여부  
	
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public int getSeasonYear() {
		return seasonYear;
	}
	public void setSeasonYear(int seasonYear) {
		this.seasonYear = seasonYear;
	}
	public boolean isChampionship() {
		return isChampionship;
	}
	public void setChampionship(boolean isChampionship) {
		this.isChampionship = isChampionship;
	}
	
	@Override
	public String toString() {
		return "ChampionshipRecordDTO [teamNumber=" + teamNumber + ", seasonYear=" + seasonYear + ", isChampionship="
				+ isChampionship + "]";
	}
	

}
