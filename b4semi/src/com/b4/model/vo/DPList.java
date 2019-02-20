package com.b4.model.vo;

import java.sql.Timestamp;

public class DPList {
	
	private int displayListSeq;
	private String displayListTitle;
	private String displayListContents;
	private String DPListAvailable;
	private Timestamp displayDate;
	private String DPListOriginalFileName;
	private String DPListRenameFilename;
	
	public DPList() {
		// TODO Auto-generated constructor stub
	}

	public DPList(int displayListSeq, String displayListTitle, String displayListContents, String dPListAvailable,
			Timestamp displayDate, String dPListOriginalFileName, String dPListRenameFilename) {
		super();
		this.displayListSeq = displayListSeq;
		this.displayListTitle = displayListTitle;
		this.displayListContents = displayListContents;
		DPListAvailable = dPListAvailable;
		this.displayDate = displayDate;
		DPListOriginalFileName = dPListOriginalFileName;
		DPListRenameFilename = dPListRenameFilename;
	}

	public int getDisplayListSeq() {
		return displayListSeq;
	}

	public void setDisplayListSeq(int displayListSeq) {
		this.displayListSeq = displayListSeq;
	}

	public String getDisplayListTitle() {
		return displayListTitle;
	}

	public void setDisplayListTitle(String displayListTitle) {
		this.displayListTitle = displayListTitle;
	}

	public String getDisplayListContents() {
		return displayListContents;
	}

	public void setDisplayListContents(String displayListContents) {
		this.displayListContents = displayListContents;
	}

	public String getDPListAvailable() {
		return DPListAvailable;
	}

	public void setDPListAvailable(String dPListAvailable) {
		DPListAvailable = dPListAvailable;
	}

	public Timestamp getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(Timestamp displayDate) {
		this.displayDate = displayDate;
	}

	public String getDPListOriginalFileName() {
		return DPListOriginalFileName;
	}

	public void setDPListOriginalFileName(String dPListOriginalFileName) {
		DPListOriginalFileName = dPListOriginalFileName;
	}

	public String getDPListRenameFilename() {
		return DPListRenameFilename;
	}

	public void setDPListRenameFilename(String dPListRenameFilename) {
		DPListRenameFilename = dPListRenameFilename;
	}

	@Override
	public String toString() {
		return "DPList [displayListSeq=" + displayListSeq + ", displayListTitle=" + displayListTitle
				+ ", displayListContents=" + displayListContents + ", DPListAvailable=" + DPListAvailable
				+ ", displayDate=" + displayDate + ", DPListOriginalFileName=" + DPListOriginalFileName
				+ ", DPListRenameFilename=" + DPListRenameFilename + "]";
	}

			}
