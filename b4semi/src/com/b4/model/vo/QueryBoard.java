package com.b4.model.vo;

import oracle.sql.TIMESTAMP;

public class QueryBoard {
	
	private int querySeq;
	private int memberSeq;
	private String queryTitle;
	private String queryContents;
	private TIMESTAMP queryDate;
	private TIMESTAMP queryDeleteDate;

	public QueryBoard() {
		// TODO Auto-generated constructor stub
	}

	public QueryBoard(int querySeq, int memberSeq, String queryTitle, String queryContents, TIMESTAMP queryDate,
			TIMESTAMP queryDeleteDate) {
		super();
		this.querySeq = querySeq;
		this.memberSeq = memberSeq;
		this.queryTitle = queryTitle;
		this.queryContents = queryContents;
		this.queryDate = queryDate;
		this.queryDeleteDate = queryDeleteDate;
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

	public TIMESTAMP getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(TIMESTAMP queryDate) {
		this.queryDate = queryDate;
	}

	public TIMESTAMP getQueryDeleteDate() {
		return queryDeleteDate;
	}

	public void setQueryDeleteDate(TIMESTAMP queryDeleteDate) {
		this.queryDeleteDate = queryDeleteDate;
	}

	@Override
	public String toString() {
		return "QueryBoard [querySeq=" + querySeq + ", memberSeq=" + memberSeq + ", queryTitle=" + queryTitle
				+ ", queryContents=" + queryContents + ", queryDate=" + queryDate + ", queryDeleteDate="
				+ queryDeleteDate + "]";
	}
	
	
}
