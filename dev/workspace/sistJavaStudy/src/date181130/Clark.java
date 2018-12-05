package date181130;

/**
 * 사람의 공통특징은 Person에서 가져다가 
 * 사용하고 자신만의 특징을 정의한 클래스
 * 
 * @author owner
 */
public final class Clark extends Person{
	
	public int power;

	/**
	 * 기본 생성자 : 객체가 생성되면 power가 9로 설정 
	 */
	public Clark() {
		super(3,1,1);
		power = 9;
	}
	
	/**
	 * 입력되는 돌의 종류에 따라 힘이 급격하게 변함
	 *  
	 * @param stone 돌의 종류
	 * @return 결과
	 */
	public String power(String stone) {
		String result = "";
		
		if(stone.equals("크립토나이트")) {
			power = 0;
			result="힘이 방전 ~(_-_)~";
		} else if(stone.equals("다이아몬드")) {
			power = 10;
			result="감사합니다. ~m(^o^)m~";
		} else {
			power=12;
			result="열받음. ㅡㅡ+";
		}
		
		return result;
	}
	
	@Override
	public String eat() {
		// 클라크이(가) 집에서 밥을 먹는다.
		return getName()+" is eating some food at home";
	}
	
	@Override
	public String eat(String menu, int price) {
		return getName()+" is eating "+menu+" which is "+price+"$";
	}
}
