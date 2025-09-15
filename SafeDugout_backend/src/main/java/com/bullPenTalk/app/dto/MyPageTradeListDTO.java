package com.bullPenTalk.app.dto;

import java.sql.Date;
import java.util.List;

public class MyPageTradeListDTO { // 마이페이지 판매글 리스트
	
	private String title;	// 글제목
	private String dealType; // 거래 방식
	private String tradeStatus; // 거래 상태
	
	private String pricePoint; // 가격
	
	private Date addDate; // 
	private Date buyDate;
	private Date confirmDate;
	
	private int sellerMemberNumber;
	private String sellerMemberId;
	
	private int buyerMemberNumber;
	private String buyerMemberId;
	
	private int sellPostNumber;
	private int tradePostNumber;
	
	private List<AttachmentDTO> attachment;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getPricePoint() {
		return pricePoint;
	}

	public void setPricePoint(String pricePoint) {
		this.pricePoint = pricePoint;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public int getSellerMemberNumber() {
		return sellerMemberNumber;
	}

	public void setSellerMemberNumber(int sellerMemberNumber) {
		this.sellerMemberNumber = sellerMemberNumber;
	}

	public String getSellerMemberId() {
		return sellerMemberId;
	}

	public void setSellerMemberId(String sellerMemberId) {
		this.sellerMemberId = sellerMemberId;
	}

	public int getBuyerMemberNumber() {
		return buyerMemberNumber;
	}

	public void setBuyerMemberNumber(int buyerMemberNumber) {
		this.buyerMemberNumber = buyerMemberNumber;
	}

	public String getBuyerMemberId() {
		return buyerMemberId;
	}

	public void setBuyerMemberId(String buyerMemberId) {
		this.buyerMemberId = buyerMemberId;
	}

	public int getSellPostNumber() {
		return sellPostNumber;
	}

	public void setSellPostNumber(int sellPostNumber) {
		this.sellPostNumber = sellPostNumber;
	}

	public int getTradePostNumber() {
		return tradePostNumber;
	}

	public void setTradePostNumber(int tradePostNumber) {
		this.tradePostNumber = tradePostNumber;
	}

	public List<AttachmentDTO> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentDTO> attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "MyPageProductInfoDTO [title=" + title + ", dealType=" + dealType + ", tradeStatus=" + tradeStatus
				+ ", pricePoint=" + pricePoint + ", addDate=" + addDate + ", buyDate=" + buyDate + ", confirmDate="
				+ confirmDate + ", sellerMemberNumber=" + sellerMemberNumber + ", sellerMemberId=" + sellerMemberId
				+ ", buyerMemberNumber=" + buyerMemberNumber + ", buyerMemberId=" + buyerMemberId + ", sellPostNumber="
				+ sellPostNumber + ", tradePostNumber=" + tradePostNumber + ", attachment=" + attachment + "]";
	}
}
