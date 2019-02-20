package com.b4.model.vo;

import java.sql.Timestamp;

public class InStock {
	
	private int instockSeq;
	private String productCode;
	private	Timestamp inStockDate;
	private int inStockCount;
	private int inStockPrice;
	private Timestamp expiryDate;
	private int remainStockCount;
	private int expiredStockCount;
	
	public InStock() {
		// TODO Auto-generated constructor stub
	}

	public InStock(int instockSeq, String productCode, Timestamp inStockDate, int inStockCount, int inStockPrice,
			Timestamp expiryDate, int remainStockCount, int expiredStockCount) {
		super();
		this.instockSeq = instockSeq;
		this.productCode = productCode;
		this.inStockDate = inStockDate;
		this.inStockCount = inStockCount;
		this.inStockPrice = inStockPrice;
		this.expiryDate = expiryDate;
		this.remainStockCount = remainStockCount;
		this.expiredStockCount = expiredStockCount;
	}

	public int getInstockSeq() {
		return instockSeq;
	}

	public void setInstockSeq(int instockSeq) {
		this.instockSeq = instockSeq;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Timestamp getInStockDate() {
		return inStockDate;
	}

	public void setInStockDate(Timestamp inStockDate) {
		this.inStockDate = inStockDate;
	}

	public int getInStockCount() {
		return inStockCount;
	}

	public void setInStockCount(int inStockCount) {
		this.inStockCount = inStockCount;
	}

	public int getInStockPrice() {
		return inStockPrice;
	}

	public void setInStockPrice(int inStockPrice) {
		this.inStockPrice = inStockPrice;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getRemainStockCount() {
		return remainStockCount;
	}

	public void setRemainStockCount(int remainStockCount) {
		this.remainStockCount = remainStockCount;
	}

	public int getExpiredStockCount() {
		return expiredStockCount;
	}

	public void setExpiredStockCount(int expiredStockCount) {
		this.expiredStockCount = expiredStockCount;
	}

	@Override
	public String toString() {
		return "InStock [instockSeq=" + instockSeq + ", productCode=" + productCode + ", inStockDate=" + inStockDate
				+ ", inStockCount=" + inStockCount + ", inStockPrice=" + inStockPrice + ", expiryDate=" + expiryDate
				+ ", remainStockCount=" + remainStockCount + ", expiredStockCount=" + expiredStockCount + "]";
	}
	
	
	

}
