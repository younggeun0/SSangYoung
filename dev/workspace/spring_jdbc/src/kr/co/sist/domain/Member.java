package kr.co.sist.domain;

public class Member {

	private int num;
	private String name, img;

	public Member() {
	}
	
	public Member(int num, String name, String img) {
		this.num = num;
		this.name = name;
		this.img = img;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
