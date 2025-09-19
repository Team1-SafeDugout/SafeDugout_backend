package com.bullPenTalk.app.dto;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.JsonAdapter;
import com.bullPenTalk.app.adapter.IPFractionAdapter;

public class PitcherRecordDTO { // 선수 투수 기록

	@SerializedName("순위")
	private int playerNumber; // 번호
	@SerializedName("선수명")
	private String playerName; // 선수명
	@SerializedName("팀명")
	private String teamName; // 팀명
	@SerializedName("ERA")
	private double era; // 자책점
	@SerializedName("G")
	private int game; // 경기수
	@SerializedName("W")
	private int w; // 승
	@SerializedName("L")
	private int l; // 패
	@SerializedName("SV")
	private int sv; // 세이브
	@SerializedName("HLD")
	private int hld; // 홀드
	@SerializedName("승률")
	private double wpct; // 승률
	@SerializedName("IP")
    @JsonAdapter(IPFractionAdapter.class) // Custom adapter for 'IP' field
	private double ip; // 이닝
	@SerializedName("H")
	private int h; // 피안타
	@SerializedName("HR")
	private int hr; // 피홈런
	@SerializedName("BB")
	private int bb; // 볼넷
	@SerializedName("HBP")
	private int hbp; // 사구
	@SerializedName("SO")
	private int so; // 삼진
	@SerializedName("R")
	private int r; // 실점
	@SerializedName("ER")
	private int er; // 자책점
	@SerializedName("WHIP")
	private double whip; // 이닝당 출루허용률
	
	// get,set
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getEra() {
		return era;
	}
	public void setEra(double era) {
		this.era = era;
	}
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game = game;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public int getSv() {
		return sv;
	}
	public void setSv(int sv) {
		this.sv = sv;
	}
	public int getHld() {
		return hld;
	}
	public void setHld(int hld) {
		this.hld = hld;
	}
	public double getWpct() {
		return wpct;
	}
	public void setWpct(double wpct) {
		this.wpct = wpct;
	}
	public double getIp() {
		return ip;
	}
	public void setIp(double ip) {
		this.ip = ip;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getBb() {
		return bb;
	}
	public void setBb(int bb) {
		this.bb = bb;
	}
	public int getHbp() {
		return hbp;
	}
	public void setHbp(int hbp) {
		this.hbp = hbp;
	}
	public int getSo() {
		return so;
	}
	public void setSo(int so) {
		this.so = so;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getEr() {
		return er;
	}
	public void setEr(int er) {
		this.er = er;
	}
	public double getWhip() {
		return whip;
	}
	public void setWhip(double whip) {
		this.whip = whip;
	}
	
	//toString
	@Override
	public String toString() {
		return "PitcherRecordDTO [playerNumber=" + playerNumber + ", playerName=" + playerName + ", teamName="
				+ teamName + ", era=" + era + ", game=" + game + ", w=" + w + ", l=" + l + ", sv=" + sv + ", hld=" + hld
				+ ", wpct=" + wpct + ", ip=" + String.format("%.1f", ip) + ", h=" + h + ", hr=" + hr + ", bb=" + bb + ", hbp=" + hbp + ", so="
				+ so + ", r=" + r + ", er=" + er + ", whip=" + whip + "]";
	}
}
