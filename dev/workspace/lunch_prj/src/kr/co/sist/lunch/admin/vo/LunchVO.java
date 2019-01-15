package kr.co.sist.lunch.admin.vo;

public class LunchVO {
	
	private String lunchCode, lunchName, img;
	private int price;
	
	public LunchVO(String lunchCode, String lunchName, String img, int price) {
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.img = img;
		this.price = price;
	}

	public String getLunchCode() {
		return lunchCode;
	}
	public String getLunchName() {
		return lunchName;
	}
	public String getImg() {
		return img;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "LunchVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", img=" + img + ", price=" + price
				+ "]";
	}
}
