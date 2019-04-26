package kr.co.sist.domain;

public class DetailMember {

	private String name, img, loc, highschool;

	public DetailMember() {
	}
	
	public DetailMember(String name, String img, String loc, String highschool) {
		this.name = name;
		this.img = img;
		this.loc = loc;
		this.highschool = highschool;
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

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getHighschool() {
		return highschool;
	}

	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
}
