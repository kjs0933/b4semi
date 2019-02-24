package com.b4.model.vo;

import java.sql.Timestamp;

public class OrderList {

	private int orderSeq;
	private int couponSeq;
	private int memberSeq;
	private String orderStatusCode;
	private int spentMileage;
	private String receiverName;
	private String receiverAddress;
	private String receiverPhone;
	private String receiverComment;
	private String shipmentNo;
	private int totalPrice;
	private int cancelprice;
	private Timestamp orderTime;
	private int shipmentFee;
	
	public OrderList() {
		// TODO Auto-generated constructor stub
	}

	public OrderList(int orderSeq, int couponSeq, int memberSeq, String orderStatusCode, int spentMileage,
			String receiverName, String receiverAddress, String receiverPhone, String receiverComment,
			String shipmentNo, int totalPrice, int cancelprice, Timestamp orderTime, int shipmentFee) {
		super();
		this.orderSeq = orderSeq;
		this.couponSeq = couponSeq;
		this.memberSeq = memberSeq;
		this.orderStatusCode = orderStatusCode;
		this.spentMileage = spentMileage;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverPhone = receiverPhone;
		this.receiverComment = receiverComment;
		this.shipmentNo = shipmentNo;
		this.totalPrice = totalPrice;
		this.cancelprice = cancelprice;
		this.orderTime = orderTime;
		this.shipmentFee = shipmentFee;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public int getCouponSeq() {
		return couponSeq;
	}

	public void setCouponSeq(int couponSeq) {
		this.couponSeq = couponSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public int getSpentMileage() {
		return spentMileage;
	}

	public void setSpentMileage(int spentMileage) {
		this.spentMileage = spentMileage;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverComment() {
		return receiverComment;
	}

	public void setReceiverComment(String receiverComment) {
		this.receiverComment = receiverComment;
	}

	public String getShipmentNo() {
		return shipmentNo;
	}

	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCancelprice() {
		return cancelprice;
	}

	public void setCancelprice(int cancelprice) {
		this.cancelprice = cancelprice;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public int getShipmentFee() {
		return shipmentFee;
	}

	public void setShipmentFee(int shipmentFee) {
		this.shipmentFee = shipmentFee;
	}

	@Override
	public String toString() {
		return "OrderList [orderSeq=" + orderSeq + ", couponSeq=" + couponSeq + ", memberSeq=" + memberSeq
				+ ", orderStatusCode=" + orderStatusCode + ", spentMileage=" + spentMileage + ", receiverName="
				+ receiverName + ", receiverAddress=" + receiverAddress + ", receiverPhone=" + receiverPhone
				+ ", receiverComment=" + receiverComment + ", shipmentNo=" + shipmentNo + ", totalPrice=" + totalPrice
				+ ", cancelprice=" + cancelprice + ", orderTime=" + orderTime + ", shipmentFee=" + shipmentFee + "]";
	}

	
}