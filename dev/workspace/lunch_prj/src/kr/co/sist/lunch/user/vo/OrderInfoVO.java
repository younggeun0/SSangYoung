package kr.co.sist.lunch.user.vo;

public class OrderInfoVO {
	
	private String orderName, orderTel;
	
	public OrderInfoVO() {
	}

	public OrderInfoVO(String orderName, String orderTel) {
		this.orderName = orderName;
		this.orderTel = orderTel;
	}

	public String getOrderName() {
		return orderName;
	}
	public String getOrderTel() {
		return orderTel;
	}
}
