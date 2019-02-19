package com.b4.model.vo;


import java.sql.Timestamp;

public class QueryBoard {
	
	private int querySeq;
	private int memberSeq;
	private String queryTitle;
	private String queryContents;
	private Timestamp queryDate;
	private Timestamp queryDeleteDate;
	private int orderSeq;

	public QueryBoard() {
		// TODO Auto-generated constructor stub
	}

	public QueryBoard(int querySeq, int memberSeq, String queryTitle, String queryContents, Timestamp queryDate,
			Timestamp queryDeleteDate, int orderSeq) {
		super();
		this.querySeq = querySeq;
		this.memberSeq = memberSeq;
		this.queryTitle = queryTitle;
		this.queryContents = queryContents;
		this.queryDate = queryDate;
		this.queryDeleteDate = queryDeleteDate;
		this.orderSeq = orderSeq;
	}

	public int getQuerySeq() {
		return querySeq;
	}

	public void setQuerySeq(int querySeq) {
		this.querySeq = querySeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getQueryTitle() {
		return queryTitle;
	}

	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}

	public String getQueryContents() {
		return queryContents;
	}

	public void setQueryContents(String queryContents) {
		this.queryContents = queryContents;
	}

	public Timestamp getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Timestamp queryDate) {
		this.queryDate = queryDate;
	}

	public Timestamp getQueryDeleteDate() {
		return queryDeleteDate;
	}

	public void setQueryDeleteDate(Timestamp queryDeleteDate) {
		this.queryDeleteDate = queryDeleteDate;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	@Override
	public String toString() {
		return "QueryBoard [querySeq=" + querySeq + ", memberSeq=" + memberSeq + ", queryTitle=" + queryTitle
				+ ", queryContents=" + queryContents + ", queryDate=" + queryDate + ", queryDeleteDate="
				+ queryDeleteDate + ", orderSeq=" + orderSeq + "]";
	}
	
	
	}
