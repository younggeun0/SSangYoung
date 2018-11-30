package date181130;

/**
 * 사람의 공통 특징을 부모(Person)로 부터 사용하고 자신만의 특징만 정의
 * 홍길동 - 싸움 잘한다
 * 
 * @author owner
 */
public class HongGilDong extends Person{

	private int level;	// 홍길동의 싸움레벨
	
	/**
	 * 홍길동은 싸움을 평민보다 잘하므로 7로 시작
	 */
	public HongGilDong() {
		super();
		level = 7;
	}
	
	/**
	 * 싸움하는 일 : 입력된 레벨보다 낮다면 패배, 
	 * 입력된 레벨보다 높다면 승리, 입력된 레벨과 같다면 비김 반환
	 * 승리하면 레벨이 1증가, 패배하면 레벨 1감소, 비기면 레벨 변화없음
	 * 레벨은 최대 10, 최소 0을 가진다.
	 * @param enemyLevel 싸움상대의 레벨
	 * @return 결과
	 */
	public String fight(int enemyLevel) {
		String result ="";
		
		if (level > enemyLevel) {
			result = "이겼다. s('.^)V";
			level++;
			if (level > 10) {
				level = 10;
			}
		} else if (level < enemyLevel) {
			result = "졌다. ~(_-_)~";
			level--;
			if (level < 0) {
				level = 0;
			}
		} else {
			result = "비김 ㅡㅡ+;; ";
		}
		
		return result;
	}
	
	@Override
	public String eat(String menu, int price) {
		return super.getName()+"이(가) 주막에서 "+menu
				+"인 음식을 "+price+"냥 내고 사먹는다.";
	}
	
	@Override
	public String toString() {
		return "홍길동 객체의 값 : 눈 "+getEye()+", 코 "+getNose()+", 입 "+getMouth();
	}
}
