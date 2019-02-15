package com.b4.model.vo;

import java.sql.Timestamp;


public class Notice {
	
	private int noticeSeq;
	private int memberSeq;
	private String noticeTitle;
	private String noticeContents;
	private Timestamp noticeDate;
	private Timestamp noticeDeleteDate;
	private int noticeReadCount;
	private String noticeOriginalFilename;
	private String noticeRenameFilename;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int noticeSeq, int memberSeq, String noticeTitle, String noticeContents, Timestamp noticeDate,
			Timestamp noticeDeleteDate, int noticeReadCount, String noticeOriginalFilename,
			String noticeRenameFilename) {
		super();
		this.noticeSeq = noticeSeq;
		this.memberSeq = memberSeq;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.noticeDate = noticeDate;
		this.noticeDeleteDate = noticeDeleteDate;
		this.noticeReadCount = noticeReadCount;
		this.noticeOriginalFilename = noticeOriginalFilename;
		this.noticeRenameFilename = noticeRenameFilename;
	}

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public Timestamp getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Timestamp getNoticeDeleteDate() {
		return noticeDeleteDate;
	}

	public void setNoticeDeleteDate(Timestamp noticeDeleteDate) {
		this.noticeDeleteDate = noticeDeleteDate;
	}

	public int getNoticeReadCount() {
		return noticeReadCount;
	}

	public void setNoticeReadCount(int noticeReadCount) {
		this.noticeReadCount = noticeReadCount;
	}

	public String getNoticeOriginalFilename() {
		return noticeOriginalFilename;
	}

	public void setNoticeOriginalFilename(String noticeOriginalFilename) {
		this.noticeOriginalFilename = noticeOriginalFilename;
	}

	public String getNoticeRenameFilename() {
		return noticeRenameFilename;
	}

	public void setNoticeRenameFilename(String noticeRenameFilename) {
		this.noticeRenameFilename = noticeRenameFilename;
	}

	@Override
	public String toString() {
		return "Notice [noticeSeq=" + noticeSeq + ", memberSeq=" + memberSeq + ", noticeTitle=" + noticeTitle
				+ ", noticeContents=" + noticeContents + ", noticeDate=" + noticeDate + ", noticeDeleteDate="
				+ noticeDeleteDate + ", noticeReadCount=" + noticeReadCount + ", noticeOriginalFilename="
				+ noticeOriginalFilename + ", noticeRenameFilename=" + noticeRenameFilename + "]";
	}
	
	
}
