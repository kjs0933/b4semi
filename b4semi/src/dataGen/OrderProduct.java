package dataGen;

public class OrderProduct {
	private ProductPrice pp;
	private int productCount;
	private int cancelCount;
	private boolean review;
	
	public OrderProduct () {}

	public ProductPrice getpp() {
		return pp;
	}

	public void setpp(ProductPrice pp) {
		this.pp = pp;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getCancelCount() {
		return cancelCount;
	}

	public void setCancelCount(int cancelCount) {
		this.cancelCount = cancelCount;
	}

	public boolean isReview() {
		return review;
	}

	public void setReview(boolean review) {
		this.review = review;
	}
	
	
	

}
