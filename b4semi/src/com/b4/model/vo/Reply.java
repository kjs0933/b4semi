package com.b4.model.vo;

import java.sql.Timestamp;

public class Reply {
	
	private int commentSeq;
	private int boardSeq;
	private int memberSeq;
	private int commentRef;
	private Timestamp commentDate;
	private String commentText;
	private int commentLevel;
	private Timestamp commentDeleteDate;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int commentSeq, int boardSeq, int memberSeq, int commentRef, Timestamp commentDate, String commentText,
			int commentLevel, Timestamp commentDeleteDate) {
		super();
		this.commentSeq = commentSeq;
		this.boardSeq = boardSeq;
		this.memberSeq = memberSeq;
		this.commentRef = commentRef;
		this.commentDate = commentDate;
		this.commentText = commentText;
		this.commentLevel = commentLevel;
		this.commentDeleteDate = commentDeleteDate;
	}

	public int getCommentSeq() {
		return commentSeq;
	}

	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getCommentRef() {
		return commentRef;
	}

	public void setCommentRef(int commentRef) {
		this.commentRef = commentRef;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public Timestamp getCommentDeleteDate() {
		return commentDeleteDate;
	}

	public void setCommentDeleteDate(Timestamp commentDeleteDate) {
		this.commentDeleteDate = commentDeleteDate;
	}

	@Override
	public String toString() {
		return "Reply [commentSeq=" + commentSeq + ", boardSeq=" + boardSeq + ", memberSeq=" + memberSeq
				+ ", commentRef=" + commentRef + ", commentDate=" + commentDate + ", commentText=" + commentText
				+ ", commentLevel=" + commentLevel + ", commentDeleteDate=" + commentDeleteDate + "]";
	}
	
	
	

}
