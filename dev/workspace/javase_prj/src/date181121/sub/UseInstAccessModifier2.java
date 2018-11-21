package date181121.sub;

import date181121.InstAccessModifier;

/**
 * 상속관계에 있다면 자식클래스로 생성하여 부모클래스 접근가능
 * 접근지정자 public, protected만 사용가능
 * @author owner
 */
public class UseInstAccessModifier2 extends InstAccessModifier  {

	public static void main(String[] args) {
		
		UseInstAccessModifier2 ivam = new UseInstAccessModifier2();
		
		System.out.println("public : "+ ivam.pub_i);
		System.out.println("protected : "+ ivam.pro_i);
//		System.out.println("default : "+ ivam.def_i); 사용불가
//		System.out.println("private : " + ivam.pri_i); 사용불가
	}
}
