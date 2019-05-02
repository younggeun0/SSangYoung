package kr.co.sist.domain;

public class ItemDomain {
	
	private String itemNo, item;
	
	public ItemDomain() {
	}
	
	public ItemDomain(String itemNo, String item) {
		this.itemNo = itemNo;
		this.item = item;
	}
	
	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}
