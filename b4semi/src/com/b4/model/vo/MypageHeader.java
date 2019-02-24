package com.b4.model.vo;

public class MypageHeader {

	private int memberSeq;
	private String memberName;
	private String memberGradeCode;
	private String memberGradeName;
	private int memberMileage;
	private double gradeRate;
	private int couponCount;
	
	public MypageHeader () {}

	public MypageHeader(int memberSeq, String memberName, String memberGradeCode, String memberGradeName, int memberMileage, double gradeRate,
			int couponCount) {
		super();
		this.memberSeq = memberSeq;
		this.memberName = memberName;
		this.memberGradeCode = memberGradeCode;
		this.memberGradeName = memberGradeName;
		this.memberMileage = memberMileage;
		this.gradeRate = gradeRate;
		this.couponCount = couponCount;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGradeName() {
		return memberGradeName;
	}

	public void setMemberGradeName(String memberGradeName) {
		this.memberGradeName = memberGradeName;
	}

	public int getMemberMileage() {
		return memberMileage;
	}

	public void setMemberMileage(int memberMileage) {
		this.memberMileage = memberMileage;
	}

	public double getGradeRate() {
		return gradeRate;
	}

	public void setGradeRate(double gradeRate) {
		this.gradeRate = gradeRate;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	public String getMemberGradeCode() {
		return memberGradeCode;
	}

	public void setMemberGradeCode(String memberGradeCode) {
		this.memberGradeCode = memberGradeCode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
