package com.bullPenTalk.app.dto;

public class PitcherRecordDTO { // 선수 투수 기록
//	CREATE TABLE TBL_PITCHER_RECORD (
//	PLAYER_NUMBER         NUMBER NOT NULL,
//	PITCHER_SEASON_YEAR   DATE NOT NULL,
//	PITCHER_GAMES         NUMBER,
//	CG                    NUMBER,
//	SHO                   NUMBER,
//	GS                    NUMBER,
//	WINS                  NUMBER,
//	LOSSES                NUMBER,
//	SAVES                 NUMBER,
//	HOLD                  NUMBER,
//	IP                    NUMBER,
//	RA                    NUMBER,
//	ER                    NUMBER,
//	ERA                   NUMBER,
//	HIT_ALLOWED           NUMBER,
//	HR_ALLOWED            NUMBER,
//	PITCHER_BB            NUMBER,
//	PITCHER_HBP           NUMBER,
//	BK                    NUMBER,
//	CONSTRAINT PK_PITCHER_RECORD PRIMARY KEY (PLAYER_NUMBER, PITCHER_SEASON_YEAR),
//	CONSTRAINT FK_PITCHER_PLAYER FOREIGN KEY (PLAYER_NUMBER) REFERENCES TBL_PLAYER(PLAYER_NUMBER)
//	);

	private int playerNumber; // 선수번호
	private String pitcherSeasonYear; // 시즌 연도
	private int pitcherGame; // 경기수
	private int cg; // 완투
	private int sho; // 완봉
	private int gs; // 선발 출장
	private int wins; // 승
	private int losses; // 패
	private int saves; // 세이브
	private int hold; // 홀드
	private double ip; // 이닝
	private int ra; // 실점
	private int er; // 자책점
	private double era; // 평균자책점
	private int hitallowed; // 피안타
	private int hrAllowed; // 피홈런
	private int pitcherBb; // 볼넷
	private int pitcherHbp; // 사구
	private int bk; // 보크
	
	// get, set
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getPitcherSeasonYear() {
		return pitcherSeasonYear;
	}
	public void setPitcherSeasonYear(String pitcherSeasonYear) {
		this.pitcherSeasonYear = pitcherSeasonYear;
	}
	public int getPitcherGame() {
		return pitcherGame;
	}
	public void setPitcherGame(int pitcherGame) {
		this.pitcherGame = pitcherGame;
	}
	public int getCg() {
		return cg;
	}
	public void setCg(int cg) {
		this.cg = cg;
	}
	public int getSho() {
		return sho;
	}
	public void setSho(int sho) {
		this.sho = sho;
	}
	public int getGs() {
		return gs;
	}
	public void setGs(int gs) {
		this.gs = gs;
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
	public int getSaves() {
		return saves;
	}
	public void setSaves(int saves) {
		this.saves = saves;
	}
	public int getHold() {
		return hold;
	}
	public void setHold(int hold) {
		this.hold = hold;
	}
	public double getIp() {
		return ip;
	}
	public void setIp(int ip) {
		this.ip = ip;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public int getEr() {
		return er;
	}
	public void setEr(int er) {
		this.er = er;
	}
	public double getEra() {
		return era;
	}
	public void setEra(int era) {
		this.era = era;
	}
	public int getHitallowed() {
		return hitallowed;
	}
	public void setHitallowed(int hitallowed) {
		this.hitallowed = hitallowed;
	}
	public int getHrAllowed() {
		return hrAllowed;
	}
	public void setHrAllowed(int hrAllowed) {
		this.hrAllowed = hrAllowed;
	}
	public int getPitcherBb() {
		return pitcherBb;
	}
	public void setPitcherBb(int pitcherBb) {
		this.pitcherBb = pitcherBb;
	}
	public int getPitcherHbp() {
		return pitcherHbp;
	}
	public void setPitcherHbp(int pitcherHbp) {
		this.pitcherHbp = pitcherHbp;
	}
	public int getBk() {
		return bk;
	}
	public void setBk(int bk) {
		this.bk = bk;
	}
	
	// toString
	@Override
	public String toString() {
		return "PitcherRecordDTO [playerNumber=" + playerNumber + ", pitcherSeasonYear=" + pitcherSeasonYear
				+ ", pitcherGame=" + pitcherGame + ", cg=" + cg + ", sho=" + sho + ", gs=" + gs + ", wins=" + wins
				+ ", losses=" + losses + ", saves=" + saves + ", hold=" + hold + ", ip=" + ip + ", ra=" + ra + ", er="
				+ er + ", era=" + era + ", hitallowed=" + hitallowed + ", hrAllowed=" + hrAllowed + ", pitcherBb="
				+ pitcherBb + ", pitcherHbp=" + pitcherHbp + ", bk=" + bk + "]";
	}
	

}
