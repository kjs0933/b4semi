package com.b4.model.vo;

public class Product {
	
	private String productCode;
	private String supplierCode;
	private String productName;
	private String originCountry;
	private String subCategoryCode;
	private String productUnit;
	private String productOriginalFileName;
	private String productRenameFilename;
	private String majorCategoryCode;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String productCode, String supplierCode, String productName, String originCountry,
			String subCategoryCode, String productUnit, String productOriginalFileName, String productRenameFilename,
			String majorCategoryCode) {
		super();
		this.productCode = productCode;
		this.supplierCode = supplierCode;
		this.productName = productName;
		this.originCountry = originCountry;
		this.subCategoryCode = subCategoryCode;
		this.productUnit = productUnit;
		this.productOriginalFileName = productOriginalFileName;
		this.productRenameFilename = productRenameFilename;
		this.majorCategoryCode = majorCategoryCode;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getSupplierCode() {
		return supplierCode;
	}


	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getOriginCountry() {
		return originCountry;
	}


	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}


	public String getSubCategoryCode() {
		return subCategoryCode;
	}


	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}


	public String getProductUnit() {
		return productUnit;
	}


	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}


	public String getProductOriginalFileName() {
		return productOriginalFileName;
	}


	public void setProductOriginalFileName(String productOriginalFileName) {
		this.productOriginalFileName = productOriginalFileName;
	}


	public String getProductRenameFilename() {
		return productRenameFilename;
	}


	public void setProductRenameFilename(String productRenameFilename) {
		this.productRenameFilename = productRenameFilename;
	}


	public String getMajorCategoryCode() {
		return majorCategoryCode;
	}


	public void setMajorCategoryCode(String majorCategoryCode) {
		this.majorCategoryCode = majorCategoryCode;
	}


	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", supplierCode=" + supplierCode + ", productName=" + productName
				+ ", originCountry=" + originCountry + ", subCategoryCode=" + subCategoryCode + ", productUnit="
				+ productUnit + ", productOriginalFileName=" + productOriginalFileName + ", productRenameFilename="
				+ productRenameFilename + ", majorCategoryCode=" + majorCategoryCode + "]";
	}


	
	
	
		}
