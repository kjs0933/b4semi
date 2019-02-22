package com.b4.model.vo;

//장바구니, DPList 모달창에 표시하기 위한 객체
public class DPOption {
	
	private String productCode;
	private int displayListSeq;
	private String discountCode;
	private int displayOptionPrice;
	private String OptionAvailable;
	private String discountName;
	private double discountRate;
	private String productName;
	private String productUnit;
	
	public DPOption() {
		// TODO Auto-generated constructor stub
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

	public String getOptionAvailable() {
		return OptionAvailable;
	}

	public void setOptionAvailable(String optionAvailable) {
		OptionAvailable = optionAvailable;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

}
