package dataGen;

import java.util.ArrayList;

public class Order {
	
	private int memberSeq;
	private int totalPrice;
	private int cancelPrice;
	private long orderTime;
	
	public Order () {
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public void addTotalPrice(int price)
	{
		this.totalPrice += price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void addCancelPrice(int price)
	{
		this.cancelPrice += price;
	}

	public int getCancelPrice() {
		return cancelPrice;
	}

	public void setCancelPrice(int cancelPrice) {
		this.cancelPrice = cancelPrice;
	}


	public long getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}
	
	
	
	

}
