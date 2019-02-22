package com.b4.model.vo;

public class Images {
	
	private String renameFile;
	private String originalFile;
	private String boardCode;
	private int boardNo;
	
	public Images() {
		// TODO Auto-generated constructor stub
	}

	public Images(String renameFile, String originalFile, String boardCode, int boardNo) {
		super();
		this.renameFile = renameFile;
		this.originalFile = originalFile;
		this.boardCode = boardCode;
		this.boardNo = boardNo;
	}

	public String getRenameFile() {
		return renameFile;
	}

	public void setRenameFile(String renameFile) {
		this.renameFile = renameFile;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Images [renameFile=" + renameFile + ", originalFile=" + originalFile + ", boardCode=" + boardCode
				+ ", boardNo=" + boardNo + "]";
	}
	
	

}
