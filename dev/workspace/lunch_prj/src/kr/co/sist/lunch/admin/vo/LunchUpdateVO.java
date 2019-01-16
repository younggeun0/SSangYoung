package kr.co.sist.lunch.admin.vo;

public class LunchUpdateVO {

	private String lunchCode, lunchName, spec, img;
	private int price;
	
	public LunchUpdateVO() {
	}
	
	public LunchUpdateVO(String lunchCode, String lunchName, String spec, int price, String img) {
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.spec = spec;
		this.price = price;
		this.img = img;
	}

	public String getImg() {
		return img;
	}
	public String getLunchCode() {
		return lunchCode;
	}
	public String getLunchName() {
		return lunchName;
	}
	public String getSpec() {
		return spec;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "LunchUpdateVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", spec=" + spec + ", img=" + img
				+ ", price=" + price + "]";
	}
}
