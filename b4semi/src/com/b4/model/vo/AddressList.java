package com.b4.model.vo;

public class AddressList {

	private int addressSeq;
	private int memberSeq;
	private String addressTag;
	private String address;
	private String addressPhone;
	
	public AddressList() {
		// TODO Auto-generated constructor stub
	}

	public AddressList(int addressSeq, int memberSeq, String addressTag, String address, String addressPhone) {
		super();
		this.addressSeq = addressSeq;
		this.memberSeq = memberSeq;
		this.addressTag = addressTag;
		this.address = address;
		this.addressPhone = addressPhone;
	}

	public int getAddressSeq() {
		return addressSeq;
	}

	public void setAddressSeq(int addressSeq) {
		this.addressSeq = addressSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getAddressTag() {
		return addressTag;
	}

	public void setAddressTag(String addressTag) {
		this.addressTag = addressTag;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	@Override
	public String toString() {
		return "AddressList [addressSeq=" + addressSeq + ", memberSeq=" + memberSeq + ", addressTag=" + addressTag
				+ ", address=" + address + ", addressPhone=" + addressPhone + "]";
	}
	
	
	
	

}
