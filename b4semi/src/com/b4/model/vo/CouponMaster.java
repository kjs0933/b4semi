package com.b4.model.vo;

public class CouponMaster {
	
	private String couponCode;
	private String couponName;
	private double discountRate;
	private int minPrice;
	private int maxDisPrice;
	
	public CouponMaster() {
		// TODO Auto-generated constructor stub
	}

	public CouponMaster(String couponCode, String couponName, double discountRate, int minPrice, int maxDisPrice) {
		super();
		this.couponCode = couponCode;
		this.couponName = couponName;
		this.discountRate = discountRate;
		this.minPrice = minPrice;
		this.maxDisPrice = maxDisPrice;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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

	@Override
	public String toString() {
		return "CouponMaster [couponCode=" + couponCode + ", couponName=" + couponName + ", discountRate="
				+ discountRate + ", minPrice=" + minPrice + ", maxDisPrice=" + maxDisPrice + "]";
	}

	
	
}
