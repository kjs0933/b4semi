package com.b4.model.vo;

public class Cart {
	
	private int memberSeq;
	private String productName;
	private String productCode;
	private int displayListSeq;
	private int productCount;
	private String discountCode;
	private int displayOptionPrice;
	private boolean optionAvailable;
	private String discountName;
	private double discountRate;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int memberSeq, String productName, String productCode, int displayListSeq, int productCount) {
		super();
		this.memberSeq = memberSeq;
		this.productName = productName;
		this.productCode = productCode;
		this.displayListSeq = displayListSeq;
		this.productCount = productCount;
	}

	public Cart(int memberSeq, String productName, String productCode, int displayListSeq, int productCount,
			String discountCode, int displayOptionPrice, boolean optionAvailable, String discountName,
			double discountRate) {
		super();
		this.memberSeq = memberSeq;
		this.productName = productName;
		this.productCode = productCode;
		this.displayListSeq = displayListSeq;
		this.productCount = productCount;
		this.discountCode = discountCode;
		this.displayOptionPrice = displayOptionPrice;
		this.optionAvailable = optionAvailable;
		this.discountName = discountName;
		this.discountRate = discountRate;
	}
	
	
	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public int getDisplayOptionPrice() {
		return displayOptionPrice;
	}

	public void setDisplayOptionPrice(int displayOptionPrice) {
		this.displayOptionPrice = displayOptionPrice;
	}

	public boolean isOptionAvailable() {
		return optionAvailable;
	}

	public void setOptionAvailable(boolean optionAvailable) {
		this.optionAvailable = optionAvailable;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getDisplayListSeq() {
		return displayListSeq;
	}

	public void setDisplayListSeq(int displayListSeq) {
		this.displayListSeq = displayListSeq;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "Cart [memberSeq=" + memberSeq + ", productName=" + productName + ", productCode=" + productCode
				+ ", displayListSeq=" + displayListSeq + ", productCount=" + productCount + ", discountCode="
				+ discountCode + ", displayOptionPrice=" + displayOptionPrice + ", optionAvailable=" + optionAvailable
				+ ", discountName=" + discountName + ", discountRate=" + discountRate + "]";
	}

	
	
	

}
