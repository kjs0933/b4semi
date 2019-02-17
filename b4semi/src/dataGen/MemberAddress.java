package dataGen;

import com.b4.model.vo.Member;

public class MemberAddress extends Member {
	
	private String address;
	
	public MemberAddress () {}
	
	public void addMemberMileage(int price) {
		super.setMemberMileage(super.getMemberMileage()+price);
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
