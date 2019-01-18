package kr.co.sist.lunch.user.vo;

public class LunchDetailVO {

	private String lunchCode, lunchName, img, spec; 
	private int price;
	
	public LunchDetailVO(String lunchCode, String lunchName, String img, String spec, int price) {
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.img = img;
		this.spec = spec;
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

	public String getSpec() {
		return spec;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "LunchDetailVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", img=" + img + ", spec=" + spec
				+ ", price=" + price + "]";
	}
}
