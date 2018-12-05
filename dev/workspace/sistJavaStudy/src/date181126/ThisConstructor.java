package date181126;

/**
 * this를 사용한 생성자 호출
 * @author owner
 */
public class ThisConstructor {

	public ThisConstructor() {
		this(26);
		System.out.println("기본 생성자");
	}
	
	public ThisConstructor(int i) {
		// this();
		System.out.println("인자있는 생성자 i:"+i);		
		// this는 생성자의 첫번째 줄에서만 사용가능
		// this(); // error!
	}
	
	public static void main(String[] args) {
		
		// 객체를 저장해서 사용할 일이 없을 때 이렇게 사용
		new ThisConstructor();
		
		new ThisConstructor(3);
	}
}
