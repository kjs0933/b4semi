package com.b4.model.vo;

import java.sql.Timestamp;

public class IssuedCoupon {
	
	private String CouponCode;
	private int CouponSeq;
	private int memberSeq;
	private String isUsed;
	private Timestamp issueDate;
	private Timestamp expiryDate;
	private String couponName;
	private double discountRate;
	private int minPrice;
	private int maxDisPrice;

	public IssuedCoupon() {

	}

	public IssuedCoupon(String couponCode, int couponSeq, int memberSeq, String isUsed, Timestamp issueDate,
			Timestamp expiryDate, String couponName, double discountRate, int minPrice, int maxDisPrice) {
		super();
		CouponCode = couponCode;
		CouponSeq = couponSeq;
		this.memberSeq = memberSeq;
		this.isUsed = isUsed;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.couponName = couponName;
		this.discountRate = discountRate;
		this.minPrice = minPrice;
		this.maxDisPrice = maxDisPrice;
	}

	public String getCouponCode() {
		return CouponCode;
	}

	public void setCouponCode(String couponCode) {
		CouponCode = couponCode;
	}

	public int getCouponSeq() {
		return CouponSeq;
	}

	public void setCouponSeq(int couponSeq) {
		CouponSeq = couponSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public Timestamp getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxDisPrice() {
		return maxDisPrice;
	}

	public void setMaxDisPrice(int maxDisPrice) {
		this.maxDisPrice = maxDisPrice;
	}

}
