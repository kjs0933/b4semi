package dataGen;

// 상품 추가시 필요한 추가 정보들을 담기 위한 객체
public class ProductPrice {
	
	String productCode;
	String productName;
	int inPrice; //기본 입고가
	int outPrice; //기본 출고가
	int dayLife; // 유통기한 지속일 - 날짜 단위
	int dpNo; // 디스플레이 넘버 - 동일한 숫자를 넣으면 세부옵션으로 선택하게 됨
	String url; //이미지 경로 - null이면 이미지 저장 없음, "default" 이면 제품명.jpg
	String discountCode; //할인코드
	
	public ProductPrice(String productCode, String productName, int inPrice, int outPrice, int dayLife, int dpNo) {
		this.productCode = productCode;
		this.productName = productName;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.dayLife = dayLife;
		this.dpNo = dpNo;
		this.url = "default";
	}
	
	public ProductPrice(String productCode, String productName, int inPrice, int outPrice, int dayLife, int dpNo,
			String url) {
		this.productCode = productCode;
		this.productName = productName;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.dayLife = dayLife;
		this.dpNo = dpNo;
		this.url = url;
	}
	public ProductPrice(String productCode, String productName, int inPrice, int outPrice, int dayLife, int dpNo,
			String url, String discountCode) {
		this.productCode = productCode;
		this.productName = productName;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.dayLife = dayLife;
		this.dpNo = dpNo;
		this.url = url;
		this.discountCode = discountCode;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
}
