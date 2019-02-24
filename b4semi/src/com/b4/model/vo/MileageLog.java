package com.b4.model.vo;

import java.sql.Timestamp;

public class MileageLog {

	private int mileageLogSeq;
	private String mileageLogType;
	private String logTypeName;
	private int memberSeq;
	private Timestamp logDate;
	private int preMileage;
	private int nextMileage;
	
	public MileageLog() {
		// TODO Auto-generated constructor stub
	}

	public MileageLog(int mileageLogSeq, String mileageLogType, String logTypeName, int memberSeq, Timestamp logDate,
			int preMileage, int nextMileage) {
		super();
		this.mileageLogSeq = mileageLogSeq;
		this.mileageLogType = mileageLogType;
		this.logTypeName = logTypeName;
		this.memberSeq = memberSeq;
		this.logDate = logDate;
		this.preMileage = preMileage;
		this.nextMileage = nextMileage;
	}

	public int getMileageLogSeq() {
		return mileageLogSeq;
	}

	public void setMileageLogSeq(int mileageLogSeq) {
		this.mileageLogSeq = mileageLogSeq;
	}

	public String getMileageLogType() {
		return mileageLogType;
	}

	public void setMileageLogType(String mileageLogType) {
		this.mileageLogType = mileageLogType;
	}

	public String getLogTypeName() {
		return logTypeName;
	}

	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
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

	@Override
	public String toString() {
		return "MileageLog [mileageLogSeq=" + mileageLogSeq + ", mileageLogType=" + mileageLogType + ", logTypeName="
				+ logTypeName + ", memberSeq=" + memberSeq + ", logDate=" + logDate + ", preMileage=" + preMileage
				+ ", nextMileage=" + nextMileage + "]";
	}
	
	
	
}
