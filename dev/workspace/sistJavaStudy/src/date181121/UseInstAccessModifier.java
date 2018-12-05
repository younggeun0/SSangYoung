package date181121;

/**
 * 같은 패키지에 존재하는 다른 클래스의 인스턴스변수 접근 사용
 * 접근지정자가 public protected, default인 것만 사용가능
 * @author owner
 */
public class UseInstAccessModifier {

	public static void main(String[] args) {
		
		InstAccessModifier ivam = new InstAccessModifier();
		
		System.out.println("public : "+ ivam.pub_i);
		System.out.println("protected : "+ ivam.pro_i);
		System.out.println("default : "+ ivam.def_i);
//		System.out.println("private : " + ivam.pri_i); 사용불가
	}
}
