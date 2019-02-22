package com.b4.model.vo;

public class DPOptionCount {
	
	private int displayListSeq;
	private int count;
	
	public DPOptionCount() {
		// TODO Auto-generated constructor stub
	}

	public DPOptionCount(int displayListSeq, int count) {
		super();
		this.displayListSeq = displayListSeq;
		this.count = count;
	}

	public int getDisplayListSeq() {
		return displayListSeq;
	}

	public void setDisplayListSeq(int displayListSeq) {
		this.displayListSeq = displayListSeq;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DPOptionCount [displayListSeq=" + displayListSeq + ", count=" + count + "]";
	}
	
	

}
