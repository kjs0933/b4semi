package com.b4.model.vo;

public class Supplier {
	
	private String supplierCode;
	private String supplierName;
	private String supplierPhone;
	private String supplierAddress;
	private String supplierEmail;
	
	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(String supplierCode, String supplierName, String supplierPhone, String supplierAddress,
			String supplierEmail) {
		super();
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.supplierPhone = supplierPhone;
		this.supplierAddress = supplierAddress;
		this.supplierEmail = supplierEmail;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	@Override
	public String toString() {
		return "Supplier [supplierCode=" + supplierCode + ", supplierName=" + supplierName + ", supplierPhone="
				+ supplierPhone + ", supplierAddress=" + supplierAddress + ", supplierEmail=" + supplierEmail + "]";
	}
	
	

}
