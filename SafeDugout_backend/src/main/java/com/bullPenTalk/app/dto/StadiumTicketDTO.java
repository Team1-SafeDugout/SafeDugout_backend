package com.bullPenTalk.app.dto;

public class StadiumTicketDTO {
//	CREATE TABLE TBL_STADIUM_TICKET (
//	TICKET_ID        NUMBER PRIMARY KEY,
//	STADIUM_NUMBER   NUMBER NOT NULL,
//	TEAM_NUMBER      NUMBER NOT NULL,
//	SEAT_NAME        VARCHAR2(50) NOT NULL,
//	WEEKDAY_PRICE    NUMBER NOT NULL,
//	WEEKEND_PRICE    NUMBER NOT NULL,
//	RESERVATION_SITE VARCHAR2(50) NOT NULL,
//	CONSTRAINT FK_TICKET_STADIUM FOREIGN KEY (STADIUM_NUMBER) REFERENCES TBL_STADIUM(STADIUM_NUMBER) ON DELETE CASCADE,
//	CONSTRAINT FK_TICKET_TEAM FOREIGN KEY (TEAM_NUMBER) REFERENCES TBL_TEAM(TEAM_NUMBER)ON DELETE CASCADE
//	);

	
	private int ticketId; // 티켓 번호
	private int stadiumNumber; // 대상 경기장 번호
	private int teamNumber; // 팀 번호
	private String seatName; // 좌석 이름
	private int weekdayPrice; // 주중 가격
	private int weekendPrice; // 주말 가격
	private String reservationSite; // 티켓 예매 사이트 주소
	
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
	
	@Override
	public String toString() {
		return "StadiumTicketDTO [ticketId=" + ticketId + ", stadiumNumber=" + stadiumNumber + ", teamNumber="
				+ teamNumber + ", seatName=" + seatName + ", weekdayPrice=" + weekdayPrice + ", weekendPrice="
				+ weekendPrice + ", reservationSite=" + reservationSite + "]";
	}
	

}
