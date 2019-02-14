package dataGen;

// 상품 추가시 필요한 추가 정보들을 담기 위한 객체
public class ProductPrice {
	
	String productCode;
	String productName;
	int inPrice; //기본 입고가
	int outPrice; //기본 출고가
	int dayLife; // 유통기한 지속일 - 날짜 단위
	int dpNo; // 디스플레이 넘버 - 동일한 숫자를 넣으면 세부옵션으로 선택하게 됨
	
	public ProductPrice(String productCode, String productName, int inPrice, int outPrice, int dayLife, int dpNo) {
		this.productCode = productCode;
		this.productName = productName;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.dayLife = dayLife;
		this.dpNo = dpNo;
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
	public int getInPrice() {
		return inPrice;
	}
	public void setInPrice(int inPrice) {
		this.inPrice = inPrice;
	}
	public int getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(int outPrice) {
		this.outPrice = outPrice;
	}
	public int getDayLife() {
		return dayLife;
	}
	public void setDayLife(int dayLife) {
		this.dayLife = dayLife;
	}
	public int getDpNo() {
		return dpNo;
	}
	public void setDpNo(int dpNo) {
		this.dpNo = dpNo;
	}
	
	
	
	
	

}
