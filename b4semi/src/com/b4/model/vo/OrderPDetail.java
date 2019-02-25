package com.b4.model.vo;

public class OrderPDetail {
	
	private int orderSeq;
	private String productCode;
	private String productName;
	private int displayListSeq;
	private int orderProductCount;
	private String discountcode;
	private int displayOptionPrice;
	private String optionavailable;
	private int countByOrderList;
	
	public OrderPDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderPDetail(int orderSeq, String productCode, String productName, int displayListSeq, int orderProductCount,
			int countByOrderList) {
		super();
		this.orderSeq = orderSeq;
		this.productCode = productCode;
		this.productName = productName;
		this.displayListSeq = displayListSeq;
		this.orderProductCount = orderProductCount;
		this.countByOrderList = countByOrderList;
	}

	

	public String getDiscountcode() {
		return discountcode;
	}

	public void setDiscountcode(String discountcode) {
		this.discountcode = discountcode;
	}

	public int getDisplayOptionPrice() {
		return displayOptionPrice;
	}

	public void setDisplayOptionPrice(int displayOptionPrice) {
		this.displayOptionPrice = displayOptionPrice;
	}

	public String getOptionavailable() {
		return optionavailable;
	}

	public void setOptionavailable(String optionavailable) {
		this.optionavailable = optionavailable;
	}

	public OrderPDetail(int orderSeq, String productCode, String productName, int displayListSeq, int orderProductCount,
			String discountcode, int displayOptionPrice, String optionavailable, int countByOrderList) {
		super();
		this.orderSeq = orderSeq;
		this.productCode = productCode;
		this.productName = productName;
		this.displayListSeq = displayListSeq;
		this.orderProductCount = orderProductCount;
		this.discountcode = discountcode;
		this.displayOptionPrice = displayOptionPrice;
		this.optionavailable = optionavailable;
		this.countByOrderList = countByOrderList;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getDisplayListSeq() {
		return displayListSeq;
	}

	public void setDisplayListSeq(int displayListSeq) {
		this.displayListSeq = displayListSeq;
	}

	public int getOrderProductCount() {
		return orderProductCount;
	}

	public void setOrderProductCount(int orderProductCount) {
		this.orderProductCount = orderProductCount;
	}

	public int getCountByOrderList() {
		return countByOrderList;
	}

	public void setCountByOrderList(int countByOrderList) {
		this.countByOrderList = countByOrderList;
	}

	@Override
	public String toString() {
		return "OrderPDetail [orderSeq=" + orderSeq + ", productCode=" + productCode + ", productName=" + productName
				+ ", displayListSeq=" + displayListSeq + ", orderProductCount=" + orderProductCount
				+ ", countByOrderList=" + countByOrderList + "]";
	}
	
	

}