package com.b4.model.vo;


import java.sql.Timestamp;
import java.util.List;

public class QueryBoard {
   
   private int querySeq;
   private int memberSeq;
   private String queryTitle;
   private String queryContents;
   private Timestamp queryDate;
   private Timestamp queryDeleteDate;
   private int orderSeq;
   private List<QueryComment> list;
   
   public QueryBoard() {}
   
   public QueryBoard(int querySeq, int memberSeq, String queryTitle, String queryContents, Timestamp queryDate,
         Timestamp queryDeleteDate, int orderSeq, List<QueryComment> list) {
      super();
      this.querySeq = querySeq;
      this.memberSeq = memberSeq;
      this.queryTitle = queryTitle;
      this.queryContents = queryContents;
      this.queryDate = queryDate;
      this.queryDeleteDate = queryDeleteDate;
      this.orderSeq = orderSeq;
      this.list = list;
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
   public List<QueryComment> getList() {
      return list;
   }
   public void setList(List<QueryComment> list) {
      this.list = list;
   }
   
}