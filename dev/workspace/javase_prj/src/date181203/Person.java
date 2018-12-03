package date181203;

/**
 * Person을 일반클래스에서 abstract 클래스로 변경<br>
 * 모든 사람의 집에서 먹는일과 밖에서 사먹는일, 언어를 반드시 가진다.
 * @author owner
 */
public abstract class Person {

	private int eye, nose, mouth;	// 눈코입
	private String name;			// 이름
	private String[] language;		// 사람이 사용하는 언어
	
	
	/**
	 * 언어를 추가할 수 있도록 
	 */
	public Person() {
		this(2, 1, 1);
	}
	
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
		this.language = new String[10];
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
	public String[] getLanguage() {
		return language;
	}
	
	/**
	 * 생성된 사람 객체가 집에서 밥을 먹는 일을 구현
	 * 
	 * @return 결과
	 */
	public abstract String eat(); 
	
	/**
	 * 생성된 사람 객체가 식당에서 주문한 음식을 먹는 일을 구현
	 * 
	 * @param menu 음식의 종류
	 * @param price 음식가격
	 * @return 결과
	 */
	public abstract String eat(String menu, int price); /*{
		return name+"이(가) 식당에서 "+menu
				+"인 음식을 "+price+"원 내고 사먹는다.";
	}*/
	
	/**
	 * 사람은 언어를 여러개 할 수 있다.
	 * @return 할 수 있는 언어
	 */

//	public abstract String[] language(String lang);
	
	public String[] language(String lang) {
		String[] tempLang = getLanguage();

		int idx = 0;
		for (int i = 0; i < tempLang.length; i++) {
			// 습득한 언어가 존재한다면 다음 인덱스를 얻는다
			if(tempLang[i] != null) { 
				if (lang.equals(tempLang[i])) { 
					// 입력된 언어가 이미 습득한 언어라면 반복문을 빠져나가
					// 해당 방에 덮어쓸 수 있는 인덱스를 가짐.
					break;
				}
				idx++;
			}
		}

		// 없으면 추가되고 있다면 덮어쓴다 : upsert
		tempLang[idx] = lang;
		return tempLang;
	}
	
	public abstract void paint();
	
	
	
}