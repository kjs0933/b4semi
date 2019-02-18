package com.b4.model.vo;

import java.sql.Timestamp;

public class Review {

	private int reviewSeq;
	private int memberSeq;
	private String reviewTitle;
	private String reviewContent;
	private Timestamp reviewDate;
	private Timestamp reviewDeleteDate;
	private int reviewScore;
	private String productCode;
	private int displayListSeq;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewSeq, int memberSeq, String reviewTitle, String reviewContent, Timestamp reviewDate,
			Timestamp reviewDeleteDate, int reviewScore, String productCode, int displayListSeq) {
		super();
		this.reviewSeq = reviewSeq;
		this.memberSeq = memberSeq;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewDeleteDate = reviewDeleteDate;
		this.reviewScore = reviewScore;
		this.productCode = productCode;
		this.displayListSeq = displayListSeq;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Timestamp getReviewDeleteDate() {
		return reviewDeleteDate;
	}

	public void setReviewDeleteDate(Timestamp reviewDeleteDate) {
		this.reviewDeleteDate = reviewDeleteDate;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getDisplayListSeq() {
		return displayListSeq;
	}

	public void setDisplayListSeq(int displayListSeq) {
		this.displayListSeq = displayListSeq;
	}

	@Override
	public String toString() {
		return "Review [reviewSeq=" + reviewSeq + ", memberSeq=" + memberSeq + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", reviewDeleteDate="
				+ reviewDeleteDate + ", reviewScore=" + reviewScore + ", productCode=" + productCode
				+ ", displayListSeq=" + displayListSeq + "]";
	}

	
}
