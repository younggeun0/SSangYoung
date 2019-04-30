package kr.co.sist.domain;

public class Lunch {

	private String lunch_code, lunch_name, img, input_date;
	private int price;
	
	public String getLunch_code() {
		return lunch_code;
	}
	public void setLunch_code(String lunch_code) {
		this.lunch_code = lunch_code;
	}
	public String getLunch_name() {
		return lunch_name;
	}
	public void setLunch_name(String lunch_name) {
		this.lunch_name = lunch_name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
