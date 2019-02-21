package com.b4.model.vo;

public class DPOption {
	
	private String productCode;
	private int displayListSeq;
	private String discountCode;
	private int displayOptionPrice;
	private String OptionAvailable;
	
	public DPOption() {
		// TODO Auto-generated constructor stub
	}

	public DPOption(String productCode, int displayListSeq, String discountCode, int displayOptionPrice,
			String optionAvailable) {
		super();
		this.productCode = productCode;
		this.displayListSeq = displayListSeq;
		this.discountCode = discountCode;
		this.displayOptionPrice = displayOptionPrice;
		OptionAvailable = optionAvailable;
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

	@Override
	public String toString() {
		return "DPOption [productCode=" + productCode + ", displayListSeq=" + displayListSeq + ", discountCode="
				+ discountCode + ", displayOptionPrice=" + displayOptionPrice + ", OptionAvailable=" + OptionAvailable
				+ "]";
	}
	
	

}
