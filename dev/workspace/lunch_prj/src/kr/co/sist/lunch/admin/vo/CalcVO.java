package kr.co.sist.lunch.admin.vo;

public class CalcVO {
	
	private String lunchCode, lunchName;
	private int price, total;
	
	public CalcVO(String lunchCode, String lunchName, int price, int total) {
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.price = price;
		this.total = total;
	}
	public String getLunchCode() {
		return lunchCode;
	}
	public String getLunchName() {
		return lunchName;
	}
	public int getPrice() {
		return price;
	}
	public int getTotal() {
		return total;
	}
	@Override
	public String toString() {
		return "CalcVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", price=" + price + ", total=" + total
				+ "]";
	}
}
