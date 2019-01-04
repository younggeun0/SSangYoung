package date190104;

public class ClassEx01 {
	
	String parameter;
	ClassEx02 ex02;
	
	public ClassEx01() {
		ex02 = new ClassEx02();
	}

	public void methodEx01() {
		System.out.println("methodEx01 »£√‚");
		ex02.methodEx05();
	}
	
	public String methodEx02() {
		System.out.println(parameter);
		return "æ»≥Á";
	}
	
	public void methodEx03(String param1) {
		parameter = param1;
		System.out.println(param1);
	}
	
	public String methodEx04(String param2) {
		ex02.methodEx05();
		return param2;
	}
}
