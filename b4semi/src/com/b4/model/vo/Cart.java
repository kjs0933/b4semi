package com.b4.model.vo;

public class Cart{

	private int productCount; // DB에 저장된 갯수를 가져올때만 필요
	private String displayListTitle;
	private String dpListAvailable;
	private String img;
	private String productCode;
	private int displayListSeq;
	private int displayOptionPrice;
	private String OptionAvailable;
	private String discountName;
	private double discountRate;
	private String productName;
	private String productUnit;
	private int discountOptionPrice; //할인 가격
	
	public Cart() {}

	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getDisplayListTitle() {
		return displayListTitle;
	}
	public void setDisplayListTitle(String displayListTitle) {
		this.displayListTitle = displayListTitle;
	}
	public String getDpListAvailable() {
		return dpListAvailable;
	}
	public void setDpListAvailable(String dpListAvailable) {
		this.dpListAvailable = dpListAvailable;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public int getDiscountOptionPrice() {
		return discountOptionPrice;
	}
	public void setDiscountOptionPrice(int discountOptionPrice) {
		this.discountOptionPrice = discountOptionPrice;
	}
	public void setDiscountOptionPrice() {
		this.discountOptionPrice = (int)Math.round(displayOptionPrice*(1-discountRate)/10)*10;
	}

	@Override
	public String toString() {
		return "Cart [productCount=" + productCount + ", displayListTitle=" + displayListTitle + ", dpListAvailable="
				+ dpListAvailable + ", img=" + img + ", productCode=" + productCode + ", displayListSeq="
				+ displayListSeq + ", displayOptionPrice=" + displayOptionPrice + ", OptionAvailable=" + OptionAvailable
				+ ", discountName=" + discountName + ", discountRate=" + discountRate + ", productName=" + productName
				+ ", productUnit=" + productUnit + ", discountOptionPrice=" + discountOptionPrice + "]";
	}
	
}
