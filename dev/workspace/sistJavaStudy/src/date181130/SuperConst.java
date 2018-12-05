package date181130;

public class SuperConst {
	
	int i;
	
	public SuperConst() {
		System.out.println("부모의 기본생성자");
	}
	
	public SuperConst(int i) {
		this.i = i;
		System.out.println("부모의 인자생성자, 부모의 i="+i);
	}
}
