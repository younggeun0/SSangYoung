package date181129;

public class Person {

	private int eye, nose, mouth;	// 눈코입
	private String name;			// 이름
	
	public Person() {
		this(2, 1, 1);
	}
	
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}

	public void setEye(int eye) {
		if (eye > 3) {
			this.eye = 2;
		} else {
			this.eye = eye;
		}
	}
	public void setNose(int nose) {
		this.nose = nose;
	}
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getEye() {
		return eye;
	}
	public int getNose() {
		return nose;
	}
	public int getMouth() {
		return mouth;
	}
	public String getName() {
		return name;
	}
	
	/**
	 * 생성된 사람 객체가 집에서 밥을 먹는 일을 구현
	 * 
	 * @return 결과
	 */
	public String eat() {
		return name+"이(가) 집에서 밥을 먹는다.";
	}
	
	/**
	 * 생성된 사람 객체가 식당에서 주문한 음식을 먹는 일을 구현
	 * 
	 * @param menu 음식의 종류
	 * @param price 음식가격
	 * @return 결과
	 */
	public String eat(String menu, int price) {
		return name+"이(가) 식당에서 "+menu
				+"인 음식을 "+price+"원 내고 사먹는다.";
	}
}