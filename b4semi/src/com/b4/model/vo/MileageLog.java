package com.b4.model.vo;

import java.sql.Timestamp;

public class MileageLog {
	
	private int MileageLogSeq;
	private int MemberSeq;
	private Timestamp logDate;
	private int preMileage;
	private int nextMileage;
	private String logTypeName;
	private String mileageLogType;
	
	public MileageLog() {}

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

	public String getMileageLogType() {
		return mileageLogType;
	}

	public void setMileageLogType(String mileageLogType) {
		this.mileageLogType = mileageLogType;
	}

	@Override
	public String toString() {
		return "MileageLog [MileageLogSeq=" + MileageLogSeq + ", MemberSeq=" + MemberSeq + ", logDate=" + logDate
				+ ", preMileage=" + preMileage + ", nextMileage=" + nextMileage + ", logTypeName=" + logTypeName
				+ ", mileageLogType=" + mileageLogType + "]";
	}
	
	
}
