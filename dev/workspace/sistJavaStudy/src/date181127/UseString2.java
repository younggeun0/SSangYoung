package date181127;

/**
 * ���ڿ� ������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� �����ϴ�
 * String class�� ���<br>
 * Java���� �����ϴ� Ŭ������ �̸��� �������� Ŭ������ �̸��� ���ٸ�
 * �������� Ŭ������ ���� ����ϰ� �ȴ�.<br>
 * �ڹٿ��� �����ϴ� Ŭ������ ����� �� ���� "full path : ��Ű������
 * ����Ͽ� Ŭ������ ����ϴ� ��"�� ����ؾ� �Ѵ�.
 * ��Ű����.Ŭ������
 * @author owner
 */
public class UseString2 {
	
	public static void main(String[] args) {
		// �⺻�� ���� ���
		String str = "AbcdEfg";
		
		// ������ ���� ���
		String mail = new String("young@ssang.kr");

		System.out.println(str);
		System.out.println(mail);
		
		System.out.println(str+"�� ���� : "+str.length());
		System.out.println(mail+"�� ���� : "+mail.length());
		
		System.out.println(str+"�� ��� �빮�� "+str.toUpperCase());
		System.out.println(str+"�� ��� �ҹ��� "+str.toLowerCase());
		
		// "AbcdEfg"
		//  01234567
		// indeOf�� L->R �����ϸ� ���� ó�� ã������ ���ڿ��� �ε����� ��´�.
		System.out.println(str+"���� 'd'�� �ε��� "+str.indexOf("dEf"));
		System.out.println(str+"���� 'z'�� �ε��� "+str.indexOf("z")); // ��� -1
		
		System.out.println(mail+"���� \"@\"�� �ε��� "+mail.indexOf("@"));
		
		str="AbcdEfAg";
		//   01234567
		System.out.println(str+"���� 'A'�� �ε��� "+str.indexOf("A"));
		
		// lastIndexOf�� R->L���� �����ϸ鼭 ���� ó�� ã������ ���ڿ��� �ε����� ��´�.
		System.out.println(str+" ���ڿ����� �ڷκ��� ������� 'A'�� �ε��� "+str.lastIndexOf("A"));
		
		// Ư�� �ε����� ���ھ��
		System.out.println(str+"���� 2��° �ε����� �ش��ϴ� ���� "+str.charAt(2));
		
		// �ڽĹ��ڿ� �ڸ���
		System.out.println(str+"���� �ε����� 2~5��°�� �ش��ϴ� ���ڿ� "+str.substring(2,6));
		
		// young@ssang.kr ���� �ּҸ� ���
		// 012345
		System.out.println(mail+"���� ������ ��� "+mail.substring(0,mail.indexOf("@")));
		
		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(mail.indexOf("@")+1,mail.length()));
		// substring�� �����ε��� �ִ�.
		// substring�� �����ε����� ������ ������ �߶󳽴�.
		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(mail.indexOf("@")+1));
		
		// �յڰ��� �ڸ���
		// trim() �յڰ��鸸 ���Ű���
		str="   A BC   ";
		System.out.println("["+str+"]���� �յڰ������� "+str.trim());
		
		// ���ڿ����̱�
		str="ABCD";
		String str1 = str.concat("EFG");
		String str2 = str+"EFG";
		System.out.println(str1);
		System.out.println(str2);
		
		// ���ڿ��� �Ϻ��ϰ� ������ ��
		str = "���ü�";
		System.out.println(str+"��(��) "+(str.equals("������")?"����":"���"));
		
		// ���ڿ��� �� ���ڿ��� �����ϴ���
		str="�Ǿ���"; 
		if(str.startsWith("����")) {
			System.out.println("���� ����Ͻ� �� �����ϴ�.");
		} else {
			System.out.println(str);
		}

		str="����� ������";
		str1="������ �ȴޱ�";
		System.out.println(str+"��(��) "+(str.startsWith("����")?"�����Դϴ�.":"�����̾ƴմϴ�."));
		System.out.println(str1+"��(��) "+(str1.startsWith("����")?"�����Դϴ�.":"�����̾ƴմϴ�."));
		
		// Ư�� ���ڿ��� �������� 
		str="����� ������ ���ﵿ";
		str1="��⵵ ������ ������";
		System.out.println(str+"��(��) "+(str.endsWith("��")?"����":"�ð�"));
		System.out.println(str1+"��(��) "+(str1.endsWith("��")?"����":"�ð�"));
		
		// ġȯ : ���ڿ� ���� ��� ���ڿ��� ã�� ġȯ
		str="�� ���� �Ǿ����ε� �� ���� �� �����";
		// �޼ҵ带 �����ؼ� ȣ���ϴ� ���� method chain�̶� �Ѵ�.
		System.out.println(str.replaceAll("��", "*").replaceAll("��", "*")); // �޼ҵ� ü��
		
		str="   A B C   ";
		System.out.println(str.replaceAll(" ", ""));
		
		// int�� String���� �Ҵ� �� �� ����.
		// �⺻�� ���������� ���ڿ��� ��ȯ
		int i = 27;
		str = String.valueOf(i);
		System.out.println(str);
		double d=11.27;
		System.out.println(d+"");
		System.out.println(String.valueOf(d));
		
		str="dd";
		System.out.println(str.isEmpty());
		
		// ��ü�� ������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� method�� ����� �� ����.
		str = null;
		try {
			System.out.println(str.isEmpty());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
