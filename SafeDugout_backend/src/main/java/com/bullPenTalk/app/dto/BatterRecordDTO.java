package com.bullPenTalk.app.dto;

public class BatterRecordDTO {
//	CREATE TABLE TBL_BATTER_RECORD (
//	PLAYER_NUMBER         NUMBER NOT NULL,
//	BATTER_SEASON_YEAR    DATE NOT NULL,
//	BATTER_GAMES          NUMBER,
//	AB                    NUMBER,
//	PA                    NUMBER,
//	RBI                   NUMBER,
//	HITS                  NUMBER,
//	DOUBLE_HIT            NUMBER,
//	TRIPLE_HIT            NUMBER,
//	HOME_RUN              NUMBER,
//	BATTER_BB             NUMBER,
//	IBB                   NUMBER,
//	BATTER_HBP            NUMBER,
//	SO                    NUMBER,
//	GDP                   NUMBER,
//	SRBI                  NUMBER,
//	OPS                   NUMBER,
//	SB                    NUMBER,
//	CONSTRAINT PK_BATTER_RECORD PRIMARY KEY (PLAYER_NUMBER, BATTER_SEASON_YEAR),
//	CONSTRAINT FK_BATTER_PLAYER FOREIGN KEY (PLAYER_NUMBER) REFERENCES TBL_PLAYER(PLAYER_NUMBER)
//	);

	
	private int playerNumber; 
	private String batterSeasonYear;
	private int batterGames; 
	private int AB;
	private int PA; 
	private int RBI; 
	private int Hits;
	private int DoubleHit;
	private int TripleHit; 
	private int HomeRun; 
	private int batterBB;
	private int IBB; 
	private int batterHBP;
	private int SO; 
	private int GDP; 
	private int SRBI;
	private int OPS; 
	private int SB;
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getBatterSeasonYear() {
		return batterSeasonYear;
	}
	public void setBatterSeasonYear(String batterSeasonYear) {
		this.batterSeasonYear = batterSeasonYear;
	}
	public int getBatterGames() {
		return batterGames;
	}
	public void setBatterGames(int batterGames) {
		this.batterGames = batterGames;
	}
	public int getAB() {
		return AB;
	}
	public void setAB(int aB) {
		AB = aB;
	}
	public int getPA() {
		return PA;
	}
	public void setPA(int pA) {
		PA = pA;
	}
	public int getRBI() {
		return RBI;
	}
	public void setRBI(int rBI) {
		RBI = rBI;
	}
	public int getHits() {
		return Hits;
	}
	public void setHits(int hits) {
		Hits = hits;
	}
	public int getDoubleHit() {
		return DoubleHit;
	}
	public void setDoubleHit(int doubleHit) {
		DoubleHit = doubleHit;
	}
	public int getTripleHit() {
		return TripleHit;
	}
	public void setTripleHit(int tripleHit) {
		TripleHit = tripleHit;
	}
	public int getHomeRun() {
		return HomeRun;
	}
	public void setHomeRun(int homeRun) {
		HomeRun = homeRun;
	}
	public int getBatterBB() {
		return batterBB;
	}
	public void setBatterBB(int batterBB) {
		this.batterBB = batterBB;
	}
	public int getIBB() {
		return IBB;
	}
	public void setIBB(int iBB) {
		IBB = iBB;
	}
	public int getBatterHBP() {
		return batterHBP;
	}
	public void setBatterHBP(int batterHBP) {
		this.batterHBP = batterHBP;
	}
	public int getSO() {
		return SO;
	}
	public void setSO(int sO) {
		SO = sO;
	}
	public int getGDP() {
		return GDP;
	}
	public void setGDP(int gDP) {
		GDP = gDP;
	}
	public int getSRBI() {
		return SRBI;
	}
	public void setSRBI(int sRBI) {
		SRBI = sRBI;
	}
	public int getOPS() {
		return OPS;
	}
	public void setOPS(int oPS) {
		OPS = oPS;
	}
	public int getSB() {
		return SB;
	}
	public void setSB(int sB) {
		SB = sB;
	}
	
	@Override
	public String toString() {
		return "BatterRecordDTO [playerNumber=" + playerNumber + ", batterSeasonYear=" + batterSeasonYear
				+ ", batterGames=" + batterGames + ", AB=" + AB + ", PA=" + PA + ", RBI=" + RBI + ", Hits=" + Hits
				+ ", DoubleHit=" + DoubleHit + ", TripleHit=" + TripleHit + ", HomeRun=" + HomeRun + ", batterBB="
				+ batterBB + ", IBB=" + IBB + ", batterHBP=" + batterHBP + ", SO=" + SO + ", GDP=" + GDP + ", SRBI="
				+ SRBI + ", OPS=" + OPS + ", SB=" + SB + "]";
	}

}
