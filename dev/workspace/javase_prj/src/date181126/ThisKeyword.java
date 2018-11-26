package date181126;

/**
 * method를 호출하는 객체의 주소로 변경되어 사용되는 this
 * 
 * @author owner
 */
public class ThisKeyword {

	int i;
	
	/**
	 * parameter의 이름과 instance변수의 이름이 같을 때 
	 * this를 사용하지 않고 파라미터의 값을 instance변수로 저장할 때 
	 * @param i  임의의 값
	 * @param tk 인스턴스주소
	 */
	public void useInstance(int i, ThisKeyword t) {
		// 파라미터 변수의 값을 인스턴스변수에 할당하겠습니다.
		// == stack의 값을 heap의 값으로 올리겠습니다.
		System.out.println("전달받은 객체 t:"+t);
		t.i = i;
	}
	
	/**
	 * 파라미터의 이름과 인스턴스변수의 이름이 같을때마다 객체를 넘기고
	 * 받아서 사용하려면 코딩시 불편함이 수반됨. <br>
	 * 이를 개선하기위해 this가 제공됨.<br>
	 * this는 호출한 객체의 주소로 변경됨, 매개변수로 객체를 받을 
	 * 필요가 없어짐!
	 * 
	 * @param i 임의의 값
	 */
	public void useThis(int i) {
		// this는 메소드를 호출하는 객체의 주소로 바뀐다.
		// 매개변수로 객체를 받을 필요가 없다.
		this.i = i;
		System.out.println("메소드를 호출한 객체의 주소 : "+this);
	}
	
	public static void test() {
		// static method 안에서는 this 키워드를 사용할 수 없다.
		// this.i = 10; // error!
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		
		ThisKeyword tk = new ThisKeyword();
		System.out.println("생성된 객체 tk:"+tk);
		
		tk.useInstance(10, tk);
		System.out.println("전달한 객체의 인스턴스변수의 값 "+tk.i);
		
		System.out.println("===========================================");
		
		tk.useThis(3300);
		System.out.println("this를 사용하여 변경한 인스턴스변수의 값 "+tk.i);
		
		ThisKeyword.test();
	}
}
