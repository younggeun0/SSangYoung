package date181202;

class HWRevision01 {

	public static void main(String[] args) {

        // �θ�⺻, �θ����� 300, �ڽ����� 200, �ڽı⺻  
        // �θ����� 100, �θ�⺻, �ڽı⺻, �ڽ�����100 
		// new SubConstructor();
		// System.out.println("-------------");
		new SubConstructor(100);
	}
}

class SuperConstructor {
	int i;
	
	public SuperConstructor() {
		this(100);
		System.out.println("�θ� �⺻������");
	}
	
	public SuperConstructor(int i) {
		// this();
		this.i = i;
		System.out.println("�θ� ���ڻ����� i="+i);
	}
}

class SubConstructor extends SuperConstructor{
	
	public SubConstructor() {
		super();
		// this(200);
		System.out.println("�ڽ� �⺻������");
	}
	
	public SubConstructor(int i) {
		this();
		// super(300);
		System.out.println("�ڽ� ���ڻ�����, �ڽ��� i="+i);
	}
	
}
