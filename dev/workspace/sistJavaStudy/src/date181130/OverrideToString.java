package date181130;

/**
 * Override(Overriding)
 * 부모클래스가 제공하는 기능이 자식클래스에 맞지 않는다면
 * 자식클래스에서 부모클래스의 메소드와 동일한 메소드를 
 * 정의하여 사용하는 것
 * 
 * @author owner
 */
public class OverrideToString {
	
	@Override
	public String toString() {
		return "OverrideToString클래스 입니다."+super.toString();
	}

}
