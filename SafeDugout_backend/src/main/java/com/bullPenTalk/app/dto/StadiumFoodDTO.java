package com.bullPenTalk.app.dto;

public class StadiumFoodDTO {
//	CREATE TABLE TBL_STADIUM_FOOD (
//	FOOD_ID         NUMBER PRIMARY KEY,
//	FOOD_NAME       VARCHAR2(200) NOT NULL,
//	FOOD_LOCATION   VARCHAR2(100) NOT NULL,
//	FOOD_TIP        VARCHAR2(200) NOT NULL,
//	STADIUM_NUMBER  NUMBER NOT NULL,
//	CONSTRAINT FK_FOOD_STADIUM FOREIGN KEY (STADIUM_NUMBER) REFERENCES TBL_STADIUM(STADIUM_NUMBER)ON DELETE CASCADE
//	);
	
	private int foodId;
	private String foodName;
	private String foodLocation;
	private String foodTip;
	private int stadiumNumber;
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
	public int getStadiumNumber() {
		return stadiumNumber;
	}
	public void setStadiumNumber(int stadiumNumber) {
		this.stadiumNumber = stadiumNumber;
	}
	
	@Override
	public String toString() {
		return "StadiumFoodDTO [foodId=" + foodId + ", foodName=" + foodName + ", foodLocation=" + foodLocation
				+ ", foodTip=" + foodTip + ", stadiumNumber=" + stadiumNumber + "]";
	}
	
	
}
