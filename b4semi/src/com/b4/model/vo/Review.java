package com.b4.model.vo;


import oracle.sql.TIMESTAMP;

public class Review {

	private int reviewSeq;
	private int memberSeq;
	private String productCode;
	private String review;
	private String reviewContents;
	private TIMESTAMP reviewDate;
	private TIMESTAMP DeleteDate;
	private int reviewScore;
}
