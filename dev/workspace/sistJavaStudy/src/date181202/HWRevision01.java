package date181202;

class HWRevision01 {

	public static void main(String[] args) {

        // 부모기본, 부모인자 300, 자식인자 200, 자식기본  
        // 부모인자 100, 부모기본, 자식기본, 자식인자100 
		// new SubConstructor();
		// System.out.println("-------------");
		new SubConstructor(100);
	}
}

class SuperConstructor {
	int i;
	
	public SuperConstructor() {
		this(100);
		System.out.println("부모 기본생성자");
	}
	
	public SuperConstructor(int i) {
		// this();
		this.i = i;
		System.out.println("부모 인자생성자 i="+i);
	}
}

class SubConstructor extends SuperConstructor{
	
	public SubConstructor() {
		super();
		// this(200);
		System.out.println("자식 기본생성자");
	}
	
	public SubConstructor(int i) {
		this();
		// super(300);
		System.out.println("자식 인자생성자, 자식의 i="+i);
	}
	
}
