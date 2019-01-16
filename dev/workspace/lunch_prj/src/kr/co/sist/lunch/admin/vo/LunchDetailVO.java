package kr.co.sist.lunch.admin.vo;

public class LunchDetailVO {

	private String lunchCode, lunchName, input_date, spec, img;
	private int price;
	
	public LunchDetailVO() {
	}
	
	public LunchDetailVO(String lunchCode, String lunchName, String input_date, String spec, int price, String img) {
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.input_date = input_date;
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
	public String getInput_date() {
		return input_date;
	}
	public String getSpec() {
		return spec;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "LunchDetailVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", input_date=" + input_date
				+ ", spec=" + spec + ", img=" + img + ", price=" + price + "]";
	}
}
