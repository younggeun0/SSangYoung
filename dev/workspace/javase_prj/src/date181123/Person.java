package date181123;

/**
 * 사람을 추상화하여 만든 클래스<br>
 * 명사적 특징 : 눈, 코, 입, 이름<br>
 * 동사적 특징 : 먹는다
 * 
 * @author owner
 */
public class Person {

	private int eye, nose, mouth;	// 눈코입
	private String name;			// 이름
	
	/**
	 * 사람클래스의 기본 생성자<br>
	 * 눈 2개, 코 1개, 입 1개를 가진 사람 객체를 생성
	 * 11-26-2018 코드 추가
	 */
	public Person() {
		this(2, 1, 1);
//		eye = 2;
//		nose = 1;
//		mouth = 1;
	}
	
	/**
	 * 눈 2개, 코 1개, 입 1개가 아닌 사람 객체를 생성할 때 사용하는 생성자
	 * @param eye 눈의 수
	 * @param nose 코의 수
	 * @param mouth 입의 수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}

	/**
	 * 생성된 사람 객체의 눈의 갯수를 설정하는 일<br>
	 * 설정할 눈의 갯수는 최대 3개까지 설정할 수 있다.<br>
	 * 3개가 넘어가면 2개로 설정된다.
	 * @param eye 설정할 눈의 수
	 */
	public void setEye(int eye) {
		if (eye > 3) {
			this.eye = 2;
		} else {
			this.eye = eye;
		}
	}
	/**
	 * 생성된 사람 객체의 코의 갯수를 설정하는 일
	 * 
	 * @param nose 설정할 코의 수
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}
	/**
	 * 생성된 사람 객체의 입의 갯수를 설정하는 일
	 * 
	 * @param mouth 설정할 입의 수
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	/**
	 * 생성된 사람 객체에 이름을 설정하는 일
	 * 
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 생성된 사람 객체의 눈의 수를 반환하는 일
	 * 
	 * @return 현재 객체가 가진 눈의 수
	 */
	public int getEye() {
		return eye;
	}
	/** 
	 * 생성된 사람 객체의 코의 수를 반환하는 일 
	 * @return 현재 객체가 가진 코의 수
	 */
	public int getNose() {
		return nose;
	}
	/**
	 * 생성된 사람 객체의 입의 수를 반환 일
	 * 
	 * @return 현재 객체가 가진 입의수
	 */
	public int getMouth() {
		return mouth;
	}
	/**
	 * 생성된 사람 객체의 이름을 반환하는 일
	 * 
	 * @return 현재 객체의 이름 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 동사적 특징 <br>
	 * 생성된 사람 객체가 집에서 밥을 먹는 일을 구현
	 * 
	 * @return 결과
	 */
	public String eat() {
		return name+"이(가) 집에서 밥을 먹는다.";
	}
	
	/**
	 * method overload : 다형성 - 같은 이름의 메소드를 
	 * 여러개 정의하는 방법<br>
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
