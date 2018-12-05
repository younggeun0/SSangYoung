package date181126;

public class Ramen {

	private String name;
	private int price;
	
	// 숙제 기본 생성자 만들기
	public Ramen() {
		this("무명 라면",0);
	}
	// 인자있는 생성자 만들기
	public Ramen(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	public void cook() {
		System.out.printf("%d원짜리 %s 라면을 조리합니다.", price, name);
		System.out.println();
	}
}
