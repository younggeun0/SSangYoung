package kr.co.sist.lunch.admin.vo;

public class LunchAddVO {
	
	private String lunchName, img, spec;
	private int price;
	
	public LunchAddVO(String lunchName, String img, String spec, int price) {
		this.lunchName = lunchName;
		this.img = img;
		this.spec = spec;
		this.price = price;
	}

	public String getLunchName() {
		return lunchName;
	}
	public String getImg() {
		return img;
	}
	public String getSpec() {
		return spec;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "LunchAddVO [lunchName=" + lunchName + ", img=" + img + ", spec=" + spec + ", price=" + price + "]";
	}
}
