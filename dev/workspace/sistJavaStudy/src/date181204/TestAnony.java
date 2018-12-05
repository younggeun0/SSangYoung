package date181204;

/**
 * anonymous inner class<br>
 * �������̽��� method�� �Ű������� �� �����ϰ� ����ϴ� ���<br>
 * 1ȸ��
 * 
 * @author owner
 */
public class TestAnony{
	
	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}

	public static void main(String[] args) {
		
		// interface�� ��üȭ�� ���� �ʴ´�.
		// AnonyInter ai = new AnonyInter();
		
		// interface�� �Ű����� ���� ��
		// 1. �������̽��� ������ Ŭ������ ����
		// 2. ����Ŭ������ ��ü�� ����
		AnonyInter ai = new AnonyImpl(); // is-a
		
		// 3. �Ű������� ���� �޼ҵ带 ȣ���ϱ����� ��ü����
		TestAnony ta = new TestAnony();
		
		// 4. method ȣ��
		ta.useAnonyInter(ai);
		
		// interface�� �Ű������� ������ ������ ����
		// ������ ���°� anonymous class
		
		System.out.println("---------------anonymous inner class -----------------");
		// anonymous inner class�� ����ϸ� class�� ���� ���� �ʿ䰡 ����.
		ta.useAnonyInter(new AnonyInter() {
			@Override
			public String getName() {
				return "������"+test();
			}
			@Override
			public String getMsg() {
				return "�ȳ��ϼ���";
			}
			public String test() {
				return " �ڽ� method";
			}
		});
	}
}
