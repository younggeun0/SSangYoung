package kr.co.sist.lunch.user.vo;

public class OrderAddVO {
	
	private String orderName, phone, ipAddress, lunchCode;
	private int quan;
	
	public OrderAddVO(String orderName, String phone, String ipAddress, String lunchCode, int quan) {
		this.orderName = orderName;
		this.phone = phone;
		this.ipAddress = ipAddress;
		this.lunchCode = lunchCode;
		this.quan = quan;
	}
	public String getOrderName() {
		return orderName;
	}
	public String getPhone() {
		return phone;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public String getLunchCode() {
		return lunchCode;
	}
	public int getQuan() {
		return quan;
	}
}
