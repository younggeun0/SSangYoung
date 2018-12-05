package date181130;

public class SubConst extends SuperConst{

	int i;
	
	public SubConst() {
		System.out.println("자식 기본생성자");
	}
	
	public SubConst(int i) {
		System.out.println("자식 인자생성자, 자식의 i="+i);
	}
}
