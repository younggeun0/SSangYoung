package date181130;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk 1.5에서부터 추가된 annotation의 사용 Deprecated, Override, SuppressWarnings
 * 
 * @author owner
 */
public class UseAnnotation {

	/**
	 * 해당 메소드는 차후에 문제를 발생시킬 수 있다.
	 */
	@Deprecated
	public void test() {
		System.out.println("차후에 문제가 발생될 method");
	}

	@Override
	public String toString() {
		return "온뇨쇼초몬도";
	}

	// 메소드 위에 설정하면 메소드 안에 있는 모든 경고 상황에 적용
	// 여러 경고타입을 한꺼번에 설정하려면 중괄호를 사용
	@SuppressWarnings({ "rawtypes", "unused" })
	public void temp() {
		// unused는 변수를 사용하지 않을 때
		@SuppressWarnings("unused")
		int i = 0;

		// rawypes : Generic을 사용하지 않을 때 경고 무시
		// 변수위에 설정하면 특정변수만 적용
		// @SuppressWarnings({ "rawtypes", "unused" })
		List l = new ArrayList();

		int j = 0;
		System.out.println(j);
	}

	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.test();

		System.out.println(ua);
	}
}
