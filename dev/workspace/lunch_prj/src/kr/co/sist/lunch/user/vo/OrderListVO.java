package kr.co.sist.lunch.user.vo;

public class OrderListVO {
	
	private String lunchName, input_date;
	private int quantity;
	
	public OrderListVO(String lunchName, String input_date, int quantity) {
		this.lunchName = lunchName;
		this.input_date = input_date;
		this.quantity = quantity;
	}

	public String getLunchName() {
		return lunchName;
	}
	public String getInput_date() {
		return input_date;
	}
	public int getQuantity() {
		return quantity;
	}
}
