package date181203;

/**
 * 나는 것들의 일<br>
 * 비행 시간, 높이
 * @author owner
 */
public interface Fly {

	/**
	 * 비행 속도
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);
	// 인터페이스의 추상메소드는 public만 가능(protected 사용불가)
	/**
	 * 비행 높이
	 * @param height
	 * @return
	 */
	public String height(String height);
	
}
