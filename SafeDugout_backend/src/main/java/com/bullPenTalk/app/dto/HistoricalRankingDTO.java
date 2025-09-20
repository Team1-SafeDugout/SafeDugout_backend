package com.bullPenTalk.app.dto;

public class HistoricalRankingDTO {
	// team_Number NUMBER NOT NULL,
	// ranking_year NUMBER NOT NULL,
	// games_played NUMBER NOT NULL,
	// wins NUMBER NOT NULL,
	// losses NUMBER NOT NULL,
	// draws NUMBER NOT NULL,
	// winning_percentage NUMBER NOT NULL,
	// final_rank NUMBER NOT NULL,

	private int teamNumber;
	private int rankingYear;
	private int gamesPlayed;
	private int wins;
	private int losses;
	private int draws;
	private double winningPercentage;
	private int finalRank;

	// get, set
	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public int getRankingYear() {
		return rankingYear;
	}

	public void setRankingYear(int rankingYear) {
		this.rankingYear = rankingYear;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public double getWinningPercentage() {
		return winningPercentage;
	}

	public void setWinningPercentage(double winningPercentage) {
		this.winningPercentage = winningPercentage;
	}

	public int getFinalRank() {
		return finalRank;
	}

	public void setFinalRank(int finalRank) {
		this.finalRank = finalRank;
	}

	// toString
	@Override
	public String toString() {
		return "HistoricalRankingDTO [teamNumber=" + teamNumber + ", rankingYear=" + rankingYear + ", gamesPlayed="
				+ gamesPlayed + ", wins=" + wins + ", losses=" + losses + ", draws=" + draws + ", winningPercentage="
				+ winningPercentage + ", finalRank=" + finalRank + "]";
	}

}
