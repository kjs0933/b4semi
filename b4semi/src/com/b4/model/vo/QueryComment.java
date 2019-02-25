package com.b4.model.vo;

import java.sql.Timestamp;

public class QueryComment {
   
   private int commentSeq;
   private int boardeSeq;
   private int memberSeq;
   private String memberId;
   private int commentRef;
   private Timestamp commentDate;
   private String commentText;
   private Timestamp commentDeleteDate;
   
   public QueryComment() {}
   
   public QueryComment(int commentSeq, int boardeSeq, int memberSeq, String memberId, int commentRef, Timestamp commentDate,
         String commentText, Timestamp commentDeleteDate) {
      super();
      this.commentSeq = commentSeq;
      this.boardeSeq = boardeSeq;
      this.memberSeq = memberSeq;
      this.memberId = memberId;
      this.commentRef = commentRef;
      this.commentDate = commentDate;
      this.commentText = commentText;
      this.commentDeleteDate = commentDeleteDate;
   }
   public int getCommentSeq() {
      return commentSeq;
   }
   public void setCommentSeq(int commentSeq) {
      this.commentSeq = commentSeq;
   }
   public int getBoardeSeq() {
      return boardeSeq;
   }
   public void setBoardeSeq(int boardeSeq) {
      this.boardeSeq = boardeSeq;
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
   public Timestamp getCommentDeleteDate() {
      return commentDeleteDate;
   }
   public void setCommentDeleteDate(Timestamp commentDeleteDate) {
      this.commentDeleteDate = commentDeleteDate;
   }

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   
}
