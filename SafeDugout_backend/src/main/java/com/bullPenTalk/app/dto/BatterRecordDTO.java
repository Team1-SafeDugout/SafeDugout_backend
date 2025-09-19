package com.bullPenTalk.app.dto;

import com.google.gson.annotations.SerializedName;

public class BatterRecordDTO {
	@SerializedName("순위")
	private int playerNumber; // 번호
	@SerializedName("선수명")
	private String plyerName; // 선수 이름
	@SerializedName("팀명")
	private String teamName; // 팀명
	@SerializedName("AVG")
	private double avg; // 타율
	@SerializedName("G")
	private int game; // 경기수
	@SerializedName("PA")
	private int pa; // 타석
	@SerializedName("AB")
	private int ab; // 타수
	@SerializedName("R")
	private int r; // 득점
	@SerializedName("H")
	private int h; // 안타
	@SerializedName("2B")
	private int doublehit; // 2루타
	@SerializedName("3B")
	private int triplehit; // 3루타
	@SerializedName("HR")
	private int hr; // 홈런
	@SerializedName("TB")
	private int tb; // 루타
	@SerializedName("RIB")
	private int rib; // 타점
	@SerializedName("SAC")
	private int sac; // 희생번트
	@SerializedName("SF")
	private int sf; // 희생플라이
	
	// get, set
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getPlyerName() {
		return plyerName;
	}
	public void setPlyerName(String plyerName) {
		this.plyerName = plyerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
	public int getPa() {
		return pa;
	}
	public void setPa(int pa) {
		this.pa = pa;
	}
	public int getAb() {
		return ab;
	}
	public void setAb(int ab) {
		this.ab = ab;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getDoublehit() {
		return doublehit;
	}
	public void setDoublehit(int doublehit) {
		this.doublehit = doublehit;
	}
	public int getTriplehit() {
		return triplehit;
	}
	public void setTriplehit(int triplehit) {
		this.triplehit = triplehit;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getTb() {
		return tb;
	}
	public void setTb(int tb) {
		this.tb = tb;
	}
	public int getRib() {
		return rib;
	}
	public void setRib(int rib) {
		this.rib = rib;
	}
	public int getSac() {
		return sac;
	}
	public void setSac(int sac) {
		this.sac = sac;
	}
	public int getSf() {
		return sf;
	}
	public void setSf(int sf) {
		this.sf = sf;
	}
	
	// toString
	@Override
	public String toString() {
		return "BatterRecordDTO [playerNumber=" + playerNumber + ", plyerName=" + plyerName + ", teamName=" + teamName
				+ ", avg=" + avg + ", game=" + game + ", pa=" + pa + ", ab=" + ab + ", r=" + r + ", h=" + h
				+ ", doublehit=" + doublehit + ", triplehit=" + triplehit + ", hr=" + hr + ", tb=" + tb + ", rib=" + rib
				+ ", sac=" + sac + ", sf=" + sf + "]";
	}	

}
