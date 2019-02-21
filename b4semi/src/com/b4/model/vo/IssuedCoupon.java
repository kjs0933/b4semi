package com.b4.model.vo;

import java.sql.Timestamp;

public class IssuedCoupon {
	
	private int couponSeq;
	private int memberSeq;
	private String couponName;
	private boolean isUsed;
	private Timestamp issueDate;
	private Timestamp expiryDate;
	
	public IssuedCoupon() {
		// TODO Auto-generated constructor stub
	}

	public IssuedCoupon(int couponSeq, int memberSeq, String couponName, boolean isUsed, Timestamp issueDate,
			Timestamp expiryDate) {
		super();
		this.couponSeq = couponSeq;
		this.memberSeq = memberSeq;
		this.couponName = couponName;
		this.isUsed = isUsed;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
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

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
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

	@Override
	public String toString() {
		return "IssuedCoupon [couponSeq=" + couponSeq + ", memberSeq=" + memberSeq + ", couponName=" + couponName
				+ ", isUsed=" + isUsed + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate + "]";
	}
	
	

}
