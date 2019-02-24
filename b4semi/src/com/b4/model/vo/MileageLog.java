package com.b4.model.vo;

import java.sql.Timestamp;

public class MileageLog {
	
	private int MileageLogSeq;
	private int MemberSeq;
	private Timestamp logDate;
	private int preMileage;
	private int nextMileage;
	private String logTypeName;
	
	public MileageLog() {}
	
	public MileageLog(int mileageLogSeq, int memberSeq, Timestamp logDate, int preMileage, int nextMileage,
			String logTypeName) {
		super();
		MileageLogSeq = mileageLogSeq;
		MemberSeq = memberSeq;
		this.logDate = logDate;
		this.preMileage = preMileage;
		this.nextMileage = nextMileage;
		this.logTypeName = logTypeName;
	}
	
	public int getMileageLogSeq() {
		return MileageLogSeq;
	}
	public void setMileageLogSeq(int mileageLogSeq) {
		MileageLogSeq = mileageLogSeq;
	}
	public int getMemberSeq() {
		return MemberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		MemberSeq = memberSeq;
	}
	public Timestamp getLogDate() {
		return logDate;
	}
	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}
	public int getPreMileage() {
		return preMileage;
	}
	public void setPreMileage(int preMileage) {
		this.preMileage = preMileage;
	}
	public int getNextMileage() {
		return nextMileage;
	}
	public void setNextMileage(int nextMileage) {
		this.nextMileage = nextMileage;
	}
	public String getLogTypeName() {
		return logTypeName;
	}
	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}
	
}
