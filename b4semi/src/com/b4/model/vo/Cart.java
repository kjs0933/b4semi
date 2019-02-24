package com.b4.model.vo;

public class Cart extends DPOption {

	private int productCount; // DB에 저장된 갯수를 가져올때만 필요
	private String displayListTitle;
	private String dpListAvailable;
	private String img;
	
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
	
	
}
