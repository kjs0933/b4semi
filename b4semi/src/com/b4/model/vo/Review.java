package com.b4.model.vo;

import java.sql.Timestamp;
import java.util.List;

public class Review {

	private int reviewSeq;
	private int memberSeq;
	private String reviewTitle;
	private String reviewContents;
	private Timestamp reviewDate;
	private Timestamp reviewDeleteDate;
	private int reviewScore;
	private String productCode;
	private int displayListSeq;
	private String memberId;
	private List<String> renameFiles; // 업로드 된 renameFile
	
	public Review() {}

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

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<String> getRenameFiles() {
		return renameFiles;
	}

	public void setRenameFiles(List<String> renameFiles) {
		this.renameFiles = renameFiles;
	}
}
