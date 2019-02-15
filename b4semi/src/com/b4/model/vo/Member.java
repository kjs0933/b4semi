package com.b4.model.vo;

import java.util.Date;

public class Member {
	
	private int memberSeq;
	private String memberId;
	private String memberGradeName;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberComment;
	private Date memberEnrollDate;
	private Date memberQuitDate;
	private int memberMileage;
	
	public Member() {}

	public Member(int memberSeq, String memberId, String memberGradeName, String memberPw, String memberName,
			String memberEmail, String memberPhone, String memberComment, Date memberEnrollDate, Date memberQuitDate,
			int memberMileage) {
		super();
		this.memberSeq = memberSeq;
		this.memberId = memberId;
		this.memberGradeName = memberGradeName;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberComment = memberComment;
		this.memberEnrollDate = memberEnrollDate;
		this.memberQuitDate = memberQuitDate;
		this.memberMileage = memberMileage;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberGradeName() {
		return memberGradeName;
	}

	public void setMemberGradeName(String memberGradeName) {
		this.memberGradeName = memberGradeName;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberComment() {
		return memberComment;
	}

	public void setMemberComment(String memberComment) {
		this.memberComment = memberComment;
	}

	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

	public Date getMemberQuitDate() {
		return memberQuitDate;
	}

	public void setMemberQuitDate(Date memberQuitDate) {
		this.memberQuitDate = memberQuitDate;
	}

	public int getMemberMileage() {
		return memberMileage;
	}

	public void setMemberMileage(int memberMileage) {
		this.memberMileage = memberMileage;
	}

	@Override
	public String toString() {
		return "Member [memberSeq=" + memberSeq + ", memberId=" + memberId + ", memberGradeName=" + memberGradeName
				+ ", memberPw=" + memberPw + ", memberName=" + memberName + ", memberEmail=" + memberEmail
				+ ", memberPhone=" + memberPhone + ", memberComment=" + memberComment + ", memberEnrollDate="
				+ memberEnrollDate + ", memberQuitDate=" + memberQuitDate + ", memberMileage=" + memberMileage + "]";
	}
	
	
	
	}


