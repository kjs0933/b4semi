package com.b4.model.vo;

public class Category {

	private String majorCode; //카테고리 링크 걸 때 major 쿼리스트링 값
	private String subCode; //카테고리 링크 걸 때 miner 쿼리스트링 값
	private String CategoryName;
	
	public Category () {}
	
	public Category(String majorCode, String subCode, String categoryName) {
		this.majorCode = majorCode;
		this.subCode = subCode;
		CategoryName = categoryName;
	}
	
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
}
