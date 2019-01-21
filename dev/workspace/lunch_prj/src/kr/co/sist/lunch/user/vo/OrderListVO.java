package kr.co.sist.lunch.user.vo;

public class OrderListVO {
	
	private String lunchName, order_date;
	private int quantity;
	
	public OrderListVO(String lunchName, String order_date, int quantity) {
		this.lunchName = lunchName;
		this.order_date = order_date;
		this.quantity = quantity;
	}
	
	public String getLunchName() {
		return lunchName;
	}
	public String getOrder_date() {
		return order_date;
	}
	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderListVO [lunchName=" + lunchName + ", order_date=" + order_date + ", quantity=" + quantity + "]";
	}
}
