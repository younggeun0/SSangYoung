package date181123;

public class Ramen {

	// 명사적 특징
	private String name;
	private int price;
	private int spicyLevel; 	// 매운강도  0:안매움, 1:조금매움 2:중간매움 3:매우매움
	private int soupNum;		// 스프 개수
	private int noodleLevel;	// 면 두께 0:얇음, 1:보통 2:두꺼움
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		if (price < 0 || price > 10000) {
			System.out.println("잘못된 가격입니다.");
		} else {
			this.price = price;
		}
	}
	public void setSpicyLevel(int spicyLevel) {
		if (spicyLevel < 4 || spicyLevel >= 0) {
			this.spicyLevel = spicyLevel;
		} else {
			System.out.println("매운정도는 0~3까지 있습니다.");
			System.out.println("0:안매움, 1:조금매움 2:중간매움 3:매우매움");
		}
	}
	public void setSoupNum(int soupNum) {
		if (soupNum > 4) {
			System.out.println("스프 개수가 5개 이상으로 너무 많습니다.");
			this.soupNum = 3;
		} else if (soupNum < 0){
			System.out.println("스프가 0개보다 적을 순 없습니다.");
			this.soupNum = 0;
		} else {
			this.soupNum = soupNum;
		}
	}
	public void setNoodleLevel(int noodleLevel) {
		if (noodleLevel < 3 || noodleLevel >= 0) {
			this.noodleLevel = noodleLevel;
		} else {
			System.out.println("면의 두께는 0~3까지 있습니다.");
			System.out.println("0:얇음, 1:보통 2:두꺼움");
		}
	}
	
	// getter
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getSpicyLevel() {
		return spicyLevel;
	}
	public int getSoupNum() {
		return soupNum;
	}
	public int getNoodleLevel() {
		return noodleLevel;
	}
	
	// 동사적 특징
	public String Cooked() {
		// 재료없이 조리하기
		String msg = name+" 라면은 "+checkSpicy()+"정도의 매움단계를 갖고 \n"
				+ "면발 두께는 "+checkNoodle()+"입니다.\n";
		
		return msg+" 라면을 조리 없이 먹기위해 뿌십니다.";
	}
	public String Cooked(int water, String... ingredients) {
		// 재료있게 조리하기
		String msg;
		
		msg = name+" 라면은 "+checkSpicy()+"정도의 매움단계를 갖고 \n"
				+ "면발 두께는 "+checkNoodle()+"입니다.\n";
		
		for (String ingredient : ingredients) {
			msg += ingredient+", ";
		}
		
		if (water > 500) {
			msg += "물 "+water+"ml만큼 넣고 조리합니다.\n"
					+ "물이 많아 싱거울것 같습니다..";
			
			return msg;
		} else if (water <= 500 || water >= 300) {

			msg += "물 "+water+"ml만큼 넣고 조리합니다.\n"
					+ "물이 적당한 것 같습니다!";
			return msg;
			
		} else {
			msg += "물 "+water+"ml만큼 넣고 조리합니다.\n"
					+ "물이 적어 짤 것 같습니다..";
			return msg;
		}
	}
	
	// 매움정도를 문자열로 반환하는 메소드
	private String checkSpicy() {
		// 매운강도  0:안매움, 1:조금매움 2:중간매움 3:매우매움
		switch(this.spicyLevel) {
		case 1:
			return "조금매움";
		case 2:
			return "중간매움";
		case 3:
			return "매우매움";
		default:
			return "안매움";
		}
	}
	
	// 면두께를 문자열로 반환하는 메소드
	private String checkNoodle() {
		// 면 두께 0:얇음, 1:보통 2:두꺼움
		switch(this.noodleLevel) {
		case 0:
			return "얇음";
		case 2:
			return "두꺼움";
		default :
			return "보통";
		}
	}
}
