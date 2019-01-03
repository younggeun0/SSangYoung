package date190103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseLambda {

	public static void main(String[] args) {
		
//		TestLambda tl = () -> new Date().toString();
//		TestLambda tl = () -> { return new Date().toString(); };
		// return ����� �߰�ȣ �ʿ�({})
		// abstract method ���� �ڵ尡 ����(������)�� ��쿡�� {}�� �ݵ�� ���
		TestLambda tl = () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(new Date());
		};
		
		System.out.println(tl.today());
		
		// �߻� method�� �Ű������� ������ �ִٸ� ���ٽĿ� �Ű������� ����
		TestLambda2 tl2 = (i, j) -> System.out.println(i+" + "+j+" = " +(i+j));
		
		TestLambda2 tl3 = (num1, num2) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(num1).append("+").append(num2).append("=")
			.append(num1+num2);
			
			System.out.println(sb.toString());
		};
		
		tl2.plus(45, 55);
		tl3.plus(44, 33);
	}
}
