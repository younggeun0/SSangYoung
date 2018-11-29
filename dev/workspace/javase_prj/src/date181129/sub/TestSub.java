package date181129.sub;

import date181129.TestSuper;

public class TestSub extends TestSuper{

	public static void main(String[] args) {
		
		TestSub ts = new TestSub();
		
		// 자식과 부모가 다른 패키지에 존재하면
		// 부모가 가진 변수나 method의 접근지정자가
		// public, protected인 자원만 사용 가능
		// (캡슐화, Encapsulation)
		ts.public_i = 10;
		ts.protected_i = 20;
		
		System.out.println("부모의 자원 : "
				+ts.public_i+"/"+ts.protected_i);
	}
}
