package com.b4.model.vo;

public class MemberGrade {
	
	private String memberGradeCode;
	private String memberGradeName;
	private double gradeRate;
	
	public MemberGrade() {
		// TODO Auto-generated constructor stub
	}

	public MemberGrade(String memberGradeCode, String memberGradeName, int gradeRate) {
		super();
		this.memberGradeCode = memberGradeCode;
		this.memberGradeName = memberGradeName;
		this.gradeRate = gradeRate;
	}

	public String getMemberGradeCode() {
		return memberGradeCode;
	}

	public void setMemberGradeCode(String memberGradeCode) {
		this.memberGradeCode = memberGradeCode;
	}

	public String getMemberGradeName() {
		return memberGradeName;
	}

	public void setMemberGradeName(String memberGradeName) {
		this.memberGradeName = memberGradeName;
	}
	
	public double getGradeRate() {
		return gradeRate;
	}

	public void setGradeRate(double gradeRate) {
		this.gradeRate = gradeRate;
	}
	
	@Override
	public String toString() {
		return "MemberGrade [memberGradeCode=" + memberGradeCode + ", memberGradeName=" + memberGradeName
				+ ", gradeRate=" + gradeRate + "]";
	}
	
	
	
	

}
