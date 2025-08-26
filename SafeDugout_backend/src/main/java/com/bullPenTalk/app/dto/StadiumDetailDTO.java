package com.bullPenTalk.app.dto;

import java.util.List;

public class StadiumDetailDTO {

	private int stadiumNumber; // 대상 경기장 번호
	private String stadiumAddress; // 경기장 주소
	private String stadiumName; // 경기장 이름
	private int stadiumteamNumber; // 경기장 홈 팀
	private int foodId; // 음식 번호
	private String foodName; // 음식 이름
	private String foodLocation; // 경기장 내 음식 위치
	private String foodTip; // 음식 먹을 때 팁
	private int ticketId; // 티켓 번호	
	private int teamNumber; // 팀 번호
	private String seatName; // 좌석 이름
	private int weekdayPrice; // 주중 가격
	private int weekendPrice; // 주말 가격
	private String reservationSite; // 티켓 예매 사이트 주소

	//get, set
	public String getStadiumAddress() {
		return stadiumAddress;
	}
	public void setStadiumAddress(String stadiumAddress) {
		this.stadiumAddress = stadiumAddress;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public int getStadiumteamNumber() {
		return stadiumteamNumber;
	}
	public void setStadiumteamNumber(int stadiumteamNumber) {
		this.stadiumteamNumber = stadiumteamNumber;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodLocation() {
		return foodLocation;
	}
	public void setFoodLocation(String foodLocation) {
		this.foodLocation = foodLocation;
	}
	public String getFoodTip() {
		return foodTip;
	}
	public void setFoodTip(String foodTip) {
		this.foodTip = foodTip;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getStadiumNumber() {
		return stadiumNumber;
	}
	public void setStadiumNumber(int stadiumNumber) {
		this.stadiumNumber = stadiumNumber;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public int getWeekdayPrice() {
		return weekdayPrice;
	}
	public void setWeekdayPrice(int weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	public int getWeekendPrice() {
		return weekendPrice;
	}
	public void setWeekendPrice(int weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	public String getReservationSite() {
		return reservationSite;
	}
	public void setReservationSite(String reservationSite) {
		this.reservationSite = reservationSite;
	}
	
	// toString	
	@Override
	public String toString() {
		return "StadiumDetail [stadiumNumber=" + stadiumNumber + ", stadiumAddress=" + stadiumAddress + ", stadiumName="
				+ stadiumName + ", stadiumteamNumber=" + stadiumteamNumber + ", foodId=" + foodId + ", foodName="
				+ foodName + ", foodLocation=" + foodLocation + ", foodTip=" + foodTip + ", ticketId=" + ticketId
				+ ", teamNumber=" + teamNumber + ", seatName=" + seatName + ", weekdayPrice=" + weekdayPrice
				+ ", weekendPrice=" + weekendPrice + ", reservationSite=" + reservationSite  + "]";
	}
	
	

	
}
